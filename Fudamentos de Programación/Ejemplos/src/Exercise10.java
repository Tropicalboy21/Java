public class Exercise10 {
    public static void main(String[] args) {
        String nombre;
        String apellido;
        int edad;
        double notaMedia;

        nombre = Utils.leerString("\nPorfavor ingrese su nombre ");

        apellido = Utils.leerString("\nPorfavor ingrese su apellido: ");

        edad = Utils.leerEntero("\nPorfavor ingrese su edad: ");

        notaMedia = Utils.leerDoble("\nPorfavor ingrese la nota media: ");

        System.out.println("\nEl estudiante " + nombre + " " + apellido + ", de " + edad
                + " años de edad tiene una nota media de " + notaMedia);

    }
}
