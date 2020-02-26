package com.webjjang.board.mapper;

import java.util.List;

import com.webjjang.board.dto.BoardDTO;

// SQL은 패키지에 맞는 resources/com/webjjang/board/mapper/BoardMapper.xml 만들고
// 각각의 메서드에 맞는 태그를 작성해준다. 이때 아이디가 메서드 이름과 같아야한다.
public interface BoardMapper {

	//	1.리스트 - list()
	public List<BoardDTO> list();
	//	2.글쓰기 처리 - write(dto)
	public Integer writer(BoardDTO dto);
	//	3.글보기 - view(no) / increaseHit(no)
	public BoardDTO view(int no);
	public Integer increaseHit(int no);
	//	4.글수정 처리 - update(dto)
	public Integer update(BoardDTO dto);
	//	5.글삭제 - delete(dto) ==> no와 pw:post 방식
	public Integer delete(BoardDTO dto);
}
