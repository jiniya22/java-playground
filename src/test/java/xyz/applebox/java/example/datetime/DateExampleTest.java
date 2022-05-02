package xyz.applebox.java.example.datetime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DateExampleTest {

    @Test
    void calendarToTimestamp() {
        DateExample.calendarToTimestamp();
    }
}
