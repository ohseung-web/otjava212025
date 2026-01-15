package hashMapEx;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HashMapEx02 {
	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
		 HashMap<String, Location> hashLocation = new HashMap<>();
		 int cnt = 4;
		 
		 // 정보를 Location객체에 저장
		 System.out.println("도시, 경도, 위도를 입력하시오.");
		 for(int i=0; i<cnt; i++) {
			 System.out.print(">> ");
			 String loca = scan.next();
			 StringTokenizer st = new StringTokenizer(loca,",");
			 String cityName = st.nextToken().trim();
			 Integer Latitude = Integer.parseInt(st.nextToken().trim());
			 Integer Hardness = Integer.parseInt(st.nextToken().trim());
			 
			 Location lc =new Location(cityName,Latitude,Hardness);
			 hashLocation.put(lc.getCityName(), lc);
		 }
		 
		 // hashLocation 정장된 모든 정보 출력
		System.out.println("-------------------------------------------");
	
		for(String city : hashLocation.keySet()) {
			Location location = hashLocation.get(city);
			System.out.println(location);
		}
		
		/*
		Iterator<String> it = hashLocation.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			Location location = hashLocation.get(key);
			System.out.println(location);
		}
		*/
		System.out.println("------------------------------------------");
		
		// 정보 검색
		while(true) {
			System.out.print("도시 이름 >> ");
			String city = scan.next();
			
			if(city.equals("그만")) {
				System.out.println("정보 검색 종료");
				break;
			}else if(hashLocation.containsKey(city)) {
				System.out.println(hashLocation.get(city));
				continue;
			}else {
				System.out.println(city+"는 없습니다.");
				continue;
			}
//-------------------------------------------------------------------------------------------					
		}
	}
}
