package inheirtance03;

public class ShapPencil {
	int Residual = 10; //잔여량
	int thickness =1; // 펜굵기
	String name = "ShapPencil";
	
	public ShapPencil() {}
	
	public void Pencilinfo() {
		System.out.println(name+" : 잔여량 : "+Residual+", 펜굵기 :"+thickness);
	}
}
