/**
 * name: Milad Ghavami
 * assignment: final project
 * date: 04/19/2023
 * The Circle class represents a circle with a specified radius.
 */

public class Circle {
    private double radius;
    /**
     * Constructs a new Circle with the specified radius.
     *
     * @param radius The radius of the circle.
     */
    public Circle(double radius) {
        this.radius = radius;
    }
    /**
     * returns the area of the circle.
     *
     * @return The area of the circle.
     */
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
}
