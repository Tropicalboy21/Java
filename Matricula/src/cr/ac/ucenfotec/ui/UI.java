package cr.ac.ucenfotec.ui;

import cr.ac.ucenfotec.bl.CL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UI {

    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static CL gestor = new CL();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) throws Exception{
        menu();
    }

    public static void menu() throws Exception{
        int opcion =0;
        do {
            System.out.println("**** Bienvenido al Sistema de Matricula ****");
            System.out.println("1. Registrar Carrera.");
            System.out.println("2. Listar Carreras.");
            System.out.println("3. Registrar un Curso.");
            System.out.println("4. Listar Cursos.");
            System.out.println("5. Agregar un curso a una carrera.");
            System.out.println("6. Crear un grupo dentro de un curso.");
            System.out.println("7. Registrar un profesor.");
            System.out.println("8. Listar profesores.");
            System.out.println("9. Agregar un profesor a un grupo de un curso.");
            System.out.println("0. Salir.");
            System.out.print("Por favor digite la opción: ");
            opcion = Integer.parseInt(in.readLine());
            procesarOpcion(opcion);
        }while(opcion!=0);
    }

    public static void procesarOpcion(int opcion) throws Exception{
        switch(opcion){
            case 1: registrarCarrera();
                    break;
            case 2: listarCarreras();
                break;
            case 3: registrarCurso();
                break;
            case 4: listarCursos();
                break;
            case 5: agregarCursoACarrera();
                break;
            case 6: crearGrupoEnCurso();
                break;
            case 7: registrarProfesor();
                break;
            case 8: listarProfesores();
                break;
            case 9: agregarProfesorAGrupo();
                break;
            case 0:
                System.out.println("Gracias por su visita!");
                break;
            default:
                System.out.println("Opción invalida!");
                break;
        }
    }

    public static void registrarCarrera() throws Exception{
        System.out.print("Digite el código de la carrera: ");
        String codigo = in.readLine();
        System.out.print("Digite el nombre de la carrera: ");
        String nombre = in.readLine();
        System.out.print("¿La carrera es acreditada? S-Sí, N->No: ");
        boolean esAcreditada = in.readLine().equals("S");

        String mensaje = gestor.registrarCarrera(codigo,nombre,esAcreditada);
        System.out.println(mensaje);
    }

    public static void listarCarreras() {
        for (String infoCarreraTemp :gestor.listarCarreras()) {
            System.out.println(infoCarreraTemp);
        }
    }

    public static void registrarCurso() throws Exception {
        System.out.print("Digite el codigo del curso: ");
        String codigo = in.readLine();
        System.out.print("Digite el nombre del curso: ");
        String nombre = in.readLine();
        System.out.print("Digite la cantidad de creditos del curso: ");
        int creditos = Integer.parseInt(in.readLine());
        System.out.print("Digite el costo del curso: ");
        double costo = Double.parseDouble(in.readLine());

        String mensaje = gestor.registrarCurso(codigo,nombre,creditos,costo);
        System.out.println(mensaje);
    }

    public static void listarCursos(){
        for (String infoCursoTemp:gestor.listarCursos()) {
            System.out.println(infoCursoTemp);
        }
    }

    public static void agregarCursoACarrera() throws Exception{
        System.out.print("Digite el código de la carrera: ");
        String codigoCarrera = in.readLine();
        System.out.print("Digite el código del curso: ");
        String codigoCurso = in.readLine();

        String mensaje = gestor.agregarCursoACarrera(codigoCarrera,codigoCurso);
        System.out.println(mensaje);
    }

    public static void crearGrupoEnCurso() throws Exception{
        System.out.print("Digite el código del curso: ");
        String codigoCurso = in.readLine();
        System.out.print("digite el número de grupo: ");
        int numGrupo = Integer.parseInt(in.readLine());
        System.out.print("digite el código de grupo: ");
        String codigoGrupo = in.readLine();

        String mensaje = gestor.crearGrupoEnCurso(codigoCurso,numGrupo,codigoGrupo);
        System.out.println(mensaje);
    }

    public static void registrarProfesor() throws Exception{
        System.out.print("digite la identificación del profesor: ");
        int identificacion = Integer.parseInt(in.readLine());
        System.out.print("digite el nombre del profesor: ");
        String nombre = in.readLine();
        System.out.print("digite la fecha de nacimiento del profesor (dd/MM/yyyy): ");
        LocalDate fechaNacimiento = LocalDate.parse(in.readLine(),formatter);
        System.out.print("digite el genero del profesor: ");
        String genero = in.readLine();
        System.out.print("digite la profesión del profesor: ");
        String profesion = in.readLine();

        String mensaje = gestor.registrarProfesor(identificacion,nombre,fechaNacimiento,genero,profesion);
    }

    public static void listarProfesores() throws Exception{

    }

    public static void agregarProfesorAGrupo() throws Exception{

    }




}
