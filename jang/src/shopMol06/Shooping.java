package shopMol06;

import java.util.*;

public class Shooping extends UserMenu {
	Scanner scan = new Scanner(System.in);
	
	ItemManager im = new ItemManager();
	Item it = new Item(null, log, null);
	
//	기본 생성자
//	public Shooping() {}
	
//	매개변수 생성자?  ↓이렇게 써도 되나
	public Shooping() {
//		for(int i = 0; i < users.length; i++) {
//	        users[i] = new User();
//	    }
	}
	
//	사용자별 배열
	User userId = new User();  // 객체화
	User[] users = new User[userId.id.length];  // 사용자 인원수만큼 배열
	
//	메뉴
	public void menu() {
		boolean nnow = true;
		
		if(super.log == -2) {  // 관리자
			while(nnow) {
				System.out.println("[1]로그아웃\n[2]아이템관리\n[3]장바구니 리스트\n메뉴선택 >>");
				int manager = scan.nextInt();
				
//			1 로그아웃
				if(manager == 1) {  // << 관리자 로그아웃 후 메인(첫화면)으로 돌아가기 안됨
					System.out.println("로그아웃 되었습니다. 안녕히 가세요.");
					super.log = -1;  // 로그아웃으로 상태 변경
					nnow = false;  // while 종료
					return;  // 첫 화면으로 돌아가려고
					
//			2 아이템관리
				}else if(manager == 2) {
					boolean mNow = true;
					
					while(mNow) {
						System.out.println("[1]상품 추가\n[2]상품 삭제\n[3]상품 수정\n[0]아이템관리 종료");
						int mMenu2 = scan.nextInt();
//					1 상품추가
						if(mMenu2 == 1) {
							im.addItem();
							im.printItemList();
							
//					2 상품 삭제
						}else if(mMenu2 == 2) {
							System.out.println("삭제할 상품의 번호를 입력하세요.");
							im.printItemList();
							im.delItem();
							im.printItemList();
							
//					3 상품 수정
						}else if(mMenu2 == 3) {
							im.printItemList();
							im.fixItem();
							im.printItemList();
							
//					0 아이템관리 종료
						}else if(mMenu2 == 0){
							System.out.println("아이템관리 종료");
							System.out.println();
							mNow = false;
							
//					예외처리
						}else {
							System.out.println("메뉴를 다시 선택하세요.");
						}
					}
					
//			3 장바구니 리스트
				}else if(manager == 3) {
					im.AllUserCart();
					
				}else {
					System.out.println("메뉴를 다시 선택하세요.");
				}
			}
		}else if(super.log == -1) {  // 비로그인중
			System.out.println("[1]로그인\n[2]로그아웃\n[3]쇼핑\n[0]종료\n메뉴선택 >>");
			
		}else {  // 로그인중
			System.out.println("=== " + super.id[super.log] + "님 로그인중 ===");
			System.out.println("[2]로그아웃\n[3]쇼핑\n[0]종료\n메뉴선택 >>");
		}
	}
	
	//쇼핑메뉴
	public void shopMenu() {
		System.out.println("[1]쇼핑목록\n[2]장바구니\n[0]뒤로가기");
		int shopMenu = scan.nextInt();
		
//		1 쇼핑 목록
		if(shopMenu == 1) {
//			카테고리 출력 -> 카테고리 선택 -> 해당 카테고리 상품 출력
			String currId = super.id[super.log];  // 로그인한 유저 아이디
			im.addCart(currId);  // 장바구니 추가
			
//			im.printItemList();  // 상품 목록 전체출력
			
//		2 장바구니
		}else if(shopMenu == 2) {
			String currId = super.id[super.log];  // 로그인한 유저 아이디
			im.AllCart(currId);
			
//		3 쇼핑
		}else if(shopMenu == 0) {
			
			
//		없는 번호 예외처리
		}else {
			System.out.println("메뉴를 다시 확인해주세요");
		}
	}
	
	//로그인 메서드
	public void login() {
		System.out.println("아이디 : ");
		String inputId = scan.next();
		System.out.println("비밀번호 : ");
		String inputPw = scan.next();
		
//		관리자 로그인
		if(inputId.equals("mmm") && inputPw.equals("123")) {
			System.out.println("당신은 관리자 입니다.");
			super.log = -2;
			return;
		}
		
//		일반유저 로그인
		for(int i = 0; i < super.id.length; i++) {
			if(super.id[i].equals(inputId) && super.pw[i].equals(inputPw)) {
				System.out.println(super.id[i] + "님, 환영합니다!\n");
				super.log = i;
				return;
			}
		}
		
//		예외처리
		System.out.println("아이디와 비밀번호를 다시 확인해 주세요.");
	}
	
	//로그아웃 메서드
	public void logout() {
		System.out.println("로그아웃 되었습니다. 안녕히 가세요.");
		super.log = -1;
	}

}
