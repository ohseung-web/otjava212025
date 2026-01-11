package bookShop;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookDTO {
	//멤머변수
	String Booktitle; //: 도서명
	String Author; //: 저자
	String publisher;//: 출판사
	Date Date; //: 출판일
	int Price; // : 가격
	
	public BookDTO() {};
	public BookDTO(String Booktitle, String Author, String publisher, Date Date,int Price) {
		this.Booktitle = Booktitle;
		this.Author = Author;
		this.publisher = publisher;
		this.Date = Date;
		this.Price = Price;
	}
	
	public void showBook() {
		// DecimalFormat 사용하면 문자가 됨을 주의하자
		DecimalFormat pe = new DecimalFormat("#,##0원");
		// 문자열 Date를 simpleDateFormat으로 변경
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-mm-dd(E)");

		System.out.printf("%s\t%s\t%s\t%s\t%s%n",Booktitle,Author,publisher,sim.format(Date),pe.format(Price));
	}
}
