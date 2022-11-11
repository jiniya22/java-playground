package xyz.applebox.java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.applebox.java.annotation.AdminAuth;

@RequestMapping("/admin")
@RestController
@AdminAuth
public class AdminController {

    @GetMapping("/test")
    public String test(@RequestParam String name) {
        return String.format("admin >> name: %s", name);
    }
}
