package org.zerock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Log4j // log를 만들어서 가져오는 처리문을 대신한다.
public class CommonExceptionAdvice {
	
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
 