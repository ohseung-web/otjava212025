package shopMol06;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemManager {
//	카테고리를 String 자료형으로 ArrayList생성
	ArrayList<String> category = new ArrayList<String>();
	
//	전체 아이템리스트를 Item 자료형으로 ArrayList생성
	ArrayList<Item> itemList = new ArrayList<Item>();
	
//	장바구니 배열
	ArrayList<Item> cartList = new ArrayList<Item>();
	
	Scanner scan = new Scanner(System.in);
	
	String addItemCate;  // 카테고리 변환?
	
	User userId = new User();  // 객체화
	
	public ItemManager() {
		info();
	}
	
	public void info() {
		category.add("과자");
		category.add("생선");
		category.add("육류");
		category.add("음료");
		
		itemList.add(new Item("새우깡", 1000, category.get(0)));
		itemList.add(new Item("고등어", 3000, category.get(1)));
		itemList.add(new Item("칸쵸",500, category.get(0)));
		itemList.add(new Item("소고기", 10000, category.get(2)));
		itemList.add(new Item("돼지고기", 8000, category.get(2)));
		itemList.add(new Item("콜라", 1000, category.get(3)));
		itemList.add(new Item("사이다", 1200, category.get(3)));
		itemList.add(new Item("새우", 5000, category.get(1)));
		itemList.add(new Item("양파링", 1300, category.get(0)));
		itemList.add(new Item("콘칩", 1500, category.get(0)));
	}
	
//	 카테고리 출력 메서드
	public void printCategory() {
		for(int i = 0; i < category.size(); i++) {
			System.out.print("[" + i + "]" + category.get(i) + "\t\n");
		}
	}
	
//	item 목록 출력 메서드 
	public void printItemList() {
		for(int i = 0; i < itemList.size(); i++) {
			System.out.println("[" + i + "][" + itemList.get(i).category + "][" + itemList.get(i).name + "][" + itemList.get(i).price + "]");
		}
	}
	
//	 카테고리 추가 및 item 추가 메서드
	public void addItem() {
		System.out.println("추가할 상품의 이름을 입력하세요.");
		String addItem = scan.next();
		
		System.out.println("추가할 상품의 금액을 입력하세요.");
		int addItemPrice = scan.nextInt();
		
		System.out.println("추가할 상품의 카테고리 번호를 입력하세요.");
		printCategory();
		
		int addItemCateNum = scan.nextInt();
		
		if(addItemCateNum == 0) {
			addItemCate = "과자";
		}else if(addItemCateNum == 1) {
			addItemCate = "생선";
		}else if(addItemCateNum == 2) {
			addItemCate = "육류";
		}else if(addItemCateNum == 3) {
			addItemCate = "음료";
		}else {
			System.out.println("없는 카테고리 입니다.");
		}
		itemList.add(new Item(addItem, addItemPrice, addItemCate));
		System.out.println();
	}
	
//	아이템 삭제
	public void delItem() {
		int delItem = scan.nextInt();
		itemList.remove(delItem);
		System.out.println();
	}
	
//	아이템, 금액 수정
	public void fixItem() {
		System.out.println("수정할 상품의 번호를 입력하세요.");
		int fixItemNum = scan.nextInt();
		
		System.out.println("수정할 상품의 이름을 입력하세요. (수정하지 않으려면 기존 이름을 입력하세요.)");
		String fixItem = scan.next();
		
		System.out.println("수정할 상품의 금액을 입력하세요. (수정하지 않으려면 기존 금액을 입력하세요.)");
		int fixItemPrice = scan.nextInt();
		
		itemList.get(fixItemNum).name = fixItem;
		itemList.get(fixItemNum).price = fixItemPrice;
	}
	
//	장바구니
//	추가
	public void addCart(String loginId) {  // 로그인한 유저 받아감
//		카테고리 출력 -> 카테고리 선택 -> 해당 카테고리 상품 출력
		
		boolean shoppingNow = true;
		
		while(shoppingNow) {
			printCategory();  // 카테고리 출력
			System.out.print("[-1] 종료 \n카테고리를 선택하세요 >> ");
			int choiceCate = scan.nextInt();  // 카테고리 선택
			
//			쇼핑 종료
			if(choiceCate == -1) {
				shoppingNow = false;
				continue;
			}
			
//			카테고리 없음 예외처리
			if(choiceCate > category.size()) {
				System.out.println("카테고리 번호를 다시 확인하세요.");
				return;
			}
			
			System.out.print("[" + category.get(choiceCate) + "]");  // 선택한 카테고리 이름
			System.out.println();
			
//			int cnt = 0;
			String targetCategory = category.get(choiceCate); // 번호로 이름찾기
//			선택한 카테고리 목록 출력
			for(int i = 0; i < itemList.size(); i++) {
				if(itemList.get(i).category.equals(targetCategory)) {
//				출력문
					System.out.println("[" + i + "]" + itemList.get(i).name +  " - " + itemList.get(i).price + "원");
//				cnt++;  // 번호 매기기 위해
				}
			}
			
			System.out.print("상품을 선택하세요 >> ");
			int choiceItem = scan.nextInt();  // 아이템 선택
			Item addItem = itemList.get(choiceItem);  // 아이템 추가
			
			Item userAddItem = new Item(addItem.name, addItem.price, addItem.category, loginId);  // 배열
			
			cartList.add(userAddItem);  // 장바구니 추가
			
			System.out.println("[" + addItem.name + "] 이(가) 장바구니에 추가되었습니다.");
		}
	}
	
//	장바구니 목록
	public void AllCart(String loginId) {
		System.out.println("=== " + loginId + "님의 장바구니 ===");
		
		int total = 0;  // 장바구니 총 금액 누적용
		
		for(Item i : cartList) {
			if(i.usersId.equals(loginId)) {
				System.out.println("[" + i.name + "] - " + i.price + "원");
				total += i.price;
			}
		}
	}
	
//	관리자메뉴 - 모든 유저 장바구니 목록
	public void AllUserCart() {
		System.out.println("=== 전체 유저 장바구니 목록 ===");
		
//		모든유저 장바구니 상태 예외처리
//		if(cartList.size() == 0) {
//			System.out.println("장바구니에 담긴 상품이 없습니다.");
//			return;
//		}
		
//		for(Item i : cartList) {
//			System.out.println("--- " + i.usersId + "님 ---\n" + "[" + i.category + "]" + i.name + " - " + i.price + "원");
//		}
//		┖> --- kkk ---
//		[과자]새우깡 - 1000원
//		--- kkk ---
//		[육류]돼지고기 - 8000원
		
//		유저별로 묶으려고
		for(String id : userId.id) {
			System.out.println("--- " + id + "님 ---");
			
			boolean state = false;  // 장바구니 보유상태 확인하려고
			
			for(Item i : cartList) {
				if(i.usersId.equals(id)) {
					System.out.println("[" + i.category + "]" + i.name + " - " + i.price + "원");
					state = true;
				}
			}
			
//			모든유저 장바구니 상태 예외처리
			if(!state) {
				System.out.println("장바구니에 담긴 상품이 없습니다.");
			}
		}
	}
}
