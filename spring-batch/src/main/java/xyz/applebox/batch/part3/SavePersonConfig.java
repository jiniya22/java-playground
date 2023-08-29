package xyz.applebox.batch.part3;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.support.builder.CompositeItemProcessorBuilder;
import org.springframework.batch.item.support.builder.CompositeItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import xyz.applebox.batch.part3.listener.SavePersonAnnotationJobExecutionListener;
import xyz.applebox.batch.part3.listener.SavePersonExecutionListener;
import xyz.applebox.batch.part3.listener.SavePersonStepAnnotationExecutionListener;
import xyz.applebox.batch.part3.listener.SavePersonStepExecutionListener;

import javax.persistence.EntityManagerFactory;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class SavePersonConfig {
  private final JobBuilderFactory jobBuilderFactory;
  private final StepBuilderFactory stepBuilderFactory;
  private final EntityManagerFactory entityManagerFactory;

  @Bean
  public Job savePersonJob() {
    return jobBuilderFactory.get("savePersonJob")
      .incrementer(new RunIdIncrementer())
      .start(savePersonStep(null))
      .listener(new SavePersonExecutionListener())
      .listener(new SavePersonAnnotationJobExecutionListener())
      .build();
  }

  @JobScope
  @Bean
  public Step savePersonStep(@Value("#{jobParameters[allow_duplicate]}") String allowDuplicate) {
    return stepBuilderFactory.get("savePersonStep")
      .<Person, Person>chunk(10)
      .reader(savePersonItemReader())
      .processor(itemProcessor(allowDuplicate))
      .writer(itemWriter())
      .listener(new SavePersonStepExecutionListener())
      .listener(new SavePersonStepAnnotationExecutionListener())
      .faultTolerant()
      .skip(NotFoundNameException.class)
      .skipLimit(2)
      .build();
  }

  @SneakyThrows
  private ItemProcessor<Person, Person> itemProcessor(String allowDuplicate) {
    ItemProcessor<Person, Person> validationProcessor = item -> {
      if(Strings.isBlank(item.getName())) {
        throw new NotFoundNameException();
      }
      return item;
    };

    DuplicateValidationProcessor<Person> duplicateValidationProcessor =
      new DuplicateValidationProcessor<>(Person::getName, Boolean.parseBoolean(allowDuplicate));

    CompositeItemProcessor<Person, Person> itemProcessor = new CompositeItemProcessorBuilder<Person, Person>()
      .delegates(validationProcessor, duplicateValidationProcessor)
      .build();
    itemProcessor.afterPropertiesSet();
    return itemProcessor;
  }

  @SneakyThrows
  private ItemReader<Person> savePersonItemReader() {
    DefaultLineMapper<Person> lineMapper = new DefaultLineMapper<>();
    DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
    lineTokenizer.setNames("name","age","address");
    lineMapper.setLineTokenizer(lineTokenizer);
    lineMapper.setFieldSetMapper(fieldSet -> new Person(
      fieldSet.readString(0),
      fieldSet.readInt(1),
      fieldSet.readString(2)
    ));

    FlatFileItemReader<Person> itemReader = new FlatFileItemReaderBuilder<Person>()
      .name("savePersonItemReader")
      .encoding("UTF-8")
      .linesToSkip(1)
      .resource(new ClassPathResource("person.csv"))
      .lineMapper(lineMapper)
      .build();
    itemReader.afterPropertiesSet();
    return itemReader;
  }

  @SneakyThrows
  private ItemWriter<Person> itemWriter() {
    JpaItemWriter<Person> jpaItemWriter = new JpaItemWriterBuilder<Person>()
      .entityManagerFactory(entityManagerFactory)
      .build();

    ItemWriter<Person> logItemWriter = items -> items.forEach(f -> log.info("item size: {}", items.size()));

    CompositeItemWriter<Person> itemWriter = new CompositeItemWriterBuilder<Person>()
      .delegates(jpaItemWriter, logItemWriter)
      .build();
    itemWriter.afterPropertiesSet();
    return itemWriter;
  }

}
