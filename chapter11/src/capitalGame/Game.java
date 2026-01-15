package capitalGame;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Game {
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	HashMap<String, String> hashCapital = new HashMap<>();

	public Game() {
		addNation();
	}

	// 나라 이름 저장 메서드
	public void addNation() {
		hashCapital.put("한국", "서울");
		hashCapital.put("그리스", "아테네");
		hashCapital.put("호주", "시드니");
		hashCapital.put("미국", "워싱턴DC");
		hashCapital.put("영국", "런던");
		hashCapital.put("일본", "도쿄");
		hashCapital.put("중국", "베이징");
		hashCapital.put("인도", "뉴델리");
		hashCapital.put("멕시코", "멕시코시티");
		hashCapital.put("스페인", "리스본");
		hashCapital.put("프랑스", "파리");
		hashCapital.put("독일", "베를린");
	}

	// game 메뉴 메서드
	public void gameMenu() {

		boolean run = true;
		System.out.println("*** 수도 맞추기 게임을 시작합니다. ***");

		while (run) {
			System.out.print("입력 : 1,  퀴즈 : 2,  종료 : 3 >>");
			int select = scan.nextInt();

			switch (select) {
			case 1:
				insertNation();
				break;
			case 2:
				gameStart();
				break;
			case 3:
				System.out.println("게임을 종료합니다.");
				run = false;
				break;
			}
		}
	}

	// 나라 추가 메서드
	public void insertNation() {

		int cnt = hashCapital.size();
		System.out.println("현재 " + cnt + "개 나라의 수도가 입력되어 있습니다.");

		while (true) {
			System.out.print("나라와 수도 입력" + (cnt + 1) + " >>");
			String nation = scan.next();
			if (nation.equals("그만")) {
				break;
			}
			String capital = scan.next();

			if (hashCapital.containsKey(nation)) {
				System.out.println(nation + "는 이미 있습니다.");
				continue;
			}
			hashCapital.put(nation, capital);
		}
	}

	// 게임 Start 메서드
	public void gameStart() {

		while (true) {
			// toArray() : 이 메소드는 컬렉션 형태로 되어있는 것들을 객체배열로 반환해준다.
			// Set<String> keys = hashCapital.keySet();
			Object[] arr = hashCapital.keySet().toArray(); // 업캐스팅
			// String[] arr =(String[])hashCapital.keySet().toArray(); 다운캐스팅
			int index = ran.nextInt(arr.length);

			// 문제와 정답을 결정한다.
			String question = (String) arr[index];
			String answer = hashCapital.get(question);

			// 문제를 출력한다.
			System.out.print(question + "의 수도는 ?");

			String userAnswer = scan.next();
			if (userAnswer.equals("그만")) {
				break;
			} else if (answer.equals(userAnswer)) {
				System.out.println("정답!!");
			} else {
				System.out.println("아닙니다.!!");
				continue;
			}
		}
	}
}
