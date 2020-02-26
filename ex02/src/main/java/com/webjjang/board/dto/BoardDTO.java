package com.webjjang.board.dto;

import java.util.Date;

import lombok.Data;

@Data
// getter, setter, 생성자, toString() 자동생성이 된다.
public class BoardDTO {
	
	private int no, hit, reply_cnt;
	private String title, content, writer, pw;
	private Date writeDate;
}
