package ucenfotec.ac.cr.ui;

import java.util.Scanner;

public class UI {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }


    public static void menu(){

        int opcion = -1;

        System.out.printf("---------------------------------%n");
        System.out.printf("      Restaurante BienFeliz      %n");
        System.out.printf("               Menu              %n");
        System.out.printf("---------------------------------%n");
        System.out.printf("    1.   Registrar empleado      %n");
        System.out.printf("    2.   Listar empleados        %n");
        System.out.printf("    3.   Registrar platillo      %n");
        System.out.printf("    4.   Listar platillos        %n");
        System.out.printf("    3.   Registrar ingredientes  %n");
        System.out.printf("    4.   listar ingredientes     %n");
        System.out.printf("    3.   Crear almacen/Estante   %n");
        System.out.printf("    4.   listar almacen/Estante  %n");
        System.out.printf("    5.   Cerrar Sesion           %n");
        System.out.print("    Porfavor ingrese una opcion:    ");
        opcion = sc.nextInt();
        procesarOpcion(opcion);


    }

    public static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
//                registrarEmpleado();
               break;
            case 2 :
        }
    }
}