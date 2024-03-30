package ucenfotec.ac.cr.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    private LoginPanel loginPanel;

    public Login() {
        loginPanel = new LoginPanel();
        getContentPane().add(loginPanel);
        setTitle("Salva Hogar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void loggedIn() {
        // Close the login screen
        dispose();

        // Open the main application screen
        MainApplicationScreen mainAppScreen = new MainApplicationScreen();
        mainAppScreen.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Login();
            }
        });
    }
}

class LoginPanel extends JPanel {
    public static JTextField usernameField;
    public static JPasswordField passwordField;

    public LoginPanel() {
        Insets insets = new Insets(6, 15, 6, 15);
        setLayout(new GridBagLayout());
        usernameField = new JTextField();
        add(new JLabel("Correo: "), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, insets, 0, 0));
        add(usernameField, new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0));

        passwordField = new JPasswordField();
        add(new JLabel("Contraseña: "), new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, insets, 0, 0));
        add(passwordField, new GridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0));

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        JButton salirButton = new JButton("Salir");
        JButton iniciarSesionButton = new JButton("Iniciar Sesion");
        buttonPanel.add(salirButton, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, insets, 0, 0));
        buttonPanel.add(iniciarSesionButton, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, insets, 0, 0));

        add(buttonPanel, new GridBagConstraints(0, 2, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, insets, 0, 0));

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action for Salir button
            }
        });

        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform login authentication here
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // For simplicity, let's assume the login is successful
                if (username.equals("admin") && password.equals("password")) {
                    ((Login) SwingUtilities.getWindowAncestor(LoginPanel.this)).loggedIn();

                } else {
                    JOptionPane.showMessageDialog(LoginPanel.this, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}

class MainApplicationScreen extends JFrame {
    public MainApplicationScreen() {
        setTitle("Main Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create main application panel
        JPanel mainPanel = new JPanel();
        mainPanel.add(new JLabel("Welcome, Admin!"));

        // Add main application panel to the content pane
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        // Pack the frame to ensure proper layout and sizing
        pack();

        setSize(500, 600);

        setResizable(false);

        // Center the frame on the screen
        setLocationRelativeTo(null);
    }
}