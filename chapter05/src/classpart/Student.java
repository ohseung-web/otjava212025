package classpart;

public class Student {
   //멤버 변수 = member variable = 속성 =property	
   int studentid; // 학번
   String studentName; //학생 이름
   String address; //사는 곳
   int grade;//학년
   
   //생성자(constructor)
   public Student(){
	   System.out.println("---- 학생 정보 ------");
   }
   
   //메소드(method)
   public void showstudentInfo() {
	   System.out.printf("%s의 주소는 %s이다%n",studentName,address);
   }
   
   public static void main(String[] args) {
	// 클래스를 인스턴스화하여 호출해서 출력하는 곳
	   Student studentlee = new Student(); // 인스턴스화 (= 객체화)
	   studentlee.studentName = "홍길동";
	   studentlee.address ="경기도 부천시 중동";
	   studentlee.showstudentInfo();
	   System.out.println(studentlee);
	   System.out.println();

	   Student studentkim = new Student(); // 인스턴스화 (= 객체화)
	   studentkim.studentName = "개나리";
	   studentkim.address ="경기도 부천시 상동";
	   System.out.println(studentkim);
	   studentkim.showstudentInfo();
   }
}

