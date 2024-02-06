import java.util.*;

public class Main {

    static int tamanno = 5;

    static String[] marcas = new String[tamanno];

    static int[] cantidadAutos = new int[tamanno];

    static Scanner sc = new Scanner(System.in);

    static int i = 0;

    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        int opcion = -1;
        do {
            System.out.println("\nBienvenido a la agencia de carros NO ande a Pie");
            System.out.println("----- Menu -----");
            System.out.println("1. Registrar marca");
            System.out.println("2. Listar marcas");
            System.out.println("3. Registar cantidad de vehiculos");
            System.out.println("4. Salir");
            System.out.println("ingrese una opción: ");
            opcion = sc.nextInt();
            procesarOpcion(opcion);
        }while(opcion != 4);
    }

    public static void procesarOpcion(int opcion){
        switch (opcion) {
            case 1:
                registrarMarca();
                break;
            case 2:
                listarMarcas();
                break;
            case 3:
                listarMarcas();
                registrarCantidadVehiculos();
                break;
            case 4:
                System.out.println("gracias por su visita");
            default:
                System.out.println("opcion invalida");
        }
    }

    public static void registrarMarca(){
        System.out.println("ingrese la marca que desea registrar");
        String marca = sc.next();

        if(i < marcas.length){
            marcas[i] = marca;
            i++;
            System.out.println("la marca " +marca+ " , fue registrada con exito");
        } else {
            System.out.println("no hay mas espacio para registrar la marca");
        }
    }

    public static void listarMarcas(){
        System.out.println("***** Listado de marcas *****");
        for (int pos = 0; pos < marcas.length; pos++) {
            if( marcas[pos] != null){
                System.out.println((pos+1)+"." + marcas[pos] + "-> Cantidad de vehiculos : " + cantidadAutos[pos]);
            }

        }
    }

    public static void registrarCantidadVehiculos(){
        System.out.println("Seleccione la marca");
        String nomMarca = sc.next();

        int posicion = buscarMarca(nomMarca);

        if(posicion >= 0){
            System.out.println("Porfavor digite la cantidad de autos de la marca " + nomMarca + ":");
            int cantidad = sc.nextInt();
            cantidadAutos[posicion] = cantidad;

        } else {
            System.out.println("la marca digitada no existe");
        }

    }

    public static int buscarMarca(String nomMarca){
        for(int pos = 0; pos < marcas.length; pos++) {
            if(marcas[pos] != null && marcas[pos].equals(nomMarca)){
                return pos;
            }
        }
        return -1;
    }
}