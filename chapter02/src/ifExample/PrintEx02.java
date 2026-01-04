package ifExample;

import java.io.IOException;

public class PrintEx02 {

	public static void main(String[] args) throws IOException {
		int keycode;
		keycode = System.in.read();
		System.out.println("keycode: "+keycode);
	}
}
