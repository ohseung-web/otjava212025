package inheirtance02;

public class IPTv extends ColorTv {
	
	String ip;
	public IPTv() {};
	public IPTv(String ip, int size, int resolution) {
		this.ip = ip;
		super.size = size;
		super.resolution = resolution;
	}
	
	public void printProperty() {
		System.out.println("나의 IPTV는"+ip+"주소의");
		super.printProperty();
	}
}
