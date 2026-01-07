package classpart10;

public class ClassEx10 {
	String name = "";
	int[] arHakbun = {1001, 1002, 1003, 1004, 1005};
	int[] arScore = { 92, 38, 87, 100, 11};
    int maxScore =0;
    int maxindex =0;
    int minindex =0;
    
	public ClassEx10() {}
	
	//전교성적 출력
	public void choice1() {
		for(int i=0; i<arHakbun.length; i++) {
			System.out.println((i+1)+"."+arHakbun[i]+"("+arScore[i]+"점)");
		}System.out.println();
		
	}
	
	// 전교1등 성적 출력
	public void choice2() {
	   for(int i=0; i<arScore.length; i++) {
		   if(maxScore < arScore[i]) {
			   maxScore = arScore[i];
			   maxindex = i;
		   }
	   }
	   System.out.println("1등학생 : "+arHakbun[maxindex]+"학번"+"("+arScore[maxindex]+"점)");
	}
	
	// 전교꼴등 성적 출력
	public void choice3() {
		int minScore = arScore[0];
		for(int i=0; i<arScore.length; i++) {
			if( minScore > arScore[i] ) {
				minScore = arScore[i];
				minindex = i;
			}
		}System.out.println("꼴등학생 : "+arHakbun[minindex]+"학번"+"("+arScore[minindex]+"점)");
	}
	
	// 학번입력 받아 성적 출력
	// 4. 학번으로 성적 조회 (입력값만 받음)
		public void choice4(int hakbun) {
			int chk = -1;

			for(int i = 0; i < arHakbun.length; i++) {
				if(arHakbun[i] == hakbun) {
					chk = i;
					break;
				}
			}

			if(chk == -1) {
				System.out.println("해당 학번은 존재하지 않습니다.");
			} else {
				System.out.println(arHakbun[chk] + "학번 성적 : " + arScore[chk] + "점");
			}
		}
	
	
}
