package interfaceExample02;

public class UserMain {

	public static void main(String[] args) {
		Animal cat = new Cat();
		Animal mo = new Monkey();
		Animal ch = new Chicken();

		cat.eat("생선");
		mo.eat("과일");
		ch.eat("사료");
		System.out.println();

		cat.work("네발로");
		mo.work("네발 또는 두발로");
		ch.work("두발로");

		System.out.println();
		cat.sleep("엎드려서");
		mo.sleep("누워서");
		ch.sleep("서서");

	}

}
