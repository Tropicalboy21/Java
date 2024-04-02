package ucenfotec.ac.cr.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MainApplicationScreen extends JFrame {

    private JPanel currentPanel;
    private JPanel mainPanel;

    public MainApplicationScreen(InciarSesion loginFrame) {

        setTitle("Menu Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create main application panel
        mainPanel = new JPanel();
        currentPanel = mainPanel;

        mainPanel.setLayout(new BorderLayout());

//        Label title = new Label("Bienvenido a SalvaHogar");
//        title.setBounds(170, 50, 220, 50);
//        mainPanel.add(title);

        // crear titulo
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label title = new Label("Bienvenido a SalvaHogar");
        titlePanel.add(title);
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        // crear menu panel
        JPanel menuPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 10, 5, 10);

        gbc.gridx = 1;
        gbc.gridwidth = 2; // Span across two columns
        JButton button = new JButton("Registrar casa");
        button.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2; // Span across two columns
        JButton button2 = new JButton("Listar casas");
        button2.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button2, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2; // Span across two columns
        JButton button3 = new JButton("Registrar vecino");
        button3.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button3, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2; // Span across two columns
        JButton button4 = new JButton("Listar vecinos");
        button4.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button4, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2; // Span across two columns
        JButton button5 = new JButton("Agregar vecino a casa");
        button5.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button5, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2; // Span across two columns
        JButton button6 = new JButton("Salir");
        button6.setPreferredSize(new Dimension(220, 50));
        menuPanel.add(button6, gbc);

        mainPanel.add(menuPanel, BorderLayout.CENTER);

        // Add action listeners to the buttons
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

        // Create title panel with the title label
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label title = new Label("Nueva Casa");
        titlePanel.add(title);

        // Add title panel to registrar casa panel
        registrarCasaPanel.add(titlePanel, BorderLayout.NORTH);

        // Create input panel with casa ID and casa dirección fields
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
//    gbc.gridwidth = 2; // Span across two columns
//    gbc.anchor = GridBagConstraints.CENTER; // Center align

        inputPanel.add(returnButton, gbc);

        gbc.gridx = 1;
        JButton registrarCasaBtn = new JButton("Registrar");
        registrarCasaBtn.setPreferredSize(new Dimension(100, 40));
        inputPanel.add(registrarCasaBtn, gbc);




        // Add input panel to registrar casa panel
        registrarCasaPanel.add(inputPanel, BorderLayout.CENTER);

        // Replace current panel with registrar casa panel
        getContentPane().remove(currentPanel);
        currentPanel = registrarCasaPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        // Repaint the frame to reflect the changes
        revalidate();
        repaint();
    }

    public void showListarCasasPanel() {
        // Create registrar casa panel
        JPanel registrarCasaPanel = new JPanel();
        registrarCasaPanel.setLayout(new BorderLayout());

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

        // Create title panel with the title label
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label title = new Label("Lista de casas");
        titlePanel.add(title);

        // Add title panel to registrar casa panel
        registrarCasaPanel.add(titlePanel, BorderLayout.NORTH);

        // Create input panel with casa ID and casa dirección fields
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

//        JLabel casaIdIn = new JLabel("Casa Identificación:");
//        inputPanel.add(casaIdIn, gbc);
//
//        gbc.gridx = 1;
//        JTextField casaID = new JTextField(10);
//        casaID.setPreferredSize(new Dimension(200, 30));
//        inputPanel.add(casaID, gbc);
//
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        JLabel casaDiIn = new JLabel("Casa Dirección:");
//        inputPanel.add(casaDiIn, gbc);
//
//        gbc.gridx = 1;
//        JTextField casaDirec = new JTextField(10);
//        casaDirec.setPreferredSize(new Dimension(200, 30));
//        inputPanel.add(casaDirec, gbc);

//        gbc.gridx = 0;
        gbc.gridy = 2;
//    gbc.gridwidth = 2; // Span across two columns
//    gbc.anchor = GridBagConstraints.CENTER; // Center align

        inputPanel.add(returnButton, gbc);

//        gbc.gridx = 1;
//        JButton registrarCasaBtn = new JButton("Registrar");
//        registrarCasaBtn.setPreferredSize(new Dimension(100, 40));
//        inputPanel.add(registrarCasaBtn, gbc);




        // Add input panel to registrar casa panel
        registrarCasaPanel.add(inputPanel, BorderLayout.CENTER);

        // Replace current panel with registrar casa panel
        getContentPane().remove(currentPanel);
        currentPanel = registrarCasaPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        // Repaint the frame to reflect the changes
        revalidate();
        repaint();
    }

    public void showRegistrarVecinoPanel() {
        // Create registrar casa panel
        JPanel registrarVecinoPanel = new JPanel();
        registrarVecinoPanel.setLayout(new BorderLayout());

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

        // crear titulo
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label title = new Label("Registrar vecino");
        titlePanel.add(title);
        registrarVecinoPanel.add(titlePanel, BorderLayout.NORTH);

        //Crear input panel
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
        JLabel encargadoLabel = new JLabel("Encargado:");
        inputPanel.add(encargadoLabel, gbc);

        gbc.gridx = 1;
        JTextField encargadoInput = new JTextField(10);
        encargadoInput.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(encargadoInput, gbc);

        // Buttons
        gbc.gridy++;
        gbc.gridx = 0;
        // gbc.gridwidth = 2; // Span across two columns
        // gbc.anchor = GridBagConstraints.CENTER; // Center align
        inputPanel.add(returnButton, gbc);

        gbc.gridx = 1;
        JButton registrarCasaBtn = new JButton("Registrar");
        registrarCasaBtn.setPreferredSize(new Dimension(100, 40));
        inputPanel.add(registrarCasaBtn, gbc);

        // Add input panel to registrar casa panel
        registrarVecinoPanel.add(inputPanel, BorderLayout.CENTER);

        // Replace current panel with registrar casa panel
        getContentPane().remove(currentPanel);
        currentPanel = registrarVecinoPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        // Repaint the frame to reflect the changes
        revalidate();
        repaint();
    }
    public void showListarVecinosPanel() {
        // Create registrar casa panel
        JPanel registrarCasaPanel = new JPanel();
        registrarCasaPanel.setLayout(new BorderLayout());

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

        // Create title panel with the title label
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label title = new Label("Lista de vecinos");
        titlePanel.add(title);

        // Add title panel to registrar casa panel
        registrarCasaPanel.add(titlePanel, BorderLayout.NORTH);

        // Create input panel with casa ID and casa dirección fields
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

//        JLabel casaIdIn = new JLabel("Casa Identificación:");
//        inputPanel.add(casaIdIn, gbc);
//
//        gbc.gridx = 1;
//        JTextField casaID = new JTextField(10);
//        casaID.setPreferredSize(new Dimension(200, 30));
//        inputPanel.add(casaID, gbc);
//
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        JLabel casaDiIn = new JLabel("Casa Dirección:");
//        inputPanel.add(casaDiIn, gbc);
//
//        gbc.gridx = 1;
//        JTextField casaDirec = new JTextField(10);
//        casaDirec.setPreferredSize(new Dimension(200, 30));
//        inputPanel.add(casaDirec, gbc);

//        gbc.gridx = 0;
        gbc.gridy = 2;
//    gbc.gridwidth = 2; // Span across two columns
//    gbc.anchor = GridBagConstraints.CENTER; // Center align

        inputPanel.add(returnButton, gbc);

//        gbc.gridx = 1;
//        JButton registrarCasaBtn = new JButton("Registrar");
//        registrarCasaBtn.setPreferredSize(new Dimension(100, 40));
//        inputPanel.add(registrarCasaBtn, gbc);




        // Add input panel to registrar casa panel
        registrarCasaPanel.add(inputPanel, BorderLayout.CENTER);

        // Replace current panel with registrar casa panel
        getContentPane().remove(currentPanel);
        currentPanel = registrarCasaPanel;
        getContentPane().add(currentPanel, BorderLayout.CENTER);

        // Repaint the frame to reflect the changes
        revalidate();
        repaint();
    }

    public void showAgregarVecinoCasaPanel() {
        // Create registrar casa panel
        JPanel registrarCasaPanel = new JPanel();
        registrarCasaPanel.setLayout(new BorderLayout());

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

        // Create title panel with the title label
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Label title = new Label("Agregar vecino a casa");
        titlePanel.add(title);

        // Add title panel to registrar casa panel
        registrarCasaPanel.add(titlePanel, BorderLayout.NORTH);

        // Create input panel with casa ID and casa dirección fields
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
        JTextField casaDirec = new JTextField(10);
        casaDirec.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(casaDirec, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
//    gbc.gridwidth = 2; // Span across two columns
//    gbc.anchor = GridBagConstraints.CENTER; // Center align

        inputPanel.add(returnButton, gbc);

        gbc.gridx = 1;
        JButton registrarCasaBtn = new JButton("Registrar");
        registrarCasaBtn.setPreferredSize(new Dimension(100, 40));
        inputPanel.add(registrarCasaBtn, gbc);




        // Add input panel to registrar casa panel
        registrarCasaPanel.add(inputPanel, BorderLayout.CENTER);

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
