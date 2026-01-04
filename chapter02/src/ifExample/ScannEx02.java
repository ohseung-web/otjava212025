package ifExample;

import java.util.*;

public class ScannEx02 {

	public static void main(String[] args) {
		
		Random rm = new Random();
		
		// 1~10까지의 난수 생성
		int num = rm.nextInt(10);
		System.out.println("난수 :" + num);

	}

}
