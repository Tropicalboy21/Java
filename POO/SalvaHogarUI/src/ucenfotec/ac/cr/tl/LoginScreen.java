package ucenfotec.ac.cr.tl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen  extends JPanel {
    public static JTextField usernameField;
    public static JPasswordField passwordField;

    public LoginScreen() {
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
                System.exit(0);
            }
        });

        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = usernameField.getText();

                String password = new String(passwordField.getPassword());


                if (username.equals("admin@salvahogar.com") && password.equals("password")) {
                    ((Controller) SwingUtilities.getWindowAncestor(LoginScreen.this)).loggedIn();

                } else {
                    JOptionPane.showMessageDialog(LoginScreen.this, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
