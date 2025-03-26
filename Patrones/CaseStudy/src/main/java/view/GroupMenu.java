package view;

import controller.CourseController;
import controller.GroupController;
import model.Course;
import model.Group;

import java.util.Scanner;

public class GroupMenu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final GroupController groupController = new GroupController();

    public static void gruposMenu() {
        int option;
        do {
            showMenu();
            option = getUserInput();

            switch (option) {
                case 1 -> showGroups();
                case 2 -> addGroup();
                case 3 -> updateGroup();
                case 4 -> deleteGroup();
                case 5 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (option != 5);
    }

    private static void showMenu() {
        System.out.println("\n--- Grupos ---");
        System.out.println("1 - Mostrar datos");
        System.out.println("2 - Agregar datos");
        System.out.println("3 - Actualizar datos");
        System.out.println("4 - Eliminar Grupo");
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


    private static void showGroups() {
        System.out.println("Lista de grupos:");
        groupController.getGroup();
    }

    private static void addGroup() {
        System.out.println("Ingrese los datos del grupo");
        System.out.println("Ingrese el nombre del grupo");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese su descripción");
        String descripcion = scanner.nextLine();

        groupController.addGroup(nombre, descripcion, true);
    }

    private static void updateGroup() {
        showGroups();

        System.out.print("Ingrese el ID del grupo que desea actualizar: ");
        int cursoId = getUserInput();

        Group grupoActual = groupController.getGroupById(cursoId);
        if (grupoActual == null) {
            System.err.println("No se encontró el grupo con el ID proporcionado.");
            return;
        }

        System.out.println("Presione Enter para mantener el valor actual.");

        System.out.print("Nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();

        System.out.print("Nueva descripción: ");
        String nuevaDescripcion = scanner.nextLine();

        System.out.print("estado (activo o inactivo): ");
        String nuevaEstado = scanner.nextLine();
        boolean estadoActualizado = true;

        if(nuevaEstado.equalsIgnoreCase("inactivo")){
            estadoActualizado = false;
        }

        if (grupoActual != null) {
            Group groupUpdated = new Group(
                    cursoId,
                    nuevoNombre.isEmpty() ? grupoActual.getName() : nuevoNombre,
                    nuevaDescripcion.isEmpty() ? grupoActual.getDescription() : nuevaDescripcion,
                    nuevaEstado.isEmpty() ? grupoActual.getStatus(): estadoActualizado
            );
            groupController.updateGroup(groupUpdated);
        } else {
            System.err.println("No se pudo encontrar el grupo con el ID proporcionado.");
        }
    }

    private static void deleteGroup() {
        showGroups();

        System.out.print("Ingrese el ID del grupo que desea eliminar: ");
        int idToDelete = getUserInput();

        groupController.deleteGroup(idToDelete);
        System.out.println("Grupo eliminado exitosamente.");
    }

}
