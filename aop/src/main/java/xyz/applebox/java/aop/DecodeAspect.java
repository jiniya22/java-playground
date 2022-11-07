package xyz.applebox.java.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import xyz.applebox.java.model.User;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Aspect
@Component
public class DecodeAspect {

    @Pointcut("execution(* xyz.applebox.java.controller..*.*(..))")
    private void pointcut1() { }

    @Pointcut("@annotation(xyz.applebox.java.annotation.Decode)")
    private void enableDecode() { }

    @Before("pointcut1() && enableDecode()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof User user) {
                String base64Email = user.getEmail();
                String email = new String(Base64.getDecoder().decode(base64Email), "UTF-8");
                user.setEmail(email);
                break;
            }
        }
    }

    @AfterReturning(value = "pointcut1() && enableDecode()", returning = "obj")
    public void afterReturning(JoinPoint joinPoint, Object obj) {
        if (obj instanceof User user) {
            String email = user.getEmail();
            String base64Email = Base64.getEncoder().encodeToString(email.getBytes());
            user.setEmail(base64Email);
        }
    }
}
