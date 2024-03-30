package ucenfotec.ac.cr.ui;

import java.util.Scanner;

import java.time.LocalDate;

import ucenfotec.ac.cr.bl.CL;

    /* Credenciales

    correo: seguridad@salvaHogar.com
    contraseña: 20Salvo20

    */

public class UI {
    static CL gestor = new CL();

    static Scanner sc = new Scanner(System.in);


    public static void iniciarSesion() {
        String correo;
        String contrasena;
        System.out.printf("---------------------------------%n");
        System.out.printf("    Bienvenido a SalvaHogar      %n");
        System.out.printf("         Iniciar sesion          %n");
        System.out.printf("---------------------------------%n");
        System.out.print("Ingrese su correo: ");
        correo = sc.next();
        System.out.print("Ingrese su contraseña: ");
        contrasena = sc.next();

        if(correo.equals("seguridad@salvaHogar.com") & contrasena.equals("20Salvo20")){
            menuInterno();
        } else {
            System.out.printf("---------------------------------%n");
            System.out.printf("   correo/contraseña invalidos   %n");
            System.out.printf("---------------------------------%n");
        }
    }


    public static void menuInterno() {
        int opcion = -1;
        do {
            System.out.printf("---------------------------------%n");
            System.out.printf("    Bienvenido a SalvaHogar      %n");
            System.out.printf("              Menu               %n");
            System.out.printf("---------------------------------%n");
            System.out.printf("    1.   Registrar casa          %n");
            System.out.printf("    2.   Listar casas            %n");
            System.out.printf("    3.   Registrar vecino        %n");
            System.out.printf("    4.   Listar vecinos          %n");
            System.out.printf("    5.   Agregar Vecino a casa   %n");
            System.out.printf("    6.   Cerrar Sesion           %n");
            System.out.print("    Porfavor ingrese una opcion:    ");
            opcion = sc.nextInt();
            procesarOpcion(opcion);

        }while(opcion != 7);
    }

    public static void procesarOpcion(int opcion){
        switch (opcion){
            case 1:
                registrarCasa();
                break;
            case 2:
                listarCasas();
                break;
            case 3:
                registrarVecino();
                break;
            case 4:
                listarVecinos();
                break;
            case 5:
                agregarVecinoCasa();
                break;
            case 6:
                System.out.printf("---------------------------------%n");
                System.out.printf("     Gracias por su visita       %n");
                System.out.printf("         vuelva pronto           %n");
                System.out.printf("---------------------------------%n");
                break;
            default:
                System.out.println("opcion invalida");
        }
    }


    public static void registrarCasa() {
        System.out.printf("---------------------------------%n");
        System.out.print("Ingrese la direccion:      ");
        String direccionIn = sc.next();

        System.out.print("Ingrese la identificación: ");
        String identificacionIn = sc.next();

        String mensaje = gestor.registrarCasa(direccionIn, identificacionIn);

        System.out.println(mensaje);

         menuInterno();
    }

    public static void listarCasas() {
        System.out.printf("---------------------------------%n");
        System.out.printf("    informacion de las casas     %n");
        System.out.printf("---------------------------------%n");
        for (String infoCasas: gestor.listarCasas()){
            System.out.println(infoCasas);
        }
    }
    public static void registrarVecino() {
        System.out.printf("---------------------------------%n");
        System.out.print("Ingrese el nombre:      ");
        String nombreIn = sc.next();

        System.out.print("Ingrese el apellido:    ");
        String apellidosIn = sc.next();

        System.out.print("Ingrese la identificación: ");
        String identificacionIn = sc.next();

        System.out.print("Ingrese fecha de nacimiento  YYYY-MM-DD: ");
        String nacimientoIn = sc.next();

        int edad = nacimientoIn.length();

        System.out.print("Porfavor ingrese la genero: ");
        String generoIn = sc.next();

        System.out.print("Porfavor ingrese su numero de telefono: ");
        String telefonoIn = sc.next();

        System.out.print("¿Desea ser encargado de seguridad? digite 1. Si 2. NO: ");
        int encargadoIn = sc.nextInt();

        boolean encargado = false;

        if(encargadoIn == 1 ) {
            encargado = true;
        }

        String mensaje = gestor.registrarVecino(nombreIn, apellidosIn,  identificacionIn, nacimientoIn, edad,  generoIn, telefonoIn, encargado);

        System.out.println(mensaje);

        menuInterno();

    }

    public static void listarVecinos() {
        System.out.printf("---------------------------------%n");
        System.out.printf("   informacion de los vecinos    %n");
        System.out.printf("---------------------------------%n");
        for (String infoVecinos: gestor.listarVecinos()){
            System.out.println(infoVecinos);
        }
    }

    public static void agregarVecinoCasa() {
        System.out.print("Digite la identificación de la Casa: ");
        String idCasa =  sc.next();
        System.out.print("Digite la identificación del Vecino: ");
        String idVecino =  sc.next();

        String mensaje = gestor.agregarVecinoCasa(idCasa,idVecino);
        System.out.println(mensaje);
    }



    public static void main(String[] args) {

        // Instancia de Casa #1
        String direccionC1 = "Pavas";
        String idetificacionC1 = "C124";

        gestor.registrarCasa(direccionC1, idetificacionC1);

        // Instancia de Casa #2
        String direccionC2 = "Alajuelita";
        String idetificacionC2 = "A024";

        gestor.registrarCasa(direccionC2, idetificacionC2);


        // Instancia de Vecino #1
        String nombreV1 = "Joshua";

        String apellidoV1 = "Hernan";

        String identificacionV1 = "604590182";

        String nacimientoV1 = "1983-03-22";

        LocalDate dob = LocalDate.parse(nacimientoV1);

        int edadV1 = gestor.CalcularEdad(dob);


        String generoV1 = "Masculino";

        String telefonoV1 = "61016510";

        int encargadoV1 = 1;
        boolean encargado = false;

        if(encargadoV1 == 1 ) {
            encargado = true;
        }

        gestor.registrarVecino(nombreV1, apellidoV1,  identificacionV1 , nacimientoV1,  edadV1, generoV1, telefonoV1, encargado);

        // Instancia de Vecino #2
        String nombreV2 = "Lucas";

        String apellidoV2 = "Dali";

        String identificacionV2 = "104520162";

        String nacimientoV2 = "1992-11-12";

        LocalDate dom = LocalDate.parse(nacimientoV2);

        int edadV2 = gestor.CalcularEdad(dom);

        String generoV2 = "Masculino";

        String telefonoV2 = "61016510";

        int encargadoV2 = 1;

        if(encargadoV2 == 1 ) {
            encargado = true;
        }

        gestor.registrarVecino(nombreV2, apellidoV2,  identificacionV2 , nacimientoV2,  edadV2, generoV2, telefonoV2, encargado);

        menuInterno();
    }
}