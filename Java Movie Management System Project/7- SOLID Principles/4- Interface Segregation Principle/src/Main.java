/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/19/2023
 */
// The Interface Segregation Principle (ISP): Clients should not be forced to depend on interfaces they do not use.
// In other words, the ISP promotes creating small, focused interfaces instead of large, monolithic ones.
// This helps to ensure that a class implementing an interface only needs to implement the methods
// that are relevant to its behavior.
// 1- We created a separate Drawable interface with the draw() method.
// 2- The Shape interface now only has the Area() method.
// 3- The Rectangle class now implements both the Shape and Drawable interfaces.
// 4- The circle class implements the shape interface.
// Suppose the draw method would be in shape interface and if we want to add a new class
// that calculates the area without needing to draw them.
// The draw() method becomes irrelevant for this new class, and having it in the Shape interface violates
// the Interface Segregation Principle. that's why we created two separate interface.
public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(8, 10);
        System.out.println("Rectangle area: " + rectangle.area());
        rectangle.draw();

        Circle circle = new Circle(6);
        System.out.println("Circle area: " + circle.area());
    }
}