package com.webjjang.image.mapper;

import java.util.List;

import com.webjjang.image.dto.ImageDTO;
import com.webjjang.util.page.PageObject;

// SQL은 패키지에 맞는 resources/com/webjjang/image/mapper/imageMapper.xml 만들고
// 각각의 메서드에 맞는 태그를 작성해준다. 이때 아이디가 메서드 이름과 같아야한다.
public interface ImageMapper {

	//	1.리스트 - list()
	public List<ImageDTO> list(PageObject pageObject);
	public Integer getTotalRow(PageObject pageObject);
	//	2.글쓰기 처리 - write(dto)
	public Integer write(ImageDTO dto);
	//	3.글보기 - view(no) / increaseHit(no)
	public ImageDTO view(int no);
	public Integer increaseHit(int no);
	//	4.글수정 처리 - update(dto)
	public Integer update(ImageDTO dto);
	//	5.글삭제 - delete(dto) ==> no와 pw:post 방식
	public Integer delete(ImageDTO dto);
}
