package ucenfotec.ac.cr.ui;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class GFG {
    private JTextField usernameField;
    private JPasswordField passwordField;

    // Main driver method
    public static void main(String[] args)
    {
        // Creating instance of JFrame
        JFrame frame = new JFrame();
        frame.setResizable(false);

        Label title = new Label("Bienvenido a SalvaHogar");

        title.setBounds(100, 50, 180, 80);

        frame.add(title);

        // Creating instance of JButton
        JTextField usernameField = new JTextField(20);

        usernameField.setPreferredSize(new Dimension(200, 30)); // Set preferred size
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setPreferredSize(new Dimension(200, 30)); // Set preferred size
        JButton button = new JButton("Iniciar Sesion");

        // x axis, y axis, width, height
        button.setBounds(150, 200, 220, 50);

        // adding button in JFrame
        frame.add(new JLabel("Username:"));
        frame.add(usernameField);
        frame.add(new JLabel("Password:"));
        frame.add(passwordField);
        frame.add(button);

        // 400 width and 500 height
        frame.setSize(500, 600);

        // using no layout managers
        frame.setLayout(null);

        // making the frame visible
        frame.setVisible(true);
    }

    public class LoginScreen extends JFrame {

    }
}

