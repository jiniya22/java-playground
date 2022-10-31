package xyz.applebox.java.controller;

import org.springframework.web.bind.annotation.*;
import xyz.applebox.java.model.User;

@RequestMapping("/sample")
@RestController
public class SampleController {

    @GetMapping("/{id}")
    public User get(@PathVariable Long id, @RequestParam String name) {
        return new User(id, name);
    }


    @PostMapping("")
    public User post(@RequestBody User user) {
        return user;
    }

}
