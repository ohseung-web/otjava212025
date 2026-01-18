package shopMol03;

import java.util.Scanner;

public class Shooping extends UserMenu{
	Scanner scan = new Scanner(System.in); // 스캐너
	String idChk; // id 스캔용 변수
	String pwChk; // pw 스캔용 변수
	ItemManager itemManage = new ItemManager(); // 관리자용 아이템 목록 및 메서드 불러오기 위한 객체화
	Cart cart = new Cart(); // 장바구니 메서드 불러오기 위한 객체화
	Item items = new Item(); // 아이템 이름, 가격 등의 코드 길이를 줄이기 위해 객체화
	CartList wishlist = new CartList(); 
	
	//메뉴
	public void menu() {
		System.out.println(wishlist.quantity);
		boolean run = true;
		while(run){
			System.out.println("[1] 로그인\n[2] 로그아웃\n[3] 쇼핑\n[0] 종료\n");
			System.out.print("메뉴 선택 : ");
			int menuSel = scan.nextInt();
			if(menuSel == 1) {
				login();
				System.out.println();
			}else if(menuSel == 2) {
				logout();
				System.out.println();
			}else if(menuSel == 3) {
				shopMenu();
				System.out.println();
			}else if(menuSel == 0) {
				run = false;
				System.out.println("안녕히계세요.");
			}else {
				System.out.println("0번부터 3번까지의 번호 중 하나를 선택해주세요.");
			}
		}
		
	}
	
	//쇼핑메뉴
	public void shopMenu() {
		super.userLog();
		if(log != -1) {
			boolean shopRun = true;
			while(shopRun) {
				System.out.println();
				System.out.print("[1] 쇼핑목록\n[2] 장바구니\n[0] 뒤로가기\n메뉴 선택 : ");
				int shopSel = scan.nextInt();
				if(shopSel == 1) {
					shopMenu1();
				}else if(shopSel == 2) {
					shopMenu2();
				}else if(shopSel == 0) {
					shopRun = false;
				}else {
					System.out.println("0번부터 2번까지의 메뉴 중 하나를 선택해주세요.");
				}
			}
		}
	}
	
	// 쇼핑 메뉴 1번
	public void shopMenu1() {
		boolean shopMenu1Run = true;
		while(shopMenu1Run) {
			System.out.println();
			itemManage.printCategory();
			System.out.println();
			System.out.println("쇼핑 목록 선택\t[뒤로가기 = -1] : ");
			int shopingSel = scan.nextInt();
			if(shopingSel == -1) {
				shopMenu1Run = false;
			}else {
				for(int i = 0; i < itemManage.itemList.size(); i++) {
					if(itemManage.category.get(shopingSel).equals(itemManage.itemList.get(i).category)) {
						System.out.print("[" + i + "]");
						itemManage.itemList.get(i).printInfo();
					}
				}
				System.out.print("항목을 선택 : ");
				int itemSel = scan.nextInt();
				System.out.println();
				// 없는 항목번호를 선택했을때 예외처리 (아직 모르겠음.)
				Item i = itemManage.itemList.get(itemSel);
				cart.cartAdd(id[super.log], i.name, i.price, wishlist.quantity);
			}
		}
	}
	
	// 쇼핑 메뉴 2번
	public void shopMenu2() {
		System.out.println("=============== 내 장바구니 ===============");
		System.out.println();
//		cart.printCart();
//		System.out.println(cart.cartlist.get(log).id);
//		System.out.println(id[super.log]);
		cart.printCart2(id[super.log]);

		//cart.printCart();
		System.out.println();
		System.out.println("========================================");
		System.out.println();
	}
	
	//로그인 메서드
	public void login() {
		System.out.print("ID 입력 : ");
		idChk = scan.next();
		System.out.print("PW 입력 : ");
		pwChk = scan.next();
		if(idChk.equals("mmm") && pwChk.equals("123")) {
			System.out.println("당신은 관리자입니다.");
			System.out.println();
			// 관리자 화면
			manager();
		}else {
			for(int i = 0; i < super.id.length; i++) {
				if(super.id[i].equals(idChk) && super.pw[i].equals(pwChk)) {
					super.log = i;
				}
			}
			if(super.log == -1) {
				System.out.println("아이디 혹은 비밀번호를 확인해주세요.");
			}else {
				System.out.println("[" + id[super.log] + "]님, 환영합니다." );
			}
		}
	}
	
