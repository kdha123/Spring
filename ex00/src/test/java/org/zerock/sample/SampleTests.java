package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j // 진행사항이나 오류를 로그로 출력 -> 서버인 txt파일로 저장, sts 인 경우 콘솔창에 나타난다.
public class SampleTests {
	
	// 자동 DI
	@Setter(onMethod_ = { @Autowired })
	private Restaurant restaurant;
//	@Setter(onMethod_ = { @Autowired })
//	private BoardController boardController;
	
	@Test
	public void testExist() {
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("----------------------");
		// null이면 DI 적용안됨. null이 아니면 DI 적용됨.
		log.info(restaurant.getChef());
	}
	
//	@Test
//	public void testBoard() {
//		assertNotNull(boardController);
//		log.info(boardController);
//		log.info("------------------------");
//		log.info(boardController.getBoardService());
//	}

}
