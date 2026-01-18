package shopMol;

import java.util.ArrayList;
import java.util.Scanner;

public class Shooping extends UserMenu{
	Scanner scan = new Scanner(System.in);
	//Item itemcls = new Item();
	ItemManager itemManager = new ItemManager();
	
	//장바구니 저장용 ArrayList
	ArrayList<Integer> cartUser = new ArrayList<>();//유저
	ArrayList<Item> cartList = new ArrayList<>(); //상품
	ArrayList<Integer> cartQty  = new ArrayList<>();//수량

	public Shooping() {};
	
	//장바구니 추가
	public void addCart(int user, int item) {		
		int status = 0; //장바구니 담겨있는지 여부	
		
		for(int i=0; i<cartUser.size(); i++) {
			//기존 장바구니에 동일한 유저가 동일한 물건을 담았으면
			if(cartUser.get(i) == user
			&& cartList.get(i).name.equals(itemManager.itemList.get(item).name)){
				
				int quan = cartQty.get(i);//기존수량
				
				cartQty.set(i, quan+1); //수량증가 
				status++;
				break;
			}
		}
		
		if(status == 0) { //기존에 담겨있는게 없으면
			cartUser.add(user);
			cartList.add(new Item(itemManager.itemList.get(item).name,
					itemManager.itemList.get(item).price,
					itemManager.itemList.get(item).category));
			cartQty.add(1);
		}
	};
	
	boolean run = true;//메뉴 실행
	
	//메뉴
	public void menu() {
		
		while(run) {
			System.out.println("[1]로그인");
			System.out.println("[2]로그아웃");
			System.out.println("[3]쇼핑");
			System.out.println("[0]종료");
			System.out.println("메뉴선택: ");
		
			//메뉴 출력
			int menuSel = scan.nextInt();
			System.out.println();
			
			if(menuSel==1) {//로그인 선택시
				if(super.userLog() == -1) {
					System.out.println("ID입력: ");
					String userId = scan.next();
					System.out.println("PW입력: ");
					String userPw = scan.next();
	
					//로그인 메소드
					login(userId,userPw);
					
					System.out.println();
					
					if(super.userLog() == 99999999) {
						adminMenu();
					}
				}else {
					System.out.println("이미 로그인 되있습니다.");
					System.out.println();
				}
			}else if(menuSel==2) {//로그아웃 선택시
				if(super.userLog() == -1) {
					System.out.println("이미 로그아웃 되있습니다.");
					System.out.println();
				}else {
					//로그아웃 메소드
					logout();
					System.out.println("로그아웃 되었습니다.");
					System.out.println();
				}
			}else if(menuSel==3) {//쇼핑메뉴 선택시
				if(super.userLog() == -1) {
					System.out.println("로그인 후 이용 가능합니다.");
					System.out.println();
				}else {
					shopMenu(); //쇼핑메뉴 메소드 실행
				}
			}else if(menuSel==0) {//종료 선택시
				System.out.println("프로그램이 종료됩니다");
				run = false;
				
			}else {//메뉴에 없는번호 입력시
				System.out.println("메뉴를 잘못 입력하였습니다. 다시 입력해주세요.");
				System.out.println();
			}
		
		}
		scan.close();
	};
	
	//쇼핑메뉴
	public void shopMenu() { 
		while(true) {
			System.out.println("[1]쇼핑목록");
			System.out.println("[2]장바구니");
			System.out.println("[0]뒤로가기");
			System.out.println("메뉴선택: ");	
			
			int shopSel = scan.nextInt();
			
			if(shopSel==1) {//카테고리 목록
				while(true) {
					// 카테고리 출력 메서드
					itemManager.printCategory();
					
					System.out.println("쇼핑목록 선택:    [뒤로가기 -1]");
					int shopList = scan.nextInt();
					
					if(shopList == -1) {//뒤로가기 눌렀을때
						break;
					}else if(shopList >= 0 && shopList < itemManager.category.size()){//쇼핑목록 선택했을때
						//아이템 출력 메서드
						itemManager.printItemList(shopList);
						System.out.println("항목을 선택 :");
						
						int item = scan.nextInt();//항목입력
						
						addCart(super.userLog(), item);//장바구니 추가
						
						System.out.println();
						break;
					}else {
						System.out.println("목록을 잘못 입력하였습니다. 다시 입력해주세요.");
						continue;
					}	
				}						
			}else if(shopSel==2) {//장바구니 목록
				System.out.println("========== 내 장바구니 ==========");
				for(int i=0; i< cartUser.size(); i++) {
					if(cartUser.get(i) == super.userLog()) {
						System.out.println("["+id[cartUser.get(i)]+"]항목 : "+
					cartList.get(i).name +", 금액 : "+cartList.get(i).price * cartQty.get(i) +", 수량 : "+cartQty.get(i)+"개");
					}
				}
				System.out.println("==============================");
				continue;
			}else if(shopSel==0) {//뒤로가기
				break;
			}else {
				System.out.println("메뉴를 잘못 입력하였습니다. 다시 입력해주세요.");
				System.out.println();
			}								
		}
	};
	
