package ucenfotec.ac.cr;

import ucenfotec.ac.cr.tl.Controller;
import ucenfotec.ac.cr.ui.InciarSesion;

import javax.swing.*;

public class Main {
//    public static void main(String[] args) {
//        Controller controller = new Controller();
//        controller.start();
//    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InciarSesion();
            }
        });
    }
}