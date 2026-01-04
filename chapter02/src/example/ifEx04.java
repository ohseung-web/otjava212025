package example;

import java.util.Scanner;

public class ifEx04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int height = 0;
		int answer = 0;
		System.out.print("키를 입려하세요 :");
		height = scan.nextInt();
		
		if(height < 120) {
			System.out.print("부모님과 함께 오셨나요 ? (yes:1 no:0) :");
			answer = scan.nextInt();
			if(answer == 1) {
				System.out.println("놀이기구 이용 가능합니다.");
			}else {
				System.out.println("놀이기구 이용 불가능합니다.");
			}
		}else {
			System.out.println("놀이기구 이용 가능합니다.");
		}
	
	}

}
