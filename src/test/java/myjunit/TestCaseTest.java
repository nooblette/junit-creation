package myjunit;

import myjunit.assertion.Assert;

public class TestCaseTest extends TestCase {

	public TestCaseTest(String testCaseName){
		super(testCaseName); // 부모 객체인 TestCase의 생성자 호출
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