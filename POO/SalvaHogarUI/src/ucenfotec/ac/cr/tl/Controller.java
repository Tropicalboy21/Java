package ucenfotec.ac.cr.tl;

import ucenfotec.ac.cr.bl.logic.CasaGestor;
import ucenfotec.ac.cr.bl.logic.VecinoGestor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;


public class Controller extends JFrame {

    private LoginScreen loginPanel;

    public Controller() {

        loginPanel = new LoginScreen();
        getContentPane().add(loginPanel);
        setTitle("Salva Hogar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void loggedIn() {
        dispose();

        MainApplicationScreen mainAppScreen = new MainApplicationScreen(this);
        mainAppScreen.setVisible(true);
    }

}

class MainApplicationScreen extends JFrame {

    private JPanel currentPanel;
    private JPanel mainPanel;

    private CasaGestor casaGestor;

    private VecinoGestor vecinoGestor;

    public MainApplicationScreen(Controller loginFrame) {

        casaGestor = new CasaGestor();
        vecinoGestor = new VecinoGestor();

        // Instancia de Casa #1
        String direccionC1 = "Pavas";
        String idetificacionC1 = "C124";

        casaGestor.registrarCasa(direccionC1, idetificacionC1);

        // Instancia de Casa #2
        String direccionC2 = "Alajuelita";
        String idetificacionC2 = "A024";

        casaGestor.registrarCasa(direccionC2, idetificacionC2);

        // Instancia de Vecino #1
        String nombreV1 = "Joshua";

        String apellidoV1 = "Hernan";

        String identificacionV1 = "604590182";

        String nacimientoV1 = "1983-03-22";

        LocalDate dob = LocalDate.parse(nacimientoV1);

        int edadV1 = vecinoGestor.calcularEdad(dob);


        String generoV1 = "Masculino";

        String telefonoV1 = "61016510";

        int encargadoV1 = 1;
        boolean encargado = false;

        if(encargadoV1 == 1 ) {
            encargado = true;
        }

        vecinoGestor.registrarVecino(nombreV1, apellidoV1,  identificacionV1 , nacimientoV1,  edadV1, generoV1, telefonoV1, encargado);

        // Instancia de Vecino #2
        String nombreV2 = "Lucas";

        String apellidoV2 = "Dali";

        String identificacionV2 = "104520162";

        String nacimientoV2 = "1992-11-12";

        LocalDate dom = LocalDate.parse(nacimientoV2);

        int edadV2 = vecinoGestor.calcularEdad(dom);

        String generoV2 = "Masculino";

        String telefonoV2 = "61016510";

        int encargadoV2 = 1;

        if(encargadoV2 == 1 ) {
            encargado = true;
        }

        vecinoGestor.registrarVecino(nombreV2, apellidoV2,  identificacionV2 , nacimientoV2,  edadV2, generoV2, telefonoV2, encargado);


        setTitle("Menu Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel();
        currentPanel = mainPanel;
        mainPanel.setLayout(new BorderLayout());


        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label title = new Label("Bienvenido a SalvaHogar");
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
        JButton button = new JButton("Registrar casa");
        button.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button2 = new JButton("Listar casas");
        button2.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button2, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button3 = new JButton("Registrar vecino");
        button3.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button3, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button4 = new JButton("Listar vecinos");
        button4.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button4, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button5 = new JButton("Agregar vecino a casa");
        button5.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button5, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton button6 = new JButton("Salir");
        button6.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button6, gbc);

        mainPanel.add(menuPanel, BorderLayout.CENTER);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create and show the registrar casa panel
                showRegistrarCasaPanel();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showListarCasasPanel();
            }
        });
