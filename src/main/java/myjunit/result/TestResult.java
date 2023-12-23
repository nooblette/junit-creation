package myjunit.result;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import myjunit.TestCase;

public class TestResult {
	private static final Logger logger = LoggerFactory.getLogger(TestResult.class);
	private int runTestCount;
	private List<TestFailure> testFailureList;
	private List<TestError> testErrorList;

	public TestResult() {
		this.runTestCount = 0;
		testFailureList = new ArrayList<>();
		testErrorList = new ArrayList<>();
	}

	/*
	 * synchronized : 하나의 TestResult 인스턴스를 여러 테스트 케이스에서 사용할 경우 동시성 문제가 발생할 수 있어 synchronized 로 선언한다.
	 * 	startTest() 메서드는 테스트 케이스에서만 사용하므로 실시간 성능 이슈는 고려하지 않아도 된다.
	 */
	public synchronized void startTest() {
		this.runTestCount++;
	}

	public synchronized void addFailure(TestCase testCase) {
		this.testFailureList.add(new TestFailure(testCase));
	}

	public synchronized void addError(TestCase testCase, Exception exception) {
		this.testErrorList.add(new TestError(testCase, exception));
	}

	public void printCount(){
		logger.info("Total Test Count: {}", runTestCount);
		logger.info("Total Test Success Count: {}", runTestCount - testFailureList.size() - testErrorList.size());
		logger.info("Total Test Failure Count: {}", testFailureList.size());
		logger.info("Total Test Error Count: {}", testErrorList.size());
	}
}
