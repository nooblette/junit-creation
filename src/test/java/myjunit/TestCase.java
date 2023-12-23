package myjunit;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
* 테스트 프레임워크로써 기능을 수행하기 위해, 각각 테스트 케이스 단위로 요청을 나눌 수 있도록 구성(Command Pattern)
* 	각각의 테스트 케이스를 Command 로 보고, run 메서드가 이러한 테스트 케이스 실행을 담당한다.
* 	TestCase 객체는 그 자체로 사용 하기 보다는, 구체적인 테스트 케이스들이 이를 상속하여 사용하기 때문에 추상 클래스(Abstract Class)로 선언한다.
* 	이를 통해 각각의 테스트는 새로운 인스턴스에서 독립적으로 수행된다.
*/
public abstract class TestCase {
	private static final Logger logger = LoggerFactory.getLogger(TestCaseTest.class);

	// 각 TestCase를 식별하기 위한 이름, 생성자를 통해 받는다.
	protected String testCaseName;

	public TestCase(String testCaseName){
		this.testCaseName = testCaseName;
	}

	// run() 메서드는 before() -> runTestCase() -> after() 순으로 테스트를 실행한다.
	public void run(){
		before();
		runTestCase();
		after();
	}

	// before() 메서드와 after() 메서드는 추상 메서드가 아니라 일반 메서드임에 유의한다.
	// 추상 메서드는 자식 클래스에서 항상 오버라이딩해야하나, Fixture() 메서드의 구현은 강제가 아닌 선택이기 때문
	protected void before() {}

	private void runTestCase(){
		try{
			logger.info("{} execute", testCaseName);
			Method method = this.getClass().getMethod(testCaseName, null);
			method.invoke(this, null);
		} catch (Exception e){
			throw new RuntimeException(e);
		}
	}

	protected void after() {}
}
