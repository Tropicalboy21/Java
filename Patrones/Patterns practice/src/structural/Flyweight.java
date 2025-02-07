package structural;
import java.util.HashMap;
import java.util.Map;


public class Flyweight {
    interface Shape {
        void draw();
    }
    static class Circle implements Shape {
        private String color;
        private int x, y, radius;

        public Circle(String color) {
            this.color = color;
        }

        public void setProperties(int x, int y, int radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        public void draw() {
            System.out.println("Drawing " + color + " Circle at (" + x + "," + y + ") with radius " + radius);
        }
    }

    class ShapeFactory {
        private static final Map<String, Shape> circleMap = new HashMap<>();

        public static Shape getCircle(String color) {
            Circle circle = (Circle) circleMap.get(color);

            if (circle == null) {
                circle = new Circle(color);
                circleMap.put(color, circle);
                System.out.println("Creating new " + color + " Circle");
            }
            return circle;
        }
    }

    public class FlyweightExample {
        public static void main(String[] args) {
            Shape circle1 = ShapeFactory.getCircle("Red");
            ((Circle) circle1).setProperties(10, 20, 30);
            circle1.draw();

            Shape circle2 = ShapeFactory.getCircle("Red");
            ((Circle) circle2).setProperties(50, 60, 30);
            circle2.draw();

            System.out.println("Same object? " + (circle1 == circle2));
        }
    }
}
