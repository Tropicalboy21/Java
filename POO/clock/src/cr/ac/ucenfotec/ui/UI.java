package cr.ac.ucenfotec.ui;

import cr.ac.ucenfotec.bl.CL;

import java.util.*;


public class UI {

    static CL gestor = new CL();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        int opcion = -1;
        do {
            System.out.println("\nRegistro de entradas y salidas.");
            System.out.println("----- Menu -----");
            System.out.println("1. Registrar empleado");
            System.out.println("2. Listar empleados");
            System.out.println("3. Buscar Empleado por identificación");
            System.out.println("4. Salir");
            System.out.print("ingrese una opción: ");
            opcion = sc.nextInt();
            procesarOpcion(opcion);
        }while(opcion != 3);
    }

    public static void procesarOpcion(int opcion) {
        switch(opcion){
            case 1 : registrarEmpleado();
                break;
            case 2 : listarEmpleados();
                break;
            case 3 : buscarEmpleado();
                break;
            case 4 :
                System.out.println("gracias por su visita");
                break;
            default:
                System.out.println("opcion invalida");
        }
    }

    public static void registrarEmpleado(){


        System.out.println("Porfavor ingrese el nombre del empleado: ");
        String nombreIn = sc.next();

        System.out.println("Porfavor ingrese la identificación del empleado: ");
        String identificacionIn = sc.next();

        System.out.println("Porfavor ingrese un genero F. Femenino, M. Masculino, O. No decir : ");
        String generoIn = sc.next();

        System.out.println("Porfavor ingrese la edad: ");
        String edadIn = sc.next();

        System.out.println("Porfavor ingrese la posición de trabajo: ");
        String puestoIn = sc.next();

        String mensaje = gestor.registrarEmpleado(nombreIn, identificacionIn, generoIn, edadIn, puestoIn);

        System.out.println(mensaje);
    }
    public static void listarEmpleados(){
        System.out.println("*** Listado de empleados registrados ***");
        for (String infoEmpleadoTemp:gestor.listarEmpleados()) {
            System.out.println(infoEmpleadoTemp);
        }
    }

    public static void buscarEmpleado(){
        System.out.print("Por favor, digite la identificación del empleado: ");
        String identificacion = sc.next();

        String mensaje = gestor.buscarEmpleado(identificacion);
        System.out.println(mensaje);
    }


}