package xyz.applebox.java.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.applebox.java.exception.AuthException;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(AuthException.class)
    private ResponseEntity<?> authException() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
