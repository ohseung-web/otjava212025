package exceptionTest;

public class MainClass04 {
	
	public static void main(String[] args) {
		
		MainClass04 mainClass004 = new MainClass04();

        try {
            mainClass004.firstMethod();
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 위치까지 출력
        }
	}
   
	public void firstMethod() throws Exception{
		   secndMethod();
	   }
	public void secndMethod() throws Exception{
		thirdMethod();
	}
	public void thirdMethod() throws Exception{
		System.out.println("10 / 0 ="+(10/0));
	}
}
