package xyz.applebox.java;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.bind.DatatypeConverter;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

@SpringBootTest
public class JwtTest {
    final byte[] SEC_KEY = DatatypeConverter.parseBase64Binary("key1234");
    final Algorithm ALGORITHM = Algorithm.HMAC256(SEC_KEY);

    void printToken(String token) {
        String[] tokens = token.split("\\.");
        System.out.println("header: " + new String(Base64.getDecoder().decode(tokens[0])));
        System.out.println("body: " + new String(Base64.getDecoder().decode(tokens[1])));
    }

    @DisplayName("1. jjwt 를 이용한 JWT 테스트")
    @Test
    void jjwtTest() {

        String oktaToken = Jwts.builder().addClaims(
                Map.of("name", "jini", "age", 31)
        ).signWith(SignatureAlgorithm.HS256, SEC_KEY).compact();

        System.out.println(oktaToken);
        printToken(oktaToken);

        Jws<Claims> body = Jwts.parser().setSigningKey(SEC_KEY).parseClaimsJws(oktaToken);
        System.out.println(body);

        DecodedJWT decodedJWT = JWT.require(ALGORITHM).build().verify(oktaToken);
        System.out.println(decodedJWT.getClaims());
    }

    @DisplayName("2. java-jwt 를 이용한 JWT 테스트")
    @Test
    void javaJwtTest() {
        String oauth0Token = JWT.create().withClaim("name", "coco").withClaim("age", 24).sign(ALGORITHM);
        System.out.println(oauth0Token);
        printToken(oauth0Token);

        DecodedJWT decodedJWT = JWT.require(ALGORITHM).build().verify(oauth0Token);
        System.out.println(decodedJWT.getClaims());

        Jws<Claims> body = Jwts.parser().setSigningKey(SEC_KEY).parseClaimsJws(oauth0Token);
        System.out.println(body);
    }
    
    @DisplayName("3. 만료시간 테스트")
    @Test
    void expireTest() {
        String token = JWT.create().withSubject("chaeking")
                .withNotBefore(new Date(System.currentTimeMillis() + 1000))
                .withExpiresAt(new Date(System.currentTimeMillis() + 3000))
                .sign(ALGORITHM);
        try {
            Thread.sleep(1500);
            DecodedJWT verify = JWT.require(ALGORITHM).build().verify(token);   // 만료되어 에러남
            System.out.println(verify.getClaims());
        } catch(Exception e) {
            System.out.println("유효하지 않은 토큰입니다");
            DecodedJWT decode = JWT.decode(token);
            System.out.println(decode.getClaims());
        }
    }
}
