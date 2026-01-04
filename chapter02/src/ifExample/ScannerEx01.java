package ifExample;

// Scanner 클래스를 사용하기위해 import 한다.
import java.util.Scanner;

public class ScannerEx01 {

	public static void main(String[] args) {
		// Scanner 클래스를 생성한다.
		Scanner scan = new Scanner(System.in); //Scanner 클래스 객체생성
		System.out.println("입력하고 싶은 정수를 입력하세요");
		
		int num = scan.nextInt(); //입력받은 정수를 num에 저장
		System.out.printf("입력하신 숫자는 %d입니다.%n",num);
		
		System.out.println("입력하고 싶은 실수를 입력하세요");
		double num2 = scan.nextDouble();
		System.out.printf("입력하신 숫자는 %.2f입니다.%n",num2);
		
		System.out.println("입력하고 싶은 문자열을 입력하세요");
		String str = scan.next();
		System.out.printf("입력하신 문자는 %s입니다.",str);
	
	}

}
