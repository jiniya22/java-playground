package xyz.applebox.java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/users")
@RestController
public class UserController {

    @GetMapping("/test")
    public String test(@RequestParam String name) {
        return String.format("user >> name: %s", name);
    }
}
