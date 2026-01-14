package scheduer;

public interface Scheduer {
	// 해야할 일을 정의한다. = 다시 말해 명세서가 된다.
	void getNextCall(); //다음 고객의 call을 가져오는 메서드
	void  sendCallToAgent(); //상담원에게 call을 던지는 메서드

}
