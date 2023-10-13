public class Ejemplo13 {
    public static void main(String[] args) {
        int cantidad;
        double total = 0, promedio, nota;
        String estado;

        cantidad = Utils.leerEntero("Digite la cantidad de exámenes: ");

        for (int i = 0; i < cantidad; i++) {
            nota = Utils.leerDoble("Digite el examen N." + (i + 1));
            total += nota;
        
        }

        promedio = total /cantidad;

        if(promedio >= 70){
            estado = "Aprobado";
        } else if(promedio >= 60){
            estado = "Ampliación";
        } else {
            estado = "Reprobado";
        }

        System.out.println("Su estado " + estado + " su promedio es " + promedio);
    }
}
