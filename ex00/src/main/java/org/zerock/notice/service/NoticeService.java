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
	//공지사항 리스트
	public List<NoticeDTO> list(){
		return noticeMapper.list();
	}
	// 공지사항 보기
	public NoticeDTO view(int no) {
		return noticeMapper.view(no);
	}
	// 공지사항 글쓰기 처리
	public Integer write(NoticeDTO dto) {
		return noticeMapper.write(dto);
	}
	// 공지사항 글수정 처리
	public Integer update(NoticeDTO dto) {
		// TODO Auto-generated method stub
		return noticeMapper.update(dto);
	}
	// 공지사항 글삭제
	public Integer delete(int no) {
		// TODO Auto-generated method stub
		return noticeMapper.delete(no);
	}
}
