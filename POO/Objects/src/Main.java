//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Galleta galleta1 = new Galleta();

        galleta1.nombre = "oreo";
        galleta1.color = "negro/blanco";
        galleta1.sabor = " chocolate";
        galleta1.relleno = "crema";
        galleta1.precio =850;

        Galleta galleta2 = new Galleta();
        galleta2.nombre = "sponge";

        System.out.println("Nombre de la Galleta numero 1: " + galleta1.nombre);
        System.out.println("Nombre de la Galleta numero 1: " + galleta2.nombre);


    }
}