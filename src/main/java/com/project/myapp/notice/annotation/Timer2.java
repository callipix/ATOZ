package com.project.myapp.notice.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Timer2 {

	/**
	 * 메서드 실행 시간 측정을 위한 Custom Annotation
	 * @Target : 어노테이션 추가 대상 지정
	 * ElementType.TYPE : 클래스, 인터페이스, 열거 타입에 어노테이션 추가
	 * ElementType.CONSTRUCTOR : 생성자에 어노테이션 추가
	 * ElementType.METHOD : 메서드에 어노테이션 추가
	 * ElementType.FIELD : 메서드 필드에 어노테이션 추가
	 *
	 * @Retention : 어노테이션이 언제까지 존재 할 수 있는지(Scope)
	 * RetentionPolicy.SOURCE : 컴파일 할 때 해당 어노테이션 제거. 소스코드(.java)까지는 존재
	 * RetentionPolicy.CLASS : 컴파일 할 때는 존재, 런타임 시 사라짐. 클래스 파일(.class)까지 존재
	 * RetentionPolicy.RUNTIME : 런타임 중에도 존재. 대부분 RUNTIME 어노테이션 사용
	 */
}
