package xyz.applebox.java.model;

import lombok.Data;

@Data
public class ErrorResponse<T> {
    private T errors;
    private String result = "fail";

    public ErrorResponse(T errors) {
        this.errors = errors;
    }

    public record ErrorMessage(String fieldName, Object inputValue, String message){}
}
