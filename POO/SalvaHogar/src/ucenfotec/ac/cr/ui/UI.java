package ucenfotec.ac.cr.ui;

import java.util.Scanner;

import ucenfotec.ac.cr.bl.CL;

public class UI {
    static CL gestor = new CL();

    static Scanner sc = new Scanner(System.in);

    /* Credenciales

    correo: seguridad@salvaHogar.com
    contraseña: 20Salvo20

    */

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
            System.out.printf("    2.   Listar casa             %n");
            System.out.printf("    3.   Registrar vecino        %n");
            System.out.printf("    4.   Listar vecino           %n");
            System.out.printf("    5.   Alerta de seguridad     %n");
            System.out.printf("    6.   Cerrar Sesion           %n");
            System.out.print("    Porfavor ingrese una opcion:    ");
            opcion = sc.nextInt();
            procesarOpcion(opcion);

        }while(opcion != 6);
    }

    public static void procesarOpcion(int opcion){
        switch (opcion){
            case 1:
                registrarCasa();
                break;
            case 2:
                listarCasa();
                break;
            case 3:
                registrarVecino();
                break;
            case 4:
                listarVecinos();
                break;
            case 5:
                alertaSeguridad();
                break;
            case 6:
                System.out.printf("--------------------------------%n");
                System.out.printf("  Muchas Gracias por su visita  %n");
                System.out.printf("     lo esperamos de vuelta     %n");
                System.out.printf("--------------------------------%n");
                break;
            default:
                System.out.println("opcion invalida");
        }
    }


    public static void registrarCasa() {

    }

    public static void listarCasa() {

    }
    public static void registrarVecino() {
        System.out.print("Porfavor ingrese su nombre: ");
        String nombreIn = sc.next();

        System.out.print("Porfavor ingrese sus apellidos: ");
        String apellidosIn = sc.next();

        System.out.print("Porfavor ingrese el numero de identificación: ");
        String identificacionIn = sc.next();

        System.out.print("Porfavor ingrese fecha de nacimiento MM/DD/YY: ");
        String nacimientoIn = sc.next();

        System.out.print("Porfavor ingrese la genero: ");
        String generoIn = sc.next();

        System.out.print("Porfavor ingrese su numero de telefono: ");
        String telefonoIn = sc.next();

        System.out.print("¿Desea ser encargado de seguridad? digite 1. Si 2. NO: ");
        int encargadoIn = sc.nextInt();

        String mensaje = gestor.registrarVecino(nombreIn, apellidosIn,  identificacionIn ,nacimientoIn, generoIn, telefonoIn, encargadoIn);

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



    public static void alertaSeguridad() {

    }


    public static void main(String[] args) {
        iniciarSesion();
    }

}