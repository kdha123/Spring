package com.webjjang.reply.sevice;

import java.util.List;


import com.webjjang.reply.dto.ReplyDTO;
import com.webjjang.util.page.PageObject;


public interface ReplyService {
	
	// 1.리스트 - list()
	public List<ReplyDTO> list(PageObject pageObject);
	// 2.댓글 등록 처리 - write(dto)
	public Integer write(ReplyDTO dto);
	// 3.댓글 수정 처리 - update(dto)
	public Integer update(ReplyDTO dto);
	// 4.댓글 삭제 - delete(dto) ==> no와 pw:post 방식
	public Integer delete(ReplyDTO dto);
	

}
