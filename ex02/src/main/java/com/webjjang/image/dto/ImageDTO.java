package com.webjjang.image.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
// getter, setter, 생성자, toString() 자동생성이 된다.
public class ImageDTO {
	
	private int no;
	// server에 올라간 path+filename
	private String title, content, id, fileName, name;
	private Date writeDate;
	// request 안에 있는 걸 꺼내서 multiFile에 집어넣게 된다.
	private MultipartFile multiFile; // form 에서 넘어오는 데이터 받기
	
	// 이미지 등록 시 필요한 처리 -> DB 저장용 파일이름을 알아 내야 한다.
	public void setFileNameProcess() {
		fileName = "/upload/image/" + multiFile.getOriginalFilename();
	} 
}
