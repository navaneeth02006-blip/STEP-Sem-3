import java.util.*;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double area();

    abstract String shape();
}

class Circle extends Plot {
    double radius;

    Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }

    String shape() {
        return "CIRCLE";
    }
}

class Rectangle extends Plot {
    double length, width;

    Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double area() {
        return length * width;
    }

    String shape() {
        return "RECTANGLE";
    }
}

class Triangle extends Plot {
    double base, height;

    Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double area() {
        return 0.5 * base * height;
    }

    String shape() {
        return "TRIANGLE";
    }
}

public class GardenPlot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Plot[] plots = new Plot[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String owner = sc.next();

            if (type.equals("CIRCLE")) {
                double radius = sc.nextDouble();
                plots[i] = new Circle(owner, radius);
            }
            else if (type.equals("RECTANGLE")) {
                double length = sc.nextDouble();
                double width = sc.nextDouble();
                plots[i] = new Rectangle(owner, length, width);
            }
            else if (type.equals("TRIANGLE")) {
                double base = sc.nextDouble();
                double height = sc.nextDouble();
                plots[i] = new Triangle(owner, base, height);
            }
        }

        double total = 0;

        for (Plot p : plots) {
            double area = p.area();
            System.out.printf("%s (%s): %.2f%n",
                    p.owner, p.shape(), area);
            total += area;
        }

        System.out.printf("Total Area: %.2f%n", total);

        sc.close();
    }
}