package org.zerock.board.mapper;

import java.util.List;

import org.zerock.board.dto.BoardDTO;

public interface BoardMapper {

	public List<BoardDTO> list();
	public Object view();
	
}
