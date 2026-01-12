package inheirtance03;

public class FounctionPen extends BollPen{
	public FounctionPen() {}

	@Override
	public void Pencilinfo() {
		super.Residual =15;
		super.thickness =2;
		super.color = "blue";
		super.name="FounctionPen";
		System.out.println(name+" : 잔여량 : "+Residual+", 펜굵기 :"+thickness+",색상 : "+color);
	}

}
