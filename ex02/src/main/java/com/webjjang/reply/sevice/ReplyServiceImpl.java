package com.webjjang.reply.sevice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webjjang.reply.dto.ReplyDTO;
import com.webjjang.reply.mapper.ReplyMapper;
import com.webjjang.util.page.PageObject;

import lombok.AllArgsConstructor;
//import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
// 로그를 출력하기 위해서 - log.info()
@Log4j
// 자동생성 - @Controller, @Service, @Repository,@Component, @RestController
//		- @ControllerAdvice, @RestControllerAdvice
@Service
@Qualifier("rs")
// 생성자를 이용해서 private 멤버 변수에 DI 적용 -> mapper가 적용
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	
	// DB처리를 위한 Mapper 변수 선언
	private ReplyMapper mapper;
	
	@Override
	public List<ReplyDTO> list(PageObject pageObject, int no) {
		// TODO Auto-generated method stub
		// 페이지 정보를 계산하는 메서드 호출
		pageObject.calcuPageInfo();
		// jsp의 페이지 네이션을 위한 계산 -> jsp에 전달이 되어야한다. request에 담는다.(Model)
		pageObject.setTotalRow(mapper.getTotalRow());
		System.out.println("ReplyServiceImpl.list().pageObject : "+pageObject);
//		log.info(mapper.list(pageObject));
		log.info("list");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageObject", pageObject);
		map.put("no", no);
		return mapper.list(map);
	}

	@Override
	public Integer write(ReplyDTO dto) {
		// TODO Auto-generated method stub
		return mapper.write(dto);
	}

	@Override
	public Integer update(ReplyDTO dto) {
		// TODO Auto-generated method stub
		return mapper.update(dto);
	}

	@Override
	public Integer delete(ReplyDTO dto) {
		// TODO Auto-generated method stub
		return mapper.delete(dto);
	}

}
