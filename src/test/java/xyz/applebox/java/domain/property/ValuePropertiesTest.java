package xyz.applebox.java.domain.property;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ValuePropertiesTest {
    @Autowired
    private ValueProperties valueProperties;

    @Test
    void test() {
        System.out.println(valueProperties);
    }
}