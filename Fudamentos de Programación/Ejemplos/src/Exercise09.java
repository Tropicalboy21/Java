public class Exercise09 {
    public static void main(String[] args) {
        double base;
        double altura;
        double perimetro;
        double area;

        base = Utils.leerDoble("\nPorfavor ingrese la base del rectangulo: ");

        altura = Utils.leerDoble("\nPorfavor ingrese la altura del rectangulo: ");

        perimetro = base + altura + base + altura;

        area = base * altura;

        System.out
                .println("\nEl rectangulo tiene las siguientes medidad\nArea: " + area + "\nPerimetro: " + perimetro);
    }
}
