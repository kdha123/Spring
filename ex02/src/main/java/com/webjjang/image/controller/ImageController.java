package com.webjjang.image.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.webjjang.image.dto.ImageDTO;
import com.webjjang.image.sevice.ImageService;
import com.webjjang.util.file.FileUtil;
//import com.webjjang.image.sevice.ImageServiceImpl;
import com.webjjang.util.page.PageObject;

//import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/image")
// 생성자에 의해서 멤버 변수를 초기화시키는 작업을 한다.
// 멤버 변수 중에서 직접 지정한 변수들을 따로 초기화 작업을 한 경우 ->@Autowired나 @Inject 사용
//@AllArgsConstructor
public class ImageController {

	@Autowired
	@Qualifier("is")
	private ImageService service;
	private final String module = "image";
	
	//1. 게시판 리스트
	@GetMapping("/list.do")
	public String list(Model model, PageObject pageObject) {
//		System.out.println("ImageController.list().pageObject : "+pageObject);
		// 이미지 게시판인 경우 이미지의 한줄에 나타낼 수 있는 이미지 갯수 * n -> 갯수
		// 한줄에 4개 표시 2줄표시
		pageObject.setPerPageNum(8);
		// /WEB-INF/views/ + image + /list + .jsp
		// DB에서 데이터 가져오기 -> 페이지 계산, JSP에서 표시할 페이지네이션 정보가 계산된다.
		model.addAttribute("list", service.list(pageObject));
		model.addAttribute("pageObject", pageObject);
		log.info("list");
		return module+"/list";
	}
	//2. 게시판 글보기
	@GetMapping("/view.do")
	public String view(Model model, int no) {
		// /WEB-INF/views/ + image + /list + .jsp
		model.addAttribute("dto", service.view(no));
		return module+"/view";
	}
	//3. 게시판 글쓰기 폼
	@GetMapping("/write.do")
	public String writeForm() {
		// /WEB-INF/views/ + image + /list + .jsp
		return module+"/write";
	}
	//3-1. 게시판 글쓰기 처리
	// 작성자 아이디는 session에서 받아야한다.
	// 이미지 파일을 dto의 property로 전달이 되지 않는다. -> 메서드의 별도의 파라메터로 지정
	// -> dto에 넣어준다.
	@PostMapping("/write.do")
	public String write(ImageDTO dto, HttpSession session, MultipartFile multiFile, HttpServletRequest request) throws Exception {
		// /WEB-INF/views/ + image + /list + .jsp
		// DTO 데이터를 자동으로 넘겨 받는다.
		// 로그인 처리가 되어있지 않으면 강제 로그인 해줘야한다.
		dto.setId("test");
		dto.setMultiFile(multiFile);
		String realPath = request.getServletContext().getRealPath("/upload/image");
		// 중복제거한 후 저장한 파일객체
		File saveFile = FileUtil.removeDuplicateFileName(realPath, multiFile.getOriginalFilename());
		System.out.println(realPath);
		System.out.println("*******************saveFile.getName() : " + saveFile.getName());
		// DB에 저장할 파일 이름 셋팅
		dto.setFileName("/upload/image/" + saveFile.getName());
		// 전달된 파일 저장
		multiFile.transferTo(saveFile);
		service.write(dto);
		return "redirect:list.do";
	}
	//4. 게시판 글수정 폼
	@GetMapping("/update.do")
	public String updateForm(Model model, int no) {
		model.addAttribute("dto",service.view(no));
		// /WEB-INF/views/ + image + /list + .jsp
		return module+"/update";
	}
	//4-1. 게시판 글수정 처리 - 전체 데이터
	@PostMapping("/update.do")
	public String update(ImageDTO dto) {
		int result = service.update(dto);
		// return 값이 Integer로 넘어오기 때문에 0일 경우 처리가 안된 것.
		if(result > 0) {
			return "redirect:view.do?no=" + dto.getNo();
		}else {
			// 오류 보여주는 페이지로 이동 -> 수정이 정상적으로 안된 경우 : 비밀번호가 틀림
			return "error/error_pw";
		}
		// /WEB-INF/views/ + image + /list + .jsp
		
	}
	//5. 게시판 글삭제 - 글번호, 비밀번호
	@PostMapping("/delete.do") //비밀번호가 있으므로 보이지 않게 post방식으로 전달
	public String delete(ImageDTO dto) {
		// /WEB-INF/views/ + image + /list + .jsp
		service.delete(dto);
		// 자동으로 리스트로 이동
		return "redirect:list.do";
	}
}
