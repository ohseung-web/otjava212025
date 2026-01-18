package shopMol05;

import java.util.Scanner;

public class UserMenu extends User{
	
	Scanner scan = new Scanner(System.in);
	// 멤버 변수
	String ID = null;
	String PW = null;
	Cart c; // Cart 인스턴스
	ManagerMenu mm; // ManagerMenu 인스턴스
	
	// 디폴트 생성자
	public UserMenu() {
		this.c = new Cart();
		this.mm = new ManagerMenu(this.c);
	};
	
	// 로그인 메서드
	public void login(String inputID, String inputPW) {
		this.ID = inputID;
		this.PW = inputPW;
		
		// 관리자일 경우
		if(inputID.equals("mmm") && inputPW.equals("123")) {
			System.out.println("당신은 관리자 입니다.");
			mm.ManagerMenu(); // 관리자 메뉴 클래스 출력
			return;
		}
		
		// 일반회원일 경우
		for(int i=0; i<super.id.length; i++) {
			
			if(super.id[i].equals(ID) && super.pw[i].equals(PW)) {
				System.out.println("["+id[i]+"]님, 환영합니다.");
				super.log = i; // 로그인된 아이디 인덱스 번호로 log 변경
				return;
			}
		}
		// 관리자 or 일반회원이 아닐 경우
		System.out.println("아이디와 비밀번호를 확인해주세요.");
	}
	
	// 로그아웃 메서드
	public void logout() {
		if(super.log == -1) {
			System.out.println("이미 로그아웃 상태입니다.");
		}else {
			super.log = -1;
			System.out.println("로그아웃되었습니다.");
		}
	}
	
	// 로그인 상태인지 로그아웃 상태인지 확인 메서드
	public void logCheck() {
		if(log == -1) {
			System.out.println("ID 입력: ");
			String inputID = scan.next();
			System.out.println("PW 입력: ");
			String inputPW = scan.next();
			login(inputID,inputPW); // 내부의 아이디와 비번 체크하는 메서드 호출
		}else {
			System.out.println("이미 로그인 상태입니다.");
		}
	}
	
}
