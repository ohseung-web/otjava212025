package interfaceExample01;

public class Television implements Buyable {

	//멤버변수
		String name="텔레비전";
		String model;
		String maker;
		int price;
		
		//생성자
		public Television(String model, String maker, int price)
		{
			this.model = model;
			this.maker = maker;
			this.price = price;
		}

		@Override
		public String getName() {
			return name;
		}

		@Override
		public int getPrice() {
			System.out.print("금액 :");
			return price;
		}

		@Override
		public String getModel() {
			System.out.print("모델명 : ");
			return model;
		}

		@Override
		public String getMaker() {
			System.out.print("메이커 :");
			return maker;
		}

}
