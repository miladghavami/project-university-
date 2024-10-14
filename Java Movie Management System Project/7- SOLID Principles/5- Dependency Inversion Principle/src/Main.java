/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/19/2023
 */
// Suppose we use one of the classes (class and rectangle) instead of the shape interface in the Calculator class,
// so it directly depends on the low-level Rectangle and Circle classes.
// In order to add more shapes, we have to modify the Calculator class, which is not ideal.
// In this example, we introduced the Shape interface, which separates the Calculator class from the concrete shapes.
// Rectangle and Circle implement this interface, and Calculator relies on the abstraction instead of the concrete classes.
// By doing this, the code becomes more modular and easy to extend with new shapes.
public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(8, 10);
        System.out.println("Rectangle area: " + Calculator.area(rectangle));

        Circle circle = new Circle(6);
        System.out.println("Circle area: " + Calculator.area(circle));
    }
}