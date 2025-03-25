package view;

import controller.StudentController;
import model.Student;

import java.util.Objects;
import java.util.Scanner;

public class StudentMenu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentController studentController = new StudentController();

    public static void estudiantesMenu() {
        int option;
        do {
            showMenu();
            option = getUserInput();

            switch (option) {
                case 1 -> showStudents();
                case 2 -> addStudent();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (option != 5);
    }

    private static void showMenu() {
        System.out.println("\n--- Estudiantes ---");
        System.out.println("1 - Mostrar datos");
        System.out.println("2 - Agregar datos");
        System.out.println("3 - Actualizar datos");
        System.out.println("4 - Eliminar estudiante");
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

    private static void showStudents() {
        System.out.println("Lista de estudiantes:");
        studentController.getStudent();
    }

    private static void addStudent() {
        System.out.println("Ingrese los datos del estudiante:");
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

        System.out.print("Carrera: ");
        String carrera = scanner.nextLine();

        studentController.addStudent(nombre, apellido, identificacion, email, fechaNacimiento, carrera, true);
        System.out.println("Estudiante agregado exitosamente.");
    }

    private static void updateStudent() {
        showStudents();

        System.out.print("Ingrese el ID del estudiante que desea actualizar: ");
        int studentId = getUserInput();

        Student estudianteActual = studentController.getStudentById(studentId);
        if (estudianteActual == null) {
            System.err.println("No se encontró el estudiante con el ID proporcionado.");
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

        System.out.print("Nueva carrera: ");
        String nuevaCarrera = scanner.nextLine();

        System.out.print("estado (activo o inactivo): ");
        String nuevaEstado = scanner.nextLine();
        boolean estadoActualizado = true;

        if(nuevaEstado.equalsIgnoreCase("inactivo")){
            estadoActualizado = false;
        }

        Student studentUpdated = new Student(
                studentId,
                nuevoNombre.isEmpty() ? estudianteActual.getName() : nuevoNombre,
                nuevosApellidos.isEmpty() ? estudianteActual.getLastname() : nuevosApellidos,
                nuevaIdentificacion.isEmpty() ? estudianteActual.getIdentification() : nuevaIdentificacion,
                nuevoEmail.isEmpty() ? estudianteActual.getEmail() : nuevoEmail,
                nuevaFechaNacimiento.isEmpty() ? estudianteActual.getBirthdate() : nuevaFechaNacimiento,
                nuevaCarrera.isEmpty() ? estudianteActual.getCareer() : nuevaCarrera,
                nuevaEstado.isEmpty() ? estudianteActual.getStatus(): estadoActualizado
        );

        studentController.updateStudent(studentUpdated);
        System.out.println("Estudiante actualizado exitosamente.");
    }

    private static void deleteStudent() {
        showStudents();

        System.out.print("Ingrese el ID del estudiante que desea eliminar: ");
        int idToDelete = getUserInput();

        studentController.deleteStudent(idToDelete);
        System.out.println("Estudiante eliminado exitosamente.");
    }
}
