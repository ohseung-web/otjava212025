package shopMall;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Shopping extends UserMenu {
	Scanner scan = new Scanner(System.in);
	ItemManager im = new ItemManager();
	boolean run = true;
	boolean shopping = true;
	boolean manager = false;
	ArrayList<UserMenu> cart = new ArrayList<>();
	NumberFormat num = NumberFormat.getInstance();
	
	
	public Shopping() {}
	
	//메뉴
	public void menu() {
		
		while(run) {
			if(log == 5 && manager) {
				showManagerMenu();
			}else {
				System.out.println("[1] 로그인");
				System.out.println("[2] 로그아웃");
				System.out.println("[3] 쇼핑");
				System.out.println("[0] 종료");
				System.out.print("메뉴선택: ");
				int selectA = scan.nextInt();
				
				if(selectA == 1) {// 로그인
					login();
				}
				
				else if(selectA == 2) { // 로그아웃
					logout();
				}
				
				else if(selectA == 3) { // 쇼핑
					System.out.println();
					shopping = true;
					shopMenu();
				}
				
				else if(selectA == 0) { // 종료
					System.out.println("프로그램 종료");
					run = false;
				}
				
				else {
					System.out.println("잘못된 입력입니다.");
				}
			}
			
		}
	}
	
	//쇼핑메뉴
	public void shopMenu() {
			if(log != -1) {
				while(shopping) {
					System.out.println("[1] 쇼핑목록");
					System.out.println("[2] 장바구니");
					System.out.println("[0] 뒤로가기");
					System.out.print("메뉴 선택: ");
					int selectB = scan.nextInt();
					if(selectB == 1) {
						System.out.println();
						im.printCategory();
						System.out.print("카테고리 선택: ");
						int selectC = scan.nextInt();
						System.out.println();
						im.printItemList(im.category.get(selectC-1));
						System.out.println("아이템 선택: ");
						int selectD = scan.nextInt();
						addCart(selectD); // 카트 담기
					}
					else if(selectB == 2) { // 카트 보기
						 if(cart.size() == 0) {
							 showCart();
					         System.out.println("장바구니가 비어있습니다.");
					         System.out.println();
					         continue;
					        }
						 else {
							 showCart();
								System.out.println("[1] 아이템 삭제");
							    System.out.println("[0] 뒤로가기");
							    System.out.print("메뉴 선택: ");
							    int selectE = scan.nextInt();
							    System.out.println();

							    if(selectE == 1) {
							       
							        System.out.println("삭제할 아이템의 이름을 입력하세요");
							        String itemName = scan.next();
							        deleteCart(itemName);  
							    }
							    else if(selectE == 0) {
							        continue;
							    }
							    else {
							        System.out.println("잘못된 입력입니다.");
							    }
						 }
						
					}
					else if(selectB == 0) {
						System.out.println();
						shopping = false;
					}
					else System.out.println("입력을 확인하세요.");
					
				}
				
			}
			else if(log == -1) {
				System.out.println("로그인 후 이용 가능합니다.");
				System.out.println();
			}
	}
	
	//로그인 메서드
	public void login() {
		if(log == -1) {
			System.out.println();
			System.out.print("ID입력: ");
			String inputID = scan.next();
			System.out.print("PW입력: ");
			String inputPW = scan.next();
			for(int i = 0; i<super.id.length ; i++) {
				if(inputID.equals(id[i]) && inputPW.equals(pw[i])) {
					userLog(i);
				}
			}
			if(log!=-1 && !id[log].equals("mmm")) {
				System.out.println();
				System.out.printf("[%s]님, 환영합니다.%n", id[log]);
				System.out.println();
				userid = id[log];
			}else if(log == -1) {
				System.out.println();
				System.out.println("입력을 확인하세요.");
				System.out.println();
			}else if(log==5){
				System.out.println();
				System.out.println("당신은 관리자 입니다.");
				System.out.println();
				userLog(5);
				manager = true;
			}
		}
		else if(log != -1) {
			System.out.println();
			System.out.println("이미 로그인 상태입니다.");
			System.out.println();
		}
	}
	
	//로그아웃 메서드
	public void logout() {
		if(log != -1) {
			System.out.println();
			System.out.println("로그아웃 되었습니다.");
			System.out.println();
			userLog(-1);
		}
		else if(log == -1) {
			System.out.println();
			System.out.println("로그아웃 상태입니다.");
			System.out.println();
		}
	}
	
	
	// 회원용
		// 카트 담기 메서드
		public void addCart(int idx) {
		    for (UserMenu u : cart) {
		        if (im.itemList.get(idx - 1).name.equals(u.itemName)) {
		            u.itemQty++;
		            System.out.println("아이템 수량이 증가했습니다.");
		            System.out.println();
		            return;
		        }
		    }
	
		    cart.add(new UserMenu(super.userid, im.itemList.get(idx - 1).name, im.itemList.get(idx - 1).price, 1));
		    System.out.println("아이템이 추가되었습니다.");
		    System.out.println();
		}
		// 카트 빼기 메서드
		public void deleteCart(String itemName) {
		    for(int i = 0; i < cart.size(); i++) {
		        if(cart.get(i).itemName.equals(itemName)) {
		            cart.remove(i);
		            System.out.println("아이템이 삭제되었습니다.");
		            showCart();
		            return;
		        }
		    }
		    System.out.println("해당 아이템을 찾을 수 없습니다.");
		    showCart();
		}
		// 카트 보이기 메서드 
		public void showCart() {
			System.out.println();
			System.out.println("================내 장바구니================");
			for(UserMenu u : cart) {
				if(u.userid.equals(userid)) {
					System.out.printf("[%s] 항목: %s   가격: %d원   수량: %d개%n",
							u.userid, u.itemName, u.itemPrice, u.itemQty
							);
				}
			}
			System.out.println();
			System.out.printf("합계금액: %s원%n", num.format(totalPrice()));
			System.out.println("==========================================");
			System.out.println();
		}
		
		// 합계금액 출력 메서드
		public int totalPrice() {
		    int total = 0;
	
		    for (UserMenu u : cart) {
		        if (u.userid.equals(userid)) {
		            total += u.itemPrice * u.itemQty;
		        }
		    }
	
		    return total;
		}
	// 관리자용
		// 관리자 메뉴 메서드
		public void showManagerMenu() {
			System.out.println("** 관리자 메뉴 **");
			System.out.println("[1] 로그아웃");
			System.out.println("[2] 아이템 관리");
			System.out.println("[3] 장바구니 보기");
			int selectA = scan.nextInt();
			if(selectA == 1) { // 메인화면으로
				System.out.println("로그아웃 되었습니다.");
				System.out.println();
				manager = false;
				userLog(-1);
			}
			else if(selectA == 2) {
				 while(true) {
					System.out.println();
					System.out.println("[1] [item 추가]");
					System.out.println("[2] [item 삭제]");
					System.out.println("[3] [item 수정]");
					System.out.println("[0] 종료");
					System.out.print("메뉴선택: ");
					int selectB = scan.nextInt();
					System.out.println();
					if(selectB == 1) { // 아이템 추가
						System.out.println("추가할 아이템의 카테고리 번호를 입력하세요.");
						for (int i = 0; i < im.category.size(); i++) {
						    System.out.printf("[%d] %s ", i + 1, im.category.get(i));
						};
						System.out.println();
						int cateNum = scan.nextInt();
						System.out.println("추가할 아이템 이름을 입력하세요.");
						String newItemName = scan.next();
						System.out.println("추가할 아이템 가격을 입력하세요.");
						int newItemPrice = scan.nextInt();
						im.addItem(newItemName, newItemPrice, im.category.get(cateNum-1));
					}
					
					else if(selectB == 2) { // 아이템 삭제
						System.out.println("삭제할 아이템의 번호를 입력하세요.");
						int cateNum = scan.nextInt();
						im.removeItem(cateNum-1);
					}
					else if(selectB == 3) { // 아이템 수정
						im.printItemAll();
						System.out.println("수정할 아이템의 번호를 입력하세요.");
						int cateNum = scan.nextInt();
						System.out.println("수정할 아이템 이름을 입력하세요.");
						String editName = scan.next();
						System.out.println("수정할 가격을 입력하세요.");
						int editPrice = scan.nextInt();
						im.editItem(cateNum-1, editName, editPrice);
					}
					else if(selectB == 0) { // 매니져 화면으로
						break;
					}
					else {
						System.out.println("잘못된 입력입니다.");
						System.out.println();
					}
				 }
			}
			else if(selectA == 3) {
				System.out.println();
				if(cart.isEmpty()) {
					System.out.println("리스트가 비어있습니다");
				} else {
					System.out.println("============장바구니 리스트============");
					for(UserMenu u : cart) {
							System.out.printf("[%s]항목: %s   가격: %d원   수량: %d개%n",
									u.userid, u.itemName, u.itemPrice, u.itemQty
									);
					}
					System.out.println("=======================================");
				}
				System.out.println();
			}
			else {
				System.out.println("잘못된 입력입니다.");
			}
		}
}
