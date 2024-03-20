package cr.ac.ucenfotec.ui;

import ucenfotec.ac.cr.bl.CL;

import java.util.Scanner;

public class UI {

    static CL gestor = new CL();

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        gestor.registrarCocinero("Gustavo", "Chavarria", "9912", "1244", "1999-12-07", "2018-11-02", "690870964", "61435565");

        gestor.registrarCocinero("Juan", "Mena", "6632", "2233", "1980-10-15", "2015-04-23", "98347544", "87018943");

        gestor.registrarCocinero("Carlos", "Hernandez", "6970", "3240", "1994-12-21", "2008-11-12", "78974014", "17451455");

        gestor.registrarPinche("Lucas", "Martinez", "7123", "9913", "2000-01-22", "Gustavo", "61652484", "81901607");

        gestor.registrarPinche("David", "Mora", "8326", "1963", "1996-01-22", "Juan", "91653482", "79237423");

        gestor.registrarPinche("Thalia", "Bazalar", "8326", "1963", "1996-01-22", "Carlos", "91653482", "79237423");


        menu();
    }


    public static void menu(){

        int opcion = -1;

        do {
            System.out.printf("\n---------------------------------%n");
            System.out.printf("      Restaurante BienFeliz      %n");
            System.out.printf("               Menu              %n");
            System.out.printf("---------------------------------%n");
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
//                registrarPlatillo();
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

            String mensaje = gestor.registrarEmpleado(nombreIn, apellidoIn, idIn, numeroSocialIn, fechaNacimientoIn, rolIn, numeroFijo, numeroMovil);

            System.out.println(mensaje);
        }

    }

    public static void registrarCocinero(){
        System.out.printf("\n---------------------------------%n");
        System.out.print("Ingrese el nombre:      ");
        String nombreIn = sc.next();

        System.out.print("Ingrese el apellido:      ");
        String apellidoIn = sc.next();

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

        String mensaje = gestor.registrarCocinero(nombreIn, apellidoIn, idIn, numeroSocialIn, fechaNacimientoIn, fechaIngresoIn, numeroFijo, numeroMovil);

        System.out.println(mensaje);
    }

    public static void registrarPinche(){
        System.out.printf("\n---------------------------------%n");

        System.out.print("Ingrese el nombre:      ");
        String nombreIn = sc.next();

        System.out.print("Ingrese el apellido:      ");
        String apellidoIn = sc.next();

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

        String mensaje = gestor.registrarPinche(nombreIn, apellidoIn, idIn, numeroSocialIn, fechaNacimientoIn, cocineroEncargado, numeroFijo, numeroMovil);

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