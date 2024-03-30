package ucenfotec.ac.cr.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test {

    public static JTextField usernameField;
    public static JPasswordField passwordField;

    public static void main(String[] args) {
        JFrame frame = new JFrame();


        Insets insets = new Insets(9, 15, 9, 15);
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.add(new JLabel("Correo: "), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, insets, 0, 0));
        inputPanel.add(new JTextField(), new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0));


        inputPanel.add(new JLabel("Contraseña: "), new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, insets, 0, 0));
        inputPanel.add(new JPasswordField(), new GridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0));

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.add(new JButton("Salir"), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, insets, 0, 0));
        buttonPanel.add(new JButton("Iniciar Sesion"), new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, insets, 0, 0));

        frame.setLayout(new GridBagLayout());
        frame.add(new JLabel("Bienvenido a SalvaHogar"), new GridBagConstraints(0, 0, 2, 1, 0, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        frame.add(inputPanel, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0));
        frame.add(buttonPanel, new GridBagConstraints(0, 2, 1, 1, 0, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));




        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

//
//        buttonPanel.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Perform login authentication here
//                String username = usernameField.getText();
//                String password = new String(passwordField.getPassword());
//
//                // For simplicity, let's assume the login is successful
//                if (username.equals("admin") && password.equals("password")) {
//                    // Notify the login screen that login is successful
////                    ((LoginScreen) SwingUtilities.getWindowAncestor(LoginPanel.this)).loggedIn();
//                } else {
//                    JOptionPane.showMessageDialog(LoginPanel.this, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
//                }
//            }
//
//        });
    }
}
