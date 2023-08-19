package xyz.applebox.batch.part3.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.StepExecution;

@Slf4j
public class SavePersonExecutionListener implements JobExecutionListener {

  @Override
  public void beforeJob(JobExecution jobExecution) {
    log.info(">>>> interface beforeJob");
  }

  @Override
  public void afterJob(JobExecution jobExecution) {
    int sum = jobExecution.getStepExecutions().stream().mapToInt(StepExecution::getWriteCount).sum();
    log.info(">>>> interface afterJob: {}", sum);
  }

}
