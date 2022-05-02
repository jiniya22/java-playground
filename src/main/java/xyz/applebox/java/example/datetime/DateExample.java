package xyz.applebox.java.example.datetime;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class DateExample {

    public static void calendarToTimestamp() {
        Date date = new Date();
        LocalDateTime localDateTime = LocalDateTime.now();

        Timestamp timestamp1 = new Timestamp(date.getTime());
        Timestamp timestamp2 = Timestamp.valueOf(localDateTime);
        System.out.println(timestamp1);
        System.out.println(timestamp2);
    }
}
