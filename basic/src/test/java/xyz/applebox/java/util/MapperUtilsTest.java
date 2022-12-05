package xyz.applebox.java.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.applebox.java.domain.value.TestValue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@SpringBootTest
class MapperUtilsTest {

    @Test
    public void serializeTest() {
        TestValue testValue1 = TestValue.builder().name("coco").age(24).job("programmer").date(new Date())
                .localDate(LocalDate.now()).localTime(LocalTime.now()).localDateTime(LocalDateTime.now()).build();
        try {
            String sTestValue1 = MapperUtils.jsonMapper.writeValueAsString(testValue1);
            System.out.println(sTestValue1);
        } catch (JsonProcessingException e) {}
    }

    @Test
    public void deserializeTest() {
        String sTestValue1 = """
        {
            "age" : 24,
            "date" : 1653461920758,
            "job" : "programmer",
            "local_date" : "2022-05-25",
            "local_date_time" : "2022-05-25 15:58:40",
            "local_time" : "15:58:40",
            "name" : "coco"
        }
        """;
        try {
            TestValue testValue = MapperUtils.jsonMapper.readerFor(TestValue.class).readValue(sTestValue1);
            System.out.println(testValue);
        } catch(JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}