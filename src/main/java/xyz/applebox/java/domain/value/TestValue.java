package xyz.applebox.java.domain.value;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Data
@NoArgsConstructor
public class TestValue {
    private String name;
    private int age;
    private String job;
    private Date date;
    private LocalDateTime localDateTime;
    private LocalDate localDate;
    private LocalTime localTime;

    @Builder
    public TestValue(String name, int age, String job, Date date, LocalDateTime localDateTime, LocalDate localDate, LocalTime localTime) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.date = date;
        this.localDateTime = localDateTime;
        this.localDate = localDate;
        this.localTime = localTime;
    }
}
