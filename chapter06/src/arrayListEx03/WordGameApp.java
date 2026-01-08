package arrayListEx03;

import java.util.ArrayList;
import java.util.Scanner;

public class WordGameApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

        ArrayList<Player> players = new ArrayList<>();

        System.out.print("참가자 수를 입력하세요: ");
        int n = scan.nextInt();

        // 참가자 생성
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "번 참가자 이름: ");
            String name = scan.next();
            players.add(new Player(name));
        }

        System.out.println("\n게임 시작!");
        String currentWord = "아버지";
        System.out.println("현재 단어: " + currentWord);

        int turn = 0;

        while (true) {

            Player currentPlayer = players.get(turn);
            String nextWord = currentPlayer.sayWord(scan);

            // 끝말잇기 검사
            char lastChar = currentWord.charAt(currentWord.length() - 1);
            char firstChar = nextWord.charAt(0);

            if (lastChar != firstChar) {
                System.out.println("\n게임 종료!");
                System.out.println("진 참가자: " + currentPlayer.name);
                break;
            }

            // 단어 교체
            currentWord = nextWord;
            turn++;

            // 순서가 끝나면 다시 처음으로
            if (turn == players.size()) {
                turn = 0;
            }
        }
	}

}
