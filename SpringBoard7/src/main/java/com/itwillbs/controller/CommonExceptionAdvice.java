package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 예외처리를 수행하는 클래스 
 *
 */

// @ControllerAdvice (컨트롤러 보조기능)
// => 해당 클래스가 예외처리를 전문적으로 수행하는 클래스
// => 컨트롤러가 던진 예외 정보를 처리

@ControllerAdvice
public class CommonExceptionAdvice {
	
	
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);

	// @ExceptionHandler(Exception.class)
	// => Exception 예외가 발생시 처리하는 메서드 정의
	
	// @ExceptionHandler(NullPointerException.class)
	@ExceptionHandler(Exception.class)
	public String common(Exception e) {
		// => 컨트롤러는 아니지만 컨트롤러 처럼 동작
		
		logger.info("e : {}", e.getMessage());
		// => 실제 서비스의 경우 DB에 저장
		
		return "errPage";
		// => 보여줄(연결된) 뷰페이지 이름
	}
	
	
}
























