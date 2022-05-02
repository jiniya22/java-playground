package xyz.applebox.java.util.datetime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.applebox.java.util.DateTimeUtils;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

@SpringBootTest
public class DateConvertTest {

    @Test
    void dateToTimestamp() {
        Date date = new Date();
        Timestamp timestamp1 = Timestamp.valueOf(LocalDateTime.now());
        Timestamp timestamp2 = DateTimeUtils.dateToTimestamp(date);

        System.out.println(timestamp1);
        System.out.println(timestamp2);
    }

    @Test
    void dateToCalendar() {
        Date date = new Date();
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = DateTimeUtils.dateToCalendar(date);

        System.out.println(calendar1);
        System.out.println(calendar2);
    }

    @Test
    void dateToLocalDate() {
        Date date = new Date();
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = DateTimeUtils.dateToLocalDate(date);

        System.out.println(localDate1);
        System.out.println(localDate2);
    }

    @Test
    void dateToLocalTime() {
        Date date = new Date();
        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = DateTimeUtils.dateToLocalTime(date);

        System.out.println(localTime1);
        System.out.println(localTime2);
    }

    @Test
    void dateToLocalDateTime() {
        Date date = new Date();
        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = DateTimeUtils.dateToLocalDateTime(date);

        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
    }
}
