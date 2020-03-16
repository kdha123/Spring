package com.webjjang.reply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webjjang.reply.dto.ReplyDTO;
import com.webjjang.reply.sevice.ReplyService;
import com.webjjang.util.page.PageObject;

import lombok.extern.log4j.Log4j;

// @Controller는 jsp로 forward나 url로 redirect 시키는 기능을 처리하기 위한 컨트롤러
// @RestController는 순수한 데이터를 전달하는 기능을 처리하기 위한 객체
@Log4j
@RestController
//@AllArgsConstructor
@RequestMapping("/reply")
public class ReplyController {
	
	@Autowired
	@Qualifier("rs")
	private ReplyService replyService;
	private final String module = "reply";
	
	//1. 댓글 리스트
	@GetMapping("/pages/{no}/{page}")
	public ResponseEntity<List<ReplyDTO>> list(Model model, @PathVariable int page, @PathVariable int no) {
		// no, page 받아내기
		PageObject pageObject = new PageObject(page, 10);
		log.info(pageObject);
		// 동기식 데이터 처리 -> 브라우저의 주소가 바뀐다.
		// 지금 처리는 비동기식 데이터 처리
		// /WEB-INF/views/ + reply + /list + .jsp
		// DB에서 데이터 가져오기 -> 페이지 계산, JSP에서 표시할 페이지네이션 정보가 계산된다.
//		model.addAttribute("list", replyService.list(pageObject));
//		model.addAttribute("pageObject", pageObject);
		return new ResponseEntity<>(replyService.list(pageObject), HttpStatus.OK);
	}

	//2. 댓글 글쓰기 처리
	@PostMapping("/write.do")
	public String write(ReplyDTO dto) {
		// /WEB-INF/views/ + reply + /list + .jsp
		replyService.write(dto);
		return "redirect:list.do";
	}
	
	//3. 댓글 글수정 처리 - 전체 데이터
	@PostMapping("/update.do")
	public String update(ReplyDTO dto) {
		int result = replyService.update(dto);
		// return 값이 Integer로 넘어오기 때문에 0일 경우 처리가 안된 것.
		if(result > 0) {
			return "redirect:view.do?no=" + dto.getNo();
		}else {
			// 오류 보여주는 페이지로 이동 -> 수정이 정상적으로 안된 경우 : 비밀번호가 틀림
			return "error/error_pw";
		}
		// /WEB-INF/views/ + reply + /list + .jsp
		
	}
	//4. 댓글 글삭제 - 글번호, 비밀번호
	@PostMapping("/delete.do") //비밀번호가 있으므로 보이지 않게 post방식으로 전달
	public String delete(ReplyDTO dto) {
		// /WEB-INF/views/ + reply + /list + .jsp
		replyService.delete(dto);
		// 자동으로 리스트로 이동
		return "redirect:list.do";
	}
}
