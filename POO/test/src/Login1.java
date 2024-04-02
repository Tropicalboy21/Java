import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login1 extends JFrame {

    private LoginPanel loginPanel;

    public Login1() {
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Login1();
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
                    ((Login1) SwingUtilities.getWindowAncestor(LoginPanel.this)).loggedIn();

                } else {
                    JOptionPane.showMessageDialog(LoginPanel.this, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}

class MainApplicationScreen extends JFrame {

    private JPanel currentPanel;
    private JPanel mainPanel;

    public MainApplicationScreen(Login1 loginFrame) {

        setTitle("Menu Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create main application panel
        mainPanel = new JPanel();
        currentPanel = mainPanel;

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

        // Add action listeners to the buttons
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create and show the registrar casa panel
                showRegistrarCasaPanel();
            }
        });

        // Add main application panel to the content pane
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        // Pack the frame to ensure proper layout and sizing
        pack();

        setSize(500, 600);

        setResizable(false);

        // Center the frame on the screen
        setLocationRelativeTo(null);
    }
    public void showRegistrarCasaPanel() {

        // Create registrar casa panel
        JPanel registrarCasaPanel = new JPanel();
        registrarCasaPanel.setLayout(new BorderLayout());


        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        Label title = new Label("Nueva Casa");
        inputPanel.add(title);

        JTextField casaID = new JTextField(20);

        casaID.setPreferredSize(new Dimension(200, 30));

        inputPanel.add(casaID);
        registrarCasaPanel.add(inputPanel, BorderLayout.CENTER);


        // Create return button
        JButton returnButton = new JButton("Menu");

        returnButton.setPreferredSize(new Dimension(100, 40));
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show main menu panel
                showMainPanel();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        buttonPanel.add(returnButton);
        registrarCasaPanel.add(buttonPanel, BorderLayout.NORTH);

        // Replace current panel with registrar casa panel
        getContentPane().remove(currentPanel);
        currentPanel = registrarCasaPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        // Repaint the frame to reflect the changes
        revalidate();
        repaint();
    }

    public void showMainPanel(){
        getContentPane().remove(currentPanel);
        currentPanel = mainPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
}