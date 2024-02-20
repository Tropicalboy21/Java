package cr.ac.ucenfotec.ui;

import cr.ac.ucenfotec.bl.Computadora;
import cr.ac.ucenfotec.bl.Empleado;

public class UI {

    public static void main(String[] args) {

        Empleado empleado1 = new Empleado(123,"Juanito");
        Empleado empleado2 = new Empleado(456,"Anita");
        Computadora computadora = new Computadora(1,"SAX-001","Dell");
        computadora.setResponsable(empleado1);

        Computadora computadora2 = new Computadora(2,"SAX-005","Asus",empleado2);

        System.out.println("Información de la computadora");
        System.out.println(computadora);
        System.out.println(computadora2);

        // Necesito imprimir el nombre del responsable de cada computadora
        System.out.println(computadora.getNombreResponsable());
        System.out.println(computadora2.getNombreResponsable());




    }
}
