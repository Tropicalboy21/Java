package structural;

public class Proxy {
    interface Image {
        void display();
    }

    static class RealImage implements Image {
        private String fileName;

        public RealImage(String fileName) {
            this.fileName = fileName;
            loadFromDisk();
        }

        private void loadFromDisk() {
            System.out.println("Loading image: " + fileName);
        }

        public void display() {
            System.out.println("Displaying image: " + fileName);
        }
    }

    static class ProxyImage implements Image {
        private RealImage realImage;
        private String fileName;

        public ProxyImage(String fileName) {
            this.fileName = fileName;
        }

        public void display() {
            if (realImage == null) {
                realImage = new RealImage(fileName);
            }
            realImage.display();
        }
    }

    // Step 4: Client Code
    public class ProxyExample {
        public static void main(String[] args) {
            Image image1 = new ProxyImage("photo1.jpg");
            Image image2 = new ProxyImage("photo2.jpg");

            image1.display();
            image1.display();
            image2.display();
        }
    }
}
