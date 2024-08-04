package me.jiniworld.jpa.controller;

import lombok.RequiredArgsConstructor;
import me.jiniworld.jpa.user.domain.TestCodeSimple;
import me.jiniworld.jpa.test_code.persistence.TestCodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
