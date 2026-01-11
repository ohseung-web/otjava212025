package staticExample;

public class StaticEx01 {
	// static 키워드 : 공유
	String name;
	static int atm = 0; 

	//생성자
	public StaticEx01(String name) {
		this.name = name;
	}

	// 메서드 = 함수
	public void sMoney(int money) {
		atm += money;
		System.out.println("atm : "+atm);
	}

	public void spendMoney(int money) {
		atm -= money ;
		System.out.println("atm :"+ atm);
	}
	public void getBankInfo() {
		System.out.println("name : "+this.name);
		System.out.println("atm :"+atm);
	}

}
