package ifExample;

public class PrintfEx {

	public static void main(String[] args) {
	
		System.out.printf("이름: %s","김자바");
	    System.out.printf("나이: %d\n", 25);
	    
	    int value = 123;
	    // %d => 123
	    System.out.printf("상품의 가격:%d원\n", value);
	    // %6d => 6자리 정수, 왼쪽 빈자리 공백 : _ _ _123
	    System.out.printf("상품의 가격:%6d원\n", value);
	    // %-6d => 6자리 정수, 오른쪽 빈자리 공백 : 123_ _ _
	    System.out.printf("상품의 가격:%-6d원\n", value);
	    // %06d => 6자리 정수, 왼쪽 빈자리 0채움 : 000123
	    System.out.printf("상품의 가격:%06d원\n", value);
	  
	    double value2 = 3.14159 *10 * 10;
	    System.out.printf("반지름이 %d인 원의 넓이:%10.2f\n",10,value2);
	    
	    String name="홍길동";
	    int age = 25;
        double score = 92.456;
        // \n => \n으로 줄바꿈을 의미
        // %n => OS에 따라 줄바꿈 문자가 다를 수 있음
                 // Windows: \r\n
                 // Linux/Mac: \n
        // OS에 맞는 줄바꿈 문자로 자동 변환
        // 이식성이 높음 → 운영체제에 상관없이 동일하게 줄바꿈
        System.out.printf("이름: %s, 나이: %d, 점수: %.1f%n", name, age, score);
        
        int price = 125000;
        System.out.printf("가격 %,d\n",price);
        
        double price02 = 87500.10;
        System.out.printf("가격 %,.2f",price02);
	    
	}

}
