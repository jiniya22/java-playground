package xyz.applebox.java.example.datetime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
class LocalDateTimeTest {
    public static final SimpleDateFormat SDF_DATETIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static final DateTimeFormatter DATETIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Test
    void localDateTimeToTimestamp() {
        LocalDateTime localDateTime = LocalDateTime.now();

        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        System.out.println(localDateTime);
        System.out.println(timestamp);
    }

    @Test
    void localDateTimeToLocalDate() {
        LocalDateTime localDateTime = LocalDateTime.now();

        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = localDateTime.toLocalDate();

        System.out.println(localDate1);
        System.out.println(localDate2);
    }

    @Test
    void localDateTimeToLocalTime() {
        LocalDateTime localDateTime = LocalDateTime.now();

        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = localDateTime.toLocalTime();

        System.out.println(localTime1);
        System.out.println(localTime2);
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

        System.out.println(DATETIME_FORMAT.format(localDateTime));
        System.out.println(String.format("%d, %d, %d, %d, %d, %d", year, month, dayOfMonth, hour, minute, second));
        System.out.println();
    }

}