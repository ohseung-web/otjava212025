package interfaceExample02;

public class Cat implements Animal {

	@Override
	public void eat(String bab) {
		System.out.println("고양이는 "+bab+"을 먹어요.");
	}

	@Override
	public void work(String move) {
		System.out.println("고양이는 "+move+"걸어요.");
	}

	@Override
	public void sleep(String zzz) {
		
		System.out.println("고양이는 "+zzz+"자요.");
	}


}
