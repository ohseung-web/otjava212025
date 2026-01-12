package shopMoll;

import java.util.Scanner;

public class UserMenu extends User{
	Scanner scan = new Scanner(System.in);
	int cnt = id.length;
    static int  logindex ;
    
	// 사용자 로그 메서드
	public int userLog() {
		int log = super.log;
		System.out.print("ID입력: ");
		String myId = scan.next();
		System.out.print("PW입력: ");
		String myPw = scan.next();

		for(int i=0; i<cnt; i++) {
			if(myId.equals(id[i]) && myPw.equals(pw[i])) {
				log = i; 
			}
		}

		if(log<0) {
			System.out.println("아이디와 비밀번호를 다시 확인해주세요.");
		}else if(log == 0) {
			System.out.println("당신은 관리자 입니다.");
		}
		else {
			System.out.printf("[%s]님, 환영합니다.\n", id[log]);
			logindex = log;
		}
		return log;
	}
}
