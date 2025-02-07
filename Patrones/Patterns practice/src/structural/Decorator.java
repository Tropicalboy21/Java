package structural;

public class Decorator {
    interface Coffee {
        String getDescription();
        double cost();
    }

    static class SimpleCoffee implements Coffee {
        public String getDescription() { return "Simple Coffee"; }
        public double cost() { return 5.0; }
    }

    abstract static class CoffeeDecorator implements Coffee {
        protected Coffee decoratedCoffee;

        public CoffeeDecorator(Coffee coffee) {
            this.decoratedCoffee = coffee;
        }

        public String getDescription() { return decoratedCoffee.getDescription(); }
        public double cost() { return decoratedCoffee.cost(); }
    }

    static class MilkDecorator extends CoffeeDecorator {
        public MilkDecorator(Coffee coffee) { super(coffee); }
        public String getDescription() { return super.getDescription() + ", Milk"; }
        public double cost() { return super.cost() + 1.5; }
    }

    static class SugarDecorator extends CoffeeDecorator {
        public SugarDecorator(Coffee coffee) { super(coffee); }
        public String getDescription() { return super.getDescription() + ", Sugar"; }
        public double cost() { return super.cost() + 0.5; }
    }

    public class DecoratorExample {
        public static void main(String[] args) {
            Coffee coffee = new SimpleCoffee();
            System.out.println(coffee.getDescription() + " $" + coffee.cost());

            Coffee milkCoffee = new MilkDecorator(coffee);
            System.out.println(milkCoffee.getDescription() + " $" + milkCoffee.cost());

            Coffee sugarMilkCoffee = new SugarDecorator(milkCoffee);
            System.out.println(sugarMilkCoffee.getDescription() + " $" + sugarMilkCoffee.cost());
        }
    }
}
