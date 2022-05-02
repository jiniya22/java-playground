package xyz.applebox.java.util.datetime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.applebox.java.util.DateTimeUtils;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@SpringBootTest
class TimestampConvertTest {

    @Test
    void timestampToDate() {
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        Date date1 = new Date();
        Date date2 = DateTimeUtils.timestampToDate(timestamp);

        System.out.println(date1);
        System.out.println(date2);
    }

    @Test
    void timestampToLocalDate() {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = DateTimeUtils.timestampToLocalDate(timestamp);

        System.out.println(localDate1);
        System.out.println(localDate2);
    }

    @Test
    void timestampToLocalTime() {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = DateTimeUtils.timestampToLocalTime(timestamp);

        System.out.println(localTime1);
        System.out.println(localTime2);
    }

    @Test
    void timestampToLocalDateTime() {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = DateTimeUtils.timestampToLocalDateTime(timestamp);

        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
    }
}