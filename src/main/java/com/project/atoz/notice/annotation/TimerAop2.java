package com.project.atoz.notice.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class TimerAop2 {

	@Pointcut("@annotation(com.project.atoz.notice.annotation.Timer2)")
	private void enableTimer() {
		//     @Pointcut("@annotation(com.project.myapp.notice.annotation.Timer)") : Timer 어노테이션이 붙은 메서드에만 적용

	}

	@Around("enableTimer()")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		// 메서드 실행시 실행 시간 측정
		StopWatch stopWatch = new StopWatch();
		try {
			stopWatch.start();
			return joinPoint.proceed();   // 메서드 실행부분
		} finally {
			stopWatch.stop();
			log.info("메서드 동작 시간 = {}", stopWatch.getTotalTimeSeconds());
		}
	}
}

