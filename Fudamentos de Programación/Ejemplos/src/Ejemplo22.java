public class Ejemplo22 {
    public static void main(String[] args) {
        double victorias1 = 0;
        double victorias2 = 0;
        int i = 0;

        while (i < 5) {

            String usuarioUno = Utils.leerString("\nUsuario uno : piedra, papel o tijera? ");

            String usuarioDos = Utils.leerString("\nUsuario dos : piedra, papel o tijera? ");

            System.out.println("\n-----------------------------------------------");

            if (usuarioUno.equals("tijera") && usuarioDos.equals("papel")
                    || usuarioUno.equals("papel") && usuarioDos.equals("piedra")
                    || usuarioUno.equals("piedra") && usuarioDos.equals("tijera")) {
                victorias1 = victorias1 + 1;
            }

            if (usuarioUno.equals("papel") && usuarioDos.equals("tijera")
                    || usuarioUno.equals("piedra") && usuarioDos.equals("papel")
                    || usuarioUno.equals("tijera") && usuarioDos.equals("piedra")) {
                victorias2 = victorias2 + 1;
            }

            if (usuarioUno.equals(usuarioDos)) {
                victorias1 = victorias1 + 0.5;
                victorias2 = victorias2 + 0.5;
            }

            i++;
        }

        if (victorias1 >= 3 && victorias2 <= 2) {
            System.out.println("el ganador es el usuario uno");
        } else if (victorias1 <= 2 && victorias2 >= 3) {
            System.out.println("el ganador es el usuario dos");
        } else if (victorias1 == 2.5 && victorias2 == 2.5) {
            System.out.println("Es un Empate");
        }
    }

}
