package shopMol05;

import java.util.Scanner;

public class Shopping extends UserMenu{
	// 멤버 변수
	String ID = null;
	String PW = null;
	boolean run = true;
	ItemManager im;  // ItemManager 인스턴스
	
	Scanner scan = new Scanner(System.in);
	
	// 기본 디폴트 생성자
	public Shopping() {
		this.im = new ItemManager();
	};
	
	// 쇼핑메뉴
	public void shopMenu() {
		System.out.println("[1]쇼핑목록");
		System.out.println("[2]장바구니");
		System.out.println("[0]뒤로가기");
	}
	
	// 쇼핑목록
	public void shoppingList(int shopMenu) {
		for(int i=0; i<im.itemList.size(); i++) {
			if(im.itemList.get(i).category.equals(im.category.get(shopMenu))) {
				System.out.println("["+i+"]"+"["+im.itemList.get(i).name+"]"+"["+im.itemList.get(i).price+"]"+"["+im.itemList.get(i).category+"]");
			}
		}
	}

	
	//메뉴
	public void menu() {
		while(run) {
			System.out.println("[1]로그인");
			System.out.println("[2]로그아웃");
			System.out.println("[3]쇼핑");
			System.out.println("[0]종료");
			System.out.print("메뉴선택: ");
			int menu = scan.nextInt();
			
			// [1] 로그인
			if(menu == 1) {
				super.logCheck();
			}
			// [2] 로그아웃
			if(menu == 2) {
				super.logout(); // 내부의 로그아웃 메서드 호출
			}
			// [3] 쇼핑
			if(menu == 3) {
				shopMenu(); // 쇼핑메뉴 출력
				int Menu01 = scan.nextInt();
				
				// [1]쇼핑목록
				if(Menu01 == 1) {
					System.out.println("[0]과자");
					System.out.println("[1]생선");
					System.out.println("[2]육류");
					System.out.println("[3]음료수");
					System.out.println("카테고리 선택:      [뒤로가기 -1]");
					int cate = scan.nextInt();
					// [-1]뒤로가기
					if(cate == -1) {
						continue;
					}
					// 카테고리 선택할 경우
					else {
						shoppingList(cate); // 해당 카테고리 상품항목 출력
						System.out.println("상품 선택: ");
						int selItem = scan.nextInt();
						c.addCart(super.id[log],im.itemList.get(selItem));
					}
		
				}
				// [2]장바구니
				else if(Menu01 == 2) {
					System.out.println("=========== 내 장바구니 ===========");
					if(c.cartList.isEmpty()) {
						System.out.println("장바구니가 비어있습니다.");
					}else {
						c.printOneCart(super.id[log]);
					}
					System.out.println("=================================");
				}
				
				
			}
			// [0] 종료
			if(menu == 0) {
				run = false;
			}
		}
		
	}

}
