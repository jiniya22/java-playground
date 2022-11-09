package xyz.applebox.java.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseResponse<T> {
    private T data;
    private String result = "success";

    public BaseResponse(T data) {
        this.data = data;
    }

    public BaseResponse(T data, String result) {
        this.data = data;
        this.result = result;
    }
}
