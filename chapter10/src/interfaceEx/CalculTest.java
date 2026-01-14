package interfaceEx;

public class CalculTest {

	public static void main(String[] args) {
		// 인터페이스 타입을 상속함
		int num1=10;
		int num2 =2;
		
		//클라이언트 코드라 부른다.
		Calc calc = new CompleteCalc();
		
		//인터페이스는 인스턴스화 할 수 없다.
		//Calc calc2 = new Calc();
		//추상클래스도 인스턴스화 할 수 없다.
		//Calculator calc4 = new Calculator(); 
		
		Calculator calc3 = new CompleteCalc();
		
		System.out.println(calc.add(num1, num2));
		System.out.println(calc.substract(num1, num2));
		
		int[] arr = {1,2,3,4,5};
		int sum = Calc.total(arr);
		System.out.println(sum);		
		
	}

}
