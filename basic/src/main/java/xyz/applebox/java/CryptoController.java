package xyz.applebox.java;

import org.apache.logging.log4j.util.Strings;
import org.springframework.web.bind.annotation.*;
import xyz.applebox.java.domain.value.HmacTestValue;
import xyz.applebox.java.encrypt.HmacExample;

@RequestMapping("/crypto")
@RestController
public class CryptoController {

    @PostMapping("/hmac")
    public String hmac(@RequestHeader("Authorization") String authorization, @RequestBody HmacTestValue req) {
        if(Strings.isNotBlank(authorization)) {
            authorization = authorization.replaceAll("^Basic ", "");
        }
        if (authorization.equals(HmacExample.encrypt(req.getUserId()))) {
            return "메시지 검증 성공!! " + req.getName();
        } else {
            return "Authorization 정보가 잘못되었습니다";
        }
    }
}
