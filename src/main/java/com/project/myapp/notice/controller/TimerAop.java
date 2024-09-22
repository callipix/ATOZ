package com.project.myapp.notice.controller;

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
public class TimerAop {

	private final int repeatCount = 51; // 평균을 낼 최소 실행 횟수

	@Pointcut("@annotation(com.project.myapp.notice.controller.Timer)")
	private void enableTimer() {
		//     @Pointcut("@annotation(com.project.myapp.notice.controller.Timer)") : Timer 어노테이션이 붙은 메서드에만 적용

	}

	@Around("enableTimer()")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		double totalExecutionTime = 0.0;

		for (int i = 0; i < repeatCount; i++) {
			// 각 반복마다 새로운 StopWatch 객체 생성
			StopWatch stopWatch = new StopWatch();
			try {
				stopWatch.start();
				joinPoint.proceed(); // 메서드 실행
				stopWatch.stop();
				double executionTime = stopWatch.getTotalTimeSeconds();

				if (i == 0) {
					log.info("first cache before execution time: {}", executionTime);
				} else {
					totalExecutionTime += executionTime;
					log.info("메서드 {} 번째 동작 시간= {}", i + 1, executionTime);
				}

			} catch (Throwable throwable) {
				log.error("메서드 실행 중 오류 발생: {}", throwable.getMessage());
				throw throwable; // 오류 발생시 예외 던짐
			}
		}

		double averageExecutionTime = totalExecutionTime / repeatCount;
		log.info("평균 메서드 동작 시간 ({}회 실행) = {}", repeatCount, averageExecutionTime);
		return null; //
	}

}