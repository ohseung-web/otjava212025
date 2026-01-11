package staticTest;

public class Student {
	//학생들의 학번을 1001, 1002, 1003으로 출력하려고 할떄
	// 기본 serialNum에 1000으로 정적 멤버변수를 이용하여 
	// 값을 지정하면 여러 개의 인스턴스가 같은 serialNum를 공유할 수 있다.
	static int serialNum = 1000;
	
	int studentId;
	String studentName;
	
	//생성자
	public Student() {
		serialNum ++;
		studentId = serialNum;
	}
	
}
