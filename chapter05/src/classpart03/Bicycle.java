package classpart03;

public class Bicycle {
		//  속성(=attribute = member variable) 
		String color;
		int price;
		
		//생성자 : 단, 생성자의 이름은 클래스의 이름과 같아야 한다.
		public Bicycle() {
		System.out.println("Bicycle constructor - I");
		}
		
		public Bicycle(String c, int p) {
		System.out.println("Bicycle constructor - II");
		
		color = c;
		price = p;
		}
		
		//  기능
		public void info() {
		System.out.println("-- info --");
		System.out.println("color : " + color);
		System.out.println("price : " + price);
		}

}
