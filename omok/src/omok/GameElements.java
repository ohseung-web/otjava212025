package omok;

public class GameElements {
	int player1Win = 0; // 플레이어1이 이긴 횟수
	int player1Lose = 0; // 플레이어1이 진 횟수
	int player2Win = 0; // 플레이어2가 이긴 횟수
	int player2Lose = 0; // 플레이어2가 진 횟수
	
	String[][] checkerboard = new String[13][13];
	
	//오목판 크기를 벗어나는 예외처리 메소드
	public boolean isCheckPosition(int row, int column) {
	    return row >= 1 && row <= 13 && column >= 1 && column <= 13;
	}
	
	public void setCheckerboard(){
		for(int i=0;i<checkerboard.length;i++) {
			for(int j=0;j<checkerboard[i].length;j++) {
				checkerboard[i][j] = "-";
			}
		}
	}
	
	public void printCheckerboard() {
		System.out.println();
		for(int i=0;i<checkerboard.length;i++) {
			for(int j=0;j<checkerboard[i].length;j++) {
				System.out.print(checkerboard[i][j]+"  ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void placeStone1(int row, int column) { // 플레이어1이 돌을 놓을 때
		checkerboard[column-1][row-1] = "●";
	}
	
	public void placeStone2(int row, int column) { // 플레이어2가 돌을 놓을 때
		checkerboard[column-1][row-1] = "○";
	}
	
	public boolean fiveRowCheck() { // 흑돌 또는 백돌이 같은 돌을 5개 늘어놓았는지 확인
		int check = -1;
		for(int i=0;i<checkerboard.length;i++) { // ( → )
			for(int j=0;j<checkerboard[i].length-4;j++) {
				if((checkerboard[i][j].equals("●")
				&& checkerboard[i][j+1].equals("●")
				&& checkerboard[i][j+2].equals("●")
				&& checkerboard[i][j+3].equals("●")
				&& checkerboard[i][j+4].equals("●"))
				||(checkerboard[i][j].equals("○")
				&& checkerboard[i][j+1].equals("○")
				&& checkerboard[i][j+2].equals("○")
				&& checkerboard[i][j+3].equals("○")
				&& checkerboard[i][j+4].equals("○"))) {
					check = i;
				}
			}
		}
		
		for(int i=0;i<checkerboard.length-4;i++) { // ( ↓ )
			for(int j=0;j<checkerboard[i].length;j++) {
				if(checkerboard[i][j].equals("●")
				&& checkerboard[i+1][j].equals("●")
				&& checkerboard[i+2][j].equals("●")
				&& checkerboard[i+3][j].equals("●")
				&& checkerboard[i+4][j].equals("●")
				||(checkerboard[i][j].equals("○")
				&& checkerboard[i+1][j].equals("○")
				&& checkerboard[i+2][j].equals("○")
				&& checkerboard[i+3][j].equals("○")
				&& checkerboard[i+4][j].equals("○"))) {
					check = i;
				}
			}
		}
		
		for(int i=0;i<checkerboard.length-4;i++) { // ( ↘ )
			for(int j=0;j<checkerboard[i].length-4;j++) {
				if(checkerboard[i][j].equals("●")
				&& checkerboard[i+1][j+1].equals("●")
				&& checkerboard[i+2][j+2].equals("●")
				&& checkerboard[i+3][j+3].equals("●")
				&& checkerboard[i+4][j+4].equals("●")
				||(checkerboard[i][j].equals("○")
				&& checkerboard[i+1][j+1].equals("○")
				&& checkerboard[i+2][j+2].equals("○")
				&& checkerboard[i+3][j+3].equals("○")
				&& checkerboard[i+4][j+4].equals("○"))) {
					check = i;
				}
			}
		}
		
		for(int i=4;i<checkerboard.length;i++) { // ( ↗ )
			for(int j=0;j<checkerboard[i].length-4;j++) {
				if(checkerboard[i][j].equals("●")
				&& checkerboard[i-1][j+1].equals("●")
				&& checkerboard[i-2][j+2].equals("●")
				&& checkerboard[i-3][j+3].equals("●")
				&& checkerboard[i-4][j+4].equals("●")
				||(checkerboard[i][j].equals("○")
				&& checkerboard[i-1][j+1].equals("○")
				&& checkerboard[i-2][j+2].equals("○")
				&& checkerboard[i-3][j+3].equals("○")
				&& checkerboard[i-4][j+4].equals("○"))) {
					check = i;
				}
			}
		}
		
		if(check == -1)
			return false;
		else
			return true;
	}
}
