package example;

import java.util.Scanner;

public class ifEx05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int money = 0;
		System.out.print("금액을 입력하시오 >>");
		money = scan.nextInt();
		int money1=0, money2=0, money3=0, money4=0, money5=0, money6=0;
		
		money1=money/50000; //5만원권 개수
		money2=(money-(money1*50000))/10000; //만원권 개수
		money3 = (money- (money1*50000)-(money2*10000))/5000; //오천권 개수
		money4 = (money- (money1*50000)-(money2*10000)-(money3*5000))/1000; //천원권 개수
		money5 = (money-(money1*50000)-(money2*10000)-(money3*5000)-(money4*1000))/500; //오백원 개수
		money6 = (money-(money1*50000)-(money2*10000)-(money3*5000)-(money4*1000)-(money5*500))/100; //백원 개수
		
		//System.out.println("==== 아래 수정 코드 ======");
		
		int oman = money/50000; // 5만원권 개수
		money = money % 50000; // 5만원권을 제외한 금액
		int man = money/10000;
		money %= 10000;
		int ochun = money/5000;
		money %= 5000;
		int chun = money/1000;
		money %= 1000;
		int oback = money/500;
		money %= 500;
		int back = money/100;
		money %= 100;
		
		System.out.println("오만원권 : "+oman+"매");
		System.out.println("일만원권 : "+man+"매");
		System.out.println("오천원권 : "+ochun+"매");
		System.out.println("천원권 : "+chun+"매");
		System.out.println("오백원 : "+oback+"매");
		System.out.println("백원 : "+back+"매");
		
		
	}

}
