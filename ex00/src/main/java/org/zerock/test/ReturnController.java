package org.zerock.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReturnController {
	
	// return type이 void인 경우는 url로 jsp를 찾는 자료로 사용한다.
	// /WEB-INF/views + /void/list + .jsp
	@GetMapping("/void/list")
	public void voidTest() {
	}
	
	// return type이 String인 경우 return되는 String으로 jsp를 찾는다.
	@GetMapping("/string/list.te")
	public String stringTest() {
		return "string/list";
	}
	
	// return type ModelAndView 인 경우 return 되는 객체의 데이터로 jsp를 찾는다.
	// 전달되는 데이터를 같이 담아서 넘긴다.
	@GetMapping("/modelAndView/list.do")
	public ModelAndView mavTest() {
		ModelAndView mav = new ModelAndView();
		// view에 해당되는 jsp 정보를 mav에 담는다.
		mav.setViewName("mav/list");
		// 전달해야할 정보도 mav에 담는다.
		mav.addObject("name","홍길동");
		return mav;
	}
}
