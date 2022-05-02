package xyz.applebox.java.example.datetime;

import xyz.applebox.java.util.DateUtils;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeExample {

    public static void localDateTimeToTimestamp() {
        LocalDateTime localDateTime = LocalDateTime.now();

        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        System.out.println(localDateTime);
        System.out.println(timestamp);
    }

    public static void localDateTimeToLocalDate() {
        LocalDateTime localDateTime = LocalDateTime.now();

        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = localDateTime.toLocalDate();

        System.out.println(localDate1);
        System.out.println(localDate2);
    }

    public static void localDateTimeToLocalTime() {
        LocalDateTime localDateTime = LocalDateTime.now();

        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = localDateTime.toLocalTime();

        System.out.println(localTime1);
        System.out.println(localTime2);
    }

    public static void getField() {
        LocalDateTime localDateTime = LocalDateTime.now();
        int year = localDateTime.getYear();
        int month = localDateTime.getMonthValue();
        int dayOfMonth = localDateTime.getDayOfMonth();
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        int second = localDateTime.getSecond();

        System.out.println(DateUtils.DATETIME_FORMAT.format(localDateTime));
        System.out.println(String.format("%d, %d, %d, %d, %d, %d", year, month, dayOfMonth, hour, minute, second));
        System.out.println();
    }

}