public class FactoryMethod {
    interface Product {
        void use();
    }
    static class ConcreteProductA implements Product {
        public void use() {
            System.out.println("Using Product A");
        }
    }

    static class ConcreteProductB implements Product {
        public void use() {
            System.out.println("Using Product B");
        }
    }
    class ProductFactory {
        public static Product createProduct(String type) {
            if (type.equalsIgnoreCase("A")) {
                return new ConcreteProductA();
            } else if (type.equalsIgnoreCase("B")) {
                return new ConcreteProductB();
            }
            return null;
        }
    }

    public class FactoryMethodExample {
        public static void main(String[] args) {
            Product product1 = ProductFactory.createProduct("A");
            product1.use(); // Output: Using Product A

            Product product2 = ProductFactory.createProduct("B");
            product2.use(); // Output: Using Product B
        }
    }
}
