package org.zerock.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

	static { // static 초기화 블록 -> 드라이버 확인
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 접속 정보
	// 객체에서 사용할 DB 정보 -> list(), view()... 다른 메서드에서 다필요로 하기 때문에
	// 전역변수로 선언한다.
	private static final String url 
	= "jdbc:oracle:thin:@402-oracle:1521:orcl";
	private static final String id = "c##java04";
	private static final String pw = "java04";

	
	// 연결 테스트 메서드
	@Test
	public void testConnection() {
		// try(자원) -> try를 빠져 나갈때 자원을 자동으로 회수 시킨다.
		try(Connection con 
				= DriverManager.getConnection(url,id, pw)){
			log.info(con);
			
		}catch (Exception e) {
			// TODO: handle exception
			fail(e.getMessage());
		}
	}
	
}
