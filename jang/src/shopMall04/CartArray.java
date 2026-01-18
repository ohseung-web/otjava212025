package shopMall04;

import java.util.ArrayList;

public class CartArray{
    ArrayList<Cart> cartList = new ArrayList<>();

    public void addCart(int log,String userName, String name, int price) { //장바구니담기
        for (Cart cart : cartList) { //확장포뭉돌려서 로그인값 일치하면서상품명같은거잇으면 수량 증가
            if (cart.log == log && cart.name.equals(name)) {
                cart.quantity++;
                return; // 이건 진짜 이해못했습니다 .
            }
        }
        cartList.add(new Cart(log, userName, name, price, 1)); //아직없으면 하나만들기
    }

    //로그인정보 맞음녀 출력하기
    public void printUserCart(int log) {
        boolean isHere = true;

        for (Cart cart : cartList) {
            if (cart.log == log) {
            	System.out.println("[" +cart.userName + "]님 항목 : [" + cart.name +"], 가격: " + cart.price +", 수량: " + cart.quantity);
                isHere = false;
            }
        }
        
        if (isHere == true) {
            System.out.println("장바구니가 비어있습니다.");
        }
    }
    //매니저보기 // 관리자 보기 모든항목 다 보이게 싹 다
    public void managerCartShow() {
        for (Cart cart : cartList) {
            System.out.println("[" +cart.userName + "]님 항목 : [" + cart.name +"], 가격: " + cart.price +", 수량: " + cart.quantity);
        }
    }
    
    // 모든 장바구니 총합계
    public int allCartTotalPrice() {
    	int totalPrice = 0;
    	for (Cart cart : cartList) {
            totalPrice += cart.price;
        }
    	return totalPrice;
    }
}
