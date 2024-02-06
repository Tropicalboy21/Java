import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prueba {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static int tamanio = 5;
    static String[] marcas = new String[tamanio];
    static int[] cantidadAutos = new int[tamanio];
    static int indice = 0;

    public static void main(String[] args) throws Exception{
        menu();
    }

    public static void menu() throws Exception {
        int opcion = -1;
        do {
            System.out.println("**** Bienvenido al sistema Ande a Pie ****");
            System.out.println("1. Registrar marca de automovil.");
            System.out.println("2. Listar marcas registradas.");
            System.out.println("3. Registrar cantidad de autos por marca.");
            System.out.println("4. Salir.");
            System.out.print("Por favor digite una opción: ");
            opcion = Integer.parseInt(in.readLine());
            procesarOpcion(opcion);
        }while (opcion!=4);
    }

    public static void procesarOpcion(int opcion) throws Exception{
        switch (opcion){
            case 1: registrarMarca();
                break;
            case 2: listarMarcas();
                break;
            case 3: listarMarcas();
                registrarCantidadAutosMarca();
                break;
            case 4:
                System.out.println("Gracias por su visita!");
            default:
                System.out.println("Opción invalida!");
        }
    }

    public static void registrarMarca() throws Exception{
        System.out.print("Por favor digite el nombre de la marca: ");
        String marca = in.readLine();

        if(indice < marcas.length) {
            marcas[indice] = marca;
            indice++;
            System.out.println("La marca " + marca + ", fue registrada exitosamente!");
        }else{
            System.out.println("No hay espacio para almacenar más marcas!");
        }
    }

    public static void listarMarcas() throws Exception{
        System.out.println("*** Listado de marcas registradas ***");
        for(int pos=0; pos < marcas.length ;pos++) {
            if(marcas[pos]!=null)
                System.out.println((pos +1) + ". "+marcas[pos] + "-> cantidad autos: " + cantidadAutos[pos]);
        }
    }

    public static void registrarCantidadAutosMarca() throws Exception{
        System.out.print("Por favor digite la marca: ");
        String marcaSeleccionada = in.readLine();
        int posicion = buscarMarca(marcaSeleccionada);

        if(posicion >= 0){
            System.out.print("Por favor digite la cantidad de autos de la marca " + marcaSeleccionada + ": ");
            int cantidad = Integer.parseInt(in.readLine());
            cantidadAutos[posicion] = cantidad;
        }else{
            System.out.println("La marca digitada no existe!");
        }
    }

    public static int buscarMarca(String marcaSeleccionada) throws Exception{
        for (int pos =0; pos < marcas.length;pos++) {
            if(marcas[pos]!=null && marcas[pos].equals(marcaSeleccionada))
                return pos;
        }
        return -1;
    }
}

