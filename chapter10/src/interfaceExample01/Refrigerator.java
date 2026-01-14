package interfaceExample01;

public class Refrigerator implements Buyable {

	String name="냉장고";
	String model;
	String denggub;
	int price;
	
	public Refrigerator(String model, String denggub, int price)
	{
		this.model = model;
		this.denggub = denggub;
		this.price = price;
	}
	@Override
	public int getPrice() {
		System.out.print("금액 : ");
		return price;
	}

	@Override
	public String getModel() {
		System.out.print("모델명 : ");
		return model;
	}

	@Override
	public String getMaker() {
		System.out.print("효율성 등급 :");
		return denggub;
	}

	@Override
	public String getName() {
		
		return name;
	}

}
