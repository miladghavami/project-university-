/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/19/2023
 */
// The Open/Closed Principle has two parts :
// 1- Open for extension: Classes can be extended to incorporate new functionality or adapt to changing needs.
// 2- Closed for modification: Once a class is developed and tested, the source code shouldn't be changed.
// Changing an existing class can introduce new bugs and break existing functionality.
// In this example, we created the Shape interface for the rectangle and circle classes,
// as well as another class (Calculator class) to take advantage of the Shape interface as composition.
// By doing this, if we want to add a new shape to calculate the area, we can just create a new class that implements Shape.
public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(8, 10);
        System.out.println("Rectangle area: " + Calculator.area(rectangle));

        Circle circle = new Circle(6);
        System.out.println("Circle area: " + Calculator.area(circle));
    }
}