/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/19/2023
 * Represents a Circle shape that implements the Shape interface.
 */
public class Circle implements Shape {
    private double radius;
    /**
     * Constructs a new Circle.
     *
     * @param radius The radius of the Circle.
     */
    public Circle(double radius) {
        this.radius = radius;
    }
    /**
     * returns the area of the Circle.
     *
     * @return The area of the Circle.
     */
    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
}
