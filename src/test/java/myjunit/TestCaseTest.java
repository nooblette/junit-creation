package myjunit;

import myjunit.assertion.Assert;

public class TestCaseTest {
	public static void main(String[] args) {
		new TestCaseTest().runTest();
	}

	public void runTest(){
		long sum = 10 + 10;
		Assert.assertTrue(sum == 20);
	}
}