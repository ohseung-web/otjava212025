package inheirtance04;

public class VIPCustomer extends Customer {
	 
	 private int agentID;
	 double salePoint;
	 
	 //생성자
	 public VIPCustomer() {}
	 public VIPCustomer(int customerID, String customerName, int agentID ) {
		 super(customerID,customerName);
		// super.customerID = customerID;
		// super.customerName = customerName;
		 customerGrade ="VIP";
		 bonusRatio =0.05;
		 this.salePoint = 0.1;
		 this.agentID = agentID;
	 }
	 
	 //메서드
	 @Override
	 public int calcprice(int price) {
		 bounsPoint += 	price * bonusRatio;
		return price - (int)(price*this.salePoint);
	 }
	 
	@Override
	public String ShowCustomerInfo() {
		return super.ShowCustomerInfo() + "\n, 담당 전문 상담은 " + getAgentID() + "번입니다.";
	}
	
	public int getAgentID() {
		 return agentID;
	 }

}
