package shopMol02;

import java.util.Scanner;

public class UserMenu extends User{
	Scanner scan = new Scanner(System.in);
	
	public UserMenu() {};
	// 사용자 로그 메서드
	public int userLog() {
		return log;
	};
}
