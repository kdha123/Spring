package org.zerock.board.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/board/list.do")
	public String list(Model model){
		// 처리한 결과 boardService.list()를 model에 담는다.
		model.addAttribute("list", boardService.list());
		// viewResolve에서 "/WEB-INF/views/"+ board/list + ".jsp"
		// "redirect:~~" - redirect 실행, 없으면 - forward가 된다.
		return "board/list";
	}
	@RequestMapping("/board/view.do")
	public String view(Model model){
		// 처리한 결과 boardService.list()를 model에 담는다.
		int no;
		model.addAttribute("view", boardService.view());
		// viewResolve에서 "/WEB-INF/views/"+ board/list + ".jsp"
		// "redirect:~~" - redirect 실행, 없으면 - forward가 된다.
		return "board/view";
	}
}