	//로그인 메서드
	public void login(String userId, String userPw) {
		//로그인 상태이면
		if(super.userLog() != -1) { 
			System.out.println("이미 로그인 되어있습니다.");
			return;
		}
		//아이디 비번 일치 체크
		for(int i=0;i<super.id.length;i++) {
			if(super.id[i].equals(userId) && super.pw[i].equals(userPw)) {
				super.log = i;
				System.out.println("["+userId+"]님, 환영합니다.");
				break;				
			}
		}
		
		//관리자 로그인
		if(userId.equals("mmm") && userPw.equals("123")) {
			super.log = 99999999;
			System.out.println("당신은 관리자 입니다.");
		}
		
		//일치하지 않으면(log가 증가하지 X)
		if(super.userLog() == -1){
			System.out.println("아이디 혹은 비밀번호가 맞지 않습니다.");
		}		
	};
	
	//로그아웃 메서드
	public void logout() {
		super.log = -1;
	};
	
	
	//관리자메뉴
	public void adminMenu() {
		boolean run = true;
		
		while(run) {
			System.out.println("[1]로그아웃");
			System.out.println("[2][카테고리 관리]");
			System.out.println("[3][아이템 관리]");
			System.out.println("[4][장바구니리스트]");
			
			int menuSel = scan.nextInt();
			
			if(menuSel == 1) {//로그아웃
				super.log = -1;
				break;				
			}else if(menuSel == 2) {//카테고리 관리
				
				adminCate();//카테고리관리 메소드 실행
				
			}else if(menuSel == 3) {//아이템 관리
				
				adminItem();//아이템관리 메소드 실행	
				
			}else if(menuSel == 4) {//장바구니 목록
				System.out.println("========== 내 장바구니 ==========");
				for(int i=0; i< cartUser.size(); i++) {
					System.out.println("["+id[cartUser.get(i)]+"]항목 : "+
					cartList.get(i).name +", 금액 : "+cartList.get(i).price * cartQty.get(i) +", 수량 : "+cartQty.get(i)+"개");
				}
				System.out.println("==============================");
				continue;
			}else {
				System.out.println("메뉴를 잘못 입력하였습니다. 다시 입력해주세요.");
				System.out.println();
			}
			
		}
	}
	
