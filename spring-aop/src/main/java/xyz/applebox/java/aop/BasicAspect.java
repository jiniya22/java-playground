package xyz.applebox.java.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BasicAspect {

    @Pointcut("execution(* xyz.applebox.java.controller..*.*(..))")
    private void pointcut1() { }

    @Before("pointcut1()")
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Before>> method name: " + methodSignature.getMethod().getName());

        for (Object arg : joinPoint.getArgs()) {
            System.out.println("type: " + arg.getClass().getSimpleName());
            System.out.println("value: " + arg);
        }
    }

    @AfterReturning(value = "pointcut1()", returning = "obj")
    public void afterReturning(JoinPoint joinPoint, Object obj) {
        System.out.println("After>> return object: " + obj);
    }
}
