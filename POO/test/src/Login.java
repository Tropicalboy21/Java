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

    public void Navegar() {
        // Close the login screen
        dispose();

        // Open the main application screen
        RegistrarCasaVista registarCasa = new RegistrarCasaVista();
        registarCasa.setVisible(true);
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
    private JPanel menuPanel;
    private JPanel contentPanel;
    private CardLayout cardLayout;

    public MainApplicationScreen(Login loginFrame) {
        setTitle("Menu Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Create menu panel with buttons
        menuPanel = new JPanel(new GridLayout(5, 1));
        JButton registrarCasaButton = new JButton("Registrar casa");
        JButton listarCasasButton = new JButton("Listar casas");
        JButton registrarVecinoButton = new JButton("Registrar vecino");
        JButton listarVecinosButton = new JButton("Listar vecinos");
        JButton agregarVecinoButton = new JButton("Agregar vecino a casa");

        menuPanel.add(registrarCasaButton);
        menuPanel.add(listarCasasButton);
        menuPanel.add(registrarVecinoButton);
        menuPanel.add(listarVecinosButton);
        menuPanel.add(agregarVecinoButton);

        getContentPane().add(menuPanel, BorderLayout.WEST);

        // Create content panel to display different screens
        contentPanel = new JPanel();
        cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);

        // Add content panels for each menu option
        contentPanel.add(new JPanel(), "Menu");
        contentPanel.add(new JPanel(), "RegistrarCasa");
        // Add content panels for other menu options as needed

        getContentPane().add(contentPanel, BorderLayout.CENTER);

        // Add actions to menu buttons
        registrarCasaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "RegistrarCasa");
            }
        });

        // Add actions for other menu buttons

        // Pack the frame to ensure proper layout and sizing
        pack();

        // Center the frame on the screen
        setLocationRelativeTo(null);
    }
}

class RegistrarCasaVista extends JFrame {


    public RegistrarCasaVista() {
        setTitle("Registrar Casa");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create main application panel
        JPanel registarCasaPanel = new JPanel();

        Label title = new Label("Nueva Casa");

        title.setBounds(170, 50, 220, 50);

        registarCasaPanel.add(title);

        getContentPane().add(title, BorderLayout.CENTER);


        getContentPane().add(registarCasaPanel, BorderLayout.CENTER);

        // Pack the frame to ensure proper layout and sizing
        pack();

        setSize(500, 600);

        setResizable(false);

        // Center the frame on the screen
        setLocationRelativeTo(null);

    }

}