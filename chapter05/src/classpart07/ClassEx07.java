package classpart07;

public class ClassEx07 {
	
//		//	메뉴를 출력할 수 있고
//		
//		주문을 받고
//		
//		계산하고
//		
//		영수증을 출력하는
//		👉 ‘햄버거 가게 객체’ 그 자체
//		
//		즉,
//		
//		ClassEx07 = 햄버거 가게 한 개
//		
//		이 개념이 학생에게 명확하게 전달됨
	
	
	
	String name;

    String[] arMenu = {"치즈버거", "불고기버거", "감자튀김", "콜라"};
    int[] arPrice   = {2500, 3800, 1500, 1000};
    int[] arCount   = new int[4];

    int total;

    //생성자
    public ClassEx07() {}
    
    // 메뉴 출력
    public void printMenu() {
        System.out.println("\n[" + name + "]");
        for (int i = 0; i < arMenu.length; i++) {
            System.out.println((i + 1) + ". " + arMenu[i] + " (" + arPrice[i] + "원)");
        }
        System.out.println("5. 주문 완료");
    }

    // 주문 추가
    public void order(int sel) {
        arCount[sel]++;
        System.out.println(arMenu[sel] + " 추가됨");
    }

    // 총 금액 계산
    public void calcTotal() {
        total = 0;
        for (int i = 0; i < arMenu.length; i++) {
            total += arPrice[i] * arCount[i];
        }
    }

    // 주문 여부 확인
    public boolean hasOrder() {
        for (int i = 0; i < arMenu.length; i++) {
            if (arCount[i] > 0) {
                return true;
            }
        }
        return false;
    }

    // 영수증 출력
    public void printReceipt(int money) {
        System.out.println("\n========== 영수증 ==========");
        System.out.println("매장명 : " + name);
        System.out.println("----------------------------");
        System.out.println("메뉴\t수량\t금액");

        for (int i = 0; i < arMenu.length; i++) {
            if (arCount[i] > 0) {
                System.out.println(
                    arMenu[i] + "\t"
                    + arCount[i] + "\t"
                    + (arPrice[i] * arCount[i])
                );
            }
        }

        System.out.println("----------------------------");
        System.out.println("총 금액 : " + total);
        System.out.println("받은 돈 : " + money);
        System.out.println("잔   돈 : " + (money - total));
        System.out.println("============================");
    }
}
