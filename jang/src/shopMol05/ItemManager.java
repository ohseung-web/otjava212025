package shopMol05;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemManager {
	
	// 카테고리를 String 자료형으로 ArrayList생성
	ArrayList<String> category = new ArrayList<String>();
		
	//전체 아이템리스트를  Item 자료형으로 ArrayList생성
	ArrayList<Item> itemList = new ArrayList<Item>();
	
	Scanner scan = new Scanner(System.in);
	
	
	// 기본 디폴트 생성자
	public ItemManager() {
		// 카테고리 추가
		category.add("과자"); // String 은 new 생성할 필요없음
		category.add("육류");
		category.add("생선");
		category.add("음료수");
		
		// 아이템 추가
		itemList.add(new Item("새우깡",1300,category.get(0))); // category 는 String 데이터 타입
		itemList.add(new Item("칸쵸",1500,category.get(0)));
		itemList.add(new Item("고등어",2000,category.get(2)));
		itemList.add(new Item("새우",1800,category.get(2)));
		itemList.add(new Item("소고기",7500,category.get(1)));
		itemList.add(new Item("삼겹살",3000,category.get(1)));
		itemList.add(new Item("콜라",1000,category.get(3)));
		itemList.add(new Item("사이다",900,category.get(3)));
	};
	
	// 카테고리 추가 및 item 추가 메서드
	public void info(String name, int price, String category) {
		int cateIndex = 0;
		for(int i=0; i<this.category.size(); i++) {
			if(category == this.category.get(i)) {
				cateIndex = i; // 입력한 카테고리와 같은 카테고리 인덱스 저장
			}
		}
		itemList.add(new Item(name, price, this.category.get(cateIndex)));
	}
	
	// item 삭제 메서드
	public void delItem(int del) {
		if(del > 0 || del < itemList.size()) {
			
			System.out.println("\n"+"["+itemList.get(del).name+"]"+" 상품이 삭제되었습니다.");
			System.out.println("-----------------------------"+"\n");
			itemList.remove(del);
			printItemList();
			System.out.println();
		}else {
			System.out.println("삭제할 item을 찾을 수 없습니다.");
		}
		
	}
	
	// 카테고리 출력 메서드
	public void printCategory() {
		for(String c : category ) System.out.println(c);
	}
	
	
	//item 목록 출력 메서드 
	public void printItemList() {
		int count = 0;
		for(Item i : itemList) {
			System.out.print("["+ count +"]");
			i.printInfo();
			count ++;
		}
	}
	
	// 추가할 아이템이 이미 목록에 존재하는지 확인하는 메서드
	public boolean checkItem(String addName) {
		for(Item i : itemList) {
			if(i.name.equals(addName)) { // trim()? 공백제거
				return false; // false 가 뜨면 이 메서드는 종료됨
			}
		}
		return true;
	}
	
	// 수정 매서드
	public void change() {
		System.out.println("수정할 item 번호를 입력하세요.");
		int itemNum = scan.nextInt();
		System.out.println("수정할 item 이름을 입력하세요.");
		System.out.println("(아이템 금액만 수정할 땐 아이템 이름은 기존 그대로 입력하세요.)");
		String changeName = scan.next();
		System.out.println("수정할 item 금액을 입력하세요.");
		System.out.println("(아이템 이름만 수정할 땐 아이템 금액은 기존 그대로 입력하세요.)");
		int changePrice = scan.nextInt();
		itemList.get(itemNum).name = changeName;
		itemList.get(itemNum).price = changePrice;
	}


	
	
}
