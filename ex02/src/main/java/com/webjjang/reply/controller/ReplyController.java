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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		return new ResponseEntity<>(replyService.list(pageObject, no), HttpStatus.OK);
	}

	//2. 댓글 글쓰기 처리
	// consumes : 전달되는 데이터 지정
	// produces : 돌려주는 값에 대한 데이터 설정
	@PostMapping(value="/new", consumes="application/json",produces= "application/text; charset=utf-8")
	public ResponseEntity<String> write(@RequestBody ReplyDTO dto) {
		// /WEB-INF/views/ + reply + /list + .jsp
		log.info(dto);
		try {
			replyService.write(dto);
			return new ResponseEntity<>("댓글이 등록되었습니다.",HttpStatus.OK);
		
		}catch(Exception e){
			return new ResponseEntity<>("댓글 등록 중 오류가 발생하였습니다.\\n"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//3. 댓글 글수정 처리 - 전체 데이터
	@RequestMapping(value="/{rno}", consumes="application/json",produces= "application/text; charset=utf-8", method = RequestMethod.PATCH)
	public ResponseEntity<String>update(@RequestBody ReplyDTO dto, @PathVariable int rno) {
		dto.setRno(rno);
		log.info("------------------"+dto);
		int result = replyService.update(dto);
		// return 값이 Integer로 넘어오기 때문에 0일 경우 처리가 안된 것.
		if(result > 0) {
			// 수정이 정상적으로 된 경우
			return new ResponseEntity<>("댓글이 수정되었습니다.",HttpStatus.OK);
		}else {
			// 수정이 정상적으로 안된 경우 : 비밀번호가 틀림
			return new ResponseEntity<>("댓글 수정 중 오류가 발생하였습니다.\\n",HttpStatus.NOT_ACCEPTABLE);
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
