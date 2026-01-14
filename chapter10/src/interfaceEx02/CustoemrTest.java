package interfaceEx02;

public class CustoemrTest {

	public static void main(String[] args) {
		
		Customer customer = new Customer();
		Buy buy = customer;
		buy.buy();
		
		Sell seller = customer;
		seller.sell();
		System.out.println("-------");
		customer.order();
		buy.order();
		seller.order();
	}

}
