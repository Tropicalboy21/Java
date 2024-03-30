//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//
//
//public class LoginScreen extends JFrame {
//    private LoginPanel loginPanel;
//
//    public LoginScreen() {
//        setTitle("Login Screen");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Initialize login panel
//        loginPanel = new LoginPanel();
//
//        // Add login panel to the content pane
//        getContentPane().add(loginPanel, BorderLayout.CENTER);
//
//        // Pack the frame to ensure proper layout and sizing
//        pack();
//
//        // Center the frame on the screen
//        setLocationRelativeTo(null);
//
//        setVisible(true);
//    }
//
//    public void loggedIn() {
//        // Close the login screen
//        dispose();
//
//        // Open the main application screen
//        MainApplicationScreen mainAppScreen = new MainApplicationScreen();
//        mainAppScreen.setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                new LoginScreen();
//            }
//        });
//    }
//}
//
//
//
//
//class LoginPanel extends JPanel {
//    private JTextField usernameField;
//    private JPasswordField passwordField;
//
//    public LoginPanel() {
//        setLayout(new GridLayout(3, 1));
//
//        usernameField = new JTextField(20);
//        usernameField.setPreferredSize(new Dimension(200, 30)); // Set preferred size
//        passwordField = new JPasswordField(20);
//        passwordField.setPreferredSize(new Dimension(200, 30)); // Set preferred size
//        JButton loginButton = new JButton("Login");
//        loginButton.setPreferredSize(new Dimension(100, 30)); // Set preferred size
//
//        loginButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Perform login authentication here
//                String username = usernameField.getText();
//                String password = new String(passwordField.getPassword());
//
//                // For simplicity, let's assume the login is successful
//                if (username.equals("admin") && password.equals("password")) {
//                    // Notify the login screen that login is successful
//                    ((LoginScreen) SwingUtilities.getWindowAncestor(LoginPanel.this)).loggedIn();
//                } else {
//                    JOptionPane.showMessageDialog(LoginPanel.this, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
//                }
//            }
//        });
//
//        add(new JLabel("Username:"));
//        add(usernameField);
//        add(new JLabel("Password:"));
//        add(passwordField);
//        add(loginButton);
//    }
//}
//
//
//
//class MainApplicationScreen extends JFrame {
//    public MainApplicationScreen() {
//        setTitle("Main Application");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Create main application panel
//        JPanel mainPanel = new JPanel();
//        mainPanel.add(new JLabel("Welcome, Admin!"));
//
//        // Add main application panel to the content pane
//        getContentPane().add(mainPanel, BorderLayout.CENTER);
//
//        // Pack the frame to ensure proper layout and sizing
//        pack();
//
//        // Center the frame on the screen
//        setLocationRelativeTo(null);
//    }
//}