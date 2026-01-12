package inheirtance03;

public class BollPen extends ShapPencil{
	String color = "black";  	
	public BollPen() {}

	@Override
	public void Pencilinfo() {
		super.Residual =25;
		super.thickness =2;
		super.name ="BollPen";
		System.out.println(name+" : 잔여량 : "+Residual+", 펜굵기 :"+thickness+",색상 : "+color);
	}
}
