package example;

import java.util.Random;

public class ifEx06 {

	public static void main(String[] args) {
	
        Random ran = new Random();
        int age = 0;
        int charge = 0;
        
        age = ran.nextInt(99)+1;
        System.out.println(age);
        if(age < 8) {
        	System.out.println("취학전 아동입니다, 입장료는 1000원 입니다.");
        }else if(age < 14) {
        	System.out.println("초등학생입니다, 입장료는 2000원 입니다.");
        }else if(age < 20) {
        	System.out.println("중,고등학생 입니다, 입장료는 2500원 입니다.");
        }else {
        	System.out.println("일반인 입니다, 입장료는 3000원 입니다.");
        }
	}

}
