package xyz.applebox.java.example.datetime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@SpringBootTest
class CalendarTest {
    public static final SimpleDateFormat SDF_DATETIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static final DateTimeFormatter DATETIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Test
    void getField() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        System.out.println(SDF_DATETIME.format(calendar.getTime()));
        System.out.println(String.format("%d, %d, %d, %d, %d, %d", year, month, dayOfMonth, hour, minute, second));
    }

    @Test
    void calendarToDate() {
        Calendar calendar = Calendar.getInstance();

        Date date1 = new Date();
        Date date2 = calendar.getTime();

        System.out.println(SDF_DATETIME.format(date1));
        System.out.println(SDF_DATETIME.format(date2));
    }

    @Test
    void calendarToLocalDate() {
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR), month = calendar.get(Calendar.MONTH)+1,
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH), dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);

        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(year, month, dayOfMonth);
        LocalDate localDate3 = LocalDate.ofYearDay(year, dayOfYear);

        System.out.println(DATE_FORMAT.format(localDate1));
        System.out.println(DATE_FORMAT.format(localDate2));
        System.out.println(DATE_FORMAT.format(localDate3));
    }

    @Test
    void calendarToLocalTime() {
        Calendar calendar = Calendar.getInstance();

        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY), minute = calendar.get(Calendar.MINUTE),
                second = calendar.get(Calendar.SECOND);

        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = LocalTime.of(hourOfDay, minute, second);

        System.out.println(TIME_FORMAT.format(localTime1));
        System.out.println(TIME_FORMAT.format(localTime2));
    }

    @Test
    void calendarToLocalDateTime() {
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

        System.out.println(DATETIME_FORMAT.format(localDateTime1));
        System.out.println(DATETIME_FORMAT.format(localDateTime2));
        System.out.println(DATETIME_FORMAT.format(localDateTime3));
    }
}