class Rectangle {
    private double width;
    private double height;

    Rectangle() {
        this(1, 1);
        System.out.println("No-argument constructor is called");
    }

    Rectangle(double side) {
        this(side, side);
        System.out.println("One-argument constructor is called");
    }

    Rectangle(double width, double height) {
        if (width > 0 && height > 0) {
            this.width = width;
            this.height = height;
        } else {
            throw new IllegalArgumentException("Dimensions must be positive");
        }

        System.out.println("Two-argument constructor is called");
    }

    double getArea() {
        return width * height;
    }

    double getPerimeter() {
        return 2 * (width + height);
    }

    boolean isSquare() {
        return width == height;
    }

    void scale(double factor) {
        if (factor > 0) {
            width = width * factor;
            height = height * factor;
        }
    }

    public String toString() {
        return "Rectangle [width=" + width +
               ", height=" + height +
               ", area=" + getArea() +
               ", perimeter=" + getPerimeter() +
               ", square=" + isSquare() + "]";
    }
}


public class RectangleModel {
    public static void main(String[] args) {

        System.out.println("No-argument rectangle:");
        Rectangle r1 = new Rectangle();
        System.out.println(r1);
        System.out.println();
        System.out.println("One-argument rectangle:");
        Rectangle r2 = new Rectangle(5);
        System.out.println(r2);
        System.out.println();
        System.out.println("Two-argument rectangle:");
        Rectangle r3 = new Rectangle(4, 6);
        System.out.println(r3);
        System.out.println();
        System.out.println("Scaling r3 by 2:");
        r3.scale(2);
        System.out.println(r3);
    }
}
