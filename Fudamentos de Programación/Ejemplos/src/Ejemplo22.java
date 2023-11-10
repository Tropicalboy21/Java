public class Ejemplo22 {
    public static void main(String[] args) {
        int victorias1 = 0;
        int victorias2 = 0;

        for (int i = 0; i < 2; i++) {

            String usuarioUno = Utils.leerString("\nUsuario uno : piedra, papel o tijera? ");

            String usuarioDos = Utils.leerString("\nUsuario dos : piedra, papel o tijera? ");

            if (usuarioUno == "tijera" && usuarioDos == "papel" || usuarioUno == "papel" && usuarioDos == "piedra"
                    || usuarioUno == "piedra" && usuarioDos == "tijera") {
                victorias1 = victorias1 + 1;
            } else if (usuarioUno == "papel" && usuarioDos == "tijera"
                    || usuarioUno == "piedra" && usuarioDos == "papel"
                    || usuarioUno == "tijera" && usuarioDos == "piedra") {
                victorias2 = victorias2 + 1;
            }

            if (usuarioUno == "piedra" && usuarioDos == "piedra") {
                victorias1 = victorias1 + 0;
                victorias2 = victorias2 + 0;
            } else if (usuarioUno == "papel" && usuarioDos == "papel") {
                victorias1 = victorias1 + 0;
                victorias2 = victorias2 + 0;
            } else if (usuarioUno == "tijera" && usuarioDos == "tijera") {
                victorias1 = victorias1 + 0;
                victorias2 = victorias2 + 0;
            }
        }

        if (victorias1 == 3 && victorias2 == 2) {
            System.out.println("el ganador es el usuario uno");
        } else if (victorias1 == 2 && victorias2 == 3) {
            System.out.println("el ganador es el usuario dos");
        } else if (victorias1 == 2.5 && victorias2 == 2.5) {
            System.out.println("Es un Empate");
        }

        System.out.println(victorias1);
        System.out.println(victorias2);
    }

}
