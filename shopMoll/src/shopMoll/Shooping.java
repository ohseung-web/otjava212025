package shopMoll;

import java.util.Scanner;

public class Shooping  extends UserMenu{
	ItemManager it = new ItemManager();
    UserMenu user = new UserMenu();
	Scanner scan = new Scanner(System.in);
	String menu =  "[1]로그인\n[2]로그아웃\n[3]쇼핑\n[0]종료\n";
	String mageMenu ="[1]로그아웃\n[2][아이템관리]\n[3][장바구니리스트]\n";
	String itemMenu ="[1][item 추가]\n[2][item 삭제]\n[3][item 수정]\n[0]종료\n";

	//	메뉴 ----------------------------------------------------------------------------
	public void menu() {
		while(true) {
			System.out.println();
			System.out.print(menu);
			System.out.print("메뉴선택: ");
			int select = scan.nextInt();

			if(select==1) {
				login();
				if(log == 0) {
					managerMenu();
				}
			} else if(select==2) {
				logout();
			} else if(select==3) {
				if(log<0) {
					System.out.println("로그인 후 이용 가능");
				} else {
					shopMenu();
				}
			} else if(select==0) {
				System.out.println("쇼핑몰 종료");
				break;
			}
		}
	}

	//	쇼핑메뉴 ----------------------------------------------------------------------------
	public void shopMenu() {
		while(true) {
			System.out.println();
			System.out.println("[1]쇼핑목록\n[2]장바구니\n[0]뒤로가기\n");
			System.out.println("메뉴 선택");
			int select = scan.nextInt();		

			if(select==0) {
				break;
			}else if(select ==1) {

				it.printCategory();
				System.out.println("쇼핑목록 선택    [뒤로가기 -1] : ");
				int caID=scan.nextInt();

				int n=0;
				for(int i=0 ; i< it.itemList.size(); i++) {
					if(it.category.get(caID).equals(it.itemList.get(i).category)) {
						System.out.print("[" + i + "]");
						it.itemList.get(i).printInfo();
					}else if(caID == -1){
						break;				}
				}
				System.out.println("항목을 선택 :");
				int itemID = scan.nextInt();
				it.addCart(super.id[log], caID , itemID);
				
			}else if(select ==2) {
				System.out.println("=============내  장바구니 ===========");
				for (int i = 0; i < it.jangList.size(); i++) {
					if(it.jangList.get(i).userId.equals(id[log])) {
						it.jangList.get(i).printCart();
					}
				}
				System.out.println("================================");
			}
		}
	}


	// 관리자 메뉴 ----------------------------------------------------------------------------
	public void managerMenu() {
		while(true) {
			System.out.println();
			System.out.println(mageMenu);
			System.out.println("메뉴 선택");
			int select = scan.nextInt();	

			if(select==1) {
				logout();
				break;
			}else if(select ==2) {
				itemmage();
				continue;
			}else if(select ==3) {
				System.out.println("============ 장바구니 리스트 ========");
				it.printJang();
				System.out.println("================================");
			}
		}

	}

	// 아이템 관리메뉴 ----------------------------------------------------------------------------
	public void itemmage() {
		while(true) {
			System.out.println();
			System.out.println(itemMenu);
			System.out.println("메뉴 선택");
			int select = scan.nextInt();	

			if(select==1) {
				System.out.println("추가할 item 이름을 입력하세요");
				String addname = scan.next();
				System.out.println("추가할 item 금액을 입력하세요");
				int addprice  = scan.nextInt();
				System.out.println("추가할 item의 categorry번호를 입력하세요");
				System.out.println("[0]과자 [1]생선 [2]육류 [3]음료수");
				int addcategory = scan.nextInt();
				it.addItem(addname, addprice, addcategory);
				it.printItemList();

			}else if(select ==2) {
				System.out.println("삭제할 item  번호를 입력하세요");
				int deleteindex = scan.nextInt();
				it.deleteItem(deleteindex);
				it.printItemList();

			}else if(select ==3) {
				System.out.println("수정할 item 번호를 입력하세요");
				int indexNUM = scan.nextInt(); 
				System.out.println("수정할 item 이름을 입력하세요");
				System.out.println("[item 금액만 수정할때  item 이름은 기존그대로 입력하세요]");
				String updatename = scan.next();
				System.out.println("수정할 item 금액을 입력하세요");
				System.out.println("[item 이름만 수정할때  item 금액은 기존그대로 입력하세요]");
				int updateprice  = scan.nextInt();
				it.updateItem(indexNUM, updatename, updateprice);
				it.printItemList();

			}else if(select==0) {
				System.out.println("아이템관리 종료");
				user.logindex = -1;
				break;
			}
		}
	}

	//	로그인 메서드 ----------------------------------------------------------------------------
	public void login() {
		if(log>-1) {
			System.out.println("이미 로그인 중입니다.");
		} else {
			log = super.userLog();
		}
	}

	//	로그아웃 메서드 ----------------------------------------------------------------------------
	public void logout() {
		if(log<0) {
			System.out.println("이미 로그아웃 상태입니다.");
		} else {
			log = -1;
			System.out.println("안녕히계세요.");
		}
	}
}
