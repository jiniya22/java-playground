package xyz.applebox.java.example.datetime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
public class DateTimeFormatterPatternTest {

    @Test
    void patternTest() {
        LocalDateTime localDateTime = LocalDateTime.of(2022, 2, 5, 15, 12, 30);

        System.out.println(String.format("%s → %s", "yyyy.MM.dd HH:mm:ss",
                localDateTime.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"))));
        System.out.println(String.format("%s → %s", "yy.M.d a hh:mm:ss",
                localDateTime.format(DateTimeFormatter.ofPattern("yy.M.d a hh:mm:ss"))));
        System.out.println(String.format("%s → %s", "kk:mm:ss",
                localDateTime.format(DateTimeFormatter.ofPattern("kk:mm:ss"))));
    }


    @Test
    void patternTest2() {
        LocalDateTime localDateTime = LocalDateTime.of(2022, 2, 14, 0, 12, 30);

        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yy.MM.dd ")));
    }
}
