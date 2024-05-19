package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.entities.cocinero.Cocinero;
import cr.ac.ucenfotec.bl.entities.pinche.Pinche;
import cr.ac.ucenfotec.bl.logic.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Controller extends JFrame {

    private LoginScreen loginPanel;

    public Controller() {
        MainApplicationScreen mainAppScreen = new MainApplicationScreen(this);
        mainAppScreen.setVisible(true);

//        loginPanel = new LoginScreen();
//        getContentPane().add(loginPanel);
//        setTitle("Restaurante Bien Feliz");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setResizable(false);
//        pack();
//        setLocationRelativeTo(null);
//        setVisible(true);
    }

    public void loggedIn() {
        // Close the login screen
        dispose();

        // Open the main application screen
        MainApplicationScreen mainAppScreen = new MainApplicationScreen(this);
        mainAppScreen.setVisible(true);
    }

}

class MainApplicationScreen extends JFrame {

    private JPanel currentPanel;
    private JPanel mainPanel;
    static CocineroGestor cocineroGestor;
    static EmpleadoGestor empleadoGestor;
    static PincheGestor pincheGestor;
    static AlmacenGestor almacenGestor;
    static IngredienteGestor ingredienteGestor;
    static PlatilloGestor platilloGestor;
    static EstanteGestor estanteGestor;

    public MainApplicationScreen(Controller loginFrame) {

        cocineroGestor = new CocineroGestor();
        empleadoGestor = new EmpleadoGestor();
        pincheGestor = new PincheGestor();
        almacenGestor = new AlmacenGestor();
        ingredienteGestor = new IngredienteGestor();
        platilloGestor = new PlatilloGestor();
        estanteGestor = new EstanteGestor();

        setTitle("Bien Feliz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel();
        currentPanel = mainPanel;
        mainPanel.setLayout(new BorderLayout());


        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label title = new Label("Bienvenido al Restaurante Bien Feliz");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(title);
        mainPanel.add(titlePanel, BorderLayout.NORTH);


        JPanel menuPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 10, 5, 10);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        JPanel subtitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label subtitle = new Label("Porfavor indique su rol");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitlePanel.add(subtitle);
        menuPanel.add(subtitlePanel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button2 = new JButton("Cocinero");
        button2.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button2, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button3 = new JButton("Pinche");
        button3.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button3, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button4 = new JButton("Empleado");
        button4.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button4, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button5 = new JButton("superAdmin");
        button5.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button5, gbc);


        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button8 = new JButton("Salir");
        button8.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button8, gbc);

        mainPanel.add(menuPanel, BorderLayout.CENTER);

//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Create and show the registrar casa panel
//                showRegistrarCasaPanel();
//            }
//        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                showLoginCocinero();
                menuCocinero();

            }
        });

//
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                showLoginPinche();
                menuPinche();
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                showLoginEmpleado();
                menuEmpleado();
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                showLoginSuperAdmin();
                menuSuperAdmin();
            }
        });
//
//        button6.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                showAsignarEncargadoCasaPanel();
//            }
//        });
//
//        button7.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                showCrearAlarmaPanel();
//            }
//        });


        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        getContentPane().add(mainPanel, BorderLayout.CENTER);

        pack();

        setSize(500, 600);

        setResizable(false);

        setLocationRelativeTo(null);
    }
    public void showLoginCocinero() {

        JPanel registrarCasaPanel = new JPanel();
        registrarCasaPanel.setLayout(new BorderLayout());


        JButton returnButton = new JButton("Menu");
        returnButton.setPreferredSize(new Dimension(100, 40));
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMainPanel();
            }
        });

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label title = new Label("Iniciar sesion Cocinero");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(title);

        registrarCasaPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel correoL = new JLabel("Correo:");
        inputPanel.add(correoL, gbc);

        gbc.gridx = 1;
        JTextField correoIn = new JTextField(10);
        correoIn.setPreferredSize(new Dimension(300, 30));
        inputPanel.add(correoIn, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel casaDiIn = new JLabel("Contraseña:");
        inputPanel.add(casaDiIn, gbc);

        gbc.gridx = 1;
        JTextField contraIn = new JTextField(10);
        contraIn.setPreferredSize(new Dimension(300, 30));
        inputPanel.add(contraIn, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;

        inputPanel.add(returnButton, gbc);

        gbc.gridx = 1;
        JButton registrarCasaBtn = new JButton("Enviar");
        registrarCasaBtn.setPreferredSize(new Dimension(100, 40));
        inputPanel.add(registrarCasaBtn, gbc);
//
        registrarCasaBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                String correoInput = correoIn.getText();
                String contraInput = contraIn.getText();

                Cocinero cocineroEncontrado = cocineroGestor.validarCocinero(correoInput, contraInput);

                if (cocineroEncontrado != null){

                    String mensaje = "Datos Validos, Bienvenido!";

                    JOptionPane.showMessageDialog(MainApplicationScreen.this, mensaje, "Bien Feliz", JOptionPane.INFORMATION_MESSAGE);

                    menuCocinero();
                } else {
                    JOptionPane.showMessageDialog(MainApplicationScreen.this, "Datos invalidos o no encontrados", "Bien Feliz", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        registrarCasaPanel.add(inputPanel, BorderLayout.CENTER);

        getContentPane().remove(currentPanel);
        currentPanel = registrarCasaPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
    public void showLoginPinche() {

        JPanel registrarCasaPanel = new JPanel();
        registrarCasaPanel.setLayout(new BorderLayout());


        JButton returnButton = new JButton("salir");
        returnButton.setPreferredSize(new Dimension(100, 40));
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMainPanel();
            }
        });

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label title = new Label("Iniciar sesion Pinche");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(title);

        registrarCasaPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel correoL = new JLabel("Correo:");
        inputPanel.add(correoL, gbc);

        gbc.gridx = 1;
        JTextField correoIn = new JTextField(10);
        correoIn.setPreferredSize(new Dimension(300, 30));
        inputPanel.add(correoIn, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel casaDiIn = new JLabel("Contraseña:");
        inputPanel.add(casaDiIn, gbc);

        gbc.gridx = 1;
        JTextField contraIn = new JTextField(10);
        contraIn.setPreferredSize(new Dimension(300, 30));
        inputPanel.add(contraIn, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;

        inputPanel.add(returnButton, gbc);

        gbc.gridx = 1;
        JButton registrarCasaBtn = new JButton("Enviar");
        registrarCasaBtn.setPreferredSize(new Dimension(100, 40));
        inputPanel.add(registrarCasaBtn, gbc);
//
        registrarCasaBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                String correoInput = correoIn.getText();
                String contraInput = contraIn.getText();

                Pinche pincheEncontrado = pincheGestor.validarPinche(correoInput, contraInput);

                if (pincheEncontrado != null){

                    String mensaje = "Datos Validos, Bienvenido!";

                    JOptionPane.showMessageDialog(MainApplicationScreen.this, mensaje, "Bien Feliz", JOptionPane.INFORMATION_MESSAGE);

                    menuPinche();
                } else {
                    JOptionPane.showMessageDialog(MainApplicationScreen.this, "Datos invalidos o no encontrados", "Bien Feliz", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        registrarCasaPanel.add(inputPanel, BorderLayout.CENTER);

        getContentPane().remove(currentPanel);
        currentPanel = registrarCasaPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
    public void showLoginEmpleado() {

        JPanel loginEmpleadoPanel = new JPanel();
        loginEmpleadoPanel.setLayout(new BorderLayout());


        JButton returnButton = new JButton("Menu");
        returnButton.setPreferredSize(new Dimension(100, 40));
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMainPanel();
            }
        });

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label title = new Label("Iniciar sesion Empleado");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(title);

        loginEmpleadoPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel correoL = new JLabel("Correo:");
        inputPanel.add(correoL, gbc);

        gbc.gridx = 1;
        JTextField correoIn = new JTextField(10);
        correoIn.setPreferredSize(new Dimension(300, 30));
        inputPanel.add(correoIn, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel casaDiIn = new JLabel("Contraseña:");
        inputPanel.add(casaDiIn, gbc);

        gbc.gridx = 1;
        JTextField contraIn = new JTextField(10);
        contraIn.setPreferredSize(new Dimension(300, 30));
        inputPanel.add(contraIn, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;

        inputPanel.add(returnButton, gbc);

        gbc.gridx = 1;
        JButton registrarCasaBtn = new JButton("Enviar");
        registrarCasaBtn.setPreferredSize(new Dimension(100, 40));
        inputPanel.add(registrarCasaBtn, gbc);
//
        registrarCasaBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                String correoInput = correoIn.getText();
                String contraInput = contraIn.getText();

                Cocinero cocineroEncontrado = cocineroGestor.validarCocinero(correoInput, contraInput);

                if (cocineroEncontrado != null){

                    String mensaje = "Datos Validos, Bienvenido!";

                    JOptionPane.showMessageDialog(MainApplicationScreen.this, mensaje, "Bien Feliz", JOptionPane.INFORMATION_MESSAGE);

                    menuEmpleado();
                } else {
                    JOptionPane.showMessageDialog(MainApplicationScreen.this, "Datos invalidos o no encontrados", "Bien Feliz", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        loginEmpleadoPanel.add(inputPanel, BorderLayout.CENTER);

        getContentPane().remove(currentPanel);
        currentPanel = loginEmpleadoPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
    public void showLoginSuperAdmin() {

        JPanel loginEmpleadoPanel = new JPanel();
        loginEmpleadoPanel.setLayout(new BorderLayout());


        JButton returnButton = new JButton("Menu");
        returnButton.setPreferredSize(new Dimension(100, 40));
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMainPanel();
            }
        });

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label title = new Label("Iniciar sesion superAdmin");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(title);

        loginEmpleadoPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel correoL = new JLabel("Correo:");
        inputPanel.add(correoL, gbc);

        gbc.gridx = 1;
        JTextField correoIn = new JTextField(10);
        correoIn.setPreferredSize(new Dimension(300, 30));
        inputPanel.add(correoIn, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel casaDiIn = new JLabel("Contraseña:");
        inputPanel.add(casaDiIn, gbc);

        gbc.gridx = 1;
        JTextField contraIn = new JTextField(10);
        contraIn.setPreferredSize(new Dimension(300, 30));
        inputPanel.add(contraIn, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;

        inputPanel.add(returnButton, gbc);

        gbc.gridx = 1;
        JButton registrarCasaBtn = new JButton("Enviar");
        registrarCasaBtn.setPreferredSize(new Dimension(100, 40));
        inputPanel.add(registrarCasaBtn, gbc);
//
        registrarCasaBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                String correoInput = correoIn.getText();
                String contraInput = contraIn.getText();


                if (correoInput.equals("superadmin@bienfeliz.com") && contraInput.equals("superBienFeliz")){

                    String mensaje = "Datos Validos, Bienvenido!";

                    JOptionPane.showMessageDialog(MainApplicationScreen.this, mensaje, "Bien Feliz", JOptionPane.INFORMATION_MESSAGE);

                    menuSuperAdmin();
                } else {
                    JOptionPane.showMessageDialog(MainApplicationScreen.this, "Datos invalidos o no encontrados", "Bien Feliz", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        loginEmpleadoPanel.add(inputPanel, BorderLayout.CENTER);

        getContentPane().remove(currentPanel);
        currentPanel = loginEmpleadoPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
    public void menuCocinero(){

        JPanel menuCocineroPanel = new JPanel();
        menuCocineroPanel.setLayout(new BorderLayout());

        JPanel menuPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 10, 5, 10);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        JPanel subtitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label subtitle = new Label("Porfavor seleccione una opción");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitlePanel.add(subtitle);
        menuPanel.add(subtitlePanel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button2 = new JButton("Perfil");
        button2.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button2, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button3 = new JButton("Pinche");
        button3.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button3, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button4 = new JButton("Crear platillo");
        button4.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button4, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button5 = new JButton("agregar un ingrediente a plato");
        button5.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button5, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button6 = new JButton("eliminar un ingrediente a plato");
        button6.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button6, gbc);


        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button7 = new JButton("Cerrar sesion");
        button7.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button7, gbc);


        menuCocineroPanel.add(menuPanel, BorderLayout.CENTER);

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMainPanel();
            }
        });

        getContentPane().remove(currentPanel);
        currentPanel = menuCocineroPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();


    }
    public void menuPinche(){

        JPanel menuPinchePanel = new JPanel();
        menuPinchePanel.setLayout(new BorderLayout());

        JPanel menuPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 10, 5, 10);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        JPanel subtitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label subtitle = new Label("Porfavor seleccione una opción");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitlePanel.add(subtitle);
        menuPanel.add(subtitlePanel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button2 = new JButton("Perfil");
        button2.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button2, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button3 = new JButton("lista de platillos");
        button3.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button3, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button7 = new JButton("Cerrar sesion");
        button7.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button7, gbc);


        menuPinchePanel.add(menuPanel, BorderLayout.CENTER);

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMainPanel();
            }
        });

        getContentPane().remove(currentPanel);
        currentPanel = menuPinchePanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();

    }
    public void menuEmpleado(){

        JPanel menuEmpleadoPanel = new JPanel();
        menuEmpleadoPanel.setLayout(new BorderLayout());

        JPanel menuPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 10, 5, 10);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        JPanel subtitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label subtitle = new Label("Porfavor seleccione una opción");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitlePanel.add(subtitle);
        menuPanel.add(subtitlePanel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button2 = new JButton("Perfil");
        button2.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button2, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button3 = new JButton("lista de platillos");
        button3.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button3, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button7 = new JButton("Cerrar sesion");
        button7.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button7, gbc);


        menuEmpleadoPanel.add(menuPanel, BorderLayout.CENTER);

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMainPanel();
            }
        });

        getContentPane().remove(currentPanel);
        currentPanel = menuEmpleadoPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();

    }

