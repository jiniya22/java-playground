package xyz.applebox.java.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.net.URI;

@ApiIgnore
@RestController
public class IndexController {

    @GetMapping("")
    public ResponseEntity swagger() {
        return ResponseEntity.status(HttpStatus.TEMPORARY_REDIRECT)
                .location(URI.create("/swagger-ui/")).build();
    }
}
