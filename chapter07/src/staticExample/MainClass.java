package staticExample;

public class MainClass {

	public static void main(String[] args) {
		StaticEx01 parkbank = new StaticEx01("박찬호");
        parkbank.sMoney(100);
        parkbank.getBankInfo();
        System.out.println("--------------");
        
        StaticEx01 leebank = new StaticEx01("이승엽");
        leebank.sMoney(200);
        leebank.getBankInfo();
        leebank.spendMoney(100);
        
	}

}
