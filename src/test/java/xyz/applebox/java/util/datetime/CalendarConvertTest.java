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
class CalendarConvertTest {

    @Test
    void calendarToDate() {
        Calendar calendar = Calendar.getInstance();
        Date date1 = new Date();
        Date date2 = DateTimeUtils.calendarToDate(calendar);

        System.out.println(date1);
        System.out.println(date2);
    }

    @Test
    void calendarToLocalDate() {
        Calendar calendar = Calendar.getInstance();
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2  = DateTimeUtils.calendarToLocalDate(calendar);

        System.out.println(localDate1);
        System.out.println(localDate2);
    }

    @Test
    void calendarToLocalTime() {
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = DateTimeUtils.calendarToLocalTime(calendar);

        System.out.println(localTime1);
        System.out.println(localTime2);
    }

    @Test
    void calendarToLocalDateTime() {
        Calendar calendar = Calendar.getInstance();
        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = DateTimeUtils.calendarToLocalDateTime(calendar);

        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
    }

    @Test
    void calendarToTimestamp() {
        Calendar calendar = Calendar.getInstance();
        Timestamp timestamp = DateTimeUtils.calendarToTimestamp(calendar);
        System.out.println(timestamp);
    }

    @Test
    void getField() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        System.out.println(DateTimeUtils.SDF_DATETIME.format(calendar.getTime()));
        System.out.println(String.format("%d, %d, %d, %d, %d, %d", year, month, dayOfMonth, hourOfDay, minute, second));
    }

}