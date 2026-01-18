package shopMall;

import java.util.ArrayList;

public class ItemManager {
	// 카테고리를 String 자료형으로 ArrayList 생성
	ArrayList<String> category = new ArrayList<String>();
	
	//전체 아이템리스트를 Item 자료형으로 ArrayList 생성
	ArrayList<Item> itemList = new ArrayList<Item>();


	public ItemManager() {
		category.add("과자");
		category.add("음료");
		category.add("생선");
		category.add("육류");
		
		itemList.add(new Item("칸쵸", 2200, category.get(0)));
		itemList.add(new Item("칙촉", 5000, category.get(0)));
		itemList.add(new Item("새우깡", 1700, category.get(0)));
		itemList.add(new Item("고구마칩", 1600, category.get(0)));
		itemList.add(new Item("나쵸", 1600, category.get(0)));
		itemList.add(new Item("사이다", 1300, category.get(1)));
		itemList.add(new Item("콜라", 1300, category.get(1)));
		itemList.add(new Item("생수", 1000, category.get(1)));
		itemList.add(new Item("탄산수", 1200, category.get(1)));
		itemList.add(new Item("고등어", 4800, category.get(2)));
		itemList.add(new Item("조기", 4000, category.get(2)));
		itemList.add(new Item("연어", 6000, category.get(2)));
		itemList.add(new Item("참치", 8000, category.get(2)));
		itemList.add(new Item("돼지목살", 6000, category.get(3)));
		itemList.add(new Item("소등심", 8000, category.get(3)));
		itemList.add(new Item("닭가슴살", 2200, category.get(3)));

	}
	
	// 아이템 추가 메서드(관리자)
	public void addItem(String name, int price, String cate) {
		itemList.add(new Item(name, price, cate));
		System.out.println("아이템이 추가되었습니다.");
		printItemAll();
	}
	
	// 아이템 삭제 메서드(관리자)
	public void removeItem(int index) {
		itemList.remove(index);
		System.out.println("아이템이 삭제되었습니다.");
		printItemAll();
	}
	
	// 아이템 수정 메서드(관리자)
	public void editItem(int idx, String name, int price) {
		if(idx < 0 || idx >= itemList.size()) {
	        System.out.println("잘못된 번호입니다.");
	        return;
	    }
	    Item item = itemList.get(idx);
	    item.setName(name);
	    item.setPrice(price);

	    System.out.println("아이템 수정이 완료되었습니다.");
	    printItemAll();
	}
	
	// item 목록 출력 메서드(관리자, 전체)
	public void printItemAll() {
		System.out.println();
		for(int i = 0; i<itemList.size();i++) {
				System.out.printf("[%d]", i+1);
				itemList.get(i).printInfo();
		}
		System.out.println();
	}
	
	// 카테고리 출력 메서드(유저, 쇼핑 시)
	public void printCategory() {
		int i = 0;
		for (String s : category) {
		    System.out.printf("[%d] [%s]%n", i + 1, s);
		    i++;
		}
	}
	
	// item 목록 출력 메서드(유저, 카테고리 선택시)
	public void printItemList(String cate) {
		for(int i = 0; i<itemList.size();i++) {
			if(cate.equals(itemList.get(i).category)) {
				System.out.printf("[%d]", i+1);
				itemList.get(i).printInfo();
			}
		}
	}

}
