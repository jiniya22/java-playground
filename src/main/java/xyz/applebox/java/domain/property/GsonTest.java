package xyz.applebox.java.domain.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "playground.gson-test")
public class GsonTest {
    private String htmlEscapingTest;
    private String stringTest;
}
