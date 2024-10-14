/**
 * name:Milad Ghavami
 * assignment: final project
 * date: 04/19/2023
 * Represents a Rectangle shape that implements the Shape interface.
 */
public class Rectangle implements Shape{
    private double width;
    private double height;
    /**
     * Constructs a new Rectangle.
     *
     * @param width  The width of the Rectangle.
     * @param height The height of the Rectangle.
     */
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    /**
     * returns the area of the Rectangle.
     *
     * @return The area of the Rectangle.
     */
    @Override
    public double area() {
        return width * height;
    }
}
