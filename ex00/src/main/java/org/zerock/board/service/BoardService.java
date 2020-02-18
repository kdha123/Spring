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
	//게시판 리스트
	public List<BoardDTO> list(){
		return boardMapper.list();
	}
	// 게시판 보기
	public BoardDTO view(int no) {
		return boardMapper.view(no);
	}
	// 게시판 글쓰기 처리
	public Integer write(BoardDTO dto) {
		return boardMapper.write(dto);
	}
	// 게시판 글수정 처리
	public Integer update(BoardDTO dto) {
		// TODO Auto-generated method stub
		return boardMapper.update(dto);
	}
	// 게시판 글삭제
	public Integer delete(int no) {
		// TODO Auto-generated method stub
		return boardMapper.delete(no);
	}
}
