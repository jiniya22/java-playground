package xyz.applebox.java.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.applebox.java.domain.property.GsonTest;
import xyz.applebox.java.domain.value.TestValue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@SpringBootTest
class GsonUtilsTest {
    @Autowired
    private GsonTest gsonTest;

    @Test
    void gsonBasicTest() {
        String htmlEscapingTest = gsonTest.getHtmlEscapingTest();
        System.out.println(htmlEscapingTest);

        String htmlTest2 = GsonUtils.toJson(gsonTest);
        System.out.println(htmlTest2);
    }

    @Test
    void gsonTest() {
        TestValue testValue1 = TestValue.builder().name("coco").age(24).job("programmer").date(new Date())
                .localDate(LocalDate.now()).localTime(LocalTime.now()).localDateTime(LocalDateTime.now()).build();
        String sTestValue1 = GsonUtils.toJson(testValue1);
        System.out.println(sTestValue1);
        System.out.println(GsonUtils.fromJson(sTestValue1, TestValue.class));

        System.out.println();

        TestValue testValue2 = TestValue.builder().name("coco")
                .localDate(LocalDate.now()).localTime(LocalTime.now()).build();
        String sTestValue2 = GsonUtils.toJson(testValue2);
        System.out.println(sTestValue2);
        System.out.println(GsonUtils.fromJson(sTestValue2, TestValue.class));
    }


}