package org.zerock.notice.dto;

import lombok.Data;

@Data
public class NoticeDTO {
	
	private int no;
	private String title, content, startDate, endDate, writeDate,
	updateDate;
}
