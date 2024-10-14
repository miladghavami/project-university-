/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/19/2023
 * The Rectangle class represents a rectangle with specified width and height.
 */
public class Rectangle {
    private double width;
    private double height;
    /**
     * Constructs a new Rectangle with the specified width and height.
     *
     * @param width The width of the rectangle.
     * @param height The height of the rectangle.
     */
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    /**
     * returns the area of the rectangle.
     *
     * @return The area of the rectangle.
     */
    public double area() {
        return width * height;
    }
}
