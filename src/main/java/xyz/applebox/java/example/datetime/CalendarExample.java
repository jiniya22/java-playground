package xyz.applebox.java.example.datetime;

import xyz.applebox.java.util.DateUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class CalendarExample {

    public static void getField() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        System.out.println(DateUtils.SDF_DATETIME.format(calendar.getTime()));
        System.out.println(String.format("%d, %d, %d, %d, %d, %d", year, month, dayOfMonth, hour, minute, second));
    }

    public static void calendarToDate() {
        Calendar calendar = Calendar.getInstance();

        Date date1 = new Date();
        Date date2 = calendar.getTime();

        System.out.println(DateUtils.SDF_DATETIME.format(date1));
        System.out.println(DateUtils.SDF_DATETIME.format(date2));
    }

    public static void calendarToLocalDate() {
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR), month = calendar.get(Calendar.MONTH)+1,
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH), dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);

        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(year, month, dayOfMonth);
        LocalDate localDate3 = LocalDate.ofYearDay(year, dayOfYear);

        System.out.println(DateUtils.DATE_FORMAT.format(localDate1));
        System.out.println(DateUtils.DATE_FORMAT.format(localDate2));
        System.out.println(DateUtils.DATE_FORMAT.format(localDate3));
    }

    public static void calendarToLocalTime() {
        Calendar calendar = Calendar.getInstance();

        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY), minute = calendar.get(Calendar.MINUTE),
                second = calendar.get(Calendar.SECOND);

        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = LocalTime.of(hourOfDay, minute, second);

        System.out.println(DateUtils.TIME_FORMAT.format(localTime1));
        System.out.println(DateUtils.TIME_FORMAT.format(localTime2));
    }

    public static void calendarToLocalDateTime() {
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR), month = calendar.get(Calendar.MONTH) + 1,
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY), minute = calendar.get(Calendar.MINUTE),
                second = calendar.get(Calendar.SECOND);

        LocalDate localDate = LocalDate.of(year, month, dayOfMonth);
        LocalTime localTime = LocalTime.of(hourOfDay, minute, second);

        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.of(year, month, dayOfMonth, hourOfDay, minute, second);
        LocalDateTime localDateTime3 = LocalDateTime.of(localDate, localTime);

        System.out.println(DateUtils.DATETIME_FORMAT.format(localDateTime1));
        System.out.println(DateUtils.DATETIME_FORMAT.format(localDateTime2));
        System.out.println(DateUtils.DATETIME_FORMAT.format(localDateTime3));
    }
}