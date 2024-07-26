package me.jiniworld.jpa.controller;

import lombok.RequiredArgsConstructor;
import me.jiniworld.jpa.user.domain.TestCodeSimple;
import me.jiniworld.jpa.user.persistence.CommonCodeService;
import me.jiniworld.jpa.user.persistence.TestCode;
import me.jiniworld.jpa.user.persistence.TestCodeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RequestMapping("/test-codes")
@RestController
class TestCodeController {
    private final TestCodeService testCodeService;

    @GetMapping("/{id}")
    public TestCodeSimple get(@PathVariable("id") Long id) {
        return testCodeService.select(id);
    }

}
