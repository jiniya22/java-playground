package xyz.applebox.java.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import xyz.applebox.java.model.BaseResponse;
import xyz.applebox.java.model.Member;

import javax.validation.Valid;
import java.net.URI;
import java.util.stream.Collectors;

@ApiIgnore
@RestController
public class IndexController {

    @GetMapping("")
    public ResponseEntity swagger() {
        return ResponseEntity.status(HttpStatus.TEMPORARY_REDIRECT)
                .location(URI.create("/swagger-ui/")).build();
    }


    @PostMapping("/special/member")
    public ResponseEntity<BaseResponse<?>> memberCheck(@RequestBody @Valid Member member) {
        return ResponseEntity.ok(new BaseResponse<>(member));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    private ResponseEntity<BaseResponse<?>> exception(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(
                new BaseResponse<>(e.getFieldErrors().stream()
                        .map(fieldError -> String.format("%s Error!! %s", fieldError.getField(), fieldError.getDefaultMessage()))
                        .collect(Collectors.toList()), "fail"));
    }

}
