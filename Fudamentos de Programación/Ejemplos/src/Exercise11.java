public class Exercise11 {
    public static void main(String[] args) {
        double kmXhr;
        double metrosXseg;

        kmXhr = Utils.leerEntero("\nPorfavor ingrese la velocidad en Km/h: ");

        metrosXseg = kmXhr * 1000 / 3600;

        System.out.println(
                "\nLa velocidad ingresada de " + kmXhr + " km/h\nes igual a la velocidad de " + metrosXseg + " m/s");

    }
}
