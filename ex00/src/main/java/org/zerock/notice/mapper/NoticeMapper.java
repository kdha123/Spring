package org.zerock.notice.mapper;

import java.util.List;

import org.zerock.notice.dto.NoticeDTO;

public interface NoticeMapper {

	// 게시판 리스트
	public List<NoticeDTO> list();
	// 게시판 글보기
	public NoticeDTO view(int no);
	// 게시판 글쓰기
	public Integer write(NoticeDTO dto);
	// 게시판 글수정
	public Integer update(NoticeDTO dto);
	// 게시판 글삭제
	public Integer delete(int no);
	
}
