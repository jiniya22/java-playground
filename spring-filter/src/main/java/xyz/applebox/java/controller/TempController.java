package xyz.applebox.java.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.applebox.java.model.User;

@Slf4j
@RequestMapping("/temp/users")
@RestController
public class TempController {

    @PostMapping("")
    public User user(@RequestBody User user) {
        log.info("name: {}, age: {}", user.name(), user.age());
        return user;
    }
}
