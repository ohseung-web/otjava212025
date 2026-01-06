package classpart03;

public class MainClass {

	public static void main(String[] args) {
		
		Bicycle myBicycle1 = new Bicycle();
		myBicycle1.info();

		System.out.println();

		Bicycle myBicycle2 = new Bicycle("red", 100000);
		myBicycle2.info();
	}

}
