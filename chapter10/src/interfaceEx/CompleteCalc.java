package interfaceEx;

public class CompleteCalc extends Calculator {

	//구현상속이다.
	@Override
	public int times(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 * num2;
	}

	@Override
	public int divide(int num1, int num2) {
		// 나누어 지는  num2가 0이 아닐때의 예외처리 한다.
		if(num2 !=0) {
			return num1/num2;
		}
		return ERROR;
	}

	public void showInfo() {
		System.out.println("Calc 인터페이스를 구현합니다.");
	}
	
	@Override
	public void description() {
		System.out.println("완벽한 계산기 입니다.");
	}
	
}
