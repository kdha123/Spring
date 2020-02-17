package org.zerock.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.mapper.BoardMapper;

@Service
public class BoardService {

	@Inject
	private BoardMapper boardMapper;
	
	public List<BoardDTO> list(){
		return boardMapper.list();
	}
	public Object view() {
		return boardMapper.view();
	}
}
