package xyz.applebox.java.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.applebox.java.service.AsyncService;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class TestController {

    private final AsyncService asyncService;

    @GetMapping("/hello")
    public CompletableFuture hello(@RequestParam int num) {
        log.info(">>> hello start");
        CompletableFuture result = asyncService.asyncSumTest(num);
        log.info(">>> hello end");
        return result;
    }
}
