package classpart09;

public class MainClass {

	public static void main(String[] args) {
		
		ClassEx09 ce9 = new ClassEx09();
		int[] arr = new int[5];
		
		System.out.print("학생점수=");
		ce9.test(arr);
		System.out.println();
		
		int tot = ce9.total(arr);
		System.out.print("학생총점="+tot);
		System.out.println();

		double avg = ce9.avgInfo(arr);
		System.out.print("학생전체평균="+avg);
		System.out.println();
		
		int first = ce9.firstPlace(arr);
		System.out.print("1등 점수 = "+first);
		System.out.println();
		
		int last = ce9.lastPlace(arr);
		System.out.print("꼴등 점수 = "+last);
	}

}
