package xyz.applebox.batch.part3;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.applebox.batch.TestConfig;

@SpringBatchTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { SavePersonConfig.class, TestConfig.class })
public class SavePersonConfigTest {

  @Autowired
  private JobLauncherTestUtils jobLauncherTestUtils;

  @Autowired
  private PersonRepository personRepository;

  @After
  public void tearDown() {
    personRepository.deleteAllInBatch();
  }

  @Test
  public void test_not_allow_duplicate() throws Exception {
    // given
    JobParameters jobParameters = new JobParametersBuilder()
      .addString("allow_duplicate", "false")
      .toJobParameters();

    // when
    JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);

    //then
    int tt = jobExecution.getStepExecutions().stream()
      .mapToInt(StepExecution::getWriteCount)
      .sum();
    Assertions.assertThat(jobExecution.getStepExecutions().stream()
        .mapToInt(StepExecution::getWriteCount)
        .sum())
        .isEqualTo(personRepository.count())
        .isEqualTo(6);
  }

  @Test
  public void test_allow_duplicate() throws Exception {
    // given
    JobParameters jobParameters = new JobParametersBuilder()
        .addString("allow_duplicate", "true")
        .toJobParameters();

    // when
    JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);

    //then
    Assertions.assertThat(jobExecution.getStepExecutions().stream()
            .mapToInt(StepExecution::getWriteCount)
            .sum())
        .isEqualTo(personRepository.count())
        .isEqualTo(100);
  }

  @Test
  public void test_step() {
    JobExecution jobExecution = jobLauncherTestUtils.launchStep("savePersonStep");

    Assertions.assertThat(jobExecution.getStepExecutions().stream()
            .mapToInt(StepExecution::getWriteCount)
            .sum())
        .isEqualTo(personRepository.count())
        .isEqualTo(6);
  }
}
