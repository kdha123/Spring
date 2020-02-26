package com.webjjang.board.sevice;

import java.util.List;

import com.webjjang.board.dto.BoardDTO;

public interface BoardService {
	
	// 1.리스트 - list()
	public List<BoardDTO> list();
	// 2.글쓰기 처리 - write(dto)
	public Integer write(BoardDTO dto);
	// 3.글보기 - view(no) / increaseHit(no)
	public BoardDTO view(int no);
	// 4.글수정 처리 - update(dto)
	public Integer update(BoardDTO dto);
	// 5.글삭제 - delete(dto) ==> no와 pw:post 방식
	public Integer delete(BoardDTO dto);
	

}
