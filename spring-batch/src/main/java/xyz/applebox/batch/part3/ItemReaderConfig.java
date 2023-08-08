package xyz.applebox.batch.part3;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.JpaCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.database.builder.JpaCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class ItemReaderConfig {
  private final JobBuilderFactory jobBuilderFactory;
  private final StepBuilderFactory stepBuilderFactory;
  private final DataSource dataSource;
  private final EntityManagerFactory entityManagerFactory;

  @Bean
  public Job itemReaderJob() {
    return jobBuilderFactory.get("itemReaderJob")
            .incrementer(new RunIdIncrementer())
            .start(customReaderStep())
            .next(jdbcStep())
            .next(jpaStep())
            .build();
  }

  @Bean
  public Step customReaderStep() {
    return stepBuilderFactory.get("customReaderStep")
            .<Person, Person>chunk(10)
            .reader(new CustomItemReader<>(getItems()))
            .writer(itemWriter())
            .build();
  }

  @Bean
  public Step jdbcStep() {
    return stepBuilderFactory.get("jdbcStep")
            .<Person, Person>chunk(10)
            .reader(jdbcCursorItemReader())
            .writer(itemWriter())
            .build();
  }

  @Bean
  public Step jpaStep() {
    return stepBuilderFactory.get("jpaStep")
            .<Person, Person>chunk(10)
            .reader(jpaCursorItemReader())
            .writer(itemWriter())
            .build();
  }

  @SneakyThrows
  private JdbcCursorItemReader<Person> jdbcCursorItemReader() {
    JdbcCursorItemReader<Person> itemReader = new JdbcCursorItemReaderBuilder<Person>()
            .name("jdbcCursorItemReader")
            .dataSource(dataSource)
            .sql("select id, name, age, address from person")
            .rowMapper((rs, rowNum) ->
                    new Person(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)))
            .build();
    itemReader.afterPropertiesSet();
    return itemReader;
  }

  @SneakyThrows
  private JpaCursorItemReader<Person> jpaCursorItemReader() {
    JpaCursorItemReader<Person> jpaCursorItemReader = new JpaCursorItemReaderBuilder<Person>()
            .name("jpaCursorItemReader")
            .entityManagerFactory(entityManagerFactory)
            .queryString("select p from Person p")
            .build();
    jpaCursorItemReader.afterPropertiesSet();
    return jpaCursorItemReader;
  }

  private ItemWriter<Person> itemWriter() {
    return items -> log.info(items.stream().map(Person::getName).collect(Collectors.joining(", ")));
  }

  private List<Person> getItems() {
    List<Person> items = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      items.add(new Person(i, "test " + i, i, "test address " + i));
    }
    return items;
  }
}