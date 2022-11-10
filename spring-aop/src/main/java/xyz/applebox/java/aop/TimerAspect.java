package xyz.applebox.java.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAspect {

    @Pointcut("execution(* xyz.applebox.java.controller..*.*(..))")
    private void pointcut1() { }

    @Pointcut("@annotation(xyz.applebox.java.annotation.Timer)")
    private void enableTimer() { }

    @Around("pointcut1() && enableTimer()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();
        System.out.println("execution time(s): " + stopWatch.getTotalTimeSeconds());
    }

}
