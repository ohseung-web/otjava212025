package classpart07;

import java.util.Scanner;

public class Mainclass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

        ClassEx07 e = new ClassEx07();
        e.name = "맥도날드";

        boolean run = true;

        while (run) {

            e.printMenu();
            System.out.print("메뉴 선택 : ");
            int sel = scan.nextInt();

            // 메뉴 선택
            if (sel >= 1 && sel <= 4) {
                e.order(sel - 1);
            }

            // 주문 완료
            else if (sel == 5) {

                if (!e.hasOrder()) {
                    System.out.println("주문 내역이 없습니다.");
                    continue;
                }

                e.calcTotal();
                System.out.println("총 금액 : " + e.total + "원");

                System.out.print("지불 금액 : ");
                int money = scan.nextInt();

                if (money < e.total) {
                    System.out.println("금액이 부족합니다.");
                    continue;
                }

                e.printReceipt(money);
                run = false;
            }
        }

        scan.close();

	}

}
