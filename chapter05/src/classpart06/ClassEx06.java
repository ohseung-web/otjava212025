package classpart06;

public class ClassEx06 {
	String name = "";

	String[] arAcc = {"1111", "2222", "3333", "4444", "5555","","","","",""};
	String[] arPw  = {"1234", "2345", "3456", "4567", "5678","","","","",""};
	int[] arMoney  = {87000, 34000, 17500, 98000, 12500,0,0,0,0,0};

	int count = 5;

	// 3333 로그인
	int loginCheck = -1;
	
	//생성자
	public ClassEx06() {}
	
	// 상태 출력
    public void printStatus() {
        if (loginCheck == -1) {
            System.out.println("상태 : 로그아웃");
        } else {
            System.out.println("상태 : " + arAcc[loginCheck] + " 로그인 중");
        }
    }

    // 회원가입
    public boolean join(String acc, String pw, int money) {
        for (int i = 0; i < arAcc.length; i++) {
            if (arAcc[i].equals(acc)) return false;
        }
        arAcc[count] = acc;
        arPw[count] = pw;
        arMoney[count] = money + 1000;
        count += 1;
        return true;
    }

    // 로그인
    public boolean login(String acc, String pw) {
        if (loginCheck != -1) return false;

        for (int i = 0; i < count; i++) {
            if (arAcc[i].equals(acc) && arPw[i].equals(pw)) {
                loginCheck = i;
                return true;
            }
        }
        return false;
    }

    // 로그아웃
    public void logout() {
        loginCheck = -1;
    }

    // 회원탈퇴
    public void deleteAccount() {
        for (int i = loginCheck; i < count - 1; i++) {
            arAcc[i] = arAcc[i + 1];
            arPw[i] = arPw[i + 1];
            arMoney[i] = arMoney[i + 1];
        }
        count--;
        loginCheck = -1;
    }

    // 입금
    public void deposit(int money) {
        arMoney[loginCheck] += money;
    }

    // 이체
    public boolean transfer(String acc, int money) {
        int target = -1;
        for (int i = 0; i < count; i++) {
            if (arAcc[i].equals(acc)) {
                target = i;
                break;
            }
        }
        if (target == -1 || arMoney[loginCheck] < money) return false;

        arMoney[loginCheck] -= money;
        arMoney[target] += money;
        return true;
    }

    // 잔액 조회
    public int getBalance() {
        return arMoney[loginCheck];
    }

    public boolean isLogin() {
        return loginCheck != -1;
    }
}
