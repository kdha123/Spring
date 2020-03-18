package com.webjjang.reply.mapper;

import java.util.List;
import java.util.Map;

import com.webjjang.reply.dto.ReplyDTO;

public interface ReplyMapper {

	// 인터페이스는 추상메서드이기 때문에 구현하지 않는다.
	// 댓글리스트
	public List<ReplyDTO> list(Map<String, Object> map);
	public Integer getTotalRow();
	// 댓글 등록
	public Integer write(ReplyDTO dto);
	// 댓글 수정
	public Integer update(ReplyDTO dto);
	// 댓글 삭제
	public Integer delete(ReplyDTO dto);
	
}