//    public void menuSuperAdmin(){
//
//        JPanel menuSuperAdminPanel = new JPanel();
//        menuSuperAdminPanel.setLayout(new BorderLayout());
//
//        JPanel menuAdminPanel = new JPanel(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//
//        gbc.gridy = 0;
//        gbc.anchor = GridBagConstraints.CENTER;
//        gbc.insets = new Insets(2, 5, 2, 5);
//
//        gbc.gridx = 1;
//        gbc.gridwidth = 1;
//        JPanel subtitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//        Label subtitle = new Label("Porfavor seleccione una opción");
//        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
//        subtitlePanel.add(subtitle);
//        menuAdminPanel.add(subtitlePanel, gbc);
//
//        gbc.gridy++;
//        gbc.gridwidth = 2;
//        JButton button2 = new JButton("Registro cocineros");
//        button2.setPreferredSize(new Dimension(620, 50));
//        menuAdminPanel.add(button2, gbc);
//
//        gbc.gridy++;
//        gbc.gridwidth = 2;
//        JButton button3 = new JButton("ListadoCocineros");
//        button3.setPreferredSize(new Dimension(620, 50));
//        menuAdminPanel.add(button3, gbc);
//
//        gbc.gridy++;
//        gbc.gridwidth = 2;
//        JButton button4 = new JButton("Registro Pinches");
//        button4.setPreferredSize(new Dimension(320, 50));
//        menuAdminPanel.add(button4, gbc);
//
//        gbc.gridy++;
//        gbc.gridwidth = 2;
//        JButton button5 = new JButton("listar Pinches");
//        button5.setPreferredSize(new Dimension(320, 50));
//        menuAdminPanel.add(button5, gbc);
//
//        gbc.gridy++;
//        gbc.gridwidth = 2;
//        JButton button6 = new JButton("Registrar Almacen");
//        button6.setPreferredSize(new Dimension(320, 50));
//        menuAdminPanel.add(button6, gbc);
//
//        gbc.gridy++;
//        gbc.gridwidth = 2;
//        JButton button7 = new JButton("Registrar Estantes");
//        button7.setPreferredSize(new Dimension(320, 50));
//        menuAdminPanel.add(button7, gbc);
//
//        gbc.gridy++;
//        gbc.gridwidth = 2;
//        JButton button8 = new JButton("Listar Estantes");
//        button8.setPreferredSize(new Dimension(320, 50));
//        menuAdminPanel.add(button8, gbc);
//
//        gbc.gridy++;
//        gbc.gridwidth = 2;
//        JButton button9 = new JButton("Registrar Estantes");
//        button9.setPreferredSize(new Dimension(320, 50));
//        menuAdminPanel.add(button9, gbc);
//
//        gbc.gridy++;
//        gbc.gridwidth = 2;
//        JButton button10 = new JButton("Listar Estantes");
//        button10.setPreferredSize(new Dimension(320, 50));
//        menuAdminPanel.add(button10, gbc);
//
//        gbc.gridy++;
//        gbc.gridwidth = 2;
//        JButton button11 = new JButton("Salir");
//        button11.setPreferredSize(new Dimension(320, 50));
//        menuAdminPanel.add(button11, gbc);
//
//        menuSuperAdminPanel.add(menuAdminPanel, BorderLayout.CENTER);
//
//        button2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                showRegistroCocinero();
//            }
//        });
//
//        button3.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                showlistarCocineros();
//            }
//        });
//
//        button11.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                showMainPanel();
//            }
//        });
//
//        getContentPane().remove(currentPanel);
//        currentPanel = menuSuperAdminPanel;
//        getContentPane().add(currentPanel, BorderLayout.CENTER);
//
//        revalidate();
//        repaint();
//
//    }

