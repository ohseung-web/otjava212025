package numFormatEx;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class FormatEx {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
        double number ;
        
        NumberFormat num1 = NumberFormat.getInstance();
        NumberFormat num2 = NumberFormat.getNumberInstance();
        NumberFormat num3 = NumberFormat.getCurrencyInstance(Locale.JAPAN);
        NumberFormat num4 = NumberFormat.getPercentInstance();
        NumberFormat num5 = NumberFormat.getIntegerInstance();
        
        System.out.println("값을 입력하시오");
        number = scan.nextDouble();
        //천단위마다 구분기호 ,(콤마)를 출력
        System.out.println(num1.format(number));
        //천단위마다 구분기호 ,(콤마)를 출력
        System.out.println(num2.format(number));
        //통화기호 ￦와 .(콤마)를 출력
        System.out.println(num3.format(number));
        //백분율로 출력 단 1200이면 => 120,000%
        System.out.println(num4.format(number));
        //실수를 반올림하여 정수로 출력 
        System.out.println(num5.format(number));
        
     scan.close();   


	}

}
