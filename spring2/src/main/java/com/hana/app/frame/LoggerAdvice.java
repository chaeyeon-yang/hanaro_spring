package com.hana.app.frame;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggerAdvice {
    @Around("execution(* com.*.*.*.*Service.*(..))")
    public Object around(ProceedingJoinPoint process){
        Object result = null;
        Signature si = process.getSignature();
        String className = process.getTarget().toString();
        long start = System.currentTimeMillis();
        // 함수 실행 전, 실행 후 시간을 로그로 찍어서 확인
        System.out.println("***Before:"+si.getName()+" "+className);
        try {
            result = process.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(
                si.getName()+" 시간: "+(end-start)+"ms");
        System.out.println("***After:"+si.getName()+" "+className);
        return result;
    }
}