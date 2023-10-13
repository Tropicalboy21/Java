public class Ejemplo06 {
    public static void main(String[] args) {
        double result1, result2, result3;

        result1 = Utils.leerDoble("ingrese el resultado de el examen 1: ");

        result2 = Utils.leerDoble("ingrese el resultado de el examen 2: ");

        result3 = Utils.leerDoble("ingrese el resultado de el examen 3: ");

        double notaFinal = (result1 * 0.3 + result2 * 0.2 + result3 * 0.5);

        if (notaFinal >= 70) {
            System.out.println("\nNota final : " + notaFinal + "\nEstado: Aprovado");
        } else {
            System.out.println("\nNota final : " + notaFinal + "\nEstado: Reprovado");
        }

    }

}
