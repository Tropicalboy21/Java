import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static int tamanio = 5;
    static Vehiculo[] listaVehiculos = new Vehiculo[tamanio];
    static int indice = 0;

    public static void main(String[] args) throws Exception {
        menu();
    }

    public static void menu() throws Exception {
        int opcion = -1;
        do {
            System.out.println("**** Bienvenido al sistema Ande a Pie ****");
            System.out.println("1. Registrar información del vehiculo.");
            System.out.println("2. Listar información de vehiculos registradas.");
            System.out.println("3. Salir.");
            System.out.print("Por favor digite una opción: ");
            opcion = Integer.parseInt(in.readLine());
            procesarOpcion(opcion);
        } while (opcion != 4);
    }

    public static void procesarOpcion(int opcion) throws Exception {
        switch (opcion) {
            case 1:
                registrarInfoVehiculo();
                break;
            case 2:
                listarInfoVehiculos();
                break;
            case 3:
                System.out.println("Gracias por su visita!");
            default:
                System.out.println("Opción invalida!");
        }
    }

    public static void registrarInfoVehiculo() throws Exception {
        System.out.print("Por favor, digite el nombre de la marca: ");
        String marca = in.readLine();
        System.out.print("Por favor, digite la cantidad de vehiculos: ");
        int cantidad = Integer.parseInt(in.readLine());
        System.out.print("Por favor, digite el nombre del contacto: ");
        String contacto = in.readLine();

        if (indice < listaVehiculos.length) {
            Vehiculo vehiculo = new Vehiculo();
            vehiculo.setMarca(marca);
            vehiculo.setCantidad(cantidad);
            vehiculo.setContacto(contacto);
            listaVehiculos[indice] = vehiculo;
            indice++;
            System.out.println("La marca " + vehiculo.getMarca() + ", fue registrada exitosamente!");
        } else {
            System.out.println("No hay espacio para almacenar más marcas!");
        }
    }

    public static void listarInfoVehiculos() throws Exception {
        System.out.println("*** Listado de información de vehiculos registrados ***");
        for (int pos = 0; pos < listaVehiculos.length; pos++) {
            if (listaVehiculos[pos] != null)
                System.out.println((pos + 1) + "-> " + listaVehiculos[pos].toString());
        }
    }

}
