package shopMol05;

import java.util.Scanner;

public class ManagerMenu extends ItemManager{
	Cart C = new Cart();
	
	// 매개변수 생성자
	public ManagerMenu(Cart c) { // Cart 클래스를 참조변수로 받아옴
		this.C = c;
	}; 
	
	Scanner scan = new Scanner(System.in);
	
	boolean ManagerRun = true;
	
	public void ManagerMenu() {
		
		while(ManagerRun) {
			System.out.println("[1]로그아웃");
			System.out.println("[2]아이템 관리");
			System.out.println("[3]장바구니 리스트");
			
			System.out.println("메뉴 선택");
			int menu = scan.nextInt();
			
			// [1]로그아웃
			if(menu == 1) {
				Shopping S = new Shopping();
				System.out.println("안녕히계세요.");
				ManagerRun = false;
				return;
			}
			// [2]아이템 관리
			else if(menu == 2) {
				System.out.println("[1]item 추가");
				System.out.println("[2]item 삭제");
				System.out.println("[3]item 수정");
				System.out.println("[0]종료");
				
				System.out.println("메뉴 선택");
				int menu01 = scan.nextInt();
				
				// [1]item 추가
				if(menu01 == 1) {
					System.out.println("추가할 item 이름을 입력하세요.");
					String addName = scan.next();
					
					// 중복된 상품인지 확인 후, 가격 입력
					if(super.checkItem(addName)) {
						System.out.println("추가할 item 금액을 입력하세요.");
					}else {
						System.out.println("이미 존재하는 item 입니다.");
						continue;
					}
//					System.out.println(super.checkItem(addName) ? "추가할 item 금액을 입력하세요." : "이미 존재하는 item 입니다.");
					int addPrice = scan.nextInt();
					
					System.out.println("추가할 item 카테고리를 입력하세요.");
					System.out.println("[0]과자  [1]육류  [2]생선  [3]음료수");
					int addCate = scan.nextInt();
					
					// [0]과자
					if(addCate == 0) {
						info(addName,addPrice,category.get(addCate)); // item 이름, 가격, 카테고리(인덱스번호)를 item 배열에 넣기
						printItemList(); // item 배열 목록 출력
					}
					// [1]육류
					else if(addCate == 1) {
						info(addName,addPrice,category.get(addCate)); // item 이름, 가격, 카테고리(인덱스번호)를 item 배열에 넣기
						printItemList(); // item 배열 목록 출력
					}
					// [2]생선
					else if(addCate == 2) {
						info(addName,addPrice,category.get(addCate)); // item 이름, 가격, 카테고리(인덱스번호)를 item 배열에 넣기
						printItemList(); // item 배열 목록 출력
					}
					// [3]음료수
					else if(addCate == 3) {
						info(addName,addPrice,category.get(addCate)); // item 이름, 가격, 카테고리(인덱스번호)를 item 배열에 넣기
						printItemList(); // item 배열 목록 출력
					}
					// 예외 처리
					else {
						System.out.println("존재하지 않는 카테고리 번호입니다.");
						continue;
					}
					
				}
				// [2]item 삭제
				else if(menu01 == 2) {
					printItemList();
					System.out.println("삭제할 item 번호를 입력하세요.");
					int del = scan.nextInt();
					delItem(del);
				}
				// [3]item 수정
				else if(menu01 == 3) {
					printItemList();
					change();
					printItemList(); // 변경 후 아이템 리스트 출력
				}
				// [0]종료
				else if(menu01 == 0) {
					System.out.println("아이템 관리 종료");
					ManagerRun = false;
				}
				// 예외처리
				else {
					System.out.println("메뉴 선택을 다시 확인해주세요.");
				}
			}
			// [3]장바구니 리스트
			else if(menu == 3) {
				C.printAllCart();
			}
			// 예외 처리
			else {
				System.out.println("메뉴를 다시 선택해주세요.");
			}
		}
	}
}
