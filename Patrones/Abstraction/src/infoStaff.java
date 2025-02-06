import Model.Employee;
import Model.EmployeeRepository;
import Service.EmployeeRepositoryImpl;

import java.util.Scanner;

public class infoStaff {

    static Scanner sc = new Scanner(System.in);
    static EmployeeRepository employeeRepo = new EmployeeRepositoryImpl();

    public static void menu() {
        int option = -1;
        do {
            System.out.printf("------------------------------------%n");
            System.out.printf("   INFORMACIÓN DE LOS EMPLIEADOS    %n");
            System.out.printf("                Menu                %n");
            System.out.printf("------------------------------------%n");
            System.out.printf("  1.   Agregar Empleado            %n");
            System.out.printf("  2.   Editar Empleado              %n");
            System.out.printf("  3.   Listar Empleados              %n");
            System.out.printf("  4.   Eliminar Empleado            %n");
            System.out.printf("  5.   Salir                        %n");
            System.out.print("\n   Porfavor ingrese una opción:  ");
            option = sc.nextInt();
            processOption(option);

        }while(option != 5);
    }

    public static void processOption(int option){
        switch (option){
            case 1:
                agregarEmpleado();
                break;
            case 2:
                editarEmpleado();
                break;
            case 3:
                listarEmpleados();
                break;
            case 4:
                eliminarEmpleado();
                break;
            case 5:
                System.out.printf("---------------------------------%n");
                System.out.printf("     Gracias por su visita       %n");
                System.out.printf("         vuelva pronto           %n");
                System.out.printf("---------------------------------%n");
                break;
            default:
                System.out.println("opcion invalida");
        }
    }

    public static void agregarEmpleado() {
        System.out.printf("---------------------------------%n");
        System.out.printf("    Registrar nuevo Empleado     %n");
        System.out.printf("---------------------------------%n");

        System.out.print("Ingrese el nombre :      ");
        String name = sc.next();

        System.out.print("Ingrese el apellido: ");
        String lastname = sc.next();

        System.out.print("Ingrese la posición: ");
        String position = sc.next();

        String msj =  employeeRepo.addEmployee(new Employee(name, lastname, position));
        System.out.println(msj);
        menu();
    }

    public static void editarEmpleado(){
        System.out.printf("---------------------------------%n");
        System.out.printf("         Editar Empleado         %n");
        System.out.printf("---------------------------------%n");
        System.out.print("Digite un nombre de empleado: ");
        String name =  sc.next();

        System.out.print("Ingrese el nuevo nombre :      ");
        String newName = sc.next();

        System.out.print("Ingrese el nuevo apellido: ");
        String newLastname = sc.next();

        System.out.print("Ingrese la nuevo posición: ");
        String newPosition = sc.next();


        String msj = employeeRepo.editEmployee(name, new Employee(newName, newLastname, newPosition));

        System.out.println(msj);
        menu();

    }

    public static void listarEmpleados(){
        System.out.println(employeeRepo.listEmployees());
    }

    public static void eliminarEmpleado(){
        System.out.printf("---------------------------------%n");
        System.out.printf("         Editar Empleado         %n");
        System.out.printf("---------------------------------%n");
        System.out.print("Digite un nombre de empleado: ");
        String name =  sc.next();

        String msj = employeeRepo.deleteEmployee(name);

        System.out.println(msj);
        menu();

    }


    public static void main(String[] args) {
        menu();
    }


}
