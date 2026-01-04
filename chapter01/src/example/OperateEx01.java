package example;

public class OperateEx01 {

	public static void main(String[] args) {
		// int score = 30 이용해 점수가 60점 이상이면 true가 출력
		int score = 30;
		boolean result = (score>=60);
		//System.out.println(result);
		
		// int money=178600 이용해 5000원을 제외한 1000원이 3장이상이면 true
		int money = 178500;
		int money5000 = money/5000; // 5000원 개수
		int money1000 = money-(money5000*5000); // 5000원권 제외
		boolean moneyCount = ((money1000/1000) >= 3);
		//System.out.println(money5000*5000);
		//System.out.println(money1000);
		//System.out.println(moneyCount);
		
		// int kor = 100;  int eng = 87;  int math = 41;
		// 3과목의 평균이 60이상이면 true, 어느 한 과목이라도 50점미만이면 false 
		int kor=100;
		int eng = 87;
		int math = 41;
		double avg = (kor+eng+math)/3;
		boolean pass=(avg>=60 && kor>=50 && eng >=50 && math>=50);
		System.out.println(pass);
		//System.out.println(math>=50);

		int x = 5;
		System.out.println(x++);
		System.out.println(++x);
		System.out.println(x);
		
		int READ = 1;   // 0001
		int WRITE = 2;  // 0010
		int user = READ | WRITE;
		System.out.println((user & READ) != 0);
		System.out.println((user & 4) != 0);
		System.out.println((user | READ) != 0);
		
		int n = 5;
		boolean result2 = (n > 10) && (++n > 5);
		System.out.println(n);
		System.out.println(result2);


		

	}

}
