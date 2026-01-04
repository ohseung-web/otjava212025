package example;

import java.util.Scanner;

public class ifEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int dbid=1234;
		int dbpw=1111;
		
		System.out.print("아이디 입력 : ");
		int inputid = scan.nextInt();
		System.out.print("비밀번호 입력 :");
		int inputpw = scan.nextInt();
		
		if(dbid==inputid && dbpw==inputpw) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
		
	}

}
