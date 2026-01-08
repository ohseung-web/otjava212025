package arrayListEx03;

import java.util.Scanner;

public class Player {
	String name;

    public Player(String name) {
        this.name = name;
    }

    // 자신의 차례에 단어 입력
    public String sayWord(Scanner scan) {
        System.out.print(name + " >> ");
        return scan.next();
    }
}
