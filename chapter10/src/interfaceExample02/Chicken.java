package interfaceExample02;

public class Chicken implements Animal{

	@Override
	public void eat(String bab) {
		System.out.println("닭은 "+bab+"을 먹어요.");
	}

	@Override
	public void work(String move) {
		System.out.println("닭은 "+move+"걸어요.");
	}

	@Override
	public void sleep(String zzz) {
		System.out.println("닭은 "+zzz+"자요.");
	}

}
