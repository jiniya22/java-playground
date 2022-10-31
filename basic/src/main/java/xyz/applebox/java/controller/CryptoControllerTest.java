package xyz.applebox.java.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import xyz.applebox.java.domain.value.HmacTestValue;
import xyz.applebox.java.encrypt.HmacExample;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CryptoControllerTest {
    @LocalServerPort
    int port;

    RestTemplate client = new RestTemplate();

    @DisplayName("1. Hmac 메시지 검증 테스트")
    @Test
    void hmacTest() {
        // AUTHORIZATION 에 이용된 HMAC 암호화값과 RequestBody에 들어있는 userId 가 일치한 경우
        String userId = "U001";
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Basic "+ HmacExample.encrypt(userId));
        HmacTestValue body = new HmacTestValue(userId, "jini");
        HttpEntity entity = new HttpEntity(body, headers);
        ResponseEntity<String> resp = client.exchange("http://localhost:"+port+"/crypto/hmac", HttpMethod.POST, entity, String.class);
        System.out.println(resp.getBody());

        // AUTHORIZATION 에 이용된 HMAC 암호화값과 RequestBody에 들어있는 userId 가 일치하지 않은 경우
        HmacTestValue body2 = new HmacTestValue("U002", "jini");
        HttpEntity entity2 = new HttpEntity(body2, headers);
        ResponseEntity<String> resp2 = client.exchange("http://localhost:"+port+"/crypto/hmac", HttpMethod.POST, entity2, String.class);
        System.out.println(resp2.getBody());    

    }

}