package shopMol06;

import java.util.ArrayList;

public class User {
	String [] id= {"kkk","ccc","ddd","eee","fff"};
	String [] pw= {"111","222","333","444","555"};
	int log = -1; // 로그아웃
	
	ArrayList<Item> userCart = new ArrayList<Item>();
	
//	장바구니 배열 관련 멤버변수
	String userId;
	
	
//	기본 생성자
	public User() {}
	
//	매개변수 생성자
//	public User(String userId, ) {
//		
//	}
}
