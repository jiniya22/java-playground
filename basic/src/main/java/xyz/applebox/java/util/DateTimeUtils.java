package xyz.applebox.java.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils {
    public static final ZoneId ZONE_ID = ZoneId.systemDefault();
    public static final ZoneOffset ZONE_OFFSET = ZonedDateTime.now().getOffset();
//    public static final ZoneId ZONE_ID_SEOUL = ZoneId.of("Asia/Seoul");
//    public static final ZoneOffset ZONE_OFFSET_SEOUL = ZoneOffset.of("+09:00");

    public static final SimpleDateFormat SDF_DATETIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter DTF_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter DTF_TIME = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static final DateTimeFormatter DTF_DATETIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    //-----------------------------------------------------------------------
    // Calendar to xxx
    public static @NotNull Date calendarToDate(@NotNull Calendar calendar) {
        return calendar.getTime();
    }

    public static @NotNull LocalDate calendarToLocalDate(@NotNull Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
//        int month = calendar.get(Calendar.MONTH) + 1;
//        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        return LocalDate.ofYearDay(year, dayOfYear);
//        return LocalDate.of(year, month, dayOfMonth);
    }

    public static LocalTime calendarToLocalTime(@NotNull Calendar calendar) {
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        return LocalTime.of(hourOfDay, minute, second);
    }

    public static @NotNull LocalDateTime calendarToLocalDateTime(@NotNull Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        return LocalDateTime.of(year, month, dayOfMonth, hourOfDay, minute, second);

//        LocalDate localDate = LocalDate.of(year, month, dayOfMonth);
//        LocalTime localTime = LocalTime.of(hourOfDay, minute, second);
//        return LocalDateTime.of(localDate, localTime);
    }

    public static Timestamp calendarToTimestamp(@NotNull Calendar calendar) {
        return new Timestamp(calendar.getTime().getTime());
    }

    //-----------------------------------------------------------------------
    // Date to xxx
    public static Calendar dateToCalendar(@NotNull Date date) {
        return new Calendar.Builder().setInstant(date).build();
    }

    public static @NotNull LocalDate dateToLocalDate(@NotNull Date date) {
        return LocalDate.ofInstant(date.toInstant(), ZONE_ID);
    }

    public static @NotNull LocalTime dateToLocalTime(@NotNull Date date) {
        return LocalTime.ofInstant(date.toInstant(), ZONE_ID);
    }

    @Contract("_ -> new")
    public static @NotNull LocalDateTime dateToLocalDateTime(@NotNull Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZONE_ID);
    }

    public static @NotNull Timestamp dateToTimestamp(@NotNull Date date) {
        return new Timestamp(date.getTime());
    }

    //-----------------------------------------------------------------------
    // LocalDate to xxx
    public static Date localDateToDate(@NotNull LocalDate localDate) {
        return Date.from(localDateToLocalDateTime(localDate).toInstant(ZONE_OFFSET));
    }

    public static @NotNull Timestamp localDateToTimestamp(@NotNull LocalDate localDate) {
        return Timestamp.valueOf(localDateToLocalDateTime(localDate));
    }

    public static LocalDateTime localDateToLocalDateTime(@NotNull LocalDate localDate) {
        return localDate.atStartOfDay();
    }

    //-----------------------------------------------------------------------
    // LocalDateTime to xxx
    public static Date localDateTimeToDate(@NotNull LocalDateTime localDateTime) {
        return Date.from(localDateTime.toInstant(ZONE_OFFSET));
    }

    public static @NotNull Timestamp localDateTimeToTimestamp(@NotNull LocalDateTime localDateTime) {
        return Timestamp.valueOf(localDateTime);
    }

    public static LocalDate localDateTimeToLocalDate(@NotNull LocalDateTime localDateTime) {
        return localDateTime.toLocalDate();
    }

    public static LocalTime localDateTimeToLocalTime(@NotNull LocalDateTime localDateTime) {
        return localDateTime.toLocalTime();
    }

    //-----------------------------------------------------------------------
    // Timestamp to xxx
    public static Date timestampToDate(Timestamp timestamp) {
        return Date.from(timestamp.toInstant());
    }

    public static LocalDate timestampToLocalDate(Timestamp timestamp) {
        return LocalDate.ofInstant(timestamp.toInstant(), ZONE_ID);
    }

    public static LocalTime timestampToLocalTime(Timestamp timestamp) {
        return LocalTime.ofInstant(timestamp.toInstant(), ZONE_ID);
    }

    public static LocalDateTime timestampToLocalDateTime(Timestamp timestamp) {
        return LocalDateTime.ofInstant(timestamp.toInstant(), ZONE_ID);
    }
}
