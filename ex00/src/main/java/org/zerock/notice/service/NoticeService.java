package org.zerock.notice.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.notice.dto.NoticeDTO;
import org.zerock.notice.mapper.NoticeMapper;

@Service
public class NoticeService {

	@Inject
	private NoticeMapper noticeMapper;
	//게시판 리스트
	public List<NoticeDTO> list(){
		return noticeMapper.list();
	}
	// 게시판 보기
	public NoticeDTO view(int no) {
		return noticeMapper.view(no);
	}
	// 게시판 글쓰기 처리
	public Integer write(NoticeDTO dto) {
		return noticeMapper.write(dto);
	}
	// 게시판 글수정 처리
	public Integer update(NoticeDTO dto) {
		// TODO Auto-generated method stub
		return noticeMapper.update(dto);
	}
	// 게시판 글삭제
	public Integer delete(int no) {
		// TODO Auto-generated method stub
		return noticeMapper.delete(no);
	}
}
