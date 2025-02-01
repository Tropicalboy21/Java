import service.Library;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    static Scanner sc = new Scanner(System.in);
    static Library gestor = new Library();

    public static void menu() {
        int option = -1;
        do {
            System.out.printf("------------------------------------%n");
            System.out.printf("     Bienvenido a la Biblioteca     %n");
            System.out.printf("                 Menu               %n");
            System.out.printf("------------------------------------%n");
            System.out.printf("  1.   Listar libros                %n");
            System.out.printf("  2.   Libros prestados por usuario %n");
            System.out.printf("  3.   prestar libro                %n");
            System.out.printf("  4.   Registrar libro              %n");
            System.out.printf("  5.   Registrar usuario            %n");
            System.out.printf("  6.   listar usuarios              %n");
            System.out.printf("  7.   Salir                        %n");
            System.out.print("\n   Porfavor ingrese una opcion:  ");
            option = sc.nextInt();
            processOption(option);

        }while(option != 7);
    }

    public static void processOption(int option){
        switch (option){
            case 1:
                listarLibros();
                break;
            case 2:
                librosPrestadosPorUsuario();
                break;
            case 3:
                prestarLibro();
                break;
            case 4:
                registrarLibro();
                break;
            case 5:
                registrarUsuario();
                break;
            case 6:
                listarUsuarios();
                break;
            case 7:
                System.out.printf("---------------------------------%n");
                System.out.printf("     Gracias por su visita       %n");
                System.out.printf("         vuelva pronto           %n");
                System.out.printf("---------------------------------%n");
                break;
            default:
                System.out.println("opcion invalida");
        }
    }

    public static void listarLibros() {
        System.out.printf("---------------------------------%n");
        System.out.printf("      Collección de libros       %n");
        System.out.printf("---------------------------------%n");

        ArrayList<String> booksList = gestor.showBooks();
        if (booksList.isEmpty()) {
            System.out.printf("      No Hay Libros       %n");
        } else {
            for (String books : booksList) {
                System.out.println(books);
            }
        }
    }
    public static void librosPrestadosPorUsuario(){
        System.out.printf("---------------------------------%n");
        System.out.printf("  libros prestados por usuario   %n");
        System.out.printf("---------------------------------%n");
        System.out.print("Digite un nombre de usuario: ");
        String userName =  sc.next();

        Object userFound = gestor.searchUser(userName);

        if(userFound != null){
            String borrowedBooks = gestor.showBorrowBooksByUser(userName);
            System.out.println(borrowedBooks);
        } else {
            System.out.println("Lo sentimos usuario no existe.");
        }
    }
    public static void prestarLibro(){
        System.out.printf("---------------------------------%n");
        System.out.printf("         Prestar libro           %n");
        System.out.printf("---------------------------------%n");
        System.out.print("Digite un nombre de usuario: ");
        String userName =  sc.next();

        Object userFound = gestor.searchUser(userName);

        if(userFound != null){
            System.out.print("Digite el nombre del libro que desea prestar: ");
            String bookName =  sc.next();

            Object bookFound = gestor.searchBook(bookName);

            if(bookFound != null) {
                String msj = gestor.borrowBook(bookName, userName);
                System.out.println(msj);
            } else {
                System.out.println("Lo sentimos libro no existe.");
            }
        } else {
            System.out.println("Lo sentimos usuario no existe.");
        }

    }
    public static void registrarLibro(){
        System.out.printf("---------------------------------%n");
        System.out.printf("     Registrar nuevo libro       %n");
        System.out.printf("---------------------------------%n");

        System.out.print("Ingrese el titulo :      ");
        String title = sc.next();

        System.out.print("Ingrese el autor: ");
        String author = sc.next();

        System.out.print("Ingrese el categoria: ");
        String category = sc.next();

        boolean availability = true;


        String msj = gestor.addBook(title,author, category, availability);
        System.out.println(msj);
        menu();
    }
    public static void registrarUsuario(){
        System.out.printf("---------------------------------%n");
        System.out.printf("     Registrar nuevo usuario     %n");
        System.out.printf("---------------------------------%n");

        System.out.print("Ingrese el nombre :      ");
        String name = sc.next();

        System.out.print("Ingrese la identificación: ");
        String id = sc.next();

        String msj = gestor.addUser(name , id);
        System.out.println(msj);
        menu();
    }
    public static void listarUsuarios(){
        System.out.printf("---------------------------------%n");
        System.out.printf("      Usuarios Registrados       %n");
        System.out.printf("---------------------------------%n");

        ArrayList<String> userList = gestor.showUsers();
        if (userList.isEmpty()) {
            System.out.printf("      No hay usuarios       %n");
        } else {
            for (String users : userList) {
                System.out.println(users);
            }
        }
    }
    public static void main(String[] args) {
        menu();
    }
}
