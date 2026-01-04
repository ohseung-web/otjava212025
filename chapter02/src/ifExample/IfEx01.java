package ifExample;

public class IfEx01 {

	public static void main(String[] args) {
		// 제어문 : if => 조건에 만족하면 true, 아니면 false 출력
		int num1 = 10;
		int num2 = 20;
		
		// if(조건식)
		if(num1<num2) {
		   System.out.println("num1은 num2보다 작다");
		}
		
		// if(조건식) else
		if(num1<num2) {
			System.out.println("num1은 num2보다 작다");
		}else {
			System.out.println("num1은 num2보다 크거나 같다");
		}
		
		// if(조건식1) else if(조건식2)
		if(num1<num2) {
		   System.out.println("num1은 num2보다 작다");	 
		}else if(num1>num2) {
			System.out.println("num1은 num2보다 크다");
		}else {
		    System.out.println("num1은 num2보다 같다.");	
		}
		
	}

}
