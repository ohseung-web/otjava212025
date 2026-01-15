package StringTokenizer;

import java.util.StringTokenizer;

public class StringTokenTest {

	public static void main(String[] args) {
		// StringTokenizer 생성방법 3가지
		String str = "java android";
		String str1 = "java!android ";
		String str2 = "java!android-fun";

		StringTokenizer st1 = new StringTokenizer(str);
		// nextToken() : 객체에서 다음토큰을 반환 
		System.out.println(st1.nextToken()); 
		System.out.println(st1.nextToken());
		System.out.println("----------");

		StringTokenizer st3 = new StringTokenizer(str1,"!");
		for(int i=0;i<2;i++) {
			System.out.println(st3.nextToken());
		}
		System.out.println("----------");
		
		// 여러개 구분자를 자를때
		StringTokenizer st4 = new StringTokenizer(str2,"!-");
		for(int i=0;i<3;i++) {
		// st4.nextToken().trim() : 혹시 모를 공백을 제거
			System.out.println(st4.nextToken().trim());
		}
		System.out.println("----------");
		
		// true를 입력하면 구분자로 지정된 ! 또한 토큰으로 넣어준다.
		StringTokenizer st5 = new StringTokenizer(str1,"!",true);
		for(int i=0;i<3;i++) {
			System.out.println(st5.nextToken());
		}
		System.out.println("----------");

	}

}