//    menu superAdmin
    public void menuSuperAdmin() {

        JPanel menuSuperAdminPanel = new JPanel();
        menuSuperAdminPanel.setLayout(new BorderLayout());

        JPanel menuAdminPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(2, 5, 2, 5);

        gbc.gridx = 1;
        gbc.gridwidth = 1;
        JPanel subtitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label subtitle = new Label("Porfavor seleccione una opción");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitlePanel.add(subtitle);
        menuAdminPanel.add(subtitlePanel, gbc);

        int buttonWidth = 220; // Set preferred width for buttons

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button1 = new JButton("Empleados");
        button1.setPreferredSize(new Dimension(buttonWidth, 50));
        menuAdminPanel.add(button1, gbc);

        gbc.gridy++;
        JButton button2 = new JButton("Platillos");
        button2.setPreferredSize(new Dimension(buttonWidth, 50));
        menuAdminPanel.add(button2, gbc);

        gbc.gridy++;
        JButton button3 = new JButton("Almacenes");
        button3.setPreferredSize(new Dimension(buttonWidth, 50));
        menuAdminPanel.add(button3, gbc);

        gbc.gridy++;
        JButton button4 = new JButton("Estantes");
        button4.setPreferredSize(new Dimension(buttonWidth, 50));
        menuAdminPanel.add(button4, gbc);

        gbc.gridy++;
        JButton button5 = new JButton("Ingredientes");
        button5.setPreferredSize(new Dimension(buttonWidth, 50));
        menuAdminPanel.add(button5, gbc);


        gbc.gridy++;
        JButton button6 = new JButton("Cerrar sesion");
        button6.setPreferredSize(new Dimension(buttonWidth, 50));
        menuAdminPanel.add(button6, gbc);

        menuSuperAdminPanel.add(menuAdminPanel, BorderLayout.CENTER);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                superAdminEmpleadosMenu();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                superAdminPlatillosMenu();
            }
        });


        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                superAdminAlmacenesMenu();
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                superAdminEstantesMenu();
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                superAdminIngredientesMenu();
            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMainPanel();
            }
        });

        getContentPane().remove(currentPanel);
        currentPanel = menuSuperAdminPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
    public void superAdminEmpleadosMenu(){

        JPanel empleadosMenuPanel = new JPanel();
        empleadosMenuPanel.setLayout(new BorderLayout());

        JPanel menu = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,10,5,10);

        gbc.gridx = 1;
        gbc.gridwidth = 1;
        JPanel subtitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label subtitle = new Label("Porfavor seleccione una opción");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitlePanel.add(subtitle);
        menu.add(subtitlePanel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button1 = new JButton("Listar empleados");
        button1.setPreferredSize(new Dimension(220, 50));
        menu.add(button1, gbc);

        gbc.gridy++;
        JButton button2 = new JButton("Registrar empleado");
        button2.setPreferredSize(new Dimension(220, 50));
        menu.add(button2, gbc);

        gbc.gridy++;
        JButton button3 = new JButton("Eliminar empleado");
        button3.setPreferredSize(new Dimension(220, 50));
        menu.add(button3, gbc);


        gbc.gridy++;
        JButton button4 = new JButton("Modificar Empleado");
        button4.setPreferredSize(new Dimension(220, 50));
        menu.add(button4, gbc);

        gbc.gridy++;
        JButton button5 = new JButton("Volver");
        button5.setPreferredSize(new Dimension(220, 50));
        menu.add(button5, gbc);



        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showListarEmpleadosMenu();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRegistrarEmpleadosMenu();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showModificarEmpleadoMenu();
            }
        });


        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showModificarEmpleadoMenu();
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuSuperAdmin();
            }
        });

        empleadosMenuPanel.add(menu, BorderLayout.CENTER);

        getContentPane().remove(currentPanel);
        currentPanel = empleadosMenuPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();

    }
    public void showListarEmpleadosMenu(){
        JPanel listarEmpleadosPanel = new JPanel();
        listarEmpleadosPanel.setLayout(new BorderLayout());

        JPanel menu = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,10,5,10);

        gbc.gridx = 1;
        gbc.gridwidth = 1;
        JPanel subtitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label subtitle = new Label("Porfavor seleccione una opción");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitlePanel.add(subtitle);
        menu.add(subtitlePanel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button1 = new JButton("Listado Cocineros");
        button1.setPreferredSize(new Dimension(220, 50));
        menu.add(button1, gbc);

        gbc.gridy++;
        JButton button2 = new JButton("listar Pinches");
        button2.setPreferredSize(new Dimension(220, 50));
        menu.add(button2, gbc);

        gbc.gridy++;
        JButton button3 = new JButton("listar Empleados");
        button3.setPreferredSize(new Dimension(220, 50));
        menu.add(button3, gbc);

        gbc.gridy++;
        JButton button4 = new JButton("Volver");
        button4.setPreferredSize(new Dimension(220, 50));
        menu.add(button4, gbc);


        listarEmpleadosPanel.add(menu, BorderLayout.CENTER);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showlistarCocineros();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showlistarPinches();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showlistarEmpleado();
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                superAdminEmpleadosMenu();
            }
        });



        getContentPane().remove(currentPanel);
        currentPanel = listarEmpleadosPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();

    }
    public void showRegistrarEmpleadosMenu(){
        JPanel registrarEmpleadosPanel = new JPanel();
        registrarEmpleadosPanel.setLayout(new BorderLayout());

        JPanel menu = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,10,5,10);

        gbc.gridx = 1;
        gbc.gridwidth = 1;
        JPanel subtitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label subtitle = new Label("Porfavor seleccione una opción");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitlePanel.add(subtitle);
        menu.add(subtitlePanel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button1 = new JButton("Registrar Cocinero");
        button1.setPreferredSize(new Dimension(220, 50));
        menu.add(button1, gbc);

        gbc.gridy++;
        JButton button2 = new JButton("Registrar Pinches");
        button2.setPreferredSize(new Dimension(220, 50));
        menu.add(button2, gbc);

        gbc.gridy++;
        JButton button3 = new JButton("Registrar Empleado");
        button3.setPreferredSize(new Dimension(220, 50));
        menu.add(button3, gbc);

        gbc.gridy++;
        JButton button4 = new JButton("Volver");
        button4.setPreferredSize(new Dimension(220, 50));
        menu.add(button4, gbc);


        registrarEmpleadosPanel.add(menu, BorderLayout.CENTER);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRegistroCocinero();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRegistroPinche();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRegistroEmpleado();
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                superAdminEmpleadosMenu();
            }
        });



        getContentPane().remove(currentPanel);
        currentPanel = registrarEmpleadosPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();

    }
    public void showModificarEmpleadoMenu(){
        JPanel ModificarEmpleadoPanel = new JPanel();
        ModificarEmpleadoPanel.setLayout(new BorderLayout());

        JPanel menu = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,10,5,10);

        gbc.gridx = 1;
        gbc.gridwidth = 1;
        JPanel subtitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label subtitle = new Label("Porfavor seleccione una opción");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitlePanel.add(subtitle);
        menu.add(subtitlePanel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button1 = new JButton("Asignar Pinche a Cocinero");
        button1.setPreferredSize(new Dimension(220, 50));
        menu.add(button1, gbc);

        gbc.gridy++;
        JButton button2 = new JButton("Eliminar Empleado");
        button2.setPreferredSize(new Dimension(220, 50));
        menu.add(button2, gbc);

        gbc.gridy++;
        JButton button3 = new JButton("Volver");
        button3.setPreferredSize(new Dimension(220, 50));
        menu.add(button3, gbc);


        ModificarEmpleadoPanel.add(menu, BorderLayout.CENTER);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                show asignar pinche a cocinero Menu.
                showAsociarPincheACocinero();

            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                show eliminar empleado panel.
                showEliminarEmpleadoMenu();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                superAdminEmpleadosMenu();
            }
        });


        getContentPane().remove(currentPanel);
        currentPanel = ModificarEmpleadoPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();

    }
    public void showEliminarEmpleadoMenu(){
        JPanel EliminarEmpleadoMenu = new JPanel();
        EliminarEmpleadoMenu.setLayout(new BorderLayout());

        JButton returnButton = new JButton("cancelar");
        returnButton.setPreferredSize(new Dimension(100, 40));
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                superAdminPlatillosMenu();
            }
        });

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel label = new JLabel("Nombre del empleado:");
        inputPanel.add(label, gbc);

        gbc.gridx = 1;
        JTextField input = new JTextField(10);
        input.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(input, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        inputPanel.add(returnButton, gbc);

        gbc.gridx = 1;
        JButton registrarCasaBtn = new JButton("Eliminar");
        registrarCasaBtn.setPreferredSize(new Dimension(100, 40));
        inputPanel.add(registrarCasaBtn, gbc);

        registrarCasaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String codigoIn = input.getText();

                String mensaje = empleadoGestor.eliminarEmpleado(codigoIn);

                JOptionPane.showMessageDialog(MainApplicationScreen.this, mensaje, "Acción Existosa", JOptionPane.INFORMATION_MESSAGE);

                revalidate();
                repaint();

                superAdminAlmacenesMenu();

            }
        });

        EliminarEmpleadoMenu.add(inputPanel, BorderLayout.CENTER);

        getContentPane().remove(currentPanel);
        currentPanel = EliminarEmpleadoMenu;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();

    }
    public void superAdminPlatillosMenu(){

        JPanel platillosMenuPanel = new JPanel();
        platillosMenuPanel.setLayout(new BorderLayout());

        JPanel menu = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,10,5,10);

        gbc.gridx = 1;
        gbc.gridwidth = 1;
        JPanel subtitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label subtitle = new Label("Porfavor seleccione una opción");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitlePanel.add(subtitle);
        menu.add(subtitlePanel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button1 = new JButton("Listar platillos");
        button1.setPreferredSize(new Dimension(220, 50));
        menu.add(button1, gbc);

        gbc.gridy++;
        JButton button2 = new JButton("Registrar platillo");
        button2.setPreferredSize(new Dimension(220, 50));
        menu.add(button2, gbc);

        gbc.gridy++;
        JButton button3 = new JButton("agregar ingrediente a platillo");
        button2.setPreferredSize(new Dimension(220, 50));
        menu.add(button2, gbc);

        gbc.gridy++;
        JButton button4 = new JButton("eliminar ingrediente de platillo");
        button4.setPreferredSize(new Dimension(220, 50));
        menu.add(button4, gbc);


        gbc.gridy++;
        JButton button5 = new JButton("Eliminar platillo");
        button5.setPreferredSize(new Dimension(220, 50));
        menu.add(button5, gbc);

        gbc.gridy++;
        JButton button6 = new JButton("Volver");
        button6.setPreferredSize(new Dimension(220, 50));
        menu.add(button6, gbc);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showlistarPlatillos();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAdminRegistrarPlatillo();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuSuperAdmin();
            }
        });

        platillosMenuPanel.add(menu, BorderLayout.CENTER);

        getContentPane().remove(currentPanel);
        currentPanel = platillosMenuPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();

    }
    public void superAdminAlmacenesMenu(){

        JPanel platillosMenuPanel = new JPanel();
        platillosMenuPanel.setLayout(new BorderLayout());

        JPanel menu = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,10,5,10);

        gbc.gridx = 1;
        gbc.gridwidth = 1;
        JPanel subtitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label subtitle = new Label("Porfavor seleccione una opción");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitlePanel.add(subtitle);
        menu.add(subtitlePanel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button1 = new JButton("Listar Almacenes");
        button1.setPreferredSize(new Dimension(220, 50));
        menu.add(button1, gbc);

        gbc.gridy++;
        JButton button2 = new JButton("Registrar Almacen");
        button2.setPreferredSize(new Dimension(220, 50));
        menu.add(button2, gbc);

        gbc.gridy++;
        JButton button3 = new JButton("agregar estante a almacen");
        button2.setPreferredSize(new Dimension(220, 50));
        menu.add(button2, gbc);

        gbc.gridy++;
        JButton button4 = new JButton("eliminar estante de almacen");
        button4.setPreferredSize(new Dimension(220, 50));
        menu.add(button4, gbc);


        gbc.gridy++;
        JButton button5 = new JButton("Eliminar almacen");
        button5.setPreferredSize(new Dimension(220, 50));
        menu.add(button5, gbc);

        gbc.gridy++;
        JButton button6 = new JButton("Volver");
        button6.setPreferredSize(new Dimension(220, 50));
        menu.add(button6, gbc);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showlistarAlmacenes();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAdminRegistrarAlmacen();
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEliminarAlmacen();
            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuSuperAdmin();
            }
        });

        platillosMenuPanel.add(menu, BorderLayout.CENTER);

        getContentPane().remove(currentPanel);
        currentPanel = platillosMenuPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();

    }

    public void showEliminarAlmacen(){
        JPanel EliminarEmpleadoMenu = new JPanel();
        EliminarEmpleadoMenu.setLayout(new BorderLayout());

        JButton returnButton = new JButton("cancelar");
        returnButton.setPreferredSize(new Dimension(100, 40));
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                superAdminPlatillosMenu();
            }
        });

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel label = new JLabel("codigo del almacen:");
        inputPanel.add(label, gbc);

        gbc.gridx = 1;
        JTextField input = new JTextField(10);
        input.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(input, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        inputPanel.add(returnButton, gbc);

        gbc.gridx = 1;
        JButton registrarCasaBtn = new JButton("Eliminar");
        registrarCasaBtn.setPreferredSize(new Dimension(100, 40));
        inputPanel.add(registrarCasaBtn, gbc);

        registrarCasaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String codigoIn = input.getText();

                String mensaje = almacenGestor.elminarAlmacen(codigoIn);

                JOptionPane.showMessageDialog(MainApplicationScreen.this, mensaje, "Acción Existosa", JOptionPane.INFORMATION_MESSAGE);

                revalidate();
                repaint();

                superAdminAlmacenesMenu();

            }
        });

        EliminarEmpleadoMenu.add(inputPanel, BorderLayout.CENTER);

        getContentPane().remove(currentPanel);
        currentPanel = EliminarEmpleadoMenu;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();

    }
    public void superAdminEstantesMenu(){

        JPanel platillosMenuPanel = new JPanel();
        platillosMenuPanel.setLayout(new BorderLayout());

        JPanel menu = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,10,5,10);

        gbc.gridx = 1;
        gbc.gridwidth = 1;
        JPanel subtitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label subtitle = new Label("Porfavor seleccione una opción");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitlePanel.add(subtitle);
        menu.add(subtitlePanel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button1 = new JButton("Listar estantes");
        button1.setPreferredSize(new Dimension(220, 50));
        menu.add(button1, gbc);

        gbc.gridy++;
        JButton button2 = new JButton("Registrar estante");
        button2.setPreferredSize(new Dimension(220, 50));
        menu.add(button2, gbc);

        gbc.gridy++;
        JButton button3 = new JButton("agregar ingrediente a estante");
        button2.setPreferredSize(new Dimension(220, 50));
        menu.add(button2, gbc);

        gbc.gridy++;
        JButton button4 = new JButton("eliminar ingrediente de estante");
        button4.setPreferredSize(new Dimension(220, 50));
        menu.add(button4, gbc);


        gbc.gridy++;
        JButton button5 = new JButton("Eliminar estante");
        button5.setPreferredSize(new Dimension(220, 50));
        menu.add(button5, gbc);

        gbc.gridy++;
        JButton button6 = new JButton("Volver");
        button6.setPreferredSize(new Dimension(220, 50));
        menu.add(button6, gbc);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showlistarEstantes();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAdminRegistrarEstante();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuSuperAdmin();
            }
        });

        platillosMenuPanel.add(menu, BorderLayout.CENTER);

        getContentPane().remove(currentPanel);
        currentPanel = platillosMenuPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();

    }
    public void superAdminIngredientesMenu(){

        JPanel ingredientesMenuPanel = new JPanel();
        ingredientesMenuPanel.setLayout(new BorderLayout());

        JPanel menu = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5,10,5,10);

        gbc.gridx = 1;
        gbc.gridwidth = 1;
        JPanel subtitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label subtitle = new Label("Porfavor seleccione una opción");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitlePanel.add(subtitle);
        menu.add(subtitlePanel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button1 = new JButton("Listar ingredientes");
        button1.setPreferredSize(new Dimension(220, 50));
        menu.add(button1, gbc);

        gbc.gridy++;
        JButton button2 = new JButton("Registrar ingrediente");
        button2.setPreferredSize(new Dimension(220, 50));
        menu.add(button2, gbc);

        gbc.gridy++;
        JButton button3 = new JButton("eliminar ingrediente");
        button3.setPreferredSize(new Dimension(220, 50));
        menu.add(button3, gbc);

        gbc.gridy++;
        JButton button4 = new JButton("Volver");
        button4.setPreferredSize(new Dimension(220, 50));
        menu.add(button4, gbc);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showlistarIngredientes();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAdminRegistrarIngrediente();
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuSuperAdmin();
            }
        });

        ingredientesMenuPanel.add(menu, BorderLayout.CENTER);

        getContentPane().remove(currentPanel);
        currentPanel = ingredientesMenuPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();

    }

