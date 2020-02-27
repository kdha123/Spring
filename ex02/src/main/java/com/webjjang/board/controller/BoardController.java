package com.webjjang.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webjjang.board.dto.BoardDTO;
import com.webjjang.board.sevice.BoardService;
//import com.webjjang.board.sevice.BoardServiceImpl;

//import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board")
// 생성자에 의해서 멤버 변수를 초기화시키는 작업을 한다.
// 멤버 변수 중에서 직접 지정한 변수들을 따로 초기화 작업을 한 경우 ->@Autowired나 @Inject 사용
//@AllArgsConstructor
public class BoardController {

	@Autowired
	@Qualifier("bs")
	private BoardService boardService;
	private final String module = "board";
	
	//1. 게시판 리스트
	@GetMapping("/list.do")
	public String list(Model model) {
		// /WEB-INF/views/ + board + /list + .jsp
		model.addAttribute("list", boardService.list());
		return module+"/list";
	}
	//2. 게시판 글보기
	@GetMapping("/view.do")
	public String view(Model model, int no) {
		// /WEB-INF/views/ + board + /list + .jsp
		model.addAttribute("dto", boardService.view(no));
		return module+"/view";
	}
	//3. 게시판 글쓰기 폼
	@GetMapping("/write.do")
	public String writeForm() {
		// /WEB-INF/views/ + board + /list + .jsp
		return module+"/write";
	}
	//3-1. 게시판 글쓰기 처리
	@PostMapping("/write.do")
	public String write(BoardDTO dto) {
		// /WEB-INF/views/ + board + /list + .jsp
		boardService.write(dto);
		return "redirect:list.do";
	}
	//4. 게시판 글수정 폼
	@GetMapping("/update.do")
	public String updateForm(Model model, int no) {
		model.addAttribute("dto",boardService.view(no));
		// /WEB-INF/views/ + board + /list + .jsp
		return module+"/update";
	}
	//4-1. 게시판 글수정 처리 - 전체 데이터
	@PostMapping("/update.do")
	public String update(BoardDTO dto) {
		boardService.update(dto);
		// /WEB-INF/views/ + board + /list + .jsp
		return "redirect:view.do?no=" + dto.getNo();
	}
	//5. 게시판 글삭제 - 글번호, 비밀번호
	@PostMapping("/delete.do") //비밀번호가 있으므로 보이지 않게 post방식으로 전달
	public String delete(BoardDTO dto) {
		// /WEB-INF/views/ + board + /list + .jsp
		boardService.delete(dto);
		// 자동으로 리스트로 이동
		return "redirect:list.do";
	}
}