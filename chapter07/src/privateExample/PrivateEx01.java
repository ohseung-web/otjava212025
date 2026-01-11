package privateExample;

public class PrivateEx01 {
	// private 멤버 변수
	private int num;

	public void setNum(int num) {
		this.num = num;
	}
	
	//출력 메소드
	public void NumPrint() {
		System.out.println("값 :"+num);
	}
	
}
