package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.logic.PropiedadGestor;
import cr.ac.ucenfotec.ui.UI;

public class Controller {

    private UI interfaz;
    private PropiedadGestor gestorProp;

    public Controller(){
        interfaz = new UI();
        gestorProp = new PropiedadGestor();
    }

    public void start() {
        int opcion = -1;
        do{
            interfaz.mostrarMenu();
            opcion = interfaz.leerNumero();
            procesarOpcion(opcion);
        }while(opcion != 0);
    }

    public void procesarOpcion(int pOpcion) {
        switch(pOpcion){
            case 1:
                registrarPropiedad();
                break;
            case 2:
                listarPropiedades();
                break;
            case 3:
                registrarInquilino();
                break;
            case 4:
                listarInquilinos();
                break;
            case 5:
                agregarInquilinoAPropiedad();
                break;
            case 6:
                asignarDimensionesAPropiedad();
                break;
            case 0:
                interfaz.imprimirMensaje("Adiós");
                break;
            default:
                interfaz.imprimirMensaje("Opción inválida");
        }
    }

    public void registrarPropiedad(){
        interfaz.imprimirMensaje("Digite el N° de finca: ");
        int numFinca = interfaz.leerNumero();
        interfaz.imprimirMensaje("Digite el nombre de la propiedad: ");
        String nombre = interfaz.leerTexto();
        interfaz.imprimirMensaje("Digite la cantidad de cuartos: ");
        int cuartos = interfaz.leerNumero();
        interfaz.imprimirMensaje("Digite la provincia: ");
        String provincia = interfaz.leerTexto();
        interfaz.imprimirMensaje("Digite el costo: ");
        double costo = interfaz.leerDecimales();

        String mensaje = gestorProp.registrarPropiedad(numFinca,nombre,cuartos,provincia,costo);
        interfaz.imprimirMensaje(mensaje);
    }

    public void listarPropiedades(){
        for (String infoPropiedad:gestorProp.listarPropiedades()) {
            interfaz.imprimirMensaje(infoPropiedad);
        }
    }

    public void registrarInquilino(){}

    public void listarInquilinos(){}

    public void agregarInquilinoAPropiedad(){}

    public void asignarDimensionesAPropiedad(){}
}
