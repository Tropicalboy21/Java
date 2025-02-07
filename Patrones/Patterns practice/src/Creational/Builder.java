package Creational;

public class Builder {
    static class Computer {
        private String CPU;
        private int RAM;
        private int storage;

        public void setCPU(String CPU) { this.CPU = CPU; }
        public void setRAM(int RAM) { this.RAM = RAM; }
        public void setStorage(int storage) { this.storage = storage; }

        public void showSpecs() {
            System.out.println("CPU: " + CPU + ", RAM: " + RAM + "GB, Storage: " + storage + "GB");
        }
    }

    interface ComputerBuilder {
        void buildCPU();
        void buildRAM();
        void buildStorage();
        Computer getComputer();
    }

    static class GamingComputerBuilder implements ComputerBuilder {
        private Computer computer = new Computer();

        public void buildCPU() { computer.setCPU("Intel i9"); }
        public void buildRAM() { computer.setRAM(32); }
        public void buildStorage() { computer.setStorage(1000); }

        public Computer getComputer() { return computer; }
    }

    static class Director {
        public void constructGamingComputer(ComputerBuilder builder) {
            builder.buildCPU();
            builder.buildRAM();
            builder.buildStorage();
        }
    }
    public class BuilderExample {
        public static void main(String[] args) {
            ComputerBuilder builder = new GamingComputerBuilder();
            Director director = new Director();
            director.constructGamingComputer(builder);

            Computer computer = builder.getComputer();
            computer.showSpecs();
        }
    }
}
