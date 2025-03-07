package view;
import java.util.Scanner;

public class App {
    static CourseMenu cursosMenu = new CourseMenu();
    static StudentMenu studentMenu = new StudentMenu();
    static ProfesorMenu profesorMenu = new ProfesorMenu();
    static GroupMenu groupMenu = new GroupMenu();
    static Scanner scanner = new Scanner(System.in);

    public static void mainMenu(){
        int option;
        do {
            showMenu();
            option = getUserInput();

            switch (option) {
                case 1 -> studentMenu.estudiantesMenu();
                case 2 -> profesorMenu.profesoresMenu();
                case 3 -> cursosMenu.cursosMenu();
                case 4 -> groupMenu.gruposMenu();
                case 5 -> System.out.println("Hasta pronto!");
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (option != 5);
    }

    private static int getUserInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. Ingrese un número: ");
            scanner.next();
        }
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return option;
    }

    private static void showMenu() {
        System.out.println("\n--- Sistema escolar ---");
        System.out.println("1 - Estudiantes");
        System.out.println("2 - Profesores");
        System.out.println("3 - Cursos");
        System.out.println("4 - Grupos");
        System.out.println("5 - Salir");
        System.out.print("\nIngrese su opción: ");
    }

    public static void main(String[] args) {
        mainMenu();
    }
}
