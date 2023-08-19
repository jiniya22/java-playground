package xyz.applebox.batch.part3.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;

@Slf4j
public class SavePersonStepAnnotationExecutionListener {
  @BeforeStep
  public void beforeStep(StepExecution stepExecution) {
    log.info("#### annotation beforeStep");
  }

  @AfterStep
  public ExitStatus afterStep(StepExecution stepExecution) {
    log.info("#### annotation afterStep: {}", stepExecution.getWriteCount());
    if(stepExecution.getWriteCount() == 0)
      return ExitStatus.FAILED;
    return stepExecution.getExitStatus();
  }
}
