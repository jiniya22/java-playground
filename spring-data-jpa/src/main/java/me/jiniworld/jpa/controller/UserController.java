package me.jiniworld.jpa.controller;

import lombok.RequiredArgsConstructor;
import me.jiniworld.jpa.persistence.UserService;
import me.jiniworld.jpa.domain.projection.UserSummary;
import me.jiniworld.jpa.domain.projection.UsernameOnly;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
class UserController {
    private final UserService userService;

    @GetMapping("/{id}/summary")
    public UserSummary summary(@PathVariable("id") Long id) {
        return userService.selectSummary(id);
    }

    @GetMapping("/{id}/username")
    public UsernameOnly usernameOnly(@PathVariable("id") Long id) {
        return userService.selectUsername(id);
    }
}
