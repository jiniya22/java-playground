package xyz.applebox.batch.part3.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

@Slf4j
public class SavePersonStepExecutionListener implements StepExecutionListener {
  @Override
  public void beforeStep(StepExecution stepExecution) {
    log.info("#### interface beforeStep");
  }

  @Override
  public ExitStatus afterStep(StepExecution stepExecution) {
    log.info("#### interface afterStep: {}", stepExecution.getWriteCount());
    if(stepExecution.getWriteCount() == 0)
      return ExitStatus.FAILED;
    return stepExecution.getExitStatus();
  }
}
