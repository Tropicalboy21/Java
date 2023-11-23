public class Ejemplo24 {
    public static double sumar(double[] datos) {
        double suma = 0;
        // for each
        for (double dato : datos) {
            suma += dato;
        }
        return suma;
    }

    public static void main(String[] args) {
        int cantidadEstudiante;
        double promedio;
        double[] notas = null;

        cantidadEstudiante = Utils.leerEntero("Digite la cantidad de estudadiantes: ");
        notas = new double[cantidadEstudiante];

        for (int i = 0; i < notas.length; i++) {
            notas[i] = Utils.leerDoble("Digite la nota del estudaintes " + (i + 1) + ": ");
        }

        promedio = sumar(notas) / notas.length;

        System.out.printf("El promedio de notas de los %d estudiantes es %.2f\n", notas.length, promedio);
    }
}
