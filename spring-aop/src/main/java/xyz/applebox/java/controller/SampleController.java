package xyz.applebox.java.controller;

import org.springframework.web.bind.annotation.*;
import xyz.applebox.java.annotation.Decode;
import xyz.applebox.java.annotation.Timer;
import xyz.applebox.java.model.User;

@RequestMapping("/sample")
@RestController
public class SampleController {

    @Decode
    @PostMapping("")
    public User post(@RequestBody User user) {
        System.out.println(">>>>> " + user);
        return user;
    }

    @Timer
    @GetMapping("/{id}")
    public User get(@PathVariable Long id, @RequestParam String email) throws InterruptedException {
        Thread.sleep(3000);
        return new User(id, email);
    }

}
