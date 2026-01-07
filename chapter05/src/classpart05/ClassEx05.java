package classpart05;

import java.util.Random;

public class ClassEx05 {
	int[] answer = { 1, 3, 4, 2, 5 };
	int[] hgd = new int[5];
	int score = 0;

	public void makeRandom() {
		Random ran = new Random();
		for (int i = 0; i < hgd.length; i++) {
			hgd[i] = ran.nextInt(5) + 1;
		}
	}

	public void printResult() {
		System.out.print("정답 : ");
		for (int n : answer)
			System.out.print(n + " ");

		System.out.print("\n응답 : ");
		for (int n : hgd)
			System.out.print(n + " ");

		System.out.print("\n정오표 : ");
		for (int i = 0; i < answer.length; i++) {
			if (answer[i] == hgd[i]) {
				System.out.print("O ");
				score += 20;
			} else {
				System.out.print("X ");
			}
		}
		System.out.println("\n성적 : " + score);
	}
}
