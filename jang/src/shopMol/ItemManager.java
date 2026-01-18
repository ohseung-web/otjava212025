package shopMol;

import java.util.ArrayList;

public class ItemManager {
	
	// 카테고리를 String 자료형으로 ArrayList생성
	ArrayList<String> category = new ArrayList<String>();
	//전체 아이템리스트를  Item 자료형으로 ArrayList생성
	ArrayList<Item> itemList = new ArrayList<Item>();
	
	public ItemManager() {
		//기본 카테고리 값들
		category.add("과자");
		category.add("생선");
		category.add("육류");
		category.add("음료수");
		
		//기본 아이템 값들
		itemList.add(new Item("새우깡",1000,"과자"));
		itemList.add(new Item("칸쵸",3600,"과자"));
		itemList.add(new Item("고등어",2000,"생선"));
		itemList.add(new Item("새우",1800,"생선"));
		itemList.add(new Item("소고기",6500,"육류"));
		itemList.add(new Item("돼지고기",5500,"육류"));
		itemList.add(new Item("양파링",2000,"과자"));
		itemList.add(new Item("사이다",1500,"음료수"));
		itemList.add(new Item("콜라",1000,"음료수"));
	};
	// 카테고리 추가 및 item 추가 메서드
	public void info(String itemName, int itemPrice, int itemCate) {
		itemList.add(new Item(itemName,itemPrice,category.get(itemCate)));
	};
	
	// 카테고리 출력 메서드
	public void printCategory() {
		for(int i=0;i<category.size();i++) {
			System.out.println("["+i+"]"+category.get(i));
		}		
	};
	//(입력한 카테고리의)item 목록 출력 메서드 
	public void printItemList(int cateIndex) {
		
		//선택한 카테고리 이름 저장
		String cateName = category.get(cateIndex);
		
		for(int i=0;i<itemList.size();i++) {
			if(itemList.get(i).category.equals(cateName)) {
				System.out.println("["+i+"] ["+itemList.get(i).name+"] ["+itemList.get(i).price+"] ["+itemList.get(i).category+"]");
			}						
		}
	};
	//전체 item 목록 출력 메서드
	public void itemList() {		
		for(int i=0;i<itemList.size();i++) {
			System.out.println("["+i+"] ["+itemList.get(i).name+"] ["+itemList.get(i).price+"] ["+itemList.get(i).category+"]");
		}
	};
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
