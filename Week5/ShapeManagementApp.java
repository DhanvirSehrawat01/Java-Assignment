public class ShapeManagementApp {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle("Red", 5),
            new Rectangle("Blue", 10, 4),
            new Triangle("Green", 6, 8, 10, 6, 8),
            new Circle("Yellow", 25),
            new Rectangle("Black", 7, 3)
        };

        System.out.println("SHAPE MANAGEMENT APP:");
        System.out.println();
        System.out.println("All Shapes:");

        for (Shape shape : shapes) {
            System.out.println(shape);
        }

        System.out.println();
        double totalArea = 0;

        for (Shape shape : shapes) {
            totalArea += shape.area();
        }

        System.out.println("Total Area: " + totalArea);

        double averageArea = totalArea / shapes.length;

        System.out.println("Average Area: " + averageArea);

        Shape largestShape = shapes[0];

        for (Shape shape : shapes) {
            if (shape.area() > largestShape.area()) {
                largestShape = shape;
            }
        }

        System.out.println("Shape with Largest Area:");
        System.out.println(largestShape);
        System.out.println();
        System.out.println("Circle Information:");

        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                Circle circle = (Circle) shape;
                circle.displayRadius();
            }
        }
    }
}
abstract class Shape {

    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
    public abstract double area();

    public abstract double perimeter();

    @Override
    public String toString() {
        return "Shape color: " + color;
    }
}

class Circle extends Shape {

    private double radius;

    public Circle(String color, double radius) {
        super(color);

        if (radius <= 0) {
           System.out.println("Radius must be positive");
        }

        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public void displayRadius() {
        System.out.println(
            "Circle -> Color: " + getColor() +
            ", Radius: " + radius
        );
    }

    @Override
    public String toString() {
        return "Circle -> Color: " + getColor()
                + ", Radius: " + radius
                + ", Area: " + area()
                + ", Perimeter: " + perimeter();
    }
}

class Rectangle extends Shape {

    private double length;
    private double width;

    public Rectangle(String color, double length, double width) {
        super(color);

        if (length <= 0 || width <= 0) {
           System.out.println("Length and width must be positive.");
        }

        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }

    @Override
    public String toString() {
        return "Rectangle -> Color: " + getColor()
                + ", Length: " + length
                + ", Width: " + width
                + ", Area: " + area()
                + ", Perimeter: " + perimeter();
    }
}

class Triangle extends Shape {

    private double base;
    private double height;
    private double side1;
    private double side2;
    private double side3;

    public Triangle(
        String color,
        double base,
        double height,
        double side1,
        double side2,
        double side3
    ) {
        super(color);

        if (base <= 0 || height <= 0 ||
            side1 <= 0 || side2 <= 0 || side3 <= 0) {

           System.out.println("All triangle dimensions must be positive");
        }

        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }

    @Override
    public double perimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return "Triangle -> Color: " + getColor()
                + ", Base: " + base
                + ", Height: " + height
                + ", Area: " + area()
                + ", Perimeter: " + perimeter();
    }
}
