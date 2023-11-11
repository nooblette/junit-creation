package myjunit.assertion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assert {
	private static final Logger log = LoggerFactory.getLogger(Assert.class);

	// Assert 클래스는 싱글톤 패턴을 따른다.(생성자를 private 선언하여 인스턴스 생성을 방지)
	private Assert() {}

	// true 인지 검증하기 위한 assertTrue 메서드
	// static 선언하여 인스턴스 생성없이 접근하도록 구현한다
	public static void assertTrue(boolean condition){
		if(!condition){
			throw new AssertionFailedError();
		}

		log.info("Test Passed");
	}
}