//        public void showAsignarEncargadoCasaPanel() {
//        JPanel registrarCasaPanel = new JPanel();
//        registrarCasaPanel.setLayout(new BorderLayout());
//
//        JButton returnButton = new JButton("Menu");
//        returnButton.setPreferredSize(new Dimension(100, 40));
//        returnButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                showMainPanel();
//            }
//        });
//
//        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//        Label title = new Label("Asignar Encargado a casa");
//        title.setFont(new Font("Arial", Font.BOLD, 16));
//        titlePanel.add(title);
//
//        registrarCasaPanel.add(titlePanel, BorderLayout.NORTH);
//
//        JPanel inputPanel = new JPanel(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.anchor = GridBagConstraints.WEST;
//        gbc.insets = new Insets(10, 10, 10, 10);
//
//        JLabel casaIdIn = new JLabel("Casa direccion:");
//        inputPanel.add(casaIdIn, gbc);
//
//        gbc.gridx = 1;
//        JTextField casaID = new JTextField(10);
//        casaID.setPreferredSize(new Dimension(200, 30));
//        inputPanel.add(casaID, gbc);
//
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        JLabel casaDiIn = new JLabel("Vecino nombre:");
//        inputPanel.add(casaDiIn, gbc);
//
//        gbc.gridx = 1;
//        JTextField vecinoIdIn = new JTextField(10);
//        vecinoIdIn.setPreferredSize(new Dimension(200, 30));
//        inputPanel.add(vecinoIdIn, gbc);
//
//        gbc.gridx = 0;
//        gbc.gridy = 2;
//
//        inputPanel.add(returnButton, gbc);
//
//        gbc.gridx = 1;
//        JButton registrarCasaBtn = new JButton("Registrar");
//        registrarCasaBtn.setPreferredSize(new Dimension(100, 40));
//        inputPanel.add(registrarCasaBtn, gbc);
//
//        registrarCasaBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//
//                String casaIn = casaID.getText();
//
//                String vecinoIn = vecinoIdIn.getText();
//
//                String mensaje = casaGestor.asignarEncargadoCasa(casaIn, vecinoIn);
//
//                JOptionPane.showMessageDialog(MainApplicationScreen.this, mensaje, "Acción Existosa", JOptionPane.INFORMATION_MESSAGE);
//
//                revalidate();
//                repaint();
//
//                showMainPanel();
//
//            }
//        });
//
//
//        registrarCasaPanel.add(inputPanel, BorderLayout.CENTER);
//
//        getContentPane().remove(currentPanel);
//        currentPanel = registrarCasaPanel;
//        getContentPane().add(currentPanel, BorderLayout.CENTER);
//
//        revalidate();
//        repaint();
//    }

//    public void showListarCasasPanel() {
//        JPanel registrarCasaPanel = new JPanel();
//        registrarCasaPanel.setLayout(new BorderLayout());
//
//        JButton returnButton = new JButton("Menu");
//        returnButton.setPreferredSize(new Dimension(100, 40));
//        returnButton.addActionListener(e -> showMainPanel());
//
//        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//        Label title = new Label("Información de las casas  ");
//        title.setFont(new Font("Arial", Font.BOLD, 16));
//        titlePanel.add(title);
//
//        registrarCasaPanel.add(titlePanel, BorderLayout.NORTH);
//
//        JPanel inputPanel = new JPanel(new BorderLayout());
//
//        JTextArea textArea = new JTextArea();
//        textArea.setEditable(false);
//
//
//        for (String infoCasas : casaGestor.listarCasas()) {
//            textArea.append(infoCasas + "\n");
//        }
//
//        JScrollPane scrollPane = new JScrollPane(textArea);
//        inputPanel.add(scrollPane, BorderLayout.CENTER);
//
//
//        inputPanel.add(returnButton, BorderLayout.SOUTH);
//
//        registrarCasaPanel.add(inputPanel, BorderLayout.CENTER);
//
//
//        getContentPane().remove(currentPanel);
//        currentPanel = registrarCasaPanel;
//        getContentPane().add(currentPanel, BorderLayout.CENTER);
//
//        revalidate();
//        repaint();
//    }

