package me.jiniworld.jpa.controller;

import lombok.RequiredArgsConstructor;
import me.jiniworld.jpa.domain.projection.UserSummary;
import me.jiniworld.jpa.domain.projection.UsernameOnly;
import me.jiniworld.jpa.persistence.CommonCode;
import me.jiniworld.jpa.persistence.CommonCodeService;
import me.jiniworld.jpa.persistence.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RequestMapping("/common-codes")
@RestController
class CommonCodeController {
    private final CommonCodeService commonCodeService;

    @GetMapping("/{id}")
    public CommonCode get(@PathVariable("id") Long id) {
        return commonCodeService.select(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void get(@PathVariable("id") Long id, @RequestBody SimpleData<String> request) {
        commonCodeService.update(id, request.data());
    }
}
