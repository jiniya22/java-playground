package xyz.applebox.java.domain.property;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@ToString
@Setter
@Component
@ConfigurationProperties(prefix = "playground.relaxed-binding")
public class RelaxedBinding {
    private String userId;
    private String password;
    private String apiKey;
    private String secretKey;
    @Getter private final List<String> sites = new LinkedList<>();
    @Getter private final List<String> sites2 = new LinkedList<>();
    @Getter private final Option option = new Option();

    @ToString
    @Setter
    public static class Option {
        private String name;
        private boolean flag;
    }
}
