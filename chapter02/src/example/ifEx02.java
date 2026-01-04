package example;

import java.util.Scanner;

public class ifEx02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String dbid1="";
		String dbpw1="";
		System.out.println("=== 회원 가입 ===");
		System.out.print("가입할 id를 입력하세요 :");
		dbid1 = scan.next();
		System.out.print("가입할 pw를 이력하세요 :");
		dbpw1=scan.next();
		System.out.println("가입을 축하합니다.");
		System.out.println("=== 로그인 ===");
		System.out.print("아이디 입력 :");
		String inputid = scan.next();
		System.out.print("비밀번호 입력 :");
		String inputpw = scan.next();
		
		if(dbid1.equals(inputid) && dbpw1.equals(inputpw)) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
//		if(dbid1 == inputid && dbpw1 == inputpw) {
//			System.out.println("로그인 성공");
//		}else {
//			System.out.println("로그인 실패");
//		}
		
	}

}
