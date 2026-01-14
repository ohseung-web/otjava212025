package interfaceExample03;

public class Circle implements Shape {

	private int radius; // 반지름

    // 생성자
    public Circle(int radius) {
        this.radius = radius;
    }

    // draw() 메소드 구현
    @Override
    public void draw() {
        System.out.println("반지름이 " + radius + "인 원입니다.");
    }

    // getArea() 메소드 구현
    @Override
    public double getArea() {
        return radius * radius * 3.14;
    }

}
