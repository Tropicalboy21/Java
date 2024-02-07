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


        Empleado nuevoEmpleado = new Empleado(nombreIn, identificacionIn, generoIn, edadIn, puestoIn);

        empleados[i] = nuevoEmpleado;

        i++;

    }
    public static void listarEmpleados(){

        System.out.println("\n***** Lista de empleados *****");
        for (int pos = 0; pos < empleados.length; pos++ ) {
            if (empleados[pos] != null) {
                System.out.println((pos + 1) +"." + empleados[pos].toString());
            }
        }

    }

    public static void buscarEmpleado() {
        System.out.print("Digite la identificación del usuario que desea registrar: ");
        String id = sc.next();

        Empleado empleadoBuscado = buscarEmpladoPorId(id);

        if(empleadoBuscado != null){
            System.out.println(empleadoBuscado);
        } else {
            System.out.println("No existe ningun empleado con la identificación " + id);
        }
    }

    public static Empleado buscarEmpladoPorId(String id){
        for (Empleado empleado: empleados){
            if(empleado != null && id.equals(empleado.getIdentificacion())){
                return empleado;
            }
        }
        return null;
    }


}