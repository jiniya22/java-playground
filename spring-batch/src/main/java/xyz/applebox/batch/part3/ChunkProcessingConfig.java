package xyz.applebox.batch.part3;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Configuration
public class ChunkProcessingConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job chunkProcessingJob() {
        return jobBuilderFactory.get("chunkProcessingJob")
                .incrementer(new RunIdIncrementer())
                .start(taskBaseStep())
                .next(chunkBaseStep())
                .build();
    }

    @Bean
    public Step chunkBaseStep() {
        return stepBuilderFactory.get("chunkBaseStep")
                .<String, String>chunk(10)
                .reader(itemReader())
                .processor(itemProcessor())
                .writer(itemWriter())
                .build();
    }

    private ItemReader<String> itemReader() {
        return new ListItemReader<>(getItems());
    }

    private ItemProcessor<? super String, String> itemProcessor() {
        return item -> item + ",  Spring Batch!";
    }

    private ItemWriter<? super String> itemWriter() {
        return items -> log.info("chunk item size: {}", items.size());
    }

    private List<String> getItems() {
        List<String> items = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            items.add("jini " + i);
        }
        return items;
    }

    @Bean
    public Step taskBaseStep() {
        return stepBuilderFactory.get("taskBaseStep")
                .tasklet(tasklet())
                .build();
    }

    private Tasklet tasklet() {
        return ((contribution, chunkContext) -> {
            List<String> items = getItems();
            log.info("task item size: {}", items.size());
            return RepeatStatus.FINISHED;
        });
//        List<String> items = getItems();
//        return ((contribution, chunkContext) -> {
//            StepExecution stepExecution = contribution.getStepExecution();
//            int chunkSize = 10;
//            int fromIndex = stepExecution.getReadCount();
//            int toIndex = fromIndex + chunkSize;
//            if(fromIndex >= items.size()) {
//                return RepeatStatus.FINISHED;
//            }
//            List<String> subList = items.subList(fromIndex, toIndex);
//            log.info("task item size: {}", subList.size());
//
//            stepExecution.setReadCount(toIndex);
//
//            return RepeatStatus.CONTINUABLE;
//        });
    }
}