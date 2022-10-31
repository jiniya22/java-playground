package xyz.applebox.java.domain.property;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@ToString
@Setter
@Component
public class ValueProperties {
    @Value("${playground.relaxed-binding.user-id}")
    private String userId;
    @Value("${playground.relaxed-binding.password}")
    private String password;
    @Value("${playground.relaxed-binding.api-key}")
    private String apiKey;
    @Value("${playground.relaxed-binding.secret-key}")
    private String secretKey;
    @Value("${playground.relaxed-binding.sites2}")
    @Getter private final List<String> sites2 = new ArrayList<>();

}
