package hashMapEx;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HashMapEx01 {

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		HashMap<String, Integer> nations = new HashMap<String, Integer>();

		System.out.println("나라 이름과 인구를 입력하세요.(예: korea 5000");

		// 정보 입력 HashMap 저장
		while(true) {
			System.out.print("나라 이름, 인구 >> ");
			String keyValue = scan.nextLine();
			StringTokenizer st = new StringTokenizer(keyValue);
			String nation = st.nextToken().trim();
			if(nation.equals("그만")) {
				break;
			}
			Integer people = Integer.parseInt(st.nextToken().trim());

			// hashMap 저장
			nations.put(nation, people);
		}

		// 정보 검색			
		while(true) {
			System.out.print("인구 검색 >> ");
			String nation2 = scan.next();

			if(nation2.equals("그만")) {
				System.out.println("인구 검색 종료");
				break;
			}else if(nations.containsKey(nation2)) {
				System.out.println(nation2 + "의 인구는 "+ nations.get(nation2));
				continue;
			}else {
				System.out.println(nation2 + "나라는 없습니다. ");
				continue;
			}
		}

	}

}
