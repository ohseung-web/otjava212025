package shopMall04;

import java.util.ArrayList;

public class ItemManager {
	
	// 카테고리를 String 자료형으로 ArrayList생성
	ArrayList<String> category = new ArrayList<String>();
	// 전체 아이템리스트를  Item 자료형으로 ArrayList생성
	ArrayList<Item> itemList = new ArrayList<Item>();
	
	public ItemManager() {
		category.add(new String("과자"));
		category.add(new String("생선"));
		category.add(new String("육류"));
		category.add(new String("음료수"));
		itemList.add(new Item(0,"과자",1000,"새우깡"));
		itemList.add(new Item(1,"생선",2000,"고등어"));
		itemList.add(new Item(0,"과자",3600,"칸쵸"));
		itemList.add(new Item(2,"육류",6500,"소고기"));
		itemList.add(new Item(2,"육류",5500,"돼지고기"));
		itemList.add(new Item(3,"음료수",1300,"콜라"));
		itemList.add(new Item(3,"음료수",1200,"사이다"));
		itemList.add(new Item(1,"생선",1800,"새우"));
	}
	
	// 카테고리 추가 및 item 추가 메서드
	public void info() { //이건 관리자용 메서드인가
		
	}
	
	//관리자 상품 추가 메서드
	public void managerAddItem(int NewCateNum,String NewCateName,int NewItemPrice,String NewItemName) {
		itemList.add(new Item(NewCateNum,NewCateName,NewItemPrice,NewItemName));
	}
	
	//관리자 상품 삭제 메서드
	public void managerRemoveItem(int DelItemIdx) {
		itemList.remove(DelItemIdx);
	}
	
	//관리자 상품 수정 메서드  해당 인덱스 삭제하고 추가하기
	public void managerModifyItem(int NewCateNum,String NewCateName,int NewItemPrice,String NewItemName,int DelItemIdx) {
		itemList.remove(DelItemIdx);
		itemList.add(new Item(NewCateNum,NewCateName,NewItemPrice,NewItemName));
	}
	
	
	
	
	
	// 카테고리 출력 메서드
	public void printCategory() {
		System.out.println("==========");
		for(int i = 0;i<category.size(); i++) {
			System.out.println("["+i+"]["+category.get(i)+"]");
		}
		System.out.println("[-1]뒤로가기 ");
		System.out.print("쇼핑목록 선택 >> ");
	}
	
	//이건 모든 아이템 출력 관리자가 보는용
	public void printItemList() {
		for(int i = 0;i<itemList.size(); i++) {
				Item item = new Item(i, itemList.get(i).name,itemList.get(i).price,itemList.get(i).category);
				System.out.print("["+i+"]"); //출력
				item.printInfo();
			}	
		}
	
	//item 목록 출력 메서드 
	public void printItemList(int sel) {
			for(int i = 0;i<itemList.size(); i++) { //sel이랑 카테고리의 index번호랑 같으면 출력인데
				if(sel == itemList.get(i).cateNum ) {
					Item item = new Item(sel,itemList.get(i).name,itemList.get(i).price,itemList.get(i).category);
					System.out.print("["+i+"]"); //출력
					item.printInfo();
				}	
			}
			System.out.println("[-1]뒤로가기 ");
			System.out.print("항목 선택 >> ");
			
		}
	}