	//아이템관리
	public void adminItem() {
		boolean run = true;
		
		while(run) {
			System.out.println("[1][item 추가]");
			System.out.println("[2][item 삭제]");
			System.out.println("[3][item 수정]");
			System.out.println("[0]종료");
			System.out.println("메뉴선택: ");	
			
			int menuSel = scan.nextInt();
			
			if(menuSel == 1) {//item추가
				//아이템 리스트 출력
				itemManager.itemList();
				System.out.println();	
				
				System.out.println("추가할 item 이름을 입력하세요.");
				String itemName = scan.next();
				
				System.out.println("추가할 item 금액을 입력하세요.");
				int itemPrice = scan.nextInt();
				
				System.out.println("추가할 item 카테고리 번호를 입력하세요.");
				itemManager.printCategory();//카테고리 목록 출력
				
				int itemCate = scan.nextInt();//카테고리 번호입력
								
				itemManager.info(itemName, itemPrice, itemCate);//아이템추가
				
				//아이템 리스트 출력
				itemManager.itemList();				
				System.out.println();
				
			}else if(menuSel == 2) {//item 삭제
				//아이템 리스트 출력
				itemManager.itemList();
				System.out.println();
				
				System.out.println("삭제할 item 번호를 입력하세요.");
				int itemNum = scan.nextInt();
				
				//아이템 번호 안의 숫자 입력시
				if(0 <= itemNum && itemNum <= itemManager.itemList.size()-1) {
					//만약 삭제한 아이템이 장바구니에도 있으면 장바구니 목록에서도 삭제
					for(int i=0; i< cartList.size(); i++) {
						if(cartList.get(i).name.equals(itemManager.itemList.get(itemNum).name)) {
							cartUser.remove(i);
							cartList.remove(i);
							cartQty.remove(i);
						}
					}
					
					itemManager.itemList.remove(itemNum);//아이템삭제
					
					//아이템 리스트 출력
					itemManager.itemList();
				}else {//아이템 번호 밖의 숫자 입력시
					System.out.println("아이템번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
				}
				System.out.println();
			}else if(menuSel == 3) {//item 수정
				//아이템 리스트 출력
				itemManager.itemList();
				System.out.println();
				
				System.out.println("수정할 item 번호를 입력하세요.");
				
				int itemNum = scan.nextInt();//item 번호입력
				
				//아이템 번호 안의 숫자 입력시
				if(0 <= itemNum && itemNum <= itemManager.itemList.size()-1) {
				
					System.out.println("수정할 item 이름을 입력하세요.");
					System.out.println("[item 금액만 수정할때 item 이름은 기존 그대로 입력하세요.]");
					
					String itemName = scan.next();//item 이름입력
					
					System.out.println("수정할 item 금액을 입력하세요.");
					System.out.println("[item 이름만 수정할때 item 금액은 기존 그대로 입력하세요.]");	
					
					int itemPrice = scan.nextInt();//item 금액입력
					
					//만약 수정한 아이템이 장바구니에도 있으면 장바구니 목록에서도 수정
					for(int i=0; i< cartList.size(); i++) {
						if(cartList.get(i).name.equals(itemManager.itemList.get(itemNum).name)) {
							cartList.set(i, new Item(itemName,itemPrice,cartList.get(i).category));
						}
					}
					
					//아이템 수정
					itemManager.itemList.set(itemNum, new Item(itemName,itemPrice,itemManager.itemList.get(itemNum).category));
					
					//아이템 리스트 출력
					itemManager.itemList();
				}else {//아이템 번호 밖의 숫자 입력시
					System.out.println("아이템번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
				}
				System.out.println();				
			}else if(menuSel == 0) {//종료
				System.out.println("아이템관리 종료");
				System.out.println();
				run=false;
			}else{//종료
				System.out.println("메뉴를 잘못 입력하였습니다. 다시 입력해주세요.");
				System.out.println();
			}
		}
	}
	
	
	//카테고리 관리
	public void adminCate() {
		boolean run = true;
		
		while(run) {
			System.out.println("[1][카테고리 추가]");
			System.out.println("[2][카테고리 삭제]");
			System.out.println("[3][카테고리 수정]");
			System.out.println("[0]종료");
			System.out.println("메뉴선택: ");	
			
			int menuSel = scan.nextInt();
			
			if(menuSel == 1) {//카테고리 추가
				//카테고리 리스트 출력
				itemManager.printCategory();
				System.out.println();	
				
				System.out.println("추가할 카테고리 이름을 입력하세요.");
				String cateName = scan.next();
				
				itemManager.category.add(cateName);//카테고리 추가
				
				//카테고리 리스트 출력
				itemManager.printCategory();
				System.out.println();
				
			}else if(menuSel == 2) {//카테고리 삭제
				//카테고리 리스트 출력
				itemManager.printCategory();
				System.out.println();
				
				System.out.println("삭제할 카테고리 번호를 입력하세요.");
				int cateNum = scan.nextInt();
				
				//카테고리 번호 안의 숫자 입력시
				if(0 <= cateNum && cateNum <= itemManager.category.size()-1) {
					//만약 삭제한 카테고리가 장바구니에도 있으면 장바구니 목록에서도 삭제
					for(int i=0; i< cartList.size(); i++) {
						if(cartList.get(i).category.equals(itemManager.category.get(cateNum))) {
							cartUser.remove(i);
							cartList.remove(i);
							cartQty.remove(i);
						}
					}
					
					itemManager.category.remove(cateNum);//카테고리삭제
					
					//카테고리 리스트 출력
					itemManager.printCategory();
				}else {//카테고리 번호 밖의 숫자 입력시
					System.out.println("카테고리 번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
				}
				System.out.println();
			}else if(menuSel == 3) {//카테고리 수정
				//카테고리 리스트 출력
				itemManager.printCategory();
				System.out.println();
				
				System.out.println("수정할 카테고리 번호를 입력하세요.");
				
				int cateNum = scan.nextInt();//카테고리 번호입력
				
				//카테고리 번호 안의 숫자 입력시
				if(0 <= cateNum && cateNum <= itemManager.category.size()-1) {
				
					System.out.println("수정할 카테고리 이름을 입력하세요.");					
					String cateName = scan.next();//카테고리 이름입력
					
					//만약 수정한 카테고리가 장바구니에도 있으면 장바구니 목록에서도 수정
					for(int i=0; i< cartList.size(); i++) {
						if(cartList.get(i).category.equals(itemManager.category.get(cateNum))) {
							cartList.set(i, new Item(cartList.get(i).name,cartList.get(i).price,cateName));
						}
					}
					
					//카테고리 수정
					itemManager.category.set(cateNum, cateName);
					
					//카테고리 리스트 출력
					itemManager.printCategory();
				}else {//카테고리 번호 밖의 숫자 입력시
					System.out.println("카테고리 번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
				}
				System.out.println();				
			}else if(menuSel == 0) {//종료
				System.out.println("카테고리 관리 종료");
				System.out.println();
				run=false;
			}else{//종료
				System.out.println("메뉴를 잘못 입력하였습니다. 다시 입력해주세요.");
				System.out.println();
			}
		}
	}
	
	
}


















