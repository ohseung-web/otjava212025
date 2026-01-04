package ifExample;

public class SwitchEx01 {

	public static void main(String[] args) {
		// switch ~ case문
	    char grade='C';
	    switch(grade) {
	    case 'A':System.out.println("VVIP 혜택을 받으실수 있습니다.");break;
	    case 'B':System.out.println("VIP 혜택을 받으실수 있습니다."); break;
	    case 'C':System.out.println("우수 회원 혜택을 받으실수 있습니다.");break;
	    case 'D':System.out.println("일반 회원 혜택을 받으실수 있습니다.");break;
	    default:System.out.println("혜택이 없습니다.");
	    }

	    
	}

}
