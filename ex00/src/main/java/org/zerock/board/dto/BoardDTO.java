package org.zerock.board.dto;

import java.util.Date;

import lombok.Data;

@Data // getter, setter, toString(), 생성자를 자동으로 만들어 준다.
public class BoardDTO {

	private int no;
	private String title, content, writer;
	private Date writeDate;
	private int hit;
}
