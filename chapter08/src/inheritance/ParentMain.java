package inheritance;

public class ParentMain {

	public static void main(String[] args) {
		ParentClass parent = new ParentClass();
		ChildClass child = new ChildClass();
		child.Parentfun();
		
		//main()에서 자식 객체를 통해서 변경된 부모의 a값을 출력할 수 있고,
		//부모 객체를 새로 생성해서는 그 변경값을 볼 수 없습니다.
		//부모 객체를 따로 설정하였기 때문에 a=10이 맞음
		System.out.println(parent.a);
		
		// child.ChildFun()에서 바뀐 super.a는
      	// child 객체 안에 있는 부모 영역의 a입니다.
		System.out.println(child.a);
		System.out.println(child.b);
		child.Chidfun();
		
	}

}
