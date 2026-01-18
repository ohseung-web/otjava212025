package shopMol02;

import java.util.ArrayList;

public class User {
	//전체 아이템리스트를  Item 자료형으로 ArrayList생성
	ArrayList<Item> itemList = new ArrayList<Item>(); 
	//멤버변수
	String [] id= {"kkk","ccc","ddd","eee","fff"};
	String [] pw= {"111","222","333","444","555"};
	int log = -1; // 로그아웃
	int cartCount = 100;
	int[][] jang = new int[id.length][cartCount]; //유저의 장바구니
	//int[][] cart = new int[100][2]; //관리자의 장바구니 리스트
	 
	//디폴트
	public User () {
		
	};
	
	public User (String [] id,String [] pw, int log, int cartCount) {
		this.id =id;
		this.pw=pw;
		this.log=log;
	}
	

}
