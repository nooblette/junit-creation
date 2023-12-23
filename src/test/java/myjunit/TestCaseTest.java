package myjunit;

import myjunit.assertion.Assert;

public class TestCaseTest extends TestCase {

	public TestCaseTest(String testCaseName){
		super(testCaseName); // 부모 객체인 TestCase의 생성자 호출
	}

	private static long base;

	public void before(){
		base = 10;
	}

	public void runPlusTest() {
		before(); // 각각의 테스트 메서드들이 테스트 전에 before() Fixture 메서드를 수행
		long sum = 10 + 10;
		Assert.assertTrue(sum == 20);
	}

	public void runMinusTest() {
		before();
		long sum = 100 - 10;
		Assert.assertTrue(sum == 90);
	}

	public static void main(String[] args) {
		new TestCaseTest("runPlusTest").run();
		new TestCaseTest("runMinusTest").run();
	}
}