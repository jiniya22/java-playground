package xyz.applebox.java.domain.property;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlaygroundPropertiesTest {

    @Test
    void test() {
        System.out.println("apiKey >> " + PlaygroundProperties.apiKey);
        System.out.println("secretKey >> " + PlaygroundProperties.secretKey);
    }
}