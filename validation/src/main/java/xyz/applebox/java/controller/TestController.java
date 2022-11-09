package xyz.applebox.java.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.applebox.java.model.BaseResponse;
import xyz.applebox.java.model.Member;
import xyz.applebox.java.model.User;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.Map;

@RequestMapping("/test")
@RestController
public class TestController {

    @GetMapping("/size")
    public Map sizeCheck(@Size(min = 2, max = 5) String name) {
        return Map.of(name, name.length());
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
