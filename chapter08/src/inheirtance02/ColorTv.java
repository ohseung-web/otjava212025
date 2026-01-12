package inheirtance02;

public class ColorTv extends Tv {
 
	protected int resolution;//해상도
	
	 public ColorTv() {}
	 public ColorTv(int size, int resolution) {
	     // super(size);
		  //size = size;
	      super.setSize(size) ;
	      this.resolution = resolution;
	   }
	   public void printProperty() {
	      System.out.print(size+"인치"+resolution+"컬러");
	   }
}
