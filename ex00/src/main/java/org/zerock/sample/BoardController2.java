package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.Data;
import lombok.Setter;

// 자동생성되는 어노테이션(scan)
// - /WEB-INT/spring/appServlet/servlet-context.xml
// - @Controller, @Service, @Repository, @Component, @RestController
@Controller
@Data
public class BoardController2 {
	@Setter(onMethod_ = {@Autowired})
	private BoardService2 boardService;
}
