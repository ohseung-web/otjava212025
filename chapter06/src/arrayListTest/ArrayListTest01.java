package arrayListTest;

import java.awt.print.Book;
import java.util.ArrayList;

public class ArrayListTest01 {

	public static void main(String[] args) {
		// ArrayList 
		// String 타입을 저장하는 ArrayList 생성
        ArrayList<String> list = new ArrayList<>();

        // 데이터 추가
        list.add("사과");
        list.add("바나나");
        list.add("딸기");

        // 전체 출력
        for(int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
        	if(list.isEmpty()) {
        		System.out.println("공백");
        	}else {
        		System.out.println("삽입");
        	}
        }
        
        
        System.out.println("-------------------");
        list.remove(1);
        // 확장 for문으로 전체 출력
        for(String li : list) System.out.println(li);
	}

}
