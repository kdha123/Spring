package com.webjjang.reply.dto;

import java.util.Date;

import lombok.Data;

@Data // setter, getter, toString() 자동으로 생성해준다.
public class ReplyDTO {
	
	private int rno, no;
	private String content, writer;
	private Date writeDate;
	private String pw;
}
