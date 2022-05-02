package xyz.applebox.java.example.datetime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LocalDateTimeExampleTest {
    @Test
    void localDateTimeToTimestamp() {
        LocalDateTimeExample.localDateTimeToTimestamp();
    }

    @Test
    void localDateTimeToLocalDate() {
        LocalDateTimeExample.localDateTimeToLocalDate();
    }

    @Test
    void localDateTimeToLocalTime() {
        LocalDateTimeExample.localDateTimeToLocalTime();
    }

    @Test
    void getField() {
        LocalDateTimeExample.getField();
    }

}