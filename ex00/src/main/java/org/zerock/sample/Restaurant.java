package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

//자동 생성해주는 어노테이션
// -> 먼저 여기 패키지를 scan할 수 있도록 지정해줘야한다. root-context.xml
//@Controller, @Service, @Repository, @RestController, @Component
//lombok -> setter/ getter/ toString() /생성자를 자동으로 만들어준다.
@Component
@Data
public class Restaurant {
	// Spring DI 적용 어노테이션 -> @Autowired
	// JAVA DI 적용 어노테이션 -> @Inject
	// 저장 변수 - DI 적용해서 넣어주기
	@Setter(onMethod = @__({ @Autowired }))
	private Chef chef;
}
