package xyz.applebox.java.util.datetime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.applebox.java.util.DateTimeUtils;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@SpringBootTest
class LocalDateConvertTest {

    @Test
    void localDateToDate() {
        LocalDate localDate = LocalDate.now();
        Date date1 = new Date();
        Date date2 = DateTimeUtils.localDateToDate(localDate);
        System.out.println(date1);
        System.out.println(date2);
    }

    @Test
    void localDateToLocalDateTime() {
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = DateTimeUtils.localDateToLocalDateTime(localDate);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
    }

    @Test
    void localDateToTimestamp() {
        LocalDate localDate = LocalDate.now();
        Timestamp timestamp1 = new Timestamp(new Date().getTime());
        Timestamp timestamp2 = DateTimeUtils.localDateToTimestamp(localDate);
        System.out.println(timestamp1);
        System.out.println(timestamp2);
    }

}
