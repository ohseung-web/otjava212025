package shopMol03;

import java.util.ArrayList;

public class ItemManager {
	// 카테고리를 String 자료형으로 ArrayList생성
	ArrayList<String> category = new ArrayList<String>();
	//전체 아이템리스트를  Item 자료형으로 ArrayList생성
	ArrayList<Item> itemList = new ArrayList<Item>();
	// Item tem = new Item();
	
	// 카테고리 추가 및 item 추가 메서드
	public ItemManager() {
		category.add("과자"); // 0
		category.add("생선"); // 1
		category.add("육류"); // 2
		category.add("음료수"); // 3
		
		itemList.add(new Item("새우깡", 1000, "과자"));
		itemList.add(new Item("고등어", 2000, "생선"));
		itemList.add(new Item("칸쵸", 3600, "과자"));
		itemList.add(new Item("소고기", 6500, "육류"));
		itemList.add(new Item("돼지고기", 5500, "육류"));
		itemList.add(new Item("콜라", 1000, "음료수"));
		itemList.add(new Item("사이다", 1500, "음료수"));
		itemList.add(new Item("새우", 1800, "생선"));
	};
	
	// 아이템 추가 메서드
	public void itemAdd(String itemName, int itemPrice, String categoryName) {
		int chk = -1;
		for(int i = 0; i < itemList.size(); i++) {
			if(itemList.get(i).name.equals(itemName)) {
				System.out.println("동일한 물건은 등록할 수 없습니다. 아이템 수정 탭을 이용해주세요.");
				System.out.println();
				chk = 100;
			}
		}
		if(chk != 100) {
			itemList.add(new Item(itemName, itemPrice, categoryName));
			printItemList();
		}
	}
	
	// 아이템 삭제 메서드
	public void itemRemove(int removeItemNum) {
		if(removeItemNum > itemList.size()-1 || removeItemNum < 0) {
			System.out.println("현재 물품번호에 맞게 선택해주세요.");
			System.out.println();
		}else {
			itemList.remove(removeItemNum);
			printItemList();
		}
	}
	
	// 아이템 수정 메서드
	public void itemChange(int changeNum, String changeName, int changeMoney) {
		itemList.get(changeNum).name = changeName;
		itemList.get(changeNum).price = changeMoney;
	}
	
	// 카테고리 출력 메서드
	public void printCategory() {
		for(int i= 0; i < category.size(); i++) {
			 System.out.print("[" + i + "]" + category.get(i) + " ");
		}
	}
	//item 목록 출력 메서드 
	public void printItemList() {
		for(int i= 0; i < itemList.size(); i++) {
			System.out.print("[" + i + "]");
			itemList.get(i).printInfo();
		}
	}
	//item 목록 출력 메서드 목록 보기용 
	public void printItemList2() {
		for(int i= 0; i < itemList.size(); i++) {
			itemList.get(i).printInfo();
		}
	}

}
