package shopMol06;

import java.util.*;

public class ShopMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Shooping sh = new Shooping();
		
		boolean now = true;
		
		while(now) {
//			메뉴
			sh.menu();
			
//			관리자 상태체크  << 관리자 로그아웃하면 메인(첫화면)으로 돌아가려했는데 안됨
			if(sh.log == -2) {
				continue;
			}
//			
			int menu = scan.nextInt();
			
//			메뉴 1 로그인
			if(sh.log == -1) {  // 비로그인중
				if(menu == 1) {
					sh.login();
				}else if(menu == 0) {
					now = false;
				}
//			메뉴 2 로그아웃
			}else if (menu == 2){
//				로그인 안 했을 때 
				if(sh.log == -1) {
					System.out.println("로그인 후 이용 가능합니다.");
				}
				sh.logout();
				
//			메뉴 3 쇼핑
			}else if (menu == 3){
//				로그인 안 했을 때 
				if(sh.log == -1) {
					System.out.println("로그인 후 이용 가능합니다.");
				}
				sh.shopMenu();
				
//			메뉴 0 종료
			}else {
				System.out.println("쇼핑몰 종료. 안녕히 가세요.");
				now = false;
			}
		}
	}

}
