package xyz.applebox.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@EnableAutoConfiguration
@Configuration
public class TestConfig {

  @Bean
  public JobLauncherTestUtils jobLauncherTestUtils(){
    return new JobLauncherTestUtils();
  }
}
