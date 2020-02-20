package org.zerock.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.board.dto.BoardDTO;

// component-scan에 의해서 자동으로 생성되는 어노테이션 지정
// @Controller - url mapping에 이루어진다. forward(jsp)나 redirect를 한다.
// @Service - 데이터 처리를 총괄
// @Repository - DAO 프로그램 - 데이터 저장과 검색
// @Component - 구성에 의해서 필요한 객체
// @RestController - url mapping이 이루어진다. 처리된 데이터를 사용자에게 직접 전달.
//                 - 보통 Ajax 처리할 때 많이 사용(특히, Mobile의 앱의 데이터처리)->JSON, XML 등
@RestController
public class ReturnRestController {

	// @RestController인 경우 리턴되는 String은 순수한 데이터로 처리가 되어 전달된다.
	@GetMapping(value = "/ajax/string.do", produces = "text/plain; charset=utf-8")
	public String testString() {
		return "김동현";
	}
	
	// DTO(VO) -> 라이브러리(jackson-databind) json 데이터로 전송
	@GetMapping("/ajax/board")
	public BoardDTO testDTO() {
		BoardDTO dto = new BoardDTO();
		dto.setNo(1);
		dto.setTitle("DTO return");
		return dto;
	}
	
	// DTO(VO), List
	@GetMapping("/ajax/list")
	public List<BoardDTO> testList() {
		BoardDTO dto = new BoardDTO();
		dto.setNo(1);
		dto.setTitle("List return");
		BoardDTO dto1 = new BoardDTO();
		dto1.setNo(2);
		dto1.setTitle("List return2");
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		list.add(dto1);
		list.add(dto);
		return list;
	}
	
	@GetMapping(value = "/ajax/stringEntity", produces = "text/plain; charset=utf-8")
	public ResponseEntity<String> testEntity(){
		System.out.println("HttpStatus.OK"+HttpStatus.OK );
		System.out.println("HttpStatus.BAD_REQUEST"+HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>("김동현",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/ajax/dtoEntity")
	public ResponseEntity<BoardDTO> testDtoEntity(){
		BoardDTO dto = new BoardDTO();
		dto.setNo(1);
		dto.setTitle("김동현");
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}
