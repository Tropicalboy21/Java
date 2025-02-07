package structural;

public class AdapterPattern {
    static class OldSystem {
        public void oldRequest() {
            System.out.println("Executing old system request");
        }
    }

    interface NewSystem {
        void newRequest();
    }

    static class Adapter implements NewSystem {
        private OldSystem oldSystem;

        public Adapter(OldSystem oldSystem) {
            this.oldSystem = oldSystem;
        }

        public void newRequest() {
            oldSystem.oldRequest();
        }
    }

    public class AdapterExample {
        public static void main(String[] args) {
            OldSystem oldSystem = new OldSystem();
            NewSystem adapter = new Adapter(oldSystem);
            adapter.newRequest();
        }
    }
}
