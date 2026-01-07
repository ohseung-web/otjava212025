package classpart09;

import java.util.Random;

public class ClassEx09 {
	//이 변수들은 메서드 안에서 계산되는 값인데
//	👉 객체의 멤버 변수로 유지되고 있음
//
//	📌 이러면 문제가 뭐냐면:
//
//	ce9.total(arr);
//	ce9.total(arr);   // 두 번 호출하면 sum 누적됨, 메서드를 한 번 더 호출하면 결과가 틀어짐
	
// 지역변수 VS 전역변수

//	👉 이 예제에서는 멤버 변수(전역변수)를 쓰지 않고, 전부 지역변수를 사용하는 구조가 맞다.
//
//	왜 여기서는 전역변수를 안 쓰는 게 맞을까?
//	이 문제의 성격부터 보면 👇
//
//	✔ 학생 점수 배열을 받아서
//	✔ 총점 / 평균 / 1등 / 꼴등을 계산해서 알려주는 문제
	
	// 🔑 객체가 기억해야 하면 멤버변수
	//  🔑 잠깐 계산만 하면 지역변수
	//멤버변수를 쓰면 안 되는 경우
//	합계
//	평균
//	최대값
//	최소값
//	임시 비교값
//	➡️ 계산용 값은 전부 지역변수
	
	
//	int sum =0;
//	double avg = 0;
//	int maxScore = 0;
	
	public ClassEx09() {}

	public void test(int[] x) {
		Random ran = new Random();
		System.out.print("[");
		for(int i=0; i<x.length; i++) {
			x[i] = ran.nextInt(100)+1;
			System.out.print(x[i]+" ");
		}System.out.print("]");
	}

	public int total(int[] x) {
		int sum = 0;
		for(int i=0; i<x.length; i++) {
			sum += x[i];
		}
		return sum;
	}

	public double avgInfo(int[] x) {
		int sum = total(x);
		return (double)sum / x.length;
	}

	// 1µî
	public int firstPlace(int[] x) {
		int maxScore = 0;
		for(int i=0; i<x.length; i++) {
			if(x[i] > maxScore) {
				maxScore = x[i];
			}
		}
		return maxScore;
	}

	//²Ãµî
	public int lastPlace(int[] x) {
		int minScore = x[0]; 
		for(int i=0; i<x.length; i++) {
			if( minScore > x[i] ) {
				minScore = x[i]; 
			}
		}
		return minScore;
	}
}