//    registros panels
    public void showRegistroCocinero() {
    JPanel showRegistroCocineroPanel = new JPanel();
    showRegistroCocineroPanel.setLayout(new BorderLayout());

    JButton returnButton = new JButton("Menu");
    returnButton.setPreferredSize(new Dimension(100, 40));
    returnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Show main menu panel
            showMainPanel();
        }
    });

    JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    Label title = new Label("Registrar Cocinero");
    title.setFont(new Font("Arial", Font.BOLD, 16));
    titlePanel.add(title);
    showRegistroCocineroPanel.add(titlePanel, BorderLayout.NORTH);

    JPanel inputPanel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.insets = new Insets(1, 2, 1, 2);

    //nombre input field
    JLabel nombreLabel = new JLabel("Nombre:");
    inputPanel.add(nombreLabel, gbc);

    gbc.gridx = 1;
    JTextField nombreInput = new JTextField(10);
    nombreInput.setPreferredSize(new Dimension(200, 30));
    inputPanel.add(nombreInput, gbc);

    //apellido input field
    gbc.gridx = 0;
    gbc.gridy = 1;
    JLabel apellidoLabel = new JLabel("Apellido:");
    inputPanel.add(apellidoLabel, gbc);

    gbc.gridx = 1;
    JTextField apellidoInput = new JTextField(10);
    apellidoInput.setPreferredSize(new Dimension(200, 30));
    inputPanel.add(apellidoInput, gbc);

    //correo input
    // field
    gbc.gridy++;
    gbc.gridx = 0;
    JLabel correoLabel = new JLabel("correo:");
    inputPanel.add(correoLabel, gbc);

    gbc.gridx = 1;
    JTextField correoInput = new JTextField(10);
    correoInput.setPreferredSize(new Dimension(200, 30));
    inputPanel.add(correoInput, gbc);

    //nacimiento input field
    gbc.gridy++;
    gbc.gridx = 0;
    JLabel contrasennaLabel = new JLabel("contraseña:");
    inputPanel.add(contrasennaLabel, gbc);

    gbc.gridx = 1;
    JTextField contrasennaInput = new JTextField(10);
    contrasennaInput.setPreferredSize(new Dimension(200, 30));
    inputPanel.add(contrasennaInput, gbc);

    //Genero input field
    gbc.gridy++;
    gbc.gridx = 0;
    JLabel idLabel = new JLabel("identificacion:");
    inputPanel.add(idLabel, gbc);

    gbc.gridx = 1;
    JTextField idInput = new JTextField(10);
    idInput.setPreferredSize(new Dimension(200, 30));
    inputPanel.add(idInput, gbc);

    //Genero input field
    gbc.gridy++;
    gbc.gridx = 0;
    JLabel numeroSLabel = new JLabel("Numero social:");
    inputPanel.add(numeroSLabel, gbc);

    gbc.gridx = 1;
    JTextField numeroSInput = new JTextField(10);
    numeroSInput.setPreferredSize(new Dimension(200, 30));
    inputPanel.add(numeroSInput, gbc);

    //nacimiento input field
    gbc.gridy++;
    gbc.gridx = 0;
    JLabel nacimientoLabel = new JLabel("Fecha de nacimiento (YYYY-MM-DD):");
    inputPanel.add(nacimientoLabel, gbc);

    gbc.gridx = 1;
    JTextField nacimientoInput = new JTextField(10);
    nacimientoInput.setPreferredSize(new Dimension(200, 30));
    inputPanel.add(nacimientoInput, gbc);

    //telefono input field
    gbc.gridy++;
    gbc.gridx = 0;
    JLabel telefonoLabel = new JLabel("Teléfono Fijo:");
    inputPanel.add(telefonoLabel, gbc);

    gbc.gridx = 1;
    JTextField telefonoFInput = new JTextField(10);
    telefonoFInput.setPreferredSize(new Dimension(200, 30));
    inputPanel.add(telefonoFInput, gbc);

    //telefono input field
    gbc.gridy++;
    gbc.gridx = 0;
    JLabel telefonoLabelM = new JLabel("Teléfono Movil:");
    inputPanel.add(telefonoLabelM, gbc);

    gbc.gridx = 1;
    JTextField telefonoMInput = new JTextField(10);
    telefonoMInput.setPreferredSize(new Dimension(200, 30));
    inputPanel.add(telefonoMInput, gbc);

    //encargado input field
    gbc.gridy++;
    gbc.gridx = 0;
    JLabel encargadoLabel = new JLabel("Encargado (si/no):");
    inputPanel.add(encargadoLabel, gbc);

    gbc.gridx = 1;
    JTextField encargadoInput = new JTextField(10);
    encargadoInput.setPreferredSize(new Dimension(200, 30));
    inputPanel.add(encargadoInput, gbc);

    //fechaingreso
    // input field
    gbc.gridy++;
    gbc.gridx = 0;
    JLabel ingresoLabel = new JLabel("Fecha de nacimiento (YYYY-MM-DD):");
    inputPanel.add(ingresoLabel, gbc);

    gbc.gridx = 1;
    JTextField ingresInput = new JTextField(10);
    ingresInput.setPreferredSize(new Dimension(200, 30));
    inputPanel.add(ingresInput, gbc);

    // Buttons
    gbc.gridy++;
    gbc.gridx = 0;
    inputPanel.add(returnButton, gbc);

    gbc.gridx = 1;
    JButton registrarCasaBtn = new JButton("Registrar");
    registrarCasaBtn.setPreferredSize(new Dimension(100, 40));
    inputPanel.add(registrarCasaBtn, gbc);

    registrarCasaBtn.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            String nombreIn = nombreInput.getText();

            String apellidoIn = apellidoInput.getText();

            String correoIn = correoInput.getText();

            String contrasennaIn = contrasennaInput.getText();

            String idIn = idInput.getText();

            String numeroSocialIn = numeroSInput.getText();

            String fechaNacimientoIn = nacimientoInput.getText();

            String numeroFijo = telefonoFInput.getText();

            String numeroMovil = telefonoMInput.getText();

            String fechaIngresoIn = ingresInput.getText();

            String mensaje = cocineroGestor.registrarCocinero(nombreIn, apellidoIn,correoIn, contrasennaIn, idIn, numeroSocialIn, fechaNacimientoIn, "cocinero", numeroFijo, numeroMovil, fechaIngresoIn);

            System.out.println(mensaje);

            JOptionPane.showMessageDialog(MainApplicationScreen.this, mensaje, "Login Failed", JOptionPane.INFORMATION_MESSAGE);

            showMainPanel();

        }
    });

    showRegistroCocineroPanel.add(inputPanel, BorderLayout.CENTER);

    getContentPane().remove(currentPanel);
    currentPanel = showRegistroCocineroPanel;
    getContentPane().add(currentPanel, BorderLayout.CENTER);

    revalidate();
    repaint();
}
    public void showRegistroPinche() {
        JPanel registroPinchePanel = new JPanel();
        registroPinchePanel.setLayout(new BorderLayout());

        JButton returnButton = new JButton("volver");
        returnButton.setPreferredSize(new Dimension(100, 40));
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show main menu panel
                showRegistrarEmpleadosMenu();
            }
        });

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label title = new Label("Registrar Empleado");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(title);
        registroPinchePanel.add(titlePanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(1, 2, 1, 2);

        //nombre input field
        JLabel nombreLabel = new JLabel("Nombre:");
        inputPanel.add(nombreLabel, gbc);

        gbc.gridx = 1;
        JTextField nombreInput = new JTextField(10);
        nombreInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(nombreInput, gbc);

        //apellido input field
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel apellidoLabel = new JLabel("Apellido:");
        inputPanel.add(apellidoLabel, gbc);

        gbc.gridx = 1;
        JTextField apellidoInput = new JTextField(10);
        apellidoInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(apellidoInput, gbc);

        //correo input
        // field
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel correoLabel = new JLabel("correo:");
        inputPanel.add(correoLabel, gbc);

        gbc.gridx = 1;
        JTextField correoInput = new JTextField(10);
        correoInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(correoInput, gbc);

        //nacimiento input field
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel contrasennaLabel = new JLabel("contraseña:");
        inputPanel.add(contrasennaLabel, gbc);

        gbc.gridx = 1;
        JTextField contrasennaInput = new JTextField(10);
        contrasennaInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(contrasennaInput, gbc);

        //Genero input field
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel idLabel = new JLabel("identificacion:");
        inputPanel.add(idLabel, gbc);

        gbc.gridx = 1;
        JTextField idInput = new JTextField(10);
        idInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(idInput, gbc);

        //Genero input field
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel numeroSLabel = new JLabel("Numero social:");
        inputPanel.add(numeroSLabel, gbc);

        gbc.gridx = 1;
        JTextField numeroSInput = new JTextField(10);
        numeroSInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(numeroSInput, gbc);

        //nacimiento input field
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel nacimientoLabel = new JLabel("Fecha de nacimiento (YYYY-MM-DD):");
        inputPanel.add(nacimientoLabel, gbc);

        gbc.gridx = 1;
        JTextField nacimientoInput = new JTextField(10);
        nacimientoInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(nacimientoInput, gbc);

        //telefono input field
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel telefonoLabel = new JLabel("Teléfono Fijo:");
        inputPanel.add(telefonoLabel, gbc);

        gbc.gridx = 1;
        JTextField telefonoFInput = new JTextField(10);
        telefonoFInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(telefonoFInput, gbc);

        //telefono input field
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel telefonoLabelM = new JLabel("Teléfono Movil:");
        inputPanel.add(telefonoLabelM, gbc);

        gbc.gridx = 1;
        JTextField telefonoMInput = new JTextField(10);
        telefonoMInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(telefonoMInput, gbc);

        //encargado input field
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel encargadoLabel = new JLabel("Encargado (si/no):");
        inputPanel.add(encargadoLabel, gbc);

        gbc.gridx = 1;
        JTextField encargadoInput = new JTextField(10);
        encargadoInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(encargadoInput, gbc);

        //fechaingreso
        // input field
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel ingresoLabel = new JLabel("Fecha de nacimiento (YYYY-MM-DD):");
        inputPanel.add(ingresoLabel, gbc);

        gbc.gridx = 1;
        JTextField ingresInput = new JTextField(10);
        ingresInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(ingresInput, gbc);

        // Buttons
        gbc.gridy++;
        gbc.gridx = 0;
        inputPanel.add(returnButton, gbc);

        gbc.gridx = 1;
        JButton registrarCasaBtn = new JButton("Registrar");
        registrarCasaBtn.setPreferredSize(new Dimension(100, 40));
        inputPanel.add(registrarCasaBtn, gbc);

        registrarCasaBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String nombreIn = nombreInput.getText();

                String apellidoIn = apellidoInput.getText();

                String correoIn = correoInput.getText();

                String contrasennaIn = contrasennaInput.getText();

                String idIn = idInput.getText();

                String numeroSocialIn = numeroSInput.getText();

                String fechaNacimientoIn = nacimientoInput.getText();

                String numeroFijo = telefonoFInput.getText();

                String numeroMovil = telefonoMInput.getText();

                String mensaje = pincheGestor.registrarPinche(nombreIn, apellidoIn,correoIn, contrasennaIn, idIn, numeroSocialIn, fechaNacimientoIn, "pinche", numeroFijo, numeroMovil);

                System.out.println(mensaje);

                JOptionPane.showMessageDialog(MainApplicationScreen.this, mensaje, "Login Failed", JOptionPane.INFORMATION_MESSAGE);

                menuSuperAdmin();

            }
        });

        registroPinchePanel.add(inputPanel, BorderLayout.CENTER);

        getContentPane().remove(currentPanel);
        currentPanel = registroPinchePanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
    public void showRegistroEmpleado() {
        JPanel showRegistroCocineroPanel = new JPanel();
        showRegistroCocineroPanel.setLayout(new BorderLayout());

        JButton returnButton = new JButton("Menu");
        returnButton.setPreferredSize(new Dimension(100, 40));
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show main menu panel
                showMainPanel();
            }
        });

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label title = new Label("Registrar Empleado");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(title);
        showRegistroCocineroPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(1, 2, 1, 2);

        //nombre input field
        JLabel nombreLabel = new JLabel("Nombre:");
        inputPanel.add(nombreLabel, gbc);

        gbc.gridx = 1;
        JTextField nombreInput = new JTextField(10);
        nombreInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(nombreInput, gbc);

        //apellido input field
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel apellidoLabel = new JLabel("Apellido:");
        inputPanel.add(apellidoLabel, gbc);

        gbc.gridx = 1;
        JTextField apellidoInput = new JTextField(10);
        apellidoInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(apellidoInput, gbc);

        //correo input
        // field
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel correoLabel = new JLabel("correo:");
        inputPanel.add(correoLabel, gbc);

        gbc.gridx = 1;
        JTextField correoInput = new JTextField(10);
        correoInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(correoInput, gbc);

        //nacimiento input field
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel contrasennaLabel = new JLabel("contraseña:");
        inputPanel.add(contrasennaLabel, gbc);

        gbc.gridx = 1;
        JTextField contrasennaInput = new JTextField(10);
        contrasennaInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(contrasennaInput, gbc);

        //Genero input field
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel idLabel = new JLabel("identificacion:");
        inputPanel.add(idLabel, gbc);

        gbc.gridx = 1;
        JTextField idInput = new JTextField(10);
        idInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(idInput, gbc);

        //Genero input field
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel numeroSLabel = new JLabel("Numero social:");
        inputPanel.add(numeroSLabel, gbc);

        gbc.gridx = 1;
        JTextField numeroSInput = new JTextField(10);
        numeroSInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(numeroSInput, gbc);

        //nacimiento input field
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel nacimientoLabel = new JLabel("Fecha de nacimiento (YYYY-MM-DD):");
        inputPanel.add(nacimientoLabel, gbc);

        gbc.gridx = 1;
        JTextField nacimientoInput = new JTextField(10);
        nacimientoInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(nacimientoInput, gbc);

        //telefono input field
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel telefonoLabel = new JLabel("Teléfono Fijo:");
        inputPanel.add(telefonoLabel, gbc);

        gbc.gridx = 1;
        JTextField telefonoFInput = new JTextField(10);
        telefonoFInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(telefonoFInput, gbc);

        //telefono input field
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel telefonoLabelM = new JLabel("Teléfono Movil:");
        inputPanel.add(telefonoLabelM, gbc);

        gbc.gridx = 1;
        JTextField telefonoMInput = new JTextField(10);
        telefonoMInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(telefonoMInput, gbc);

        //encargado input field
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel encargadoLabel = new JLabel("Encargado (si/no):");
        inputPanel.add(encargadoLabel, gbc);

        gbc.gridx = 1;
        JTextField encargadoInput = new JTextField(10);
        encargadoInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(encargadoInput, gbc);

        //fechaingreso
        // input field
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel ingresoLabel = new JLabel("Fecha de nacimiento (YYYY-MM-DD):");
        inputPanel.add(ingresoLabel, gbc);

        gbc.gridx = 1;
        JTextField ingresInput = new JTextField(10);
        ingresInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(ingresInput, gbc);

        // Buttons
        gbc.gridy++;
        gbc.gridx = 0;
        inputPanel.add(returnButton, gbc);

        gbc.gridx = 1;
        JButton registrarCasaBtn = new JButton("Registrar");
        registrarCasaBtn.setPreferredSize(new Dimension(100, 40));
        inputPanel.add(registrarCasaBtn, gbc);

        registrarCasaBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String nombreIn = nombreInput.getText();

                String apellidoIn = apellidoInput.getText();

                String correoIn = correoInput.getText();

                String contrasennaIn = contrasennaInput.getText();

                String idIn = idInput.getText();

                String numeroSocialIn = numeroSInput.getText();

                String fechaNacimientoIn = nacimientoInput.getText();

                String numeroFijo = telefonoFInput.getText();

                String numeroMovil = telefonoMInput.getText();

                String fechaIngresoIn = ingresInput.getText();

                String mensaje = empleadoGestor.registrarEmpleado(nombreIn, apellidoIn,correoIn, contrasennaIn, idIn, numeroSocialIn, fechaNacimientoIn, "cocinero", numeroFijo, numeroMovil);

                System.out.println(mensaje);

                JOptionPane.showMessageDialog(MainApplicationScreen.this, mensaje, "Login Failed", JOptionPane.INFORMATION_MESSAGE);

                menuSuperAdmin();

            }
        });

        showRegistroCocineroPanel.add(inputPanel, BorderLayout.CENTER);

        getContentPane().remove(currentPanel);
        currentPanel = showRegistroCocineroPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
    public void showAdminRegistrarPlatillo(){

        JPanel platillosMenuPanel = new JPanel();
        platillosMenuPanel.setLayout(new BorderLayout());

        JButton returnButton = new JButton("volver");
        returnButton.setPreferredSize(new Dimension(100, 40));
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                superAdminPlatillosMenu();
            }
        });

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel label = new JLabel("nombre:");
        inputPanel.add(label, gbc);

        gbc.gridx = 1;
        JTextField input = new JTextField(10);
        input.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(input, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel label2 = new JLabel("Experto:");
        inputPanel.add(label2, gbc);

        gbc.gridx = 1;
        JTextField input2 = new JTextField(10);
        input2.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(input2, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        JLabel label3 = new JLabel("Costo:");
        inputPanel.add(label3, gbc);

        gbc.gridx = 1;
        JTextField input3 = new JTextField(10);
        input3.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(input3, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        inputPanel.add(returnButton, gbc);

        gbc.gridx = 1;
        JButton registrarCasaBtn = new JButton("Crear");
        registrarCasaBtn.setPreferredSize(new Dimension(100, 40));
        inputPanel.add(registrarCasaBtn, gbc);

        registrarCasaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String nombreIn = input.getText();

                String expertoIn = input2.getText();

                String costoTxt = input3.getText();

                double costoIn = Double.parseDouble(costoTxt);

                String mensaje = platilloGestor.registrarPlatillo(nombreIn, expertoIn, costoIn);

                JOptionPane.showMessageDialog(MainApplicationScreen.this, mensaje, "Acción Existosa", JOptionPane.INFORMATION_MESSAGE);

                revalidate();
                repaint();

                superAdminPlatillosMenu();

            }
        });

        platillosMenuPanel.add(inputPanel, BorderLayout.CENTER);

        getContentPane().remove(currentPanel);
        currentPanel = platillosMenuPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();

    }
    public void showAdminRegistrarAlmacen(){

        JPanel platillosMenuPanel = new JPanel();
        platillosMenuPanel.setLayout(new BorderLayout());

        JButton returnButton = new JButton("volver");
        returnButton.setPreferredSize(new Dimension(100, 40));
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                superAdminPlatillosMenu();
            }
        });

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel label = new JLabel("codigo:");
        inputPanel.add(label, gbc);

        gbc.gridx = 1;
        JTextField input = new JTextField(10);
        input.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(input, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        inputPanel.add(returnButton, gbc);

        gbc.gridx = 1;
        JButton registrarCasaBtn = new JButton("Crear");
        registrarCasaBtn.setPreferredSize(new Dimension(100, 40));
        inputPanel.add(registrarCasaBtn, gbc);

        registrarCasaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String codigoIn = input.getText();

                String mensaje = almacenGestor.registrarAlmacen(codigoIn);

                JOptionPane.showMessageDialog(MainApplicationScreen.this, mensaje, "Acción Existosa", JOptionPane.INFORMATION_MESSAGE);

                revalidate();
                repaint();

                superAdminAlmacenesMenu();

            }
        });

        platillosMenuPanel.add(inputPanel, BorderLayout.CENTER);

        getContentPane().remove(currentPanel);
        currentPanel = platillosMenuPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();

    }
    public void showAdminRegistrarEstante(){

        JPanel platillosMenuPanel = new JPanel();
        platillosMenuPanel.setLayout(new BorderLayout());

        JButton returnButton = new JButton("volver");
        returnButton.setPreferredSize(new Dimension(100, 40));
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                superAdminPlatillosMenu();
            }
        });

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel label = new JLabel("codigo:");
        inputPanel.add(label, gbc);

        gbc.gridx = 1;
        JTextField input = new JTextField(10);
        input.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(input, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        inputPanel.add(returnButton, gbc);

        gbc.gridx = 1;
        JButton registrarCasaBtn = new JButton("Crear");
        registrarCasaBtn.setPreferredSize(new Dimension(100, 40));
        inputPanel.add(registrarCasaBtn, gbc);

        registrarCasaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String codigoIn = input.getText();

                String mensaje = estanteGestor.registrarEstante(codigoIn);

                JOptionPane.showMessageDialog(MainApplicationScreen.this, mensaje, "Acción Existosa", JOptionPane.INFORMATION_MESSAGE);

                revalidate();
                repaint();

                superAdminAlmacenesMenu();

            }
        });

        platillosMenuPanel.add(inputPanel, BorderLayout.CENTER);

        getContentPane().remove(currentPanel);
        currentPanel = platillosMenuPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();

    }
    public void showAdminRegistrarIngrediente(){

        JPanel platillosMenuPanel = new JPanel();
        platillosMenuPanel.setLayout(new BorderLayout());

        JButton returnButton = new JButton("volver");
        returnButton.setPreferredSize(new Dimension(100, 40));
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                superAdminIngredientesMenu();
            }
        });

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel label = new JLabel("Nombre:");
        inputPanel.add(label, gbc);

        gbc.gridx = 1;
        JTextField input = new JTextField(10);
        input.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(input, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        JLabel ingresoLabel = new JLabel("Cantidad:");
        inputPanel.add(ingresoLabel, gbc);

        gbc.gridx = 1;
        JTextField ingresInput = new JTextField(10);
        ingresInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(ingresInput, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        inputPanel.add(returnButton, gbc);

        gbc.gridx = 1;
        JButton registrarCasaBtn = new JButton("Crear");
        registrarCasaBtn.setPreferredSize(new Dimension(100, 40));
        inputPanel.add(registrarCasaBtn, gbc);

        registrarCasaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String codigoIn = input.getText();

                String ingreTxt = ingresInput.getText();

                int ingreIn = Integer.parseInt(ingreTxt);


                String mensaje = ingredienteGestor.registrarIngrediente(codigoIn,ingreIn);

                JOptionPane.showMessageDialog(MainApplicationScreen.this, mensaje, "Acción Existosa", JOptionPane.INFORMATION_MESSAGE);

                revalidate();
                repaint();

                superAdminIngredientesMenu();

            }
        });

        platillosMenuPanel.add(inputPanel, BorderLayout.CENTER);

        getContentPane().remove(currentPanel);
        currentPanel = platillosMenuPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();

    }

    //    listar
    //    panels
    public void showlistarCocineros() {
        JPanel registrarCasaPanel = new JPanel();
        registrarCasaPanel.setLayout(new BorderLayout());

        JButton returnButton = new JButton("volver");
        returnButton.setPreferredSize(new Dimension(100, 40));
        returnButton.addActionListener(e -> showListarEmpleadosMenu());

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label title = new Label("Información de los cocineros ");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(title);

        registrarCasaPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);


        for (String infoVecinos : cocineroGestor.listarCocineros()) {
            textArea.append(infoVecinos + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        inputPanel.add(scrollPane, BorderLayout.CENTER);


        inputPanel.add(returnButton, BorderLayout.SOUTH);

        registrarCasaPanel.add(inputPanel, BorderLayout.CENTER);


        getContentPane().remove(currentPanel);
        currentPanel = registrarCasaPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
    public void showlistarPinches() {
        JPanel listarPinchesPanel = new JPanel();
        listarPinchesPanel.setLayout(new BorderLayout());

        JButton returnButton = new JButton("volver");
        returnButton.setPreferredSize(new Dimension(100, 40));
        returnButton.addActionListener(e -> showListarEmpleadosMenu());

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label title = new Label("Información de los Pinches ");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(title);

        listarPinchesPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);


        for (String infoPinches : pincheGestor.listarPinches()) {
            textArea.append(infoPinches + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        inputPanel.add(scrollPane, BorderLayout.CENTER);


        inputPanel.add(returnButton, BorderLayout.SOUTH);

        listarPinchesPanel.add(inputPanel, BorderLayout.CENTER);


        getContentPane().remove(currentPanel);
        currentPanel = listarPinchesPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
    public void showlistarEmpleado() {
        JPanel registrarCasaPanel = new JPanel();
        registrarCasaPanel.setLayout(new BorderLayout());

        JButton returnButton = new JButton("Menu");
        returnButton.setPreferredSize(new Dimension(100, 40));
        returnButton.addActionListener(e -> showListarEmpleadosMenu());

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label title = new Label("Información de los cocineros ");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(title);

        registrarCasaPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);


        for (String infoVecinos : cocineroGestor.listarCocineros()) {
            textArea.append(infoVecinos + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        inputPanel.add(scrollPane, BorderLayout.CENTER);


        inputPanel.add(returnButton, BorderLayout.SOUTH);

        registrarCasaPanel.add(inputPanel, BorderLayout.CENTER);


        getContentPane().remove(currentPanel);
        currentPanel = registrarCasaPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
    public void showlistarPlatillos() {
        JPanel listarPlatillosPanel = new JPanel();
        listarPlatillosPanel.setLayout(new BorderLayout());

        JButton returnButton = new JButton("Menu");
        returnButton.setPreferredSize(new Dimension(100, 40));
        returnButton.addActionListener(e -> superAdminPlatillosMenu());

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label title = new Label("Información de los platillos ");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(title);

        listarPlatillosPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);


        for (String infoPlatillos : platilloGestor.listarPlatillos()) {
            textArea.append(infoPlatillos + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        inputPanel.add(scrollPane, BorderLayout.CENTER);


        inputPanel.add(returnButton, BorderLayout.SOUTH);

        listarPlatillosPanel.add(inputPanel, BorderLayout.CENTER);


        getContentPane().remove(currentPanel);
        currentPanel = listarPlatillosPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
    public void showlistarAlmacenes() {
        JPanel registrarCasaPanel = new JPanel();
        registrarCasaPanel.setLayout(new BorderLayout());

        JButton returnButton = new JButton("Menu");
        returnButton.setPreferredSize(new Dimension(100, 40));
        returnButton.addActionListener(e -> superAdminAlmacenesMenu());

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label title = new Label("Información de los almacenes ");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(title);

        registrarCasaPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        for (String infoAlmacenes : almacenGestor.listarAlmacenes()) {
            textArea.append(infoAlmacenes + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        inputPanel.add(scrollPane, BorderLayout.CENTER);

        inputPanel.add(returnButton, BorderLayout.SOUTH);

        registrarCasaPanel.add(inputPanel, BorderLayout.CENTER);

        getContentPane().remove(currentPanel);
        currentPanel = registrarCasaPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
    public void showlistarEstantes() {
        JPanel listarEstantesPanel = new JPanel();
        listarEstantesPanel.setLayout(new BorderLayout());

        JButton returnButton = new JButton("Menu");
        returnButton.setPreferredSize(new Dimension(100, 40));
        returnButton.addActionListener(e -> showListarEmpleadosMenu());

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label title = new Label("Información de los estantes ");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(title);

        listarEstantesPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);


        for (String infoEstantes : estanteGestor.listarEstantes()) {
            textArea.append(infoEstantes + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        inputPanel.add(scrollPane, BorderLayout.CENTER);


        inputPanel.add(returnButton, BorderLayout.SOUTH);

        listarEstantesPanel.add(inputPanel, BorderLayout.CENTER);


        getContentPane().remove(currentPanel);
        currentPanel = listarEstantesPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
    public void showlistarIngredientes() {
        JPanel istarIngredientesPanel = new JPanel();
        istarIngredientesPanel.setLayout(new BorderLayout());

        JButton returnButton = new JButton("volver");
        returnButton.setPreferredSize(new Dimension(100, 40));
        returnButton.addActionListener(e -> superAdminIngredientesMenu());

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label title = new Label("Información de los ingredientes ");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(title);

        istarIngredientesPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);


        for (String infoIngredientes : ingredienteGestor.listarIngredientes()) {
            textArea.append(infoIngredientes + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        inputPanel.add(scrollPane, BorderLayout.CENTER);


        inputPanel.add(returnButton, BorderLayout.SOUTH);

        istarIngredientesPanel.add(inputPanel, BorderLayout.CENTER);


        getContentPane().remove(currentPanel);
        currentPanel = istarIngredientesPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }

//
//    public void showAgregarVecinoCasaPanel() {
//        JPanel registrarCasaPanel = new JPanel();
//        registrarCasaPanel.setLayout(new BorderLayout());
//
//        JButton returnButton = new JButton("Menu");
//        returnButton.setPreferredSize(new Dimension(100, 40));
//        returnButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                showMainPanel();
//            }
//        });
//
//        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//        Label title = new Label("Agregar vecino a casa");
//        title.setFont(new Font("Arial", Font.BOLD, 16));
//        titlePanel.add(title);
//
//        registrarCasaPanel.add(titlePanel, BorderLayout.NORTH);
//
//        JPanel inputPanel = new JPanel(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.anchor = GridBagConstraints.WEST;
//        gbc.insets = new Insets(10, 10, 10, 10);
//
//        JLabel casaIdIn = new JLabel("Casa direccion:");
//        inputPanel.add(casaIdIn, gbc);
//
//        gbc.gridx = 1;
//        JTextField casaID = new JTextField(10);
//        casaID.setPreferredSize(new Dimension(200, 30));
//        inputPanel.add(casaID, gbc);
//
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        JLabel casaDiIn = new JLabel("Vecino nombre:");
//        inputPanel.add(casaDiIn, gbc);
//
//        gbc.gridx = 1;
//        JTextField vecinoIdIn = new JTextField(10);
//        vecinoIdIn.setPreferredSize(new Dimension(200, 30));
//        inputPanel.add(vecinoIdIn, gbc);
//
//        gbc.gridx = 0;
//        gbc.gridy = 2;
//
//        inputPanel.add(returnButton, gbc);
//
//        gbc.gridx = 1;
//        JButton registrarCasaBtn = new JButton("Registrar");
//        registrarCasaBtn.setPreferredSize(new Dimension(100, 40));
//        inputPanel.add(registrarCasaBtn, gbc);
//
//        registrarCasaBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//
//                String casaIn = casaID.getText();
//
//                String vecinoIn = vecinoIdIn.getText();
//
//                String mensaje = casaGestor.agregarVecinoCasa(casaIn, vecinoIn);
//
//                JOptionPane.showMessageDialog(MainApplicationScreen.this, mensaje, "Acción Existosa", JOptionPane.INFORMATION_MESSAGE);
//
//                revalidate();
//                repaint();
//
//                showMainPanel();
//
//            }
//        });
//
//
//        registrarCasaPanel.add(inputPanel, BorderLayout.CENTER);
//
//        getContentPane().remove(currentPanel);
//        currentPanel = registrarCasaPanel;
//        getContentPane().add(currentPanel, BorderLayout.CENTER);
//
//        revalidate();
//        repaint();
//    }
//
//    public void showAsignarEncargadoCasaPanel() {
//        JPanel registrarCasaPanel = new JPanel();
//        registrarCasaPanel.setLayout(new BorderLayout());
//
//        JButton returnButton = new JButton("Menu");
//        returnButton.setPreferredSize(new Dimension(100, 40));
//        returnButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                showMainPanel();
//            }
//        });
//
//        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//        Label title = new Label("Asignar Encargado a casa");
//        title.setFont(new Font("Arial", Font.BOLD, 16));
//        titlePanel.add(title);
//
//        registrarCasaPanel.add(titlePanel, BorderLayout.NORTH);
//
//        JPanel inputPanel = new JPanel(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.anchor = GridBagConstraints.WEST;
//        gbc.insets = new Insets(10, 10, 10, 10);
//
//        JLabel casaIdIn = new JLabel("Casa direccion:");
//        inputPanel.add(casaIdIn, gbc);
//
//        gbc.gridx = 1;
//        JTextField casaID = new JTextField(10);
//        casaID.setPreferredSize(new Dimension(200, 30));
//        inputPanel.add(casaID, gbc);
//
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        JLabel casaDiIn = new JLabel("Vecino nombre:");
//        inputPanel.add(casaDiIn, gbc);
//
//        gbc.gridx = 1;
//        JTextField vecinoIdIn = new JTextField(10);
//        vecinoIdIn.setPreferredSize(new Dimension(200, 30));
//        inputPanel.add(vecinoIdIn, gbc);
//
//        gbc.gridx = 0;
//        gbc.gridy = 2;
//
//        inputPanel.add(returnButton, gbc);
//
//        gbc.gridx = 1;
//        JButton registrarCasaBtn = new JButton("Registrar");
//        registrarCasaBtn.setPreferredSize(new Dimension(100, 40));
//        inputPanel.add(registrarCasaBtn, gbc);
//
//        registrarCasaBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//
//                String casaIn = casaID.getText();
//
//                String vecinoIn = vecinoIdIn.getText();
//
//                String mensaje = casaGestor.asignarEncargadoCasa(casaIn, vecinoIn);
//
//                JOptionPane.showMessageDialog(MainApplicationScreen.this, mensaje, "Acción Existosa", JOptionPane.INFORMATION_MESSAGE);
//
//                revalidate();
//                repaint();
//
//                showMainPanel();
//
//            }
//        });
//
//
//        registrarCasaPanel.add(inputPanel, BorderLayout.CENTER);
//
//        getContentPane().remove(currentPanel);
//        currentPanel = registrarCasaPanel;
//        getContentPane().add(currentPanel, BorderLayout.CENTER);
//
//        revalidate();
//        repaint();
//    }
//
//    public void showCrearAlarmaPanel() {
//        JPanel registrarCasaPanel = new JPanel();
//        registrarCasaPanel.setLayout(new BorderLayout());
//
//        JButton returnButton = new JButton("Menu");
//        returnButton.setPreferredSize(new Dimension(100, 40));
//        returnButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                showMainPanel();
//            }
//        });
//
//        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//        Label title = new Label("Crear Alarma");
//        title.setFont(new Font("Arial", Font.BOLD, 16));
//        titlePanel.add(title);
//
//        registrarCasaPanel.add(titlePanel, BorderLayout.NORTH);
//
//        JPanel inputPanel = new JPanel(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.anchor = GridBagConstraints.WEST;
//        gbc.insets = new Insets(10, 10, 10, 10);
//
//        JLabel casaIdIn = new JLabel("Casa direccion:");
//        inputPanel.add(casaIdIn, gbc);
//
//        gbc.gridx = 1;
//        JTextField casaID = new JTextField(10);
//        casaID.setPreferredSize(new Dimension(200, 30));
//        inputPanel.add(casaID, gbc);
//
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        JLabel casaDiIn = new JLabel("descripcion:");
//        inputPanel.add(casaDiIn, gbc);
//
//        gbc.gridx = 1;
//        JTextField desc = new JTextField(10);
//        desc.setPreferredSize(new Dimension(200, 30));
//        inputPanel.add(desc, gbc);
//
//        gbc.gridx = 0;
//        gbc.gridy = 2;
//
//        inputPanel.add(returnButton, gbc);
//
//        gbc.gridx = 1;
//        JButton registrarCasaBtn = new JButton("Registrar");
//        registrarCasaBtn.setPreferredSize(new Dimension(100, 40));
//        inputPanel.add(registrarCasaBtn, gbc);
//
//        registrarCasaBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//
//                String casaIn = casaID.getText();
//
//                String descIn = desc.getText();
//
//                String mensaje = vecinoGestor.crearAlarma(casaIn, descIn);
//
//                JOptionPane.showMessageDialog(MainApplicationScreen.this, mensaje, "Acción Existosa", JOptionPane.INFORMATION_MESSAGE);
//
//                revalidate();
//                repaint();
//
//                showMainPanel();
//
//            }
//        });
//
//
//        registrarCasaPanel.add(inputPanel, BorderLayout.CENTER);
//
//        getContentPane().remove(currentPanel);
//        currentPanel = registrarCasaPanel;
//        getContentPane().add(currentPanel, BorderLayout.CENTER);
//
//        revalidate();
//        repaint();
//    }

//    Asociar
public void showAsociarPincheACocinero(){

    JPanel asociarPincheACocineroPanel = new JPanel();
    asociarPincheACocineroPanel.setLayout(new BorderLayout());

        JButton returnButton = new JButton("Menu");
        returnButton.setPreferredSize(new Dimension(100, 40));
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMainPanel();
            }
        });

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label title = new Label("Agregar pinche a cocinero");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(title);

    asociarPincheACocineroPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel cocineroNombre = new JLabel("Nombre del cocinero:");
        inputPanel.add(cocineroNombre, gbc);

        gbc.gridx = 1;
        JTextField nombreCIn = new JTextField(10);
        nombreCIn.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(nombreCIn, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel pincheNombre = new JLabel("Nombre del Vecino:");
        inputPanel.add(pincheNombre, gbc);

        gbc.gridx = 1;
        JTextField nombrePIn = new JTextField(10);
        nombrePIn.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(nombrePIn, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;

        inputPanel.add(returnButton, gbc);

        gbc.gridx = 1;
        JButton registrarCasaBtn = new JButton("Registrar");
        registrarCasaBtn.setPreferredSize(new Dimension(100, 40));
        inputPanel.add(registrarCasaBtn, gbc);

        registrarCasaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String cocineroIn = nombreCIn.getText();

                String pincheIn = nombrePIn.getText();

                String mensaje = pincheGestor.asociarPincheACocinero(cocineroIn, pincheIn);

                JOptionPane.showMessageDialog(MainApplicationScreen.this, mensaje, "Acción Existosa", JOptionPane.INFORMATION_MESSAGE);

                revalidate();
                repaint();

                showMainPanel();

            }
        });


    asociarPincheACocineroPanel.add(inputPanel, BorderLayout.CENTER);

        getContentPane().remove(currentPanel);
        currentPanel = asociarPincheACocineroPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();

}

//    volver a menu principal
    public void showMainPanel(){
        getContentPane().remove(currentPanel);
        currentPanel = mainPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }


}
