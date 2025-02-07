package Creational;

public class PrototypePattern {
    static class Prototype implements Cloneable {
        private String name;

        public Prototype(String name) {
            this.name = name;
        }

        public void showName() {
            System.out.println("Prototype Name: " + name);
        }

        public Prototype clone() throws CloneNotSupportedException {
            return (Prototype) super.clone();
        }
    }

    // Step 2: Client Code
    public class PrototypeExample {
        public static void main(String[] args) throws CloneNotSupportedException {
            Prototype original = new Prototype("Original");
            Prototype clone = original.clone();

            original.showName();
            clone.showName();
        }
    }
}
