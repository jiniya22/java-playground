package xyz.applebox.java.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class AsyncService {

    @Async("asyncThread")
    public CompletableFuture asyncSumTest(int num) {
        return new AsyncResult(sum(num)).completable();
    }

    public int sum(int num) {
        int result = 0;
        log.info(">>> sum start");
        for (int i = 1; i <= num; i++) {
            try {
                Thread.sleep(1000);
                log.info("thread sleep {}", i);
                result += i;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        log.info(">>> sum end");
        return result;
    }
}
