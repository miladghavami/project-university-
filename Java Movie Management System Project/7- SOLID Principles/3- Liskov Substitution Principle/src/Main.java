/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/19/2023
 */
// The Liskov Substitution Principle (LSP) =
// Objects of a derived class should be able to replace objects of the base class without affecting the correctness of the program.
// We create an abstract shape class with an abstract area() method.
// We create a new class Circle that extends the Shape class, implementing the area() method.
// We create the Rectangle class to extend the Shape class directly, implementing the area() method.
// When we substitute a Rectangle object and a Circle object for a Shape object in the main class,
// the program's correctness is maintained, and This adheres to the Liskov Substitution Principle,
// making our code more robust and maintainable.
public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(8, 10);
        System.out.println("Rectangle area: " + rectangle.area());

        Shape circle = new Circle(6);
        System.out.println("Circle area: " + circle.area());
    }
}