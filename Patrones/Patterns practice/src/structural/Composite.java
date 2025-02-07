package structural;

import java.util.ArrayList;
import java.util.List;

public class Composite {
    interface Graphic {
        void draw();
    }
    static class Circle implements Graphic {
        public void draw() {
            System.out.println("Drawing a Circle");
        }
    }

    static class Drawing implements Graphic {
        private List<Graphic> graphics = new ArrayList<>();

        public void add(Graphic g) { graphics.add(g); }
        public void draw() {
            for (Graphic g : graphics) {
                g.draw();
            }
        }
    }

    public class CompositeExample {
        public static void main(String[] args) {
            Drawing drawing = new Drawing();
            drawing.add(new Circle());
            drawing.add(new Circle());

            drawing.draw();
        }
    }
}
