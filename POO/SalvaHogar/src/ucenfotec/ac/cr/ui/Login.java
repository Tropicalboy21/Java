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
        MainApplicationScreen mainAppScreen = new MainApplicationScreen(this);
        mainAppScreen.setVisible(true);
    }
    public void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Login();
            }
        });
    }
}

class LoginPanel extends JPanel {
    public JTextField usernameField;
    public JPasswordField passwordField;

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

    private JPanel mainPanel;
    private JPanel registrarCasaPanel;

    public MainApplicationScreen(Login loginFrame) {

        setTitle("Menu Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create main application panel
        mainPanel = new JPanel();


        Label title = new Label("Bienvenido a SalvaHogar");
        title.setBounds(170, 50, 220, 50);
        mainPanel.add(title);

        JButton button = new JButton("Registrar casa");
        button.setBounds(140, 150, 220, 50);
        mainPanel.add(button);

        JButton button2 = new JButton("Listar casas");
        button2.setBounds(140, 200, 220, 50);
        mainPanel.add(button2);

        JButton button3 = new JButton("Registrar vecino");
        button3.setBounds(140, 250, 220, 50);
        mainPanel.add(button3);

        JButton button4 = new JButton("Listar vecinos");
        button4.setBounds(140, 300, 220, 50);
        mainPanel.add(button4);

        JButton button5 = new JButton("Agregar vecino a casa");
        button5.setBounds(140, 350, 220, 50);
        mainPanel.add(button5);

        JButton button6 = new JButton("Salir");
        button6.setBounds(140, 400, 220, 50);
        mainPanel.add(button6);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                showRegistrarCasaPanel();

            }
        });


        // Add main application panel to the content pane
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        // Add main application panel to the content pane
        getContentPane().add(registrarCasaPanel, BorderLayout.CENTER);

        // Pack the frame to ensure proper layout and sizing
        pack();

        setSize(500, 600);

        setResizable(false);

        // Center the frame on the screen
        setLocationRelativeTo(null);
    }

    public void showMainPanel(){
        registrarCasaPanel.setVisible(false);
        mainPanel.setVisible(true);
    }

    public void showRegistrarCasaPanel() {
        // Create registrar casa panel
        JPanel registrarCasaPanel = new JPanel();
        registrarCasaPanel.setLayout(new BorderLayout());

        Label title = new Label("Nueva Casa");
        registrarCasaPanel.add(title, BorderLayout.CENTER);

        JButton returnButton = new JButton("volver a Menu");

        getContentPane().remove(mainPanel);
        mainPanel = registrarCasaPanel;
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               showMainPanel();
            }
        });
        add(returnButton, BorderLayout.SOUTH);

        // Replace current panel with registrar casa panel

        // Repaint the frame to reflect the changes
        revalidate();
        repaint();
    }


}

