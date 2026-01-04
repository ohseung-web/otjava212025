package example;

public class DataType01 {

	public static void main(String[] args) {
		// 자동(묵시적) 형 변환 :
		// 작은 공간의 메모리에서 큰 공간의 메모리로 이동
		byte by = 10;
		int in = by;
		System.out.println("in = "+ in);
		
		// 명시적 형 변환:
		// 큰 공간의 메모리에서 작은 공간의 메모리로 이동
		int ivar = 100;
		byte bvar = (byte)ivar;
		System.out.println("bvar ="+bvar);
		
		ivar = 123456;
		bvar = (byte)ivar;
		System.out.println("bvar ="+bvar);
		
		
		boolean isLoading = false;
		System.out.println(isLoading);
		
		
		
		System.out.println("번호\t이름\t직업");
		System.out.print("행 단위 출력 \n");
		System.out.print("행 단위 출력 \n");
        System.out.println("우리는 \"개발자\" 입니다.");		
        System.out.print("봄\\여름\\가을\\겨울");		
		
		
        System.out.println();
		System.out.println("====================");
		String str = "나는\"자바\"를 좋아합니다.";
		System.out.println(str);
		
		
		String name="홍길동";
		String job="프로그래머";
		System.out.println(name);
//		System.identityHashCode(): 
//		String 객체변수의 주소는 아니지만 주소처럼 비교할수 있는 값
		System.out.println(System.identityHashCode(name)); //10진수로 출력
		int id = System.identityHashCode(name);
		System.out.println(Integer.toHexString(id));  //16진수로 출력
		System.out.println(job);
		System.out.println(System.identityHashCode(job));
		System.out.println();
		
		//char var9 = "A";
		//char var10 ="홍길동";
		
		//long var6 = 1000000000000; //정수 int 타입의 허용범위를 초과해 컴파일 에러 출력
		long var7 = 100000000000L;
		long var8 = 50;
		
		
		byte var1= -128;
		byte var2= -30;
		byte var3= 0;
		byte var4= 30;
		byte var5= 127;
		System.out.println(var1+","+var2+","+var3+","+var4+","+var5);
		//byte var6= 128; // 컴파일 에러, 이유->byte 표현범위 -128~127 
		
		
		System.out.println("==========================");
		char ch='A';
		char ch3 = 'a';
		System.out.println(ch);
		System.out.println(ch3);
		System.out.println((int)ch);
		System.out.println((int)ch3);
		
		ch=66;
		System.out.println(ch);
		
		int ch2=67;
		System.out.println(ch2);
		System.out.println((char)ch2);
	}

}
