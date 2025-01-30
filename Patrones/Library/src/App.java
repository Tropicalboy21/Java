import java.util.Scanner;

public class App {

    static Scanner sc = new Scanner(System.in);


    public static void menuInterno() {
        int option = -1;
        do {
            System.out.printf("------------------------------------%n");
            System.out.printf("     Bienvenido a la Biblioteca     %n");
            System.out.printf("                 Menu               %n");
            System.out.printf("------------------------------------%n");
            System.out.printf("  1.   Registrar usuario            %n");
            System.out.printf("  2.   Libros prestados por usuario %n");
            System.out.printf("  3.   Registrar libro              %n");
            System.out.printf("  4.   Listar libros                %n");
            System.out.printf("  5.   prestar libro                %n");
            System.out.printf("  6.   Salir                        %n");
            System.out.print("   Porfavor ingrese una opcion:  ");
            option = sc.nextInt();
            processOption(option);

        }while(option != 7);
    }

    public static void processOption(int option){

    }

    public static void main(String[] args) {

        menuInterno();
    }
}
