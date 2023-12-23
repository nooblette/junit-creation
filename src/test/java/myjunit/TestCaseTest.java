package myjunit;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import myjunit.assertion.Assert;

public class TestCaseTest extends TestCase {
	private static final Logger logger = LoggerFactory.getLogger(TestCaseTest.class);

	public TestCaseTest(String testCaseName){
		super(testCaseName); // 부모 객체인 TestCase의 생성자 호출
	}

	@Override
	public void run(){
		try{
			logger.info("{} execute", testCaseName);
			Method method = this.getClass().getMethod(super.testCaseName, null);
			method.invoke(this, null);
		} catch (Exception e){
			throw new RuntimeException(e);
		}
	}


	public void runPlusTest() {
		long sum = 10 + 10;
		Assert.assertTrue(sum == 20);
	}

	public void runMinusTest() {
		long sum = 100 - 10;
		Assert.assertTrue(sum == 90);
	}

	public static void main(String[] args) {
		new TestCaseTest("runPlusTest").run();
		new TestCaseTest("runMinusTest").run();
	}
}