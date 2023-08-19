package xyz.applebox.batch.part3.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.BeforeJob;

@Slf4j
public class SavePersonAnnotationJobExecutionListener {

  @BeforeJob
  public void beforeJob() {
    log.info(">>>> annotation beforeJob");
  }

  @AfterJob
  public void afterJob(JobExecution jobExecution) {
    int sum = jobExecution.getStepExecutions().stream().mapToInt(StepExecution::getWriteCount).sum();
    log.info(">>>> annotation afterJob: {}", sum);
  }

}
