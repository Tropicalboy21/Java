import java.util.*;


public class Main {

    static int i = 0;

    static int tamanno = 10;

    static Empleado[] empleados = new Empleado[tamanno];

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        int opcion = -1;
        do {
            System.out.println("\nRegistro de entradas y salidas.");
            System.out.println("----- Menu -----");
            System.out.println("1. Registrar Empleado");
            System.out.println("2. Marcar entrada o salida");
            System.out.println("3. Listar empleados");
            System.out.println("4. Salir");
            System.out.println("ingrese una opción: ");
            opcion = sc.nextInt();
            procesarOpcion(opcion);
        }while(opcion != 4);
    }

    public static void procesarOpcion(int opcion) {
        switch(opcion){
            case 1 : registrarEmpleado();
                break;
            case 2 : hacerMarca();
                break;
            case 3 : listarEmpleados();
                break;
            case 4 :
                System.out.println("gracias por su visita");
                break;
            default:
                System.out.println("opcion invalida");
        }
    }

    public static void registrarEmpleado(){
        String nombreIn = "";
        String identificacionIn = "";
        String generoIn = "";
        String edadIn = "";
        String puestoIn = "";

        Empleado nuevoEmpleado = new Empleado();

        System.out.println("Porfavor ingrese el nombre del empleado: ");
        nombreIn = sc.next();

        System.out.println("Porfavor ingrese la identificación del empleado: ");
        identificacionIn = sc.next();

        System.out.println("Porfavor ingrese un genero F. Femenino, M. Masculino, O. No decir : ");
        generoIn = sc.next();

        System.out.println("Porfavor ingrese la edad: ");
        edadIn = sc.next();

        System.out.println("Porfavor ingrese la posición de trabajo: ");
        puestoIn = sc.next();


        nuevoEmpleado.nombre = nombreIn;
        nuevoEmpleado.identificacion = identificacionIn;
        nuevoEmpleado.genero = generoIn;
        nuevoEmpleado.edad = edadIn;
        nuevoEmpleado.puesto = puestoIn;

        empleados[i] = nuevoEmpleado;

        i++;


    }

    public static void hacerMarca() {

    }
    public static void listarEmpleados() {
        for (Empleado empleado : empleados) {
            if (empleado != null) {
                System.out.println("Nombre: " + empleado.nombre + ", Identificación: " + empleado.identificacion + ", genero: " + empleado.genero + ", edad: " + empleado.edad + ", puesto: " + empleado.puesto);
            }
        }

    }
}