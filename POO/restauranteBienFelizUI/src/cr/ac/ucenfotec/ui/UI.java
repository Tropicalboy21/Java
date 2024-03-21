package cr.ac.ucenfotec.ui;

import cr.ac.ucenfotec.bl.CL;
import cr.ac.ucenfotec.bl.Cocinero;
import cr.ac.ucenfotec.bl.Empleado;
import cr.ac.ucenfotec.bl.Pinche;

import java.util.Scanner;

public class UI {

    static CL gestor = new CL();

    static String roluser;

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        gestor.registrarCocinero("Gustavo", "Navarro", "gus12@bienfeliz.com", "bienFeliz","9912", "1244", "1999-12-07", "cocinero", "690870964", "61435565", "2018-11-02");

        gestor.registrarCocinero("Juan", "Mena", "Jmena22@bienfeliz.com","bienFeliz","6632", "2233", "1980-10-15", "cocinero", "98347544", "87018943", "2015-04-23");

        gestor.registrarCocinero("Carlos", "Hernandez","Carher00@bienfeliz.com","bienFeliz", "6970", "3240", "1994-12-21", "cocinero", "78974014", "17451455", "2008-11-12");

        gestor.registrarPinche("Lucas", "Martinez", "Lucasmm@bienfeliz.com","bienFeliz","7123", "9913", "2000-01-22", "pinche", "61652484", "81901607", "Gustavo");

        gestor.registrarPinche("David", "Mora", "David19@bienfeliz.com","bienFeliz","8326", "1963", "1996-01-22", "pinche", "91653482", "79237423", "Juan");

        gestor.registrarPinche("Tatiana", "Vargas", "ttvargas@bienfeliz.com","bienFeliz","8326", "1963", "1996-01-22", "pinche", "91653482", "79237423", "Carlos");


        IniciarSesion();
    }

    public static void IniciarSesion(){
        int opcion = -1;

        System.out.printf("\n---------------------------------%n");
        System.out.printf("      Restaurante BienFeliz      %n");
        System.out.printf("          Inciar sesion          %n");
        System.out.printf("---------------------------------%n");
        System.out.printf("      Porfavor indique su rol    %n");
        System.out.printf("         1.   Cocinero           %n");
        System.out.printf("         2.   Pinche             %n");
        System.out.printf("         3.   Empleado           %n");
        System.out.printf("         4.   SuperAdmin         %n");
        System.out.print("    Porfavor ingrese una opcion:    ");
        opcion = sc.nextInt();


        if(opcion == 1){
            roluser = "cocinero";
            validarCocinero();
        } else if (opcion == 2) {
            roluser = "pinche";
            validarPinche();
        } else if (opcion == 3){
            System.out.print("ingrese su rol: ");
            roluser = sc.next();
            validarEmpleado();
        } else if (opcion == 4){
            roluser = "SuperAdmin";
            validarSuperAdmin();
        }

    }

    public static void validarCocinero(){
        String correo;
        String contrasenna;

        System.out.print("Ingrese su correo electrónico: ");
        correo = sc.next();
        System.out.print("Ingrese su contraseña: ");
        contrasenna = sc.next();

        Cocinero cocineroEncontrado = gestor.validarCocinero(correo, contrasenna);

        if (cocineroEncontrado != null){
            menuEmpleados();
        } else
            System.out.println("Lo sentimos, datos no encontrados.");
    }

    public static void validarPinche(){
        String correo;
        String contrasenna;

        System.out.print("Ingrese su correo electrónico: ");
        correo = sc.next();
        System.out.print("Ingrese su contraseña: ");
        contrasenna = sc.next();

        Pinche picheEncontrado = gestor.validarPinche(correo, contrasenna);

        if (picheEncontrado != null){
            menuEmpleados();
        } else
            System.out.println("Lo sentimos, datos no encontrados.");
    }


    public static void validarEmpleado(){
        String correo;
        String contrasenna;

        System.out.print("Ingrese su correo electrónico: ");
        correo = sc.next();
        System.out.print("Ingrese su contraseña: ");
        contrasenna = sc.next();

        Empleado empleadoEncontrado = gestor.validarEmpleado(correo, contrasenna);

        if (empleadoEncontrado != null){
            menuEmpleados();
        } else
            System.out.println("Lo sentimos, datos no encontrados.");
    }

    public static void validarSuperAdmin(){
        String correo;
        String adminCorreo = "superadmin@bienfeliz.com";
        String contrasenna;
        String adminContra = "superBienFeliz";

        System.out.print("Ingrese su correo electrónico: ");
        correo = sc.next();
        System.out.print("Ingrese su contraseña: ");
        contrasenna = sc.next();

        if (correo.equals(adminCorreo) && contrasenna.equals(adminContra)){
            menuAdmin();
        } else
            System.out.println("Lo sentimos, usuario administrador invalido.");
    }

    public static void menuEmpleados(){

        int opcion = -1;

        do {
            System.out.printf("\n---------------------------------%n");
            System.out.printf("      Restaurante BienFeliz      %n");
            System.out.printf("       Bienvenido " + roluser + "%n");
            System.out.printf("---------------------------------%n");
            System.out.printf("               Menu              %n");
            System.out.printf("    1.   Listar platillos        %n");
            System.out.printf("    2.   listar ingredientes     %n");
            System.out.printf("    3.   listar almacen/Estante  %n");
            System.out.printf("    0.   Cerrar Sesion           %n");
            System.out.print("    Porfavor ingrese una opcion:    ");
            opcion = sc.nextInt();
            procesarOpcion(opcion);
        }while(opcion != 0 );

    }

    public static void menuAdmin(){

        int opcion = -1;

        do {
            System.out.printf("\n---------------------------------%n");
            System.out.printf("      Restaurante BienFeliz      %n");
            System.out.printf("      Bienvenido " + roluser +  "%n");
            System.out.printf("---------------------------------%n");
            System.out.printf("               Menu              %n");
            System.out.printf("    1.   Registrar empleado      %n");
            System.out.printf("    2.   Listar empleados        %n");
            System.out.printf("    3.   Registrar platillo      %n");
            System.out.printf("    4.   Listar platillos        %n");
            System.out.printf("    5.   Registrar ingredientes  %n");
            System.out.printf("    6.   listar ingredientes     %n");
            System.out.printf("    7.   Crear almacen/Estante   %n");
            System.out.printf("    8.   listar almacen/Estante  %n");
            System.out.printf("    0.   Cerrar Sesion           %n");
            System.out.print("    Porfavor ingrese una opcion:    ");
            opcion = sc.nextInt();
            procesarOpcion(opcion);
        }while(opcion != 0 );


    }

    public static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                registrarEmpleado();
                break;
            case 2:
                listarEmpleado();
                break;
            case 3:
