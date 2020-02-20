package org.zerock.notice.mapper;

import java.util.List;

import org.zerock.notice.dto.NoticeDTO;

public interface NoticeMapper {

	// 공지사항 리스트
	public List<NoticeDTO> list();
	// 공지사항 글보기
	public NoticeDTO view(int no);
	// 공지사항 글쓰기
	public Integer write(NoticeDTO dto);
	// 공지사항 글수정
	public Integer update(NoticeDTO dto);
	// 공지사항 글삭제
	public Integer delete(int no);
	
}
