package hashMapEx;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HashMapEx04 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		HashMap<String, Integer> pointmanagement = new HashMap<>();

		System.out.println("**  포인트 관리 프로그램입니다. **");

		while(true) {

			System.out.print("이름과 포인트 입력 >>");
			String keyvalue = scan.nextLine();
			StringTokenizer st = new StringTokenizer(keyvalue);
			String name = st.nextToken().trim();
			if(name.equals("그만")) {
				System.out.println("포인트 관리 종료");
				break;
			}
			Integer point = Integer.parseInt(st.nextToken().trim());
			if(pointmanagement.containsKey(name)) {
				point += pointmanagement.get(name);
			}
			pointmanagement.put(name, point);

			for(String keys : pointmanagement.keySet()) {
				Integer pointScore = pointmanagement.get(keys);
				System.out.print("("+keys+","+pointScore+") ");
			}
			System.out.println();
		}
	
	}
	
}
