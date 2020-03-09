package com.webjjang.board.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webjjang.board.dto.BoardDTO;
import com.webjjang.board.mapper.BoardMapper;
import com.webjjang.util.page.PageObject;

import lombok.AllArgsConstructor;
//import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
// 로그를 출력하기 위해서 - log.info()
@Log4j
// 자동생성 - @Controller, @Service, @Repository,@Component, @RestController
//		- @ControllerAdvice, @RestControllerAdvice
@Service
@Qualifier("bs")
// 생성자를 이용해서 private 멤버 변수에 DI 적용 -> mapper가 적용
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	// DB처리를 위한 Mapper 변수 선언
	private BoardMapper mapper;
	
	@Override
	public List<BoardDTO> list(PageObject pageObject) {
		// TODO Auto-generated method stub
		// 페이지 정보를 계산하는 메서드 호출
		pageObject.calcuPageInfo();
		// jsp의 페이지 네이션을 위한 계산 -> jsp에 전달이 되어야한다. request에 담는다.(Model)
		pageObject.setTotalRow(mapper.getTotalRow());
		System.out.println("BoardServiceImpl.list().pageObject : "+pageObject);
//		log.info(mapper.list(pageObject));
		return mapper.list(pageObject);
	}

	@Override
	public Integer write(BoardDTO dto) {
		// TODO Auto-generated method stub
		return mapper.write(dto);
	}

	@Override
	public BoardDTO view(int no) {
		// TODO Auto-generated method stub
		mapper.increaseHit(no);
		return mapper.view(no);
	}

	@Override
	public Integer update(BoardDTO dto) {
		// TODO Auto-generated method stub
		return mapper.update(dto);
	}

	@Override
	public Integer delete(BoardDTO dto) {
		// TODO Auto-generated method stub
		return mapper.delete(dto);
	}

}
