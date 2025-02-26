package view;

import controller.CourseController;
import controller.GroupController;
import controller.ProfesorController;
import controller.StudentController;
import model.Course;
import model.Group;
import model.Profesor;
import model.Student;

import java.util.Scanner;

public class App {

    static ProfesorController profesorController = new ProfesorController();
    static StudentController studentController = new StudentController();
    static CourseController courseController = new CourseController();
    static GroupController groupController = new GroupController();

    static Scanner scann = new Scanner(System.in);

    public static void estudiantesMenu(){

        int option = -1;

        while(option != 5){
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

                    System.out.println("Ingrese su email");
                    String email = scann.nextLine();

                    System.out.println("Ingrese su fecha nacimiento");
                    String fechanacimiento = scann.nextLine();

                    System.out.println("Ingrese su carrera");
                    String carrera = scann.nextLine();

                    studentController.addStudent(nombre, apellidos, identificacion, email, fechanacimiento, carrera, true);
                    break;
                case 3:
                    System.out.println("Lista de profesores disponibles:");

                    // Get and display professors
                    studentController.getStudent();

                    System.out.println("Ingrese el ID del profesor que desea actualizar:");
                    int studentId = scann.nextInt();
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
                    Student estudianteActual = studentController.getStudentById(studentId);

                    if (estudianteActual != null) {
                        Student studentUpdated = new Student(
                                studentId,
                                nuevoNombre.isEmpty() ? estudianteActual.getName() : nuevoNombre,
                                nuevosApellidos.isEmpty() ? estudianteActual.getLastname() : nuevosApellidos,
                                nuevaIdentificacion.isEmpty() ? estudianteActual.getIdentification() : nuevaIdentificacion,
                                nuevoEmail.isEmpty() ? estudianteActual.getEmail() : nuevoEmail,
                                nuevaFechanacimiento.isEmpty() ? estudianteActual.getBirthdate() : nuevaFechanacimiento,
                                nuevoDepartamento.isEmpty() ? estudianteActual.getCareer() : nuevoDepartamento,
                                true
                        );
                        studentController.updateStudent(studentUpdated);
                    } else {
                        System.err.println("No se pudo encontrar el estudiante con el ID proporcionado.");
                    }

                    break;
                case 4:
                    System.out.println("Lista de estudiantes disponibles:");

                    // Get and display professors
                    studentController.getStudent();

                    System.out.println("Ingrese el ID del estudiante que desea eliminar:");
                    int idTodelete = scann.nextInt();
                    scann.nextLine();

                    studentController.deleteStudent(idTodelete);

                    break;
                case 5:
                    option = 5;
                    break;
                default:
                    System.out.println("No existe esta opcion.");
                    break;
            }
        }
    }

    public static void profesorMenu(){

        int option = -1;

        while(option != 5){
            System.out.println("--- Profesor ---");
            System.out.println("1 - mostrar datos");
            System.out.println("2 - agregar datos");
            System.out.println("3 - actualizar datos");
            System.out.println("4 - Eliminar profesor");
            System.out.println("5 - volver");

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
                        Profesor profesorUpdated = new Profesor(
                                profesorId,
                                nuevoNombre.isEmpty() ? profesorActual.getName() : nuevoNombre,
                                nuevosApellidos.isEmpty() ? profesorActual.getLastname() : nuevosApellidos,
                                nuevaIdentificacion.isEmpty() ? profesorActual.getIdentification() : nuevaIdentificacion,
                                nuevoEmail.isEmpty() ? profesorActual.getEmail() : nuevoEmail,
                                nuevaFechanacimiento.isEmpty() ? profesorActual.getBirthdate() : nuevaFechanacimiento,
                                nuevoDepartamento.isEmpty() ? profesorActual.getDepartment() : nuevoDepartamento,
                                true
                        );
                        profesorController.updateProfesor(profesorUpdated);
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
                case 5:
                    option = 5;
                    break;
                default:
                    System.out.println("No existe esta opcion.");
                    break;
            }
        }
    }

    public static void cursosMenu(){

        int option = -1;

        while(option != 5){
            System.out.println("--- Cursos ---");
            System.out.println("1 - mostrar datos");
            System.out.println("2 - agregar datos");
            System.out.println("3 - actualizar datos");
            System.out.println("4 - Eliminar Curso");
            System.out.println("5 - volver");

            System.out.println("\nIngrese su opcion");
            int opcionDigitada = scann.nextInt();
            scann.nextLine();


            switch (opcionDigitada){

                case 1:
                    System.out.println("Lista de cursos");
                    courseController.getCourse();
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del Curso");
                    String nombre = scann.nextLine();

                    System.out.println("Ingrese su descripción");
                    String descripcion = scann.nextLine();

                    courseController.addCourse(nombre, descripcion, true);
                    break;
                case 3:
                    System.out.println("Lista de cursos disponibles:");

                    // Get and display professors
                    courseController.getCourse();

                    System.out.println("Ingrese el ID del curso que desea actualizar (o presione Enter para no cambiar):");
                    int cursoId = scann.nextInt();
                    scann.nextLine(); // Consume newline

                    System.out.println("Ingrese el nombre del Curso (o presione Enter para no cambiar):");
                    String nuevoNombre = scann.nextLine();

                    System.out.println("Ingrese su descripción (o presione Enter para no cambiar):" );
                    String nuevaDescripcion = scann.nextLine();

                    // Retrieve the current professor info
                    Course cursoActual = courseController.getStudentById(cursoId);

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

                    break;
                case 4:
                    System.out.println("Lista de cursos disponibles:");

                    // Get and display professors
                    courseController.getCourse();

                    System.out.println("Ingrese el ID del curso que desea eliminar:");
                    int idTodelete = scann.nextInt();
                    scann.nextLine();

                    courseController.deleteCourse(idTodelete);

                    break;
                case 5:
                    option = 5;
                    break;
                default:
                    System.out.println("No existe esta opcion.");
                    break;
            }
        }
    }

    public static void gruposMenu(){
        int option = -1;

        while(option != 5) {
            System.out.println("--- Grupos ---");
            System.out.println("1 - mostrar datos");
            System.out.println("2 - agregar datos");
            System.out.println("3 - actualizar datos");
            System.out.println("4 - eliminar Grupo");
            System.out.println("5 - volver");

            System.out.println("\nIngrese su opcion");
            int opcionDigitada = scann.nextInt();
            scann.nextLine();


            switch (opcionDigitada) {

                case 1:
                    System.out.println("Lista de grupos");
                    groupController.getGroup();
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del Grupo");
                    String nombre = scann.nextLine();

                    System.out.println("Ingrese su descripción");
                    String descripcion = scann.nextLine();

                    groupController.addGroup(nombre, descripcion, true);
                    break;
                case 3:
                    System.out.println("Lista de grupos disponibles:");

                    // Get and display professors
                    groupController.getGroup();

                    System.out.println("Ingrese el ID del grupo que desea actualizar:");
                    int groupId = scann.nextInt();
                    scann.nextLine(); // Consume newline

                    System.out.println("Ingrese el nombre del grupo (o presione Enter para no cambiar):");
                    String nuevoNombre = scann.nextLine();

                    System.out.println("Ingrese su descripción (o presione Enter para no cambiar):");
                    String nuevaDescripcion = scann.nextLine();

                    // Retrieve the current professor info
                    Group grupoActual = groupController.getGroupById(groupId);

                    if (grupoActual != null) {
                        Group groupUpdated = new Group(
                                groupId,
                                nuevoNombre.isEmpty() ? grupoActual.getName() : nuevoNombre,
                                nuevaDescripcion.isEmpty() ? grupoActual.getDescription() : nuevaDescripcion,
                                true
                        );
                        groupController.updateGroup(groupUpdated);
                    } else {
                        System.err.println("No se pudo encontrar el grupo con el ID proporcionado.");
                    }

                    break;
                case 4:
                    System.out.println("Lista de grupo disponibles:");

                    // Get and display professors
                    groupController.getGroup();

                    System.out.println("Ingrese el ID del grupo que desea eliminar:");
                    int idTodelete = scann.nextInt();
                    scann.nextLine();

                    groupController.deleteGroup(idTodelete);

                    break;
                case 5:
                    option = 5;
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
            System.out.println("5 - Salir");


            System.out.println("\nIngrese su opcion");
            int opcionDigitada = scann.nextInt();
            scann.nextLine();

            switch (opcionDigitada){
                case 1:
                    estudiantesMenu();
                    break;
                case 2:
                    profesorMenu();
                    break;
                case 3:
                    cursosMenu();
                    break;
                case 4:
                    gruposMenu();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("No existe esta opcion.");
                    break;
            }
        }
    }
}
