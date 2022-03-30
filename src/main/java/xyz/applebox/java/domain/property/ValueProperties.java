package xyz.applebox.java.domain.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
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
    private List<String> sites2;

}
