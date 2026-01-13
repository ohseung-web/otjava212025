package omok;

import java.util.Scanner;

public class Game {
	Scanner scan = new Scanner(System.in);
	GameElements ge = new GameElements();
	boolean run = true;
	int menu = -1;
	
	public void menu() {
		while(run) {
			System.out.println("[오목]");
			System.out.println("[1]게임 시작");
			System.out.println("[2]전적 확인");
			System.out.println("[0]종료");
			System.out.print("메뉴선택: ");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				playGame();
				run = true;
				break;
			case 2:
				showGameRecord();
				break;
			case 0:
				run = false;
				System.out.println("게임 종료");
				break;
			}
		}
	}
	
	public void playGame() {
		System.out.println("오목 게임 시작 (플레이어1 : 흑돌, 플레이어2 : 백돌)");
		ge.setCheckerboard();
		ge.printCheckerboard();
		
		while(run) {
			System.out.println("플레이어1 차례 - 놓을 위치를 선택");
			while(true) {
				System.out.print("세로(1~13) : ");
				int row = scan.nextInt();
				System.out.print("가로(1~13) : ");
				int column = scan.nextInt();
				
				if(!ge.isCheckPosition(row, column)) {
					System.out.println("오목판을 벗어났습니다. 다시 입력하세요");
					continue;
				}
				
				if(ge.checkerboard[column-1][row-1].equals("●") || ge.checkerboard[column-1][row-1].equals("○")) {
					System.out.println("이미 돌이 놓여진 자리입니다.");
				}
				else {
					ge.placeStone1(row, column);
					ge.printCheckerboard();
					if(ge.fiveRowCheck()) {
						System.out.println("게임 끝 : 플레이어 1 승리");
						ge.player1Win++;
						ge.player2Lose++;
						run = false;
					}
					break;
				}
			}
			
			if(ge.fiveRowCheck()==false) {
				System.out.println("플레이어2 차례 - 놓을 위치를 선택");
				while(true) {
					System.out.print("세로(1~13) : ");
					int row = scan.nextInt();
					System.out.print("가로(1~13) : ");
					int column = scan.nextInt();
					
					if(!ge.isCheckPosition(row, column)) {
						System.out.println("오목판을 벗어났습니다. 다시 입력하세요");
						continue;
					}
					
					if(ge.checkerboard[column-1][row-1].equals("●") || ge.checkerboard[column-1][row-1].equals("○")) {
						System.out.println("이미 돌이 놓여진 자리입니다.");
					}
					else {
						ge.placeStone2(row, column);
						ge.printCheckerboard();
						if(ge.fiveRowCheck()) {
							System.out.println("게임 끝 : 플레이어 2 승리");
							ge.player2Win++;
							ge.player1Lose++;
							run = false;
						}
						break;
					}
				}
			}
		}
	}
	
	public void showGameRecord() {
		System.out.println("플레이어 1 : "+ge.player1Win+"승 "+ge.player1Lose+"패");
		System.out.println("플레이어 2 : "+ge.player2Win+"승 "+ge.player2Lose+"패");
	}
}
