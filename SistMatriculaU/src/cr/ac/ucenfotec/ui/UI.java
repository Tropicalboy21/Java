package cr.ac.ucenfotec.ui;

import cr.ac.ucenfotec.bl.CL;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UI {

    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static CL gestor = new CL();

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
            case 3: //registrarCurso();
                break;
            case 4: //listarCursos();
                break;
            case 5: //agregarCursoACarrera();
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













}
