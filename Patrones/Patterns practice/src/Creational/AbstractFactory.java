package Creational;

public class AbstractFactory {
    interface Button {
        void render();
    }

    interface Checkbox {
        void check();
    }

    static class WindowsButton implements Button {
        public void render() {
            System.out.println("Rendering Windows Button");
        }
    }

    class MacOSButton implements Button {
        public void render() {
            System.out.println("Rendering MacOS Button");
        }
    }

    static class WindowsCheckbox implements Checkbox {
        public void check() {
            System.out.println("Checking Windows Checkbox");
        }
    }

    class MacOSCheckbox implements Checkbox {
        public void check() {
            System.out.println("Checking MacOS Checkbox");
        }
    }

    interface GUIFactory {
        Button createButton();
        Checkbox createCheckbox();
    }

    static class WindowsFactory implements GUIFactory {
        public Button createButton() {
            return new WindowsButton();
        }

        public Checkbox createCheckbox() {
            return new WindowsCheckbox();
        }
    }

    class MacOSFactory implements GUIFactory {
        public Button createButton() {
            return new MacOSButton();
        }

        public Checkbox createCheckbox() {
            return new MacOSCheckbox();
        }
    }

    public class AbstractFactoryExample {
        public static void main(String[] args) {
            GUIFactory factory = new WindowsFactory();
            Button button = factory.createButton();
            button.render();

            Checkbox checkbox = factory.createCheckbox();
            checkbox.check();
        }
    }
}
