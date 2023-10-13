public class Exercise05 {
    public static void main(String[] args) {
        double salarioBruto, excedente;
        final double IMPUESTOS, LIMITE;

        LIMITE = 1000000;
        salarioBruto = Utils.leerDoble("Ingrese su salario bruto:");
        excedente = salarioBruto - LIMITE;
        IMPUESTOS = (excedente / 100) * 10;

        if (salarioBruto > LIMITE) {
            System.out.println("Salario neto: " + (salarioBruto - IMPUESTOS));
        } else {
            System.out.println("Salario neto: " + salarioBruto);
        }
    }
}
