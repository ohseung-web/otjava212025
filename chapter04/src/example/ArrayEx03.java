package example;

import java.util.Scanner;

public class ArrayEx03 {

	public static void main(String[] args) {
//		 문제1) 인덱스를 입력받아 성적 출력
//		 정답1) 인덱스 입력 : 1	성적 : 11점
//		
//		 문제2) 성적을 입력받아 인덱스 출력
//		 정답2) 성적 입력 : 11	인덱스 : 1

		Scanner scan = new Scanner(System.in);
		int[]  arr = {87,11,45,98,23};
		
		System.out.println("인덱스 :");
		int index = scan.nextInt();
		System.out.println(arr[index]+"점");
		
		System.out.print("성적 :");
		int score = scan.nextInt();
		int check=0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == score) {
				 check = i;
			}
		}
		System.out.printf("성적 입력: %d  인덱스 : %d",score, check);
	}

}