//               registrarPlatillo();
                break;
            case 4:
//                listarPlatillo();
                break;
            case 5:
//                registrarIngrediente();
                break;
            case 6:
//                listarIngredientes();
                break;
            case 7:
//                RegistrarAlmacenEstante();
                break;
            case 8:
//                listarAlmacenes();
                break;
            case 0:
                System.out.printf("---------------------------------%n");
                System.out.printf("     Gracias por su visita       %n");
                System.out.printf("         vuelva pronto           %n");
                System.out.printf("---------------------------------%n");
                break;

            default:
                System.out.println("opcion invalida");
        }
    }

    public static void registrarEmpleado(){
        int opcion = -1;
        System.out.printf("---------------------------------%n");
        System.out.printf("   Registrar un nuevo empleado   %n");
        System.out.printf("---------------------------------%n");
        System.out.printf("    1.   Registrar Cocinero      %n");
        System.out.printf("    2.   Registrar Pinche        %n");
        System.out.printf("    3.   Registrar otro          %n");
        System.out.print("    Porfavor ingrese una opción:    ");
        opcion = sc.nextInt();

        if(opcion == 1){
            registrarCocinero();
        } else if(opcion == 2) {
            registrarPinche();
        } else {
            System.out.printf("\n---------------------------------%n");
            System.out.print("Ingrese el nombre:      ");
            String nombreIn = sc.next();

            System.out.print("Ingrese el apellido:      ");
            String apellidoIn = sc.next();

            System.out.println("Genere un correo electronico en el siguiente formato (XXXXXX@bienfeliz.com):");
            String correoIn = sc.next();

            System.out.println("Genere una contraseña: ");
            String contrasennaIn = sc.next();

            System.out.print("Ingrese la idetificación:      ");
            String idIn = sc.next();

            System.out.print("Ingrese el numero social:      ");
            String numeroSocialIn = sc.next();

            System.out.print("Ingrese la fecha de nacimiento  YYYY-MM-DD:   ");
            String fechaNacimientoIn = sc.next();

            System.out.print("Ingrese el rol:   ");
            String rolIn = sc.next();

            System.out.print("Ingrese el numero de teléfono fijo:   ");
            String numeroFijo = sc.next();

            System.out.print("Ingrese el numero de teléfono Móvil:   ");
            String numeroMovil = sc.next();

            String mensaje = gestor.registrarEmpleado(nombreIn, apellidoIn,correoIn, contrasennaIn, idIn, numeroSocialIn, fechaNacimientoIn, rolIn, numeroFijo, numeroMovil);

            System.out.println(mensaje);
        }

    }

    public static void registrarCocinero(){
        System.out.printf("\n---------------------------------%n");
        System.out.print("Ingrese el nombre:      ");
        String nombreIn = sc.next();

        System.out.print("Ingrese el apellido:      ");
        String apellidoIn = sc.next();

        System.out.println("Genere un correo electronico en el siguiente formato (XXXXXX@bienfeliz.com):");
        String correoIn = sc.next();

        System.out.println("Genere una contraseña: ");
        String contrasennaIn = sc.next();

        System.out.print("Ingrese la idetificación:      ");
        String idIn = sc.next();

        System.out.print("Ingrese el numero social:      ");
        String numeroSocialIn = sc.next();

        System.out.print("Ingrese la fecha de nacimiento YYYY-MM-DD:   ");
        String fechaNacimientoIn = sc.next();

        System.out.print("Ingrese la fecha de ingreso YYYY-MM-DD:    ");
        String fechaIngresoIn = sc.next();

        System.out.print("Ingrese el numero de teléfono fijo:   ");
        String numeroFijo = sc.next();

        System.out.print("Ingrese el numero de teléfono Móvil:   ");
        String numeroMovil = sc.next();

        String mensaje = gestor.registrarCocinero(nombreIn, apellidoIn,correoIn, contrasennaIn, idIn, numeroSocialIn, fechaNacimientoIn, "cocinero", numeroFijo, numeroMovil, fechaIngresoIn);

        System.out.println(mensaje);
    }

    public static void registrarPinche(){
        System.out.printf("\n---------------------------------%n");

        System.out.print("Ingrese el nombre:      ");
        String nombreIn = sc.next();

        System.out.print("Ingrese el apellido:      ");
        String apellidoIn = sc.next();

        System.out.println("Genere un correo electronico en el siguiente formato (XXXXXX@bienfeliz.com):");
        String correoIn = sc.next();

        System.out.println("Genere una contraseña: ");
        String contrasennaIn = sc.next();

        System.out.print("Ingrese la idetificación:      ");
        String idIn = sc.next();

        System.out.print("Ingrese el numero social:      ");
        String numeroSocialIn = sc.next();

        System.out.print("Ingrese la fecha de nacimiento YYYY-MM-DD:   ");
        String fechaNacimientoIn = sc.next();

        System.out.print("Ingrese el cocinero encargado:    ");
        String cocineroEncargado = sc.next();

        System.out.print("Ingrese el numero de teléfono fijo:   ");
        String numeroFijo = sc.next();

        System.out.print("Ingrese el numero de teléfono Móvil:   ");
        String numeroMovil = sc.next();

        String mensaje = gestor.registrarPinche(nombreIn, apellidoIn, correoIn, contrasennaIn, idIn, numeroSocialIn, fechaNacimientoIn, "pinche", numeroFijo, numeroMovil, cocineroEncargado);

        System.out.println(mensaje);
    }

    public static void listarEmpleado(){
        int opcion = 0;
        System.out.printf("---------------------------------%n");
        System.out.printf("     Restaurante Bien Feliz      %n");
        System.out.printf("---------------------------------%n");
        System.out.printf("    1.   listar cocineros        %n");
        System.out.printf("    2.   listar pinches          %n");
        System.out.printf("    3.   listar otros empleados  %n");
        System.out.print("    Porfavor ingrese una opción:    ");
        opcion = sc.nextInt();

        switch (opcion){
            case 1:
                System.out.printf("---------------------------------%n");
                System.out.printf("       Lista de Cocineros        %n");
                System.out.printf("---------------------------------%n");
                for(String infoCocineros: gestor.listarCocinero()){
                    System.out.println(infoCocineros);
                }
                break;
            case 2:
                System.out.printf("---------------------------------%n");
                System.out.printf("       Lista de Pinches          %n");
                System.out.printf("---------------------------------%n");
                for(String infoPinches: gestor.listarPinche()){
                    System.out.println(infoPinches);
                }
                break;
            case 3:
                System.out.printf("---------------------------------%n");
                System.out.printf("       Lista de Empleados        %n");
                System.out.printf("---------------------------------%n");
                for(String infoEmpleados: gestor.listarEmpleados()){
                    System.out.println(infoEmpleados);
                }
                break;
            default:
                System.out.println("opción invalida");
                break;
        }


    }
}