package bookShop;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookMain {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		BookArrayList list = new BookArrayList();
		DecimalFormat de = new DecimalFormat("\u00A4#,##0원");
		//Date dete = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-mm-dd");
		
		//parse는 변환하는 메소드로 반드시 예외처리가 필요함 => 여기서는 그냥 throws사용함
		list.addBook(new BookDTO("Java","홍길동","코리아출판사",simple.parse("2026-01-12"),35000));
		list.addBook(new BookDTO("React","김길동","코리아출판사",simple.parse("2025-02-12"),45000));
		list.addBook(new BookDTO("Spring","최길동","코리아출판사",simple.parse("2020-03-12"),15000));
		list.addBook(new BookDTO("HTML","박길동","코리아출판사",simple.parse("2023-01-12"),75000));
		list.addBook(new BookDTO("MySQL","오길동","코리아출판사",simple.parse("2021-04-12"),25000));
		list.bookInfo();
		System.out.println("합계: "+de.format(list.gettotalBook()));
		
	}

}
