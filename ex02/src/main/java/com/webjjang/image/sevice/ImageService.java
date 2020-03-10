package com.webjjang.image.sevice;

import java.util.List;


import com.webjjang.image.dto.ImageDTO;
import com.webjjang.util.page.PageObject;


public interface ImageService {
	
	// 1.리스트 - list()
	public List<ImageDTO> list(PageObject pageObject);
	// 2.글쓰기 처리 - write(dto)
	public Integer write(ImageDTO dto);
	// 3.글보기 - view(no) / increaseHit(no)
	public ImageDTO view(int no);
	// 4.글수정 처리 - update(dto)
	public Integer update(ImageDTO dto);
	// 5.글삭제 - delete(dto) ==> no와 pw:post 방식
	public Integer delete(ImageDTO dto);
	

}
