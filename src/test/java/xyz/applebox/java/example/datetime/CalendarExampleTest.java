package xyz.applebox.java.example.datetime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalendarExampleTest {

    @Test
    void getField() {
        CalendarExample.getField();
    }

    @Test
    void calendarToDate() {
        CalendarExample.calendarToDate();
    }

    @Test
    void calendarToLocalDate() {
        CalendarExample.calendarToLocalDate();
    }

    @Test
    void calendarToLocalTime() {
        CalendarExample.calendarToLocalTime();
    }

    @Test
    void calendarToLocalDateTime() {
        CalendarExample.calendarToLocalDateTime();
    }
}