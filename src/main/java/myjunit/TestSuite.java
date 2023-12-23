package myjunit;

import java.util.ArrayList;
import java.util.List;

import myjunit.result.TestResult;

public class TestSuite implements Test{
	private List<TestCase> testCaseList = new ArrayList<>();

	@Override
	public void run(TestResult testResult) {
		for(TestCase testCase : testCaseList){
			testCase.run();
		}
	}

	public void addTestCase(TestCase testCase){
		this.testCaseList.add(testCase);
	}
}
