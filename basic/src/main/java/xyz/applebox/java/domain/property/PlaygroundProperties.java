package xyz.applebox.java.domain.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PlaygroundProperties {
    static String apiKey;
    static String secretKey;

    @Value("${playground.relaxed-binding.api-key}")
    public void setApiKey(String apiKey) {
        PlaygroundProperties.apiKey = apiKey;
    }

    @Value("${playground.relaxed-binding.secret-key}")
    public void setSecretKey(String secretKey) {
        PlaygroundProperties.secretKey = secretKey;
    }
}
