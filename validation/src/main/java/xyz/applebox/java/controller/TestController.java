package xyz.applebox.java.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.applebox.java.model.BaseResponse;
import xyz.applebox.java.model.Member;
import xyz.applebox.java.model.User;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Map;

@Validated
@RequestMapping("/test")
@RestController
public class TestController {

    @GetMapping("/param")
    public Map paramCheck(
            @Size(min = 2, max = 5) @RequestParam String name,
            @Min(1) @Max(130) @RequestParam Integer age) {
        return Map.of(name, name.length(), "age", age);
    }

    @PostMapping("/user")
    public ResponseEntity<BaseResponse<?>> userCheck(@RequestBody @Valid User user) {
        return ResponseEntity.ok(new BaseResponse<>(user));
    }

    @PostMapping("/member")
    public ResponseEntity<BaseResponse<?>> memberCheck(@RequestBody @Valid Member member) {
        return ResponseEntity.ok(new BaseResponse<>(member));
    }

}
