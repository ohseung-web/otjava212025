package arrayListexample;

import java.util.Scanner;

public class CartMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Cart cart = new Cart();
		

        cart.addProduct(new Product("사과", 1000));
        cart.addProduct(new Product("바나나", 2000));
        cart.addProduct(new Product("망고", 5000));
        cart.addProduct(new Product("포도", 8000));
        cart.addProduct(new Product("수박", 10000));

        System.out.println("[장바구니 목록]");
        cart.showCart();
        System.out.println("총 금액 : " + cart.getTotalPrice());
        System.out.println("-------------------");
        System.out.print("삭제할 상품을 입력하시요:");
        int itemIndex = scan.nextInt();
        cart.removeProduct(itemIndex-1);
        System.out.println("[삭제한 후 장바구니 목록]");
        cart.showCart();
        System.out.println("-------------------");
        System.out.print("추가할 상품을 입력하시요:");
        String itemName = scan.next();
        cart.addProduct(new Product(itemName,3000));
        System.out.println("[추가한 후 장바구니 목록]");
        cart.showCart();
	}

}
