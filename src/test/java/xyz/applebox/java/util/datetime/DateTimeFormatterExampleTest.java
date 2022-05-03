package xyz.applebox.java.util.datetime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
public class DateTimeFormatterExampleTest {

    // 2022-02-05 15:05:02.844351600
    LocalDateTime localDateTime1 = LocalDateTime.of(2022, 2, 5, 15, 5, 2, 844351600);
    LocalDateTime localDateTime2 = LocalDateTime.of(2022, 2, 14, 0, 5, 2, 844351600);

    @Test
    void datePatternTest() {
        System.out.println(String.format("%s → %s", "yyyy.MM.dd HH:mm:ss",
                localDateTime1.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"))));
        System.out.println(String.format("%s → %s", "yy.M.d a hh:mm:ss.n",
                localDateTime1.format(DateTimeFormatter.ofPattern("yy.M.d a hh:mm:ss.n"))));
        System.out.println(String.format("%s → %s", "yy.M.d a h:m:s",
                localDateTime1.format(DateTimeFormatter.ofPattern("yy.M.d a h:m:s"))));
        System.out.println();
    }


    @Test
    void timePatternTest() {
        System.out.println(String.format("%s → %s", "yyyy.MM.dd HH:mm:ss",
                localDateTime2.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"))));
        System.out.println(String.format("%s → %s", "kk:mm:ss",
                localDateTime2.format(DateTimeFormatter.ofPattern("kk:mm:ss"))));
        System.out.println(String.format("%s → %s", "KK:mm:ss",
                localDateTime2.format(DateTimeFormatter.ofPattern("KK:mm:ss"))));
        System.out.println(String.format("%s → %s", "hh:mm:ss",
                localDateTime2.format(DateTimeFormatter.ofPattern("hh:mm:ss"))));
    }
}
