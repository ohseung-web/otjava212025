package shopMol03;

public class UserMenu extends User {
	
	public UserMenu() {};
	
	// 사용자 로그 메서드
	public void userLog() {
		if(super.log == -1) {
			System.out.println("로그아웃 상태입니다. 로그인을 해주세요.");
		}
	}
}
