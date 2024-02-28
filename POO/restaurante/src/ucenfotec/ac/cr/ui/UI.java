package ucenfotec.ac.cr.ui;

import java.util.Scanner;

public class UI {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }


    public static void menu(){

        int opcion = -1;

        do {
            System.out.printf("---------------------------------%n");
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
//                listarEmpleado();
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
        System.out.print("    Porfavor ingrese una opcion:    ");
        opcion = sc.nextInt();

        if(opcion == 1){
//        registrarCocinero();
        } else if(opcion == 2) {
//            registrarPinche();
        } else {
            System.out.printf("\n---------------------------------%n");
        }
    }
}