	// 관리자 전용 화면
	public void manager() {
		boolean managerRun = true;
		while(managerRun) {
			System.out.print("[1] 로그아웃\n[2] [아이템 관리]\n[3] [장바구니 리스트]\n메뉴 선택 : ");
			int managerSel = scan.nextInt();
			if(managerSel == 1) {
				log = -1;
				System.out.println("안녕히계세요.");
				managerRun = false;
			}else if(managerSel == 2) {
				itemM();
			}else if(managerSel == 3) {
				userCart();
			}else {
				System.out.println("1번부터 3번까지의 메뉴 중 하나를 선택해주세요.");
			}
		}
	}
	
	// 관리자의 아이템 관리
	public void itemM() {
		boolean itemManageRun = true;
		while(itemManageRun) {
			System.out.println();
			System.out.print("[1] [item 추가]\n[2] [item 삭제]\n[3] [item 수정]\n[0] 종료\n메뉴 선택 : ");
			int itemManagerSel = scan.nextInt();
			System.out.println();
			if(itemManagerSel == 1) {
				addItem();
			}else if(itemManagerSel == 2) {
				removeItem();
			}else if(itemManagerSel == 3) {
				changeItem();
			}else if(itemManagerSel == 0) {
				itemManageRun = false;
			}else {
				System.out.println("0번부터 3번까지의 메뉴 중 하나를 선택해주세요.");
			}
		}
	}
	
	// 관리자의 아이템 추가
	public void addItem() {
		// 아이템 목록 --------------
		System.out.println("===== 현재 아이템 목록 =====");
		itemManage.printItemList2();
		System.out.println();
		
		// 아이템 추가 --------------
		System.out.println("추가할 item의 category 번호를 입력하세요.");
		itemManage.printCategory();
		System.out.println();
		int categorySel = scan.nextInt();
		System.out.println("추가할 item의 이름을 입력하세요.");
		String itemName = scan.next();
		System.out.println("추가할 item의 가격을 입력하세요.");
		int itemPrice = scan.nextInt();
		itemManage.itemAdd(itemName, itemPrice, itemManage.category.get(categorySel));
	}
	
	// 관리자의 아이템 삭제
	public void removeItem() {
		// 현재 물품 리스트 ------------------
		System.out.println("===== 현재 아이템 목록 =====");
		itemManage.printItemList();
		System.out.println();
		
		// 삭제 -----------------------
		System.out.print("삭제할 아이템 번호를 입력하세요 : ");
		int removeItemNum = scan.nextInt();
		itemManage.itemRemove(removeItemNum);
	}
	
	// 관리자의 아이템 수정
	public void changeItem() {
		// 현재 물품 리스트 ------------------------------
		System.out.println("===== 현재 아이템 목록 =====");
		itemManage.printItemList();
		System.out.println();
		
		// 수정 -------------------------------
		System.out.print("수정할 아이템 번호를 입력하세요 : ");
		int changeNum = scan.nextInt();
		if(changeNum > itemManage.itemList.size() - 1 || changeNum < 0) {
			System.out.println("현재 물품번호에 맞게 선택해주세요.");
		}else {
			System.out.println("수정할 아이템 이름을 입력하세요. \n[item 금액만 수정할 때 item 이름은 기존 그대로 입력하세요.]");
			String changeName = scan.next();
			System.out.println("수정할 아이템 금액을 입력하세요. \n[item 이름만 수정할 때 item 금액은 기존 그대로 입력하세요.]");
			int changeMoney = scan.nextInt();
			itemManage.itemChange(changeNum, changeName, changeMoney);
			itemManage.printItemList();
		}
	}
	
	// 관리자의 장바구니 리스트
	public void userCart() {
		System.out.println("============= 장바구니 리스트 =============");
		System.out.println();
		cart.printCart();
		System.out.println();
		System.out.println("========================================");
		System.out.println();
	}
	//로그아웃 메서드
	public void logout() {
		super.userLog();
		if(log != -1) {
			log = -1;
			System.out.println("안녕히계세요.");
		}
	}
}
