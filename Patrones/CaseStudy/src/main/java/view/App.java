package view;

import controller.ProfesorController;
import controller.StudentController;
import model.Profesor;

import java.util.Scanner;

public class App {

    ProfesorController profesorController= new ProfesorController();
    StudentController studentController = new StudentController();

    static Scanner scann = new Scanner(System.in);

    public void estudiantesMenu(){

        while(true){
            System.out.println("--- Estudiantes ---");
            System.out.println("1 - mostrar datos");
            System.out.println("2 - agregar datos");
            System.out.println("3 - actualizar datos");
            System.out.println("4 - Eliminar estudiante");
            System.out.println("5 - volver");

            System.out.println("\nIngrese su opcion");
            int opcionDigitada = scann.nextInt();
            scann.nextLine();


            switch (opcionDigitada){

                case 1:
                    System.out.println("Lista de datos");
                    studentController.getStudent();
                    break;
                case 2:
                    System.out.println("Ingrese su nombre");
                    String nombre = scann.nextLine();

                    System.out.println("Ingrese su apellido");
                    String apellidos = scann.nextLine();

                    System.out.println("Ingrese su identificación");
                    String identificacion = scann.nextLine();

                    System.out.println("Ingrese su identificación");
                    String email = scann.nextLine();

                    System.out.println("Ingrese su fecha nacimiento");
                    String fechanacimiento = scann.nextLine();

                    System.out.println("Ingrese su carrera");
                    String carrera = scann.nextLine();

                    studentController.addStudent(nombre, apellidos, identificacion, email, fechanacimiento, carrera, true);
                    break;
                default:
                    System.out.println("No existe esta opcion.");
                    break;

            }

        }

    }


    public static void main(String[] args) {

        while(true){
            System.out.println("--- Sistema escolar ---");
            System.out.println("1 - Estudiantes");
            System.out.println("2 - Profesores");
            System.out.println("3 - Cursos");
            System.out.println("4 - Grupos");


            System.out.println("\nIngrese su opcion");
            int opcionDigitada = scann.nextInt();
            scann.nextLine();

            switch (opcionDigitada){
                case 1:
                    System.out.println("Lista de datos");
                    profesorController.getProfesor();
                    break;
                case 2:
                    System.out.println("Ingrese su nombre");
                    String nombre = scann.nextLine();

                    System.out.println("Ingrese su apellido");
                    String apellidos = scann.nextLine();

                    System.out.println("Ingrese su identificación");
                    String identificacion = scann.nextLine();

                    System.out.println("Ingrese su email");
                    String email = scann.nextLine();

                    System.out.println("Ingrese su fecha nacimiento");
                    String fechanacimiento = scann.nextLine();

                    System.out.println("Ingrese su departamento");
                    String departamento = scann.nextLine();

                    profesorController.addProfesor(nombre, apellidos, identificacion, email, fechanacimiento, departamento, true);
                    break;
                case 3:
                    System.out.println("Lista de profesores disponibles:");

                    // Get and display professors
                    profesorController.getProfesor();

                    System.out.println("Ingrese el ID del profesor que desea actualizar:");
                    int profesorId = scann.nextInt();
                    scann.nextLine(); // Consume newline

                    System.out.println("Ingrese su nombre (o presione Enter para no cambiar):");
                    String nuevoNombre = scann.nextLine();

                    System.out.println("Ingrese su apellido (o presione Enter para no cambiar):");
                    String nuevosApellidos = scann.nextLine();

                    System.out.println("Ingrese su identificación (o presione Enter para no cambiar):");
                    String nuevaIdentificacion = scann.nextLine();

                    System.out.println("Ingrese su email (o presione Enter para no cambiar):");
                    String nuevoEmail = scann.nextLine();

                    System.out.println("Ingrese su fecha de nacimiento (o presione Enter para no cambiar):");
                    String nuevaFechanacimiento = scann.nextLine();

                    System.out.println("Ingrese su departamento (o presione Enter para no cambiar):");
                    String nuevoDepartamento = scann.nextLine();

                    // Retrieve the current professor info
                    Profesor profesorActual = profesorController.getProfesorById(profesorId);

                    if (profesorActual != null) {
                        Profesor profesorActualizado = new Profesor(
                                profesorId,
                                nuevoNombre.isEmpty() ? profesorActual.getName() : nuevoNombre,
                                nuevosApellidos.isEmpty() ? profesorActual.getLastname() : nuevosApellidos,
                                nuevaIdentificacion.isEmpty() ? profesorActual.getIdentification() : nuevaIdentificacion,
                                nuevoEmail.isEmpty() ? profesorActual.getEmail() : nuevoEmail,
                                nuevaFechanacimiento.isEmpty() ? profesorActual.getBirthdate() : nuevaFechanacimiento,
                                nuevoDepartamento.isEmpty() ? profesorActual.getDepartment() : nuevoDepartamento,
                                true
                        );

                        profesorController.updateProfesor(profesorActualizado);
                    } else {
                        System.err.println("No se pudo encontrar el profesor con el ID proporcionado.");
                    }
                    break;
                case 4:
                    System.out.println("Lista de profesores disponibles:");

                    // Get and display professors
                    profesorController.getProfesor();

                    System.out.println("Ingrese el ID del profesor que desea eliminar:");
                    int idTodelete = scann.nextInt();
                    scann.nextLine();

                    profesorController.deleteProfesor(idTodelete);

                    break;
                default:
                    System.out.println("No existe esta opcion.");
                    break;
            }
        }
    }
}
