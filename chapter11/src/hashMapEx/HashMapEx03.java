package hashMapEx;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HashMapEx03 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashMap<String, Double> excellentStudent = new HashMap<>();


		System.out.println("미래 장학금 관리 시스템 입니다.");
		// 정보 저장
		for(int i=0; i<5; i++) {
			System.out.print("이름과 학점 >> ");
			String keyvalue = scan.nextLine();
			StringTokenizer st = new StringTokenizer(keyvalue);
			String name = st.nextToken().trim();
			Double grade = Double.parseDouble(st.nextToken().trim());
			excellentStudent.put(name, grade);
		}

		System.out.print("장학생 선발 학생 기준 입력 >>");
		double standard = scan.nextDouble();

		// 기준학점 이상만 출력
		System.out.print("장학생 명단 :"); 
		for(String student : excellentStudent.keySet()) {
			double sg = excellentStudent.get(student);
			if(sg >= standard ) {
                 System.out.print(student+" ");
			}
		}



	}
}
