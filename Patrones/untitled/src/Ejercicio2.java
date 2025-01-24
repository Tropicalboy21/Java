import java.util.Scanner;

import static java.lang.System.exit;

public class Ejercicio2 {
    static Scanner sc = new Scanner(System.in);
    static double balance = 0.00;

    public static void main(String[] args) {
        Account();
    }

    public static void Account(){
        int option = -1;

        do {
            System.out.println("\nTrasacciones de cuenta.");
            System.out.println("\nSaldo actual: ₡" + balance);
            System.out.println("\n----- Menu -----");
            System.out.println("1. Depósito");
            System.out.println("2. Retiro");
            System.out.println("3. Salir");
            System.out.print("ingrese una opción: ");
            option = sc.nextInt();
            processOption(option);
        } while (option != 3);
    }


    public static void processOption(int option){
        switch(option){
            case 1 : CashIn();
                break;
            case 2 : CashOut();
                break;
            case 3 :
                System.out.println("gracias por su visita");
                break;
            default:
                System.out.println("opcion invalida");
        }
    }


    public static void CashIn(){

        double amount = 0.00;
        int choice = 0;

        System.out.println("\nDeposito");
        System.out.println("\nPor favor ingrese el monto a depositar: ");
        amount = sc.nextInt();

        balance += amount;

        System.out.println("\nMonto Depositado con exito!");
        System.out.println("\nSaldo Actual: ₡" + balance);


        System.out.print("\nDesea realizar otra transacción? digite 1 para si y 2 para No: ");
        choice = sc.nextInt();

        if (choice == 2){
            System.out.println("gracias por su visita");
            System.exit(0);
        }

    }

    public static void CashOut(){
        double amount = 0.00;
        int choice = 0;

        System.out.println("\nRetiro");
        System.out.println("\nPor favor ingrese el monto a retirar: ");
        amount = sc.nextInt();

        if (amount <= balance) {
            balance -= amount;
            System.out.println("\nMonto retirado con exito!");
            System.out.println("\nSaldo Actual despues del retiro: ₡" + balance);

        } else {
            System.out.println("\nLo sentimos fondos insuficientes en la cuenta");
        }

        System.out.print("\nDesea realizar otra transacción? digite 1 para si y 2 para No: ");
        choice = sc.nextInt();

        if (choice == 2) {
            System.out.println("gracias por su visita");
            System.exit(0);
        }
    }
}
