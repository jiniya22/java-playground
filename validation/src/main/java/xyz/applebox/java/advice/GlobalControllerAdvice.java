package xyz.applebox.java.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.applebox.java.model.ErrorResponse;
import xyz.applebox.java.model.ErrorResponse.ErrorMessage;

import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestControllerAdvice(basePackages = {"xyz.applebox.java.controller"})
public class GlobalControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    private ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(new ErrorResponse<>(
                e.getFieldErrors().stream()
                    .map(fieldError ->
                            new ErrorResponse.ErrorMessage(fieldError.getField(), fieldError.getRejectedValue(), fieldError.getDefaultMessage()))
                    .collect(Collectors.toList())));
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    private ResponseEntity<?> ConstraintViolationException(ConstraintViolationException e) {
        return ResponseEntity.badRequest().body(new ErrorResponse<>(
                e.getConstraintViolations().stream()
                    .map(m -> {
                        List<Path.Node> nodes = StreamSupport.stream(m.getPropertyPath().spliterator(), false).toList();
                        return new ErrorResponse.ErrorMessage(nodes.get(nodes.size() - 1).getName(), m.getInvalidValue(), m.getMessage());
                    })
                    .collect(Collectors.toList())));
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    private ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException e) {
        return ResponseEntity.badRequest().body(new ErrorResponse<>(
                List.of(new ErrorResponse.ErrorMessage(e.getParameterName(), null, e.getMessage()))));
    }

    @ExceptionHandler(value = Exception.class)
    private ResponseEntity<?> exception(Exception exception) {
        return ResponseEntity.internalServerError().body("Internal Server Error");
    }
}
