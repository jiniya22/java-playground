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
class LocalDateTimeConvertTest {

    @Test
    void localDateTimeToDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date1 = new Date();
        Date date2 = DateTimeUtils.localDateTimeToDate(localDateTime);
        System.out.println(date1);
        System.out.println(date2);
    }

    @Test
    void localDateTimeToLocalDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = DateTimeUtils.localDateTimeToLocalDate(localDateTime);
        System.out.println(localDate1);
        System.out.println(localDate2);
    }

    @Test
    void localDateTimeToLocalTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = DateTimeUtils.localDateTimeToLocalTime(localDateTime);

        System.out.println(localTime1);
        System.out.println(localTime2);
    }
    @Test
    void localDateTimeToTimestamp() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp timestamp1 = new Timestamp(new Date().getTime());
        Timestamp timestamp2 = DateTimeUtils.localDateTimeToTimestamp(localDateTime);
        System.out.println(timestamp1);
        System.out.println(timestamp2);
    }

    @Test
    void getField() {
        LocalDateTime localDateTime = LocalDateTime.now();
        int year = localDateTime.getYear();
        int month = localDateTime.getMonthValue();
        int dayOfMonth = localDateTime.getDayOfMonth();
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        int second = localDateTime.getSecond();

        System.out.println(DateTimeUtils.DTF_DATETIME.format(localDateTime));
        System.out.println(String.format("%d, %d, %d, %d, %d, %d", year, month, dayOfMonth, hour, minute, second));
        System.out.println();
    }

}
