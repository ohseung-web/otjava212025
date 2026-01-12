package inheritance;

public class ChildClass extends ParentClass{

	int a = 5; 
	int b = 6;
	
	public ChildClass() {
		super(); // 부모 클래스의 기본 생성자를 호출 (생략해도 컴파일러가 자동 추가)
		System.out.println("ChildClass Constructor");
	}
	
	public void Chidfun() {
		this.b =12;
		// 부모클래스의 멤버변수 a의 값에 접근하여 수정함
		super.a = 35; 
		
		System.out.println("Childfun START");
		System.out.println("자식의 a값 :"+a+", 부모의 a값:"+super.a);
	}
}
