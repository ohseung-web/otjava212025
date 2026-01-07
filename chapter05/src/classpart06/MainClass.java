package classpart06;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        ClassEx06 atm = new ClassEx06();
        atm.name = "Mega Bank";

        while (true) {
        	System.out.println("-------------------------");
			System.out.println("계좌번호\t비밀번호\t계좌잔액");
			System.out.println("-------------------------");
			for(int i=0; i<atm.count; i++) {
				System.out.println(atm.arAcc[i] + "\t" + atm.arPw[i] + "\t" + atm.arMoney[i]);
			}
			System.out.println("-------------------------");
			//----------  상태확인

            System.out.println("\n[" + atm.name + "]");
            atm.printStatus();

            System.out.println("[1]회원가입");
            System.out.println("[2]로그인");
            System.out.println("[3]로그아웃");
            System.out.println("[4]입금");
            System.out.println("[5]이체");
            System.out.println("[6]잔액조회");
            System.out.println("[0]종료");

            System.out.print("선택 : ");
            int sel = scan.nextInt();

            if (sel == 1) {
                System.out.print("계좌 : ");
                String acc = scan.next();
                System.out.print("비번 : ");
                String pw = scan.next();
                System.out.print("금액 : ");
                int money = scan.nextInt();

                System.out.println(
                    atm.join(acc, pw, money)
                    ? "가입 성공"
                    : "중복 계좌"
                );
            }

//            else if (sel == 2) {
//                if (!atm.isLogin()) System.out.println("로그인 필요");
//                else {
//                    atm.deleteAccount();
//                    System.out.println("탈퇴 완료");
//                }
//            }

            else if (sel == 2) {
                System.out.print("계좌 : ");
                String acc = scan.next();
                System.out.print("비번 : ");
                String pw = scan.next();

                System.out.println(
                    atm.login(acc, pw)
                    ? "로그인 성공"
                    : "로그인 실패"
                );
            }

            else if (sel == 3) {
                atm.logout();
                System.out.println("로그아웃");
            }

            else if (sel == 4) {
                if (!atm.isLogin()) continue;
                System.out.print("입금액 : ");
                atm.deposit(scan.nextInt());
            }

            else if (sel == 5) {
                if (!atm.isLogin()) continue;
                System.out.print("상대 계좌 : ");
                String acc = scan.next();
                System.out.print("금액 : ");
                int money = scan.nextInt();

                System.out.println(
                    atm.transfer(acc, money)
                    ? "이체 성공"
                    : "이체 실패"
                );
            }

            else if (sel == 6) {
                if (!atm.isLogin()) continue;
                System.out.println("잔액 : " + atm.getBalance());
            }

            else if (sel == 0) {
                break;
            }
        }

        scan.close();

	}

}
