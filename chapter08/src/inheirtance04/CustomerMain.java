package inheirtance04;

import java.text.DecimalFormat;

public class CustomerMain {

	public static void main(String[] args) {
		
      DecimalFormat de = new DecimalFormat("#,###원");
		
		Customer vc = new VIPCustomer(0200, "김길동", 1010);
		int price = vc.calcprice(10000);
		System.out.println("지불 금액은 "+de.format(price)+"이고,"+vc.ShowCustomerInfo());
		
		
		
		Customer cusomerLee = new Customer(0100,"이성계");
		//cusomerLee.setCustomerID(0100);
		//cusomerLee.setCustomerName("이성계");
		//cusomerLee.bounsPoint = 1000;
		int price2 = cusomerLee.calcprice(10000);
		System.out.println("지불 금액은 "+de.format(price2)+"이고,"+cusomerLee.ShowCustomerInfo());
		
	
		
		//cusomerKim.bounsPoint =1000;
		

	}

}
