//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class Login extends JFrame {
//
//    private LoginPanel loginPanel;
//
//    public Login() {
//        loginPanel = new LoginPanel();
//        getContentPane().add(loginPanel);
//        setTitle("Salva Hogar");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setResizable(false);
//        pack();
//        setLocationRelativeTo(null);
//        setVisible(true);
//    }
//
//    public void loggedIn() {
//        // Close the login screen
//        dispose();
//
//        // Open the main application screen
//        MainApplicationScreen mainAppScreen = new MainApplicationScreen(this);
//        mainAppScreen.setVisible(true);
//    }
//
////    public void Navegar() {
////        // Close the login screen
////        dispose();
////
////        // Open the main application screen
////        RegistrarCasaVista registarCasa = new RegistrarCasaVista();
////        registarCasa.setVisible(true);
////    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                new Login();
//            }
//        });
//    }
//}
//
//class LoginPanel extends JPanel {
//    public static JTextField usernameField;
//    public static JPasswordField passwordField;
//
//    public LoginPanel() {
//        Insets insets = new Insets(6, 15, 6, 15);
//        setLayout(new GridBagLayout());
//        usernameField = new JTextField();
//        add(new JLabel("Correo: "), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, insets, 0, 0));
//        add(usernameField, new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0));
//
//        passwordField = new JPasswordField();
//        add(new JLabel("Contraseña: "), new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, insets, 0, 0));
//        add(passwordField, new GridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0));
//
//        JPanel buttonPanel = new JPanel(new GridBagLayout());
//        JButton salirButton = new JButton("Salir");
//        JButton iniciarSesionButton = new JButton("Iniciar Sesion");
//        buttonPanel.add(salirButton, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, insets, 0, 0));
//        buttonPanel.add(iniciarSesionButton, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, insets, 0, 0));
//
//        add(buttonPanel, new GridBagConstraints(0, 2, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, insets, 0, 0));
//
//        salirButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Action for Salir button
//            }
//        });
//
//        iniciarSesionButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Perform login authentication here
//                String username = usernameField.getText();
//                String password = new String(passwordField.getPassword());
//
//                // For simplicity, let's assume the login is successful
//                if (username.equals("admin") && password.equals("password")) {
//                    ((Login) SwingUtilities.getWindowAncestor(LoginPanel.this)).loggedIn();
//
//                } else {
//                    JOptionPane.showMessageDialog(LoginPanel.this, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
//                }
//            }
//        });
//    }
//}
//
//class MainApplicationScreen extends JFrame {
//
//    public MainApplicationScreen(Login loginFrame) {
//
//        setTitle("Menu Principal");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Create main application panel
//        JPanel mainPanel = new JPanel();
//
//        Label title = new Label("Bienvenido a SalvaHogar");
//
//        title.setBounds(170, 50, 220, 50);
//
//        mainPanel.add(title);
//
//        getContentPane().add(title, BorderLayout.CENTER);
//
//
//        JButton button = new JButton("Registrar casa");
//
//        // x axis, y axis, width, height
//        button.setBounds(140, 150, 220, 50);
//
//        mainPanel.add(button);
//
//        getContentPane().add(button, BorderLayout.CENTER);
//
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
////                JLayeredPane layeredPane = new JLayeredPane();
////
////                layeredPane.setBounds(0,0, 500, 600);
////
////                getContentPane().add(layeredPane, BorderLayout.CENTER);
////
////                Label title = new Label("Nueva Casa");
////
////                title.setBounds(170, 50, 220, 50);
////
////                layeredPane.add(title);
//
//                JLayeredPane layeredPane = new JLayeredPane();
//                layeredPane.setBounds(0, 0, 500, 600);
//
//                // Create a panel to contain the content
//                JPanel contentPanel = new JPanel();
//                contentPanel.setBounds(0, 0, 500, 600);
//                contentPanel.setBackground(Color.WHITE); // Set background color for visibility
//
//                // Add content to the content panel
//                Label title = new Label("Nueva Casa");
//                title.setBounds(170, 50, 220, 50);
//                contentPanel.add(title);
//
//                // Add the content panel to the layered pane
//                layeredPane.add(contentPanel, JLayeredPane.DEFAULT_LAYER);
//
//                // Add the layered pane to the content pane of the frame
//                getContentPane().add(layeredPane);
//
//                // Repaint the frame to reflect the changes
//                revalidate();
//                repaint();
//
//
//
//            }
//        });
//
//
//
//        JButton button2 = new JButton("Listar casas");
//
//        // x axis, y axis, width, height
//        button2.setBounds(140, 200, 220, 50);
//
//        mainPanel.add(button2);
//
//        getContentPane().add(button2, BorderLayout.CENTER);
//
//
//        JButton button3 = new JButton("Registrar vecino");
//
//        // x axis, y axis, width, height
//        button3.setBounds(140, 250, 220, 50);
//
//        mainPanel.add(button3);
//
//        getContentPane().add(button3, BorderLayout.CENTER);
//
//
//        JButton button4 = new JButton("Listar vecinos");
//
//        // x axis, y axis, width, height
//        button4.setBounds(140, 300, 220, 50);
//
//        mainPanel.add(button4);
//
//        getContentPane().add(button4, BorderLayout.CENTER);
//
//        JButton button5 = new JButton("Agregar vecino a casa");
//
//        // x axis, y axis, width, height
//        button5.setBounds(140, 350, 220, 50);
//
//        mainPanel.add(button5);
//
//        getContentPane().add(button5, BorderLayout.CENTER);
//
//        JButton button6 = new JButton("Salir");
//
//        // x axis, y axis, width, height
//        button6.setBounds(140, 400, 220, 50);
//
//        mainPanel.add(button6);
//
//        getContentPane().add(button6, BorderLayout.CENTER);
//
//        // Add main application panel to the content pane
//        getContentPane().add(mainPanel, BorderLayout.CENTER);
//
//        // Pack the frame to ensure proper layout and sizing
//        pack();
//
//        setSize(500, 600);
//
//        setResizable(false);
//
//        // Center the frame on the screen
//        setLocationRelativeTo(null);
//    }
//
//
//}
