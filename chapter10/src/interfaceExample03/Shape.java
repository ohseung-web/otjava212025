package interfaceExample03;

public interface Shape {
	void draw();        // 도형을 그리는 메소드
    double getArea();   // 면적을 구하는 메소드

    // default 메소드
    default void redraw() {
        System.out.println("--- 다시 그립니다.");
        draw();
    }
}
