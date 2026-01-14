package bookself;

public class BookShelf extends Shelf implements Queue {

	@Override
	public void enQueue(String title) {
		shelf.add(title); //ArrayList에서 add는 맨 뒤에서 부터 추가 된다.
	}

	@Override
	public int getSize() {
		return getCount();
	}

	@Override
	public String deQueue() {
		return shelf.remove(0); // 제일 첫번째 자료를 삭제

	}

}
