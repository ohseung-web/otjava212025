package interfaceEx;

public interface Calc {

	//멤버변수 => 인터페이스에는 상수와 추상메소드가 선언된다.
	public static final double PI = 3.14;
	int ERROR = -999999;
	
	
 	int add(int num1, int num2);
	int substract(int num1, int num2);
	int times(int num1, int num2);
	int divide(int num1, int num2);
	
	// java 8버전 이후에 추가된 부분이다.--------------------
	//default 키워드가 없으면 오류가 뜬다.
	default void description() {
		System.out.println("점수 계산기를 구현합니다.");
	}
	
	//static 메소드는 인스턴스하지 않고도 사용할 수 있다.
	static int total(int[] arr) {
		int total = 0;
		for(int i : arr) {
			total += i;
		}
		return total;
	}
	
	// private 메서드 : 인터페이스 내부에서만 사용 가능, 구현한 클래스에서 사용하거나 재정의 할 수 없음
	// private 메서드는 default 메서드에서 사용 가능
	private void myMethod() {
	System.out.println("private 메서드 입니다.");
	}

	// private static 메서드는 static 메서드에서 사용 가능
	private static void myStaticMethod() {
	System.out.println("myStaticMethod 메서드 입니다.");
	}

}
