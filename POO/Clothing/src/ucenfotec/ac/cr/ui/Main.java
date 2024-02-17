package ucenfotec.ac.cr.ui;


import java.util.Scanner;

public class Main {

    static Scanner sc  = new Scanner(System.in);


    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        int opcion = -1;
        do {
            System.out.println("\nDirectory Clothing,Inc.");
            System.out.println("----- Menu -----");
            System.out.println("1. Registrar Clientes");
            System.out.println("2. Listar clientes");
            System.out.println("3. Registrar catalogo");
            System.out.println("4. listar catalogo");
            System.out.println("4. Salir");
            System.out.print("ingrese una opción: ");
            opcion = sc.nextInt();
            procesarOpcion(opcion);
        }while(opcion != 3);
    }

    public static void procesarOpcion(int opcion) {

        switch (opcion){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4 :
                System.out.println("gracias por su visita");
                break;
            default:
                System.out.println("opcion invalida");
        }
    }
}