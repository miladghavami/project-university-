/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/19/2023
 */
// SRP says a class should only have one reason to change, which means it should only be responsible for one thing.
// This example is about rectangles and circle. Each class calculates its own area.
// To change the area calculation for a specific shape, we only need to change the class corresponding to that shape.
// As a result, the code is more maintainable and scalable.
public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(8, 10);
        System.out.println("Rectangle area: " + rectangle.area());

        Circle circle = new Circle(6);
        System.out.println("Circle area: " + circle.area());
    }
}