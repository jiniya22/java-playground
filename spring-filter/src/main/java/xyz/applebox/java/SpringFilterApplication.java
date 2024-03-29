package xyz.applebox.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringFilterApplication.class, args);
    }
}
