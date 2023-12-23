package myjunit;

/*
* 테스트 프레임워크로써 기능을 수행하기 위해, 각각 테스트 케이스 단위로 요청을 나눌 수 있도록 구성(Command Pattern)
* 	각각의 테스트 케이스를 Command 로 보고, run 메서드가 이러한 테스트 케이스 실행을 담당한다.
* 	TestCase 객체는 그 자체로 사용 하기 보다는, 구체적인 테스트 케이스들이 이를 상속하여 사용하기 때문에 추상 클래스(Abstract Class)로 선언한다.
* 	이를 통해 각각의 테스트는 새로운 인스턴스에서 독립적으로 수행된다.
*/
public abstract class TestCase {
	// 각 TestCase를 식별하기 위한 이름, 생성자를 통해 받는다.
	protected String testCaseName;

	public TestCase(String testCaseName){
		this.testCaseName = testCaseName;
	}

	public abstract void run();
}
