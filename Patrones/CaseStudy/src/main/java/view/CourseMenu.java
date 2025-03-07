package view;

import controller.CourseController;
import controller.ProfesorController;
import model.Course;
import model.Profesor;

import java.util.Scanner;

public class CourseMenu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CourseController courseController = new CourseController();

    public static void cursosMenu() {
        int option;
        do {
            showMenu();
            option = getUserInput();

            switch (option) {
                case 1 -> showCourses();
                case 2 -> addCourse();
                case 3 -> updateCourse();
                case 4 -> deleteCourse();
                case 5 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (option != 5);
    }

    private static void showMenu() {
        System.out.println("\n--- Cursos ---");
        System.out.println("1 - Mostrar datos");
        System.out.println("2 - Agregar datos");
        System.out.println("3 - Actualizar datos");
        System.out.println("4 - Eliminar Curso");
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


    private static void showCourses() {
        System.out.println("Lista de cursos:");
        courseController.getCourse();
    }

    private static void addCourse() {
        System.out.println("Ingrese los datos del Curso");
        System.out.println("Ingrese el nombre del Curso");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese su descripción");
        String descripcion = scanner.nextLine();

        courseController.addCourse(nombre, descripcion, true);
    }

    private static void updateCourse() {
        showCourses();

        System.out.print("Ingrese el ID del curso que desea actualizar: ");
        int cursoId = getUserInput();

        Course cursoActual = courseController.getCourseById(cursoId);
        if (cursoActual == null) {
            System.err.println("No se encontró el curso con el ID proporcionado.");
            return;
        }

        System.out.println("Presione Enter para mantener el valor actual.");

        System.out.print("Nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();

        System.out.print("Nueva descripción: ");
        String nuevaDescripcion = scanner.nextLine();

        if (cursoActual != null) {
            Course courseUpdated = new Course(
                    cursoId,
                    nuevoNombre.isEmpty() ? cursoActual.getName() : nuevoNombre,
                    nuevaDescripcion.isEmpty() ? cursoActual.getDescription() : nuevaDescripcion,
                    true
            );
            courseController.updateCourse(courseUpdated);
        } else {
            System.err.println("No se pudo encontrar el curso con el ID proporcionado.");
        }
    }

    private static void deleteCourse() {
        showCourses();

        System.out.print("Ingrese el ID del curso que desea eliminar: ");
        int idToDelete = getUserInput();

        courseController.deleteCourse(idToDelete);
        System.out.println("Curso eliminado exitosamente.");
    }

}
