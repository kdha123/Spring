package org.zerock.notice.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.notice.dto.NoticeDTO;
import org.zerock.notice.service.NoticeService;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	// 게시판 리스트
	@RequestMapping("/notice/list.do")
	public String list(Model model){
		// 처리한 결과 noticeService.list()를 model에 담는다.
		model.addAttribute("list", noticeService.list());
		// viewResolve에서 "/WEB-INF/views/"+ notice/list + ".jsp"
		// "redirect:~~" - redirect 실행, 없으면 - forward가 된다.
		return "notice/list";
	}
	
	// 게시판 보기
	@RequestMapping(value = "/notice/view.do", method = RequestMethod.GET)
	public String view(int no, Model model){
		// 넘어오는 데이터 확인
		System.out.println("noticeController.view().no: "+no);
		// 처리한 결과 noticeService.view(no)를 model에 담는다.
		model.addAttribute("dto", noticeService.view(no));
		return "notice/view";
	}
	
	//게시판 글쓰기 폼
	@RequestMapping(value = "/notice/write.do", method = RequestMethod.GET)
	public String writeForm(){
		return "notice/write";
	}
	
	// 게시판 글쓰기 처리
	@RequestMapping(value = "/notice/write.do",method = RequestMethod.POST)
	// Spring(DispatherServlet)이 넘어오는 데이터를 noticeDTO를 생성하고
	// 프로퍼티 이름과 같은 항이 있으면 바로 넣어준다.
	public String write(NoticeDTO dto){
		// 넘어오는 데이터 확인
		System.out.println("noticeController.write().dto: "+dto);
		// DB처리
		noticeService.write(dto);
		// 자동으로 게시판 리스트로 이동
		return "redirect:list.do";
	}
	
	//게시판 글수정 폼
	@RequestMapping(value = "/notice/update.do", method = RequestMethod.GET)
	public String updateForm(Model model,int no){
		model.addAttribute("dto", noticeService.view(no));
		return "notice/update";
	}
	// 게시판 글수정 처리
	@RequestMapping(value = "/notice/update.do",method = RequestMethod.POST)
	public String update(NoticeDTO dto){
		// 넘어오는 데이터 확인
		System.out.println("noticeController.update().dto: "+dto);
		// DB처리
		noticeService.update(dto);
		// 자동으로 게시판 글보기로 이동
		return "redirect:view.do?no="+dto.getNo();
	}
	//게시판 글삭제 처리
	@RequestMapping(value = "/notice/delete.do", method = RequestMethod.GET)
	public String delete(int no){
		// 넘어오는 데이터 확인
		System.out.println("noticeController.delete().no: "+no);
		// 처리한 결과 noticeService.view(no)를 model에 담는다.
		noticeService.delete(no);
		return "redirect:list.do?page=1&perPageNum=10";
	}
}
