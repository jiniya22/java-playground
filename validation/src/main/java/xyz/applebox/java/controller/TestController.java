package xyz.applebox.java.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import xyz.applebox.java.model.BaseResponse;
import xyz.applebox.java.model.Member;
import xyz.applebox.java.model.User;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/test")
@RestController
public class TestController {

    @GetMapping("/size")
    public Map sizeCheck(@Size(min = 2, max = 5) String name) {
        return Map.of(name, name.length());
    }

    @PostMapping("/user")
    public ResponseEntity<BaseResponse<?>> userCheck(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest()
                    .body(new BaseResponse<>(getFieldErrors(bindingResult), "fail"));
        }
        return ResponseEntity.ok(new BaseResponse<>(user));
    }

    @PostMapping("/member")
    public ResponseEntity<BaseResponse<?>> memberCheck(@RequestBody @Valid Member member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest()
                    .body(new BaseResponse<>(getFieldErrors(bindingResult), "fail"));
        }
        return ResponseEntity.ok(new BaseResponse<>(member));
    }

    private List<String> getFieldErrors(BindingResult bindingResult) {
        return bindingResult.getFieldErrors().stream()
                .map(fieldError -> String.format("%s 오류. %s", fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());
    }

}
