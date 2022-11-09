package xyz.applebox.java.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.applebox.java.model.BaseResponse;

import java.util.stream.Collectors;

@RestControllerAdvice(basePackages = {"xyz.applebox.java.controller"})
public class GlobalControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    private ResponseEntity<?> exception(Exception exception) {
        if (exception instanceof MethodArgumentNotValidException e) {
            return ResponseEntity.badRequest().body(
                    new BaseResponse<>(e.getFieldErrors().stream()
                            .map(fieldError -> String.format("%s 오류. %s", fieldError.getField(), fieldError.getDefaultMessage()))
                            .collect(Collectors.toList()), "fail"));
        }
        return ResponseEntity.internalServerError().body("Internal Server Error");
    }
}
