package shopMall04;

import java.util.Scanner;


public class Shopping extends UserMenu {
	ItemManager itemManager = new ItemManager();
	CartArray cartarray = new CartArray();
	public Shopping() {};
	boolean run = true;
	boolean shoppingRun = true;
	boolean categoryRun = true;
	Scanner scan = new Scanner(System.in);
	//메뉴
	public void menu() {
		while(run) {
			shoppingRun = true;
			if(super.log != -2) { //일반 회원으로 로그인했다면
				System.out.println("[1]로그인");
				System.out.println("[2]로그아웃");
				System.out.println("[3]쇼핑");
				System.out.println("[0]종료");
				System.out.print("메뉴를 선택하세요 >> ");
				int sel = scan.nextInt();
				if(sel == 1) {
					login();		
				}else if(sel ==2) {
					logout();
				}else if(sel ==3) {
					shopMenu();
				}else if(sel ==0) {
					System.out.println("종료되었습니다.");
					run = false;
				}
			}else { //관리자로 로그인했다면
				System.out.println("\n[1]로그아웃");
				System.out.println("[2]아이템관리");
				System.out.println("[3]장바구니 리스트");
				System.out.print("메뉴를 선택하세요 >> ");
				int sel = scan.nextInt();
				if(sel == 1) {
					logout();
				}else if(sel ==2) {   // 아이템 관리 시작
					System.out.println("[1]상품 추가");
					System.out.println("[2]상품 삭제");
					System.out.println("[3]상품 수정");
					System.out.println("[0]종료");
					System.out.print("메뉴를 선택하세요 >> ");
					sel = scan.nextInt();
					if(sel ==1) {  //관리자가 상품 추가 선택===================================
					String cateString = "";
						System.out.print("추가할 상품 이름을 입력하세요 >> ");
							String newItemName = scan.next();
						System.out.print("추가할 상품 가격을 입력하세요 >> ");
							int newItemPrice = scan.nextInt();
						System.out.println("추가할 상품의 카테고리 번호를 입력하세요. ");
						System.out.println("[0]과자 [1]생선 [2]육류 [3]음료수 ");
						System.out.print("입력 >> ");
							int newItemCategory = scan.nextInt();
							if(newItemCategory == 0) { //카테고리 넘버랑 String 매칭시키기
								cateString = "과자";
							}else if(newItemCategory == 1) {
								cateString = "생선";
							}else if(newItemCategory == 2) {
								cateString = "육류";
							}else if(newItemCategory == 3) {
								cateString = "음료수";
							};
							itemManager.managerAddItem(newItemCategory,cateString,newItemPrice,newItemName);//관리자 아이템추가 끝
						
					}else if(sel==2) {	//관리자가 상품삭제 선택=====================================
						itemManager.printItemList();
						System.out.print("삭제할 상품의 번호를 입력하세요 >> ");
						sel = scan.nextInt();
						itemManager.managerRemoveItem(sel);
					}else if(sel ==3) { //관리자가 상품수정 선택====================================
						itemManager.printItemList();
						System.out.print("수정할 상품의 번호를 입력하세요 >> ");
							sel = scan.nextInt();
						System.out.print("수정할 상품의 이름를 입력하세요 >> ");
							String ModItemName = scan.next();
						System.out.print("수정할 상품의 금액를 입력하세요 >> ");
							int ModItemPrice = scan.nextInt();
						System.out.println("수정할 상품의 카테고리 번호를 입력하세요. ");
						System.out.println("[0]과자 [1]생선 [2]육류 [3]음료수 ");
						System.out.print("입력 >> ");
							int ModItemCategory = scan.nextInt();
							String ModItemCateName = ""; //카테고리 넘버랑 String 매칭시키기
							if(ModItemCategory == 0) {
								ModItemCateName = "과자";
							}else if(ModItemCategory == 1) {
								ModItemCateName = "생선";
							}else if(ModItemCategory == 2) {
								ModItemCateName = "육류";
							}else if(ModItemCategory == 3) {
								ModItemCateName = "음료수";
							};
						itemManager.managerModifyItem(sel,ModItemName,ModItemPrice,ModItemCateName,sel);
						//관리자의 전체 아이템 관리 끝
					}
					
				}else if(sel ==3) { // 관리자 장바구니 리스트 확인하기 ===========
					cartarray.managerCartShow();
					if(cartarray.cartList.size() != 0) {
						System.out.println("모든 고객들의 장바구니 상품 총액 합산 : "+ cartarray.allCartTotalPrice()+"원");
					}
					
				}
			}
			
		}
	};
	//쇼핑메뉴
	public void shopMenu() {
		if(super.log != -1) {
			while(shoppingRun) {
				categoryRun = true;
				System.out.println("===========");
				System.out.println("[1]쇼핑목록");
				System.out.println("[2]장바구니");
				System.out.println("[-1]뒤로가기");
				System.out.print("메뉴를 선택하세요 >> ");
				int sel = scan.nextInt();
				if(sel == 1) { //쇼핑 목록 확인하기
					while(categoryRun) {	
						itemManager.printCategory(); //카테고리 출력
						sel = scan.nextInt(); //카테고리 선택 
						
						itemManager.printItemList(sel); //상품출력 ex)[0][과자][1000][새우깡] ...
						sel = scan.nextInt();
						if(sel == -1) { 
							System.out.println("뒤로가기");
							categoryRun = false;
						}if(sel != -1) {//뒤로가기가 아니라 항목 선택
							//sel값 받아서 
							Item item = itemManager.itemList.get(sel);
						    cartarray.addCart(log, super.id[super.log], item.category, item.price);
						    categoryRun = false;
						}
					}
				}else if(sel == 2) {
					//여긴 장바구니 목록 출력하는 메서드 불러오기
					cartarray.printUserCart(super.log);
					
				}else if(sel == -1) {
					System.out.println("뒤로가기");
					shoppingRun = false;
				}
			}
		}else {
			System.out.println("로그인 후 이용 가능");
		}
	
	};
	//로그인 메서드
	public void login() {
			System.out.print("아이디를 입력하세요 >> ");
			String inputid = scan.next();
			System.out.print("비밀번호를 입력하세요 >> ");
			String inputpw = scan.next();
			for(int i = 0; i<super.id.length; i++) {
				if(super.id[i].equals(inputid) && super.pw[i].equals(inputpw)) {
					super.log = i;
				}else if(inputid.equals("mmm") && inputpw.equals("123")) {
					super.log = -2;
				}
			}
			if(super.log != -2 && super.log != -1) {
				System.out.println("\n["+super.id[super.log]+"]님, 환영합니다.\n");
				super.userLog(log);
			}else if(super.log == -2){
				System.out.println("\n당신은 관리자입니다.\n");
				super.userLog(log);
			}else {
				System.out.println("아이디와 비밀번호를 다시 확인해주세요.");
			}
		
	};
	//로그아웃 메서드
	public void logout() {
		if(super.log != -1) {
			System.out.println("로그아웃 되었습니다.");
			super.log = -1;
		}else {
			System.out.println("로그인 상태가 아닙니다.");
		}
	};

}