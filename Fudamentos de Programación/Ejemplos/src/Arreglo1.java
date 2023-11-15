public class Arreglo1 {
    public static double sumar(double[] datos) {
        double suma = 0;
        for (double dato : datos) {
            suma += dato;
        }
        return suma;
    }

    public static void main(String[] args) {
        int cantidadEstudiantes;
        double promedio;
        double[] notas = null;

        cantidadEstudiantes = Utils.leerEntero("\nDigite la candidad de estudiantes: ");
        notas = new double[cantidadEstudiantes];

        for (int i = 0; i < notas.length; i++) {
            notas[i] = Utils.leerDoble("Digite la nota del estudiante " + (i + 1) + ":");
        }
        promedio = sumar(notas) / notas.length;

        System.out.printf("El promedio de notas de los %d estudiandes es %.2f\n", notas.length, promedio);
    }
}
