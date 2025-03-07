package view;

import controller.ProfesorController;
import model.Profesor;


import java.util.Scanner;

public class ProfesorMenu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ProfesorController profesorController = new ProfesorController();

    public static void profesoresMenu() {
        int option;
        do {
            showMenu();
            option = getUserInput();

            switch (option) {
                case 1 -> showProfesors();
                case 2 -> addProfesor();
                case 3 -> updateProfesor();
                case 4 -> deleteProfesor();
                case 5 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (option != 5);
    }

    private static void showMenu() {
        System.out.println("\n--- Profesores ---");
        System.out.println("1 - Mostrar datos");
        System.out.println("2 - Agregar datos");
        System.out.println("3 - Actualizar datos");
        System.out.println("4 - Eliminar profesor");
        System.out.println("5 - Volver");
        System.out.print("\nIngrese su opción: ");
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

    private static void showProfesors() {
        System.out.println("Lista de profesores:");
        profesorController.getProfesor();
    }

    private static void addProfesor() {
        System.out.println("Ingrese los datos del profesor:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Identificación: ");
        String identificacion = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Fecha de nacimiento: ");
        String fechaNacimiento = scanner.nextLine();

        System.out.print("Departamento: ");
        String departamento = scanner.nextLine();

        profesorController.addProfesor(nombre, apellido, identificacion, email, fechaNacimiento, departamento, true);
        System.out.println("Profesor agregado exitosamente.");
    }

    private static void updateProfesor() {
        showProfesors();

        System.out.print("Ingrese el ID del profesor que desea actualizar: ");
        int profesorId = getUserInput();

        Profesor profesorActual = profesorController.getProfesorById(profesorId);
        if (profesorActual == null) {
            System.err.println("No se encontró el profesor con el ID proporcionado.");
            return;
        }

        System.out.println("Presione Enter para mantener el valor actual.");

        System.out.print("Nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();

        System.out.print("Nuevo apellido: ");
        String nuevosApellidos = scanner.nextLine();

        System.out.print("Nueva identificación: ");
        String nuevaIdentificacion = scanner.nextLine();

        System.out.print("Nuevo email: ");
        String nuevoEmail = scanner.nextLine();

        System.out.print("Nueva fecha de nacimiento: ");
        String nuevaFechaNacimiento = scanner.nextLine();

        System.out.print("Nuevo departamento: ");
        String nuevaDepartamento = scanner.nextLine();

        Profesor profesorUpdated = new Profesor(
                profesorId,
                nuevoNombre.isEmpty() ? profesorActual.getName() : nuevoNombre,
                nuevosApellidos.isEmpty() ? profesorActual.getLastname() : nuevosApellidos,
                nuevaIdentificacion.isEmpty() ? profesorActual.getIdentification() : nuevaIdentificacion,
                nuevoEmail.isEmpty() ? profesorActual.getEmail() : nuevoEmail,
                nuevaFechaNacimiento.isEmpty() ? profesorActual.getBirthdate() : nuevaFechaNacimiento,
                nuevaDepartamento.isEmpty() ? profesorActual.getDepartment() : nuevaDepartamento,
                true
        );

        profesorController.updateProfesor(profesorUpdated);
        System.out.println("Profesor actualizado exitosamente.");
    }

    private static void deleteProfesor() {
        showProfesors();

        System.out.print("Ingrese el ID del profesor que desea eliminar: ");
        int idToDelete = getUserInput();

        profesorController.deleteProfesor(idToDelete);
        System.out.println("Profesor eliminado exitosamente.");
    }
}
