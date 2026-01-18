package shopMol02;

import java.util.ArrayList;

public class ItemManager {
	// 카테고리를 String 자료형으로 ArrayList생성
	ArrayList<String> category = new ArrayList<String>();
	//전체 아이템리스트를  Item 자료형으로 ArrayList생성
	ArrayList<Item> itemList = new ArrayList<Item>(); 
	//디폴트 생성자
	public ItemManager(Item i) {
		category.add("과자");
		category.add("생선");
		category.add("육류");
		category.add("음료수");
		itemList.add(new Item("새우깡",1000,category.get(0)));
		itemList.add(new Item("고등어",2000,category.get(1)));
		itemList.add(new Item("칸쵸",3600,category.get(0)));
		itemList.add(new Item("소고기",6500,category.get(2)));
		itemList.add(new Item("돼지고기",5500,category.get(2)));
		itemList.add(new Item("콜라",1000,category.get(3)));
		itemList.add(new Item("사이다",1500,category.get(3)));
		itemList.add(new Item("새우",1800,category.get(1)));
		itemList.add(new Item("양파링",2000,category.get(0)));
	};
	// 카테고리 추가 및 item 추가 메서드
	public void info() {
		
	};
	// item 삭제
	
	// item 수정
	
	// 카테고리 출력 메서드
	public void printCategory() {
		int num = 0;
		for(String s : category) {
			System.out.println("["+num+"]"+s);
			num++;
		}
	};
	//item 목록 출력 메서드 
	public void printItemList() {
		int num= 0;
		for(Item i : itemList) {
			System.out.print("["+num+"]");
			i.printInfo();
			num++;
		}
		System.out.println(itemList.get(0).category);
	};
}
