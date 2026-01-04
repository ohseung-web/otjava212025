package example;

public class ForEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		int sum;
		for(num=1,sum=0;num<10;num++) {
			sum += num;
			System.out.printf("sum: %d, num: %d%n",sum,num);
		}
		System.out.printf("1~10까지 합은 %d",sum);
	}

}
