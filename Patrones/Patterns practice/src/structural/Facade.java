package structural;

public class Facade {
    static class CPU {
        void start() { System.out.println("CPU started"); }
    }
    static class Memory {
        void load() { System.out.println("Memory loaded"); }
    }
    static class HardDrive {
        void read() { System.out.println("Hard Drive reading data"); }
    }

    static class ComputerFacade {
        private CPU cpu;
        private Memory memory;
        private HardDrive hardDrive;

        public ComputerFacade() {
            this.cpu = new CPU();
            this.memory = new Memory();
            this.hardDrive = new HardDrive();
        }

        public void startComputer() {
            cpu.start();
            memory.load();
            hardDrive.read();
            System.out.println("Computer started successfully!");
        }
    }

    public class FacadeExample {
        public static void main(String[] args) {
            ComputerFacade computer = new ComputerFacade();
            computer.startComputer();
        }
    }
}
