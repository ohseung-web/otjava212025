package classpart10;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ClassEx10 ce10 = new ClassEx10();
		ce10.name = "메가IT 고등학교";

		boolean run = true;

		while(run) {
			System.out.println("==== " + ce10.name + " ====");
			System.out.println("1. 전교생 성적확인");
			System.out.println("2. 1등학생 성적확인");
			System.out.println("3. 꼴등학생 성적확인");
			System.out.println("4. 학번 입력 성적확인");
			System.out.println("5. 종료");
			System.out.print("메뉴선택 : ");

			int select = scan.nextInt();

			if(select == 1) {
				ce10.choice1();
			}
			else if(select == 2) {
				ce10.choice2();
			}
			else if(select == 3) {
				ce10.choice3();
			}
			else if(select == 4) {
				System.out.print("학번 입력 : ");
				int hakbun = scan.nextInt();
				ce10.choice4(hakbun);
			}
			else {
				System.out.println("프로그램 종료");
				run = false;
			}
		}
		
		scan.close();
	}

}
