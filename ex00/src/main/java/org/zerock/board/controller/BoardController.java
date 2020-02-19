package org.zerock.board.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	// 게시판 리스트
//	@RequestMapping("/list.do")
	@GetMapping("/list.do")
	// 기본형 변수인 경우 값이 안넘어오면 오류가 난다. defaultValue=1로 선언해서 기본값을 셋팅할 수 있다.
	public String list(@RequestParam(defaultValue = "1") int page, Model model){
		// 처리한 결과 boardService.list()를 model에 담는다.
		model.addAttribute("list", boardService.list());
		// viewResolve에서 "/WEB-INF/views/"+ board/list + ".jsp"
		// "redirect:~~" - redirect 실행, 없으면 - forward가 된다.
		return "board/list";
	}
	
	// 게시판 보기
//	@RequestMapping(value = "/view.do", method = RequestMethod.GET)
	@GetMapping("/view.do")
	// 기본형 변수 + String으로 선언된 변수는 반드시 파라메터로 넘어와야한다. 안넘어오면 오류
	//@RequestParam("no") : 넘어오는 파라메터 이름이 no인 데이터 가져오기
	// --> 파라메터 이름과 매개변수명이 같은 경우 생략할 수 있다.
	public String view(@RequestParam("no") int no, Model model){
		// 넘어오는 데이터 확인
		System.out.println("BoardController.view().no: "+no);
		// 처리한 결과 boardService.view(no)를 model에 담는다.
		model.addAttribute("dto", boardService.view(no));
		return "board/view";
	}
	
	//게시판 글쓰기 폼
	@GetMapping("/write.do")
	public String writeForm(){
		return "board/write";
	}
	
	// 게시판 글쓰기 처리
	@PostMapping("/write.do")
	// Spring(DispatherServlet)이 넘어오는 데이터를 BoardDTO를 생성하고
	// 프로퍼티 이름과 같은 항이 있으면 바로 넣어준다.
	public String write(BoardDTO dto){
		// 넘어오는 데이터 확인
		System.out.println("BoardController.write().dto: "+dto);
		// DB처리
		boardService.write(dto);
		// 자동으로 게시판 리스트로 이동
		return "redirect:list.do";
	}
	
	//게시판 글수정 폼
	@GetMapping("/update.do")
	public String updateForm(Model model,int no){
		model.addAttribute("dto", boardService.view(no));
		return "board/update";
	}
	// 게시판 글수정 처리
	@PostMapping("/update.do")
	public String update(BoardDTO dto){
		// 넘어오는 데이터 확인
		System.out.println("BoardController.update().dto: "+dto);
		// DB처리
		boardService.update(dto);
		// 자동으로 게시판 글보기로 이동
		return "redirect:view.do?no="+dto.getNo();
	}
	//게시판 글삭제 처리
	@GetMapping("/delete.do")
	public String delete(int no){
		// 넘어오는 데이터 확인
		System.out.println("BoardController.delete().no: "+no);
		// 처리한 결과 boardService.view(no)를 model에 담는다.
		boardService.delete(no);
		return "redirect:list.do?page=1&perPageNum=10";
	}
}
