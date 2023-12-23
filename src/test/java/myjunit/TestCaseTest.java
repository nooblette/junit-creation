package myjunit;

import myjunit.assertion.Assert;

public class TestCaseTest extends TestCase {
	private static long base;

	public TestCaseTest(String testCaseName){
		super(testCaseName); // 부모 객체인 TestCase의 생성자 호출
	}

	@Override
	public void before(){
		base = 10;
	}

	public void runPlusTest() {
		long sum = 10 + base;
		Assert.assertTrue(sum == 20);
	}

	public void runMinusTest() {
		long sum = 100 - base;
		Assert.assertTrue(sum == 90);
	}

	public static void main(String[] args) {
		new TestCaseTest("runPlusTest").run();
		new TestCaseTest("runMinusTest").run();
	}
}