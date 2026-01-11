package numFormatEx;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SimpleDateEx {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

        // 현재 날짜/시간 객체
        Date now = new Date();

        // 날짜 포맷 객체들
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy년 MM월 dd일");
        SimpleDateFormat sdf4 = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat sdf5 = new SimpleDateFormat("hh:mm:ss a");
        SimpleDateFormat sdf6 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf7 = new SimpleDateFormat("E"); 
        SimpleDateFormat sdf8 = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");

        System.out.println("현재 날짜/시간 출력");

        // 기본 날짜 형식
        System.out.println(sdf1.format(now));
        // / 구분자 사용
        System.out.println(sdf2.format(now));
        // 한글 날짜 출력
        System.out.println(sdf3.format(now));
        // 24시간제 시간 출력
        System.out.println(sdf4.format(now));
        // 12시간제 + 오전/오후
        System.out.println(sdf5.format(now));
        // 날짜 + 시간 출력
        System.out.println(sdf6.format(now));
        // 요일 출력
        System.out.println(sdf7.format(now));
        // 전체 형식 출력
        System.out.println(sdf8.format(now));

        scan.close();

	}

}
