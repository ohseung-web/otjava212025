package inheirtance02;

public class Tv {
	//private인 경우 상속받는 하위 클래스에서 메소드에 접근 할 수 없음
	//그러므로 protected 접근 제어자 사용한다.
	//상속받은 클래스에서는 직접 접근 가능
	protected int size; //인치
	
	public Tv() {};
	public Tv(int size) {
		this.size = size;
	}
	
	//protected 접근 제어자는
	//상속받은 클래스에서 직접 접근은 가능하지만,
	//객체지향의 캡슐화를 위해서 getter / setter를 함께 사용하는 것이 바람직하다.
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		if(size > 0) {
			this.size = size;
		}
	}
	
	
}
