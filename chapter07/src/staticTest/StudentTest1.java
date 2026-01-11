package staticTest;

public class StudentTest1 {
	public static void main(String[] args) {
		//인스턴스화
		Student studentJ = new Student();
		System.out.println(studentJ.studentId);
		
		Student studentT = new Student();
		System.out.println(studentT.studentId);

		System.out.println(studentJ.serialNum);
		System.out.println(studentT.serialNum);
		
	}
}