//
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRegistrarVecinoPanel();
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showListarVecinosPanel();
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAgregarVecinoCasaPanel();
            }
        });

        button6.addActionListener(new ActionListener() {
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

    public void showRegistrarCasaPanel() {

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
        Label title = new Label("Nueva Casa");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(title);

        registrarCasaPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel casaIdIn = new JLabel("Casa Identificación:");
        inputPanel.add(casaIdIn, gbc);

        gbc.gridx = 1;
        JTextField casaID = new JTextField(10);
        casaID.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(casaID, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel casaDiIn = new JLabel("Casa Dirección:");
        inputPanel.add(casaDiIn, gbc);

        gbc.gridx = 1;
        JTextField casaDirec = new JTextField(10);
        casaDirec.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(casaDirec, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;

        inputPanel.add(returnButton, gbc);

        gbc.gridx = 1;
        JButton registrarCasaBtn = new JButton("Registrar");
        registrarCasaBtn.setPreferredSize(new Dimension(100, 40));
        inputPanel.add(registrarCasaBtn, gbc);

        registrarCasaBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                String casaIdInput = casaID.getText();
                String casaDirecInput = casaDirec.getText();

                String mensaje = casaGestor.registrarCasa(casaDirecInput, casaIdInput);

                System.out.println(mensaje);

                JOptionPane.showMessageDialog(MainApplicationScreen.this, mensaje, "Salva Hogar", JOptionPane.INFORMATION_MESSAGE);

                showMainPanel();
            }
        });

        registrarCasaPanel.add(inputPanel, BorderLayout.CENTER);

        getContentPane().remove(currentPanel);
        currentPanel = registrarCasaPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }

    public void showListarCasasPanel() {
        JPanel registrarCasaPanel = new JPanel();
        registrarCasaPanel.setLayout(new BorderLayout());

        JButton returnButton = new JButton("Menu");
        returnButton.setPreferredSize(new Dimension(100, 40));
        returnButton.addActionListener(e -> showMainPanel());

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label title = new Label("Información de las casas  ");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(title);

        registrarCasaPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);


        for (String infoCasas : casaGestor.listarCasas()) {
            textArea.append(infoCasas + "\n");
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

    public void showRegistrarVecinoPanel() {
        JPanel registrarVecinoPanel = new JPanel();
        registrarVecinoPanel.setLayout(new BorderLayout());

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
        Label title = new Label("Registrar vecino");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(title);
        registrarVecinoPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

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

        //identificacion input field
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel idLabel = new JLabel("Identificación:");
        inputPanel.add(idLabel, gbc);

        gbc.gridx = 1;
        JTextField idInput = new JTextField(10);
        idInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(idInput, gbc);

        //nacimiento input field
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel nacimientoLabel = new JLabel("Fecha de nacimiento:");
        inputPanel.add(nacimientoLabel, gbc);

        gbc.gridx = 1;
        JTextField nacimientoInput = new JTextField(10);
        nacimientoInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(nacimientoInput, gbc);

        //Genero input field
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel generoLabel = new JLabel("Genero:");
        inputPanel.add(generoLabel, gbc);

        gbc.gridx = 1;
        JTextField generoInput = new JTextField(10);
        generoInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(generoInput, gbc);

        //telefono input field
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel telefonoLabel = new JLabel("Teléfono:");
        inputPanel.add(telefonoLabel, gbc);

        gbc.gridx = 1;
        JTextField telefonoInput = new JTextField(10);
        telefonoInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(telefonoInput, gbc);

        //encargado input field
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel encargadoLabel = new JLabel("Encargado (si/no):");
        inputPanel.add(encargadoLabel, gbc);

        gbc.gridx = 1;
        JTextField encargadoInput = new JTextField(10);
        encargadoInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(encargadoInput, gbc);

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

                String identiInput = idInput.getText();

                String nacimientoIn = nacimientoInput.getText();

                LocalDate dom = LocalDate.parse(nacimientoIn);

                int edadIn = vecinoGestor.calcularEdad(dom);

                String generoIn = generoInput.getText();

                String telefonoIn = telefonoInput.getText();

                String encargadoIn = encargadoInput.getText();

                boolean encargado = false;

                if(encargadoIn.equals("si")) {
                    encargado = true;
                }

                String mensaje = vecinoGestor.registrarVecino(nombreIn, apellidoIn, identiInput, nacimientoIn, edadIn, generoIn, telefonoIn, encargado);

                System.out.println(mensaje);

                JOptionPane.showMessageDialog(MainApplicationScreen.this, mensaje, "Login Failed", JOptionPane.INFORMATION_MESSAGE);

                showMainPanel();

            }
        });

        registrarVecinoPanel.add(inputPanel, BorderLayout.CENTER);

        getContentPane().remove(currentPanel);
        currentPanel = registrarVecinoPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
    public void showListarVecinosPanel() {
        JPanel registrarCasaPanel = new JPanel();
        registrarCasaPanel.setLayout(new BorderLayout());

        JButton returnButton = new JButton("Menu");
        returnButton.setPreferredSize(new Dimension(100, 40));
        returnButton.addActionListener(e -> showMainPanel());

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label title = new Label("Información de los vecinos ");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(title);

        registrarCasaPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);


        for (String infoVecinos : vecinoGestor.listarVecinos()) {
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

    public void showAgregarVecinoCasaPanel() {
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
        Label title = new Label("Agregar vecino a casa");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(title);

        registrarCasaPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel casaIdIn = new JLabel("Casa identificación:");
        inputPanel.add(casaIdIn, gbc);

        gbc.gridx = 1;
        JTextField casaID = new JTextField(10);
        casaID.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(casaID, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel casaDiIn = new JLabel("Vecino identificación:");
        inputPanel.add(casaDiIn, gbc);

        gbc.gridx = 1;
        JTextField vecinoIdIn = new JTextField(10);
        vecinoIdIn.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(vecinoIdIn, gbc);

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


                String casaIn = casaID.getText();

                String vecinoIn = vecinoIdIn.getText();

                String mensaje = vecinoGestor.agregarVecinoCasa(casaIn, vecinoIn);

                JOptionPane.showMessageDialog(MainApplicationScreen.this, mensaje, "Login Failed", JOptionPane.INFORMATION_MESSAGE);

                revalidate();
                repaint();

                showMainPanel();

            }
        });


        registrarCasaPanel.add(inputPanel, BorderLayout.CENTER);

        getContentPane().remove(currentPanel);
        currentPanel = registrarCasaPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

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

