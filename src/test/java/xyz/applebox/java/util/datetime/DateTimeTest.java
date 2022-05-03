package xyz.applebox.java.util.datetime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

@SpringBootTest
public class DateTimeTest {

    @Test
    void chronoUnitTest() {
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
        System.out.println(dateTime.plus(3, ChronoUnit.DAYS));      // dateTime.plusDays(3)
        System.out.println(dateTime.plus(2, ChronoUnit.YEARS));
        System.out.println(dateTime.minus(6, ChronoUnit.HOURS));
    }

    @Test
    void temporalAdjustersTest() {
        LocalDate localDate = LocalDate.of(2022,12,9);
        LocalDate firstDay = localDate.with(TemporalAdjusters.firstDayOfMonth());   // 2022년 12월 1일
        
        System.out.println(firstDay);
        System.out.println(firstDay.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY)));  // 2022년 12월 첫번째 월요일
        System.out.println(firstDay
                .with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY))
                .with(TemporalAdjusters.next(DayOfWeek.THURSDAY))); // 2022년 12월 두번째 목요일
        System.out.println(localDate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)));   // 2022월 12월 9일 이후의 첫번째 일요일
        
    }

}
