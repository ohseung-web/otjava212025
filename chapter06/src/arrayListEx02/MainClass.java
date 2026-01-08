package arrayListEx02;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);

        ArrayList<Student> list = new ArrayList<>();
        int cnt = 0;

        // 학생 3명 입력
        while (cnt < 3) {

            Student s = new Student();

            System.out.print("학생 이름 입력: ");
            s.name = scan.next();

            // 과목 2개 입력
            for (int i = 0; i < 2; i++) {
                Subject sub = new Subject();

                System.out.print("과목명 입력: ");
                sub.name = scan.next();

                System.out.print("점수 입력: ");
                sub.score = scan.nextInt();

                s.subjects.add(sub);
            }

            list.add(s);
            cnt++;
        }

        // 출력
        System.out.println("\n===== 학생 성적 출력 =====");
        for (Student s : list) {
            System.out.println("학생 이름: " + s.name);
            for (Subject sub : s.subjects) {
                System.out.println("과목명: " + sub.name + ", 점수: " + sub.score);
            }
            System.out.println();
        }
		
	}

}
