package xyz.applebox.batch.part3;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class ItemProcessorConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job itemProcessorJob() {
        return jobBuilderFactory.get("itemProcessorJob")
                .incrementer(new RunIdIncrementer())
                .start(itemProcessorStep())
                .build();
    }

    @Bean
    public Step itemProcessorStep() {
        return stepBuilderFactory.get("itemProcessorStep")
                .<Person, Person>chunk(10)
                .reader(itemReader())
                .processor(itemProcessor())
                .writer(itemWriter())
                .build();
    }

  private ItemWriter<Person> itemWriter() {
      return items -> items.forEach(f -> log.info("person id: {}, person name: {}", f.getId(), f.getName()));
  }

  private ItemProcessor<Person, Person> itemProcessor() {
    return item -> item.getId() % 2 == 0 ? item : null;
  }


  private ItemReader<Person> itemReader() {
    return new CustomItemReader<>(getItems());
  }

  private List<Person> getItems() {
    List<Person> items = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
      items.add(new Person(i, "test " + i, i, "address " + i));
    }
    return items;
  }

}