package capitalGame;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Game02 {
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	HashMap<String, String> hashCapital = new HashMap<>();

	public Game02() {
		addNation();
	}

	// 나라/수도이름 삽입 메소드
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

	// 나라,수도 삽입 메소드
	public void insertNation() {
		int cnt = hashCapital.size();
		// nextInt()는 숫자만 읽고 엔터를 남긴다. \n
		// 그래서 바로 nextLine()을 쓰면 빈 문자열이 들어가고,
		// 그 결과 StringTokenizer에 토큰이 없어 예외가 발생한다.
		scan.nextLine(); // 🔥 이전 입력 버퍼 정리

		System.out.println("현재 " + cnt + "개 나라의 수도가 입력되었습니다.");
		while (true) {
			System.out.println("나라와 수도 입력" + (cnt + 1) + " >>");
			String nation = scan.nextLine();
			if (nation.equals("그만")) {
				break;
			}
			StringTokenizer st = new StringTokenizer(nation);
			String na = st.nextToken().trim();
			String ca = st.nextToken().trim();

			if (hashCapital.containsKey(na)) {
				System.out.println(na + "이미 존재합니다.");
				continue;
			}

			// hashMap에 저장
			hashCapital.put(na, ca);
		}
	}

	// 게임 시작 메소드
	public void gameStart() {
		while (true) {
			// toArray() : 이 메소드는 컬렉션 형태로 되어있는 것들을 객체배열로 반환해주는, 컬렉션 메소드이다.
			// [스페인, 프랑스, 독일, 미국, 그리스, 영국, 일본, 인도, 중국, 한국, 호주, 멕시코]
			// toArray()의 반환 타입이 Object[] 이기 때문에 Object
			Object[] arr = hashCapital.keySet().toArray(); // 업캐스팅
			System.out.println(Arrays.toString(arr));
	        // 랜덤하게 나라가 출력되도록 하기 위한 코드	
			int index = ran.nextInt(arr.length);

			// 문제와 정답을 결정한다.
			String question = (String) arr[index];
			String answer = hashCapital.get(question);

			// keySet()을 ArrayList로 변환
	       // ArrayList<String> nations = new ArrayList<>(hashCapital.keySet());

	      // int index = ran.nextInt(nations.size());
	       // String question = nations.get(index);
	       // String answer = hashCapital.get(question);
			
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