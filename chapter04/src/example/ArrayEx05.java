package example;

import java.util.Scanner;

public class ArrayEx05 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int[] hakbuns = {1001, 1002, 1003, 1004, 1005};
		int[] scores = { 87, 11, 45, 98, 23};
		
//		문제) 학번을 입력받아 성적 출력
//        단, 없는학번 입력 시 예외처리
//		 예)
//		      학번 입력 : 1002		성적 : 11점
//		      학번 입력 : 1000		해당학번은 존재하지 않습니다.

		System.out.print("학번을 입력하세요 :");
		int hakbun = scan.nextInt();
		int hakCheck = -1;
		for(int i=0; i<hakbuns.length; i++) {
			if(hakbuns[i]==hakbun) {
				hakCheck = i;
			}
		}
		
		if(hakCheck == -1) {
			System.out.printf("학번 %d 해당학번은 존재하지 않습니다.",hakbun);
		}else {
			System.out.printf("학번 %d의 성적: %d점",hakbun,scores[hakCheck]);
		}
	
		scan.close();
	}

}
