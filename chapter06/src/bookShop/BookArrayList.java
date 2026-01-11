package bookShop;

import java.util.ArrayList;

public class BookArrayList {

	//멤버 변수
	ArrayList<BookDTO> bookList;
	
	public BookArrayList() {
		bookList = new ArrayList<BookDTO>();
	}
	
	//책 추가
	public void addBook(BookDTO bdto) {
		bookList.add(bdto);
	}
	
	//총계 메소드
	public int gettotalBook() {
		int total = 0;
		for(BookDTO b:bookList) {
			total += b.Price;
		}
		return total;
	}
	
	//출력 메소드
	public void bookInfo() {
		System.out.println("========================================================");
		System.out.println("도서명\t저자\t출판사\t\t출판일\t\t가격");
		System.out.println("========================================================");
		for(BookDTO b:bookList) {
			b.showBook();
		}
		System.out.println("========================================================");
	}
	
	
	
	
}
