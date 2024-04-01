package ucenfotec.ac.cr.tl;

import ucenfotec.ac.cr.bl.logic.CasaGestor;
import ucenfotec.ac.cr.bl.logic.VecinoGestor;
import ucenfotec.ac.cr.ui.UI;

import java.time.LocalDate;

public class Controller {
    private UI interfaz;
    private CasaGestor casaGestor;
    private VecinoGestor vecinoGestor;

    public Controller(){
        interfaz  = new UI();
        casaGestor = new CasaGestor();
        vecinoGestor = new VecinoGestor();
    }

    public void start() {

        // Instancia de Casa #1
        String direccionC1 = "Pavas";
        String idetificacionC1 = "C124";

        casaGestor.registrarCasa(direccionC1, idetificacionC1);

        // Instancia de Casa #2
        String direccionC2 = "Alajuelita";
        String idetificacionC2 = "A024";

        casaGestor.registrarCasa(direccionC2, idetificacionC2);


        // Instancia de Vecino #1
        String nombreV1 = "Joshua";

        String apellidoV1 = "Hernan";

        String identificacionV1 = "604590182";

        String nacimientoV1 = "1983-03-22";

        LocalDate dob = LocalDate.parse(nacimientoV1);

        int edadV1 = vecinoGestor.calcularEdad(dob);


        String generoV1 = "Masculino";

        String telefonoV1 = "61016510";

        int encargadoV1 = 1;
        boolean encargado = false;

        if(encargadoV1 == 1 ) {
            encargado = true;
        }

        vecinoGestor.registrarVecino(nombreV1, apellidoV1,  identificacionV1 , nacimientoV1,  edadV1, generoV1, telefonoV1, encargado);

        // Instancia de Vecino #2
        String nombreV2 = "Lucas";

        String apellidoV2 = "Dali";

        String identificacionV2 = "104520162";

        String nacimientoV2 = "1992-11-12";

        LocalDate dom = LocalDate.parse(nacimientoV2);

        int edadV2 = vecinoGestor.calcularEdad(dom);

        String generoV2 = "Masculino";

        String telefonoV2 = "61016510";

        int encargadoV2 = 1;

        if(encargadoV2 == 1 ) {
            encargado = true;
        }

        vecinoGestor.registrarVecino(nombreV2, apellidoV2,  identificacionV2 , nacimientoV2,  edadV2, generoV2, telefonoV2, encargado);


        int opcion = -1;
        do{
            interfaz.mostrarMenu();
            opcion = interfaz.leerNumero();
            procesarOpcion(opcion);
        }while(opcion != 6);
    }

    public void procesarOpcion(int pOpcion){
        switch (pOpcion){
            case 1:
                registrarCasa();
                break;
            case 2:
                listarCasas();
                break;
            case 3:
                registrarVecino();
                break;
            case 4:
                listarVecinos();
                break;
            case 5:
                agregarVecinoCasa();
                break;
            case 6:
                interfaz.imprimirMensaje("Gracias por su visita ");
                interfaz.imprimirMensaje("    vuelva pronto     ");
                break;
            default:
                interfaz.imprimirMensaje("Opción inválida");
        }
    }

    public void registrarCasa() {
        System.out.printf("---------------------------------%n");
        System.out.print("Ingrese la direccion:      ");
        String direccionIn = interfaz.leerTexto();

        System.out.print("Ingrese la identificación: ");
        String identificacionIn = interfaz.leerTexto();

        String mensaje = casaGestor.registrarCasa(direccionIn, identificacionIn);

        interfaz.imprimirMensaje(mensaje);
    }

    public void listarCasas() {
        System.out.printf("---------------------------------%n");
        System.out.printf("    informacion de las casas     %n");
        System.out.printf("---------------------------------%n");
        for (String infoCasas: casaGestor.listarCasas()){
            System.out.println(infoCasas);
        }
    }
    public void registrarVecino() {
        System.out.printf("---------------------------------%n");
        System.out.print("Ingrese el nombre:      ");
        String nombreIn = interfaz.leerTexto();

        System.out.print("Ingrese el apellido:    ");
        String apellidosIn = interfaz.leerTexto();

        System.out.print("Ingrese la identificación: ");
        String identificacionIn = interfaz.leerTexto();

        System.out.print("Ingrese fecha de nacimiento  YYYY-MM-DD: ");
        String nacimientoIn = interfaz.leerTexto();

        int edad = nacimientoIn.length();

        System.out.print("Porfavor ingrese la genero: ");
        String generoIn = interfaz.leerTexto();

        System.out.print("Porfavor ingrese su numero de telefono: ");
        String telefonoIn = interfaz.leerTexto();

        System.out.print("¿Desea ser encargado de seguridad? digite 1. Si 2. NO: ");
        int encargadoIn = interfaz.leerNumero();

        boolean encargado = false;

        if(encargadoIn == 1 ) {
            encargado = true;
        }

        String mensaje = vecinoGestor.registrarVecino(nombreIn, apellidosIn,  identificacionIn, nacimientoIn, edad,  generoIn, telefonoIn, encargado);

        interfaz.imprimirMensaje(mensaje);

    }

    public void listarVecinos() {
        System.out.printf("---------------------------------%n");
        System.out.printf("   informacion de los vecinos    %n");
        System.out.printf("---------------------------------%n");
        for (String infoVecinos: vecinoGestor.listarVecinos()){
            System.out.println(infoVecinos);
        }
    }

    public void agregarVecinoCasa() {
        System.out.print("Digite la identificación de la Casa: ");
        String idCasa = interfaz.leerTexto();
        System.out.print("Digite la identificación del Vecino: ");
        String idVecino = interfaz.leerTexto();

        String mensaje = vecinoGestor.agregarVecinoCasa(idCasa,idVecino);
        System.out.println(mensaje);
    }

}
