package ucenfotec.ac.cr;

import ucenfotec.ac.cr.tl.Controller;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Controller();
            }
        });
    }
}