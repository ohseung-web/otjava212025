package exceptionTest;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int i=0; 
		int j=0;
		int[] iArr = new int[5];
		List<Integer> list = new ArrayList<Integer>();
		try{
			System.out.println("input i:");
			i = scan.nextInt();
			System.out.println("input j:");
			j=scan.nextInt();
			System.out.println("i/j :"+(i/j));
			
			for(int k=0; k<6; k++) {
				System.out.println("iArr["+k+"]"+iArr[k]);
			}
			System.out.println("list size :"+list.size());
		}catch(InputMismatchException e) {
			   e.printStackTrace();
		}catch(ArrayIndexOutOfBoundsException e) {
			   System.out.println(e);
		}catch(java.lang.Exception e) {
			   System.out.println(e.getMessage());
		}finally {
			System.out.println("end");
		}
	}

}
