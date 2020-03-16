package com.webjjang.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

/*
 * 자동으로 생성이 되어지게 하는 어노테이션 
 * - @Controller : 서버의 uri를 클래스나 메서드를 매칭시켜주는 처리 : @RequestMapping
 * - @Service : 처리되는 프로세서를 처리해 주는 객체 => 호출해서 사용
 * - @Repository : DB연동에 관련된 처리
 * - @Component : 객체의 구성으로 포함시키는 객체
 * - @RestController : 서버의 uri를 클래스나 메서드에 매칭시키는 처리, 순수 데이터(text, json, xml) 전송
 * - @ControllerAdvice, @RestControllerAdvice : spring의 예외처리객체 => 예외와 메서드를 매칭시켜서 처리되도록 한다.
 */
@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {

	// 500 오류 - 내부오류
	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model) {
		log.error("Exception...." + ex.getMessage());
		// 예외객체를 JSP에서 사용해서 예외 정보를 출력하려고 한다면 데이터로 넘겨주기위해서
		// model이 필요하다.
		model.addAttribute("exception", ex);
		log.error(model);
		// WEB-INF/views + error_page + .jsp
		return "error/error_page";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex) {
		return "error/custom404";
	}
}
