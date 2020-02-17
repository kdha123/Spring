package org.zerock.mapper;

// 2.xx 버전까지는 ibatis -> 3.xx Mybatis
import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	// TimeMapper.xml을 이용한 메서드 선언
	public String getTime();
	
	// 어노테이션을 이용한 메서드 선언
	@Select("select sysdate from dual")
	public String getTimeAN();
}
