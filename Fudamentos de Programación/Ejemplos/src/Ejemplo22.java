public class Ejemplo22 {
    public static void main(String[] args) {

        double victorias1 = 0;
        double victorias2 = 0;

        for (int i = 0; i < 5; i++) {

            String usuarioUno = Utils.leerString("\nUsuario uno : piedra, papel o tijera? ");

            String usuarioDos = Utils.leerString("\nUsuario dos : piedra, papel o tijera? ");

            if (usuarioUno == "tijeras" && usuarioDos == "papel") {
                victorias1 += 1;
            } else if (usuarioUno == "papel" && usuarioDos == "tijera") {
                victorias2 += 1;
            }

            if (usuarioUno == "papel" && usuarioDos == "piedra") {
                victorias1 += 1;
            } else if (usuarioUno == "pidra" && usuarioDos == "papel") {
                victorias2 += 1;
            }

            if (usuarioUno == "piedra" && usuarioDos == "tijeras") {
                victorias1 += 1;
            } else if (usuarioUno == "tijeras" && usuarioDos == "piedra") {
                victorias2 += 1;
            }

            if (usuarioUno == "piedra" && usuarioDos == "piedra") {
                victorias1 += 0.5;
            } else if (usuarioUno == "papel" && usuarioDos == "papel") {
                victorias2 += 0.5;
            } else if (usuarioUno == "tijeras" && usuarioDos == "tijeras") {
                victorias2 += 0.5;
            }
        }

        if (victorias1 == 3 && victorias2 == 2) {
            System.out.println("el ganador es el usuario uno");
        } else if (victorias1 == 2 && victorias2 == 3) {
            System.out.println("el ganador es el usuario dos");
        } else if (victorias1 == 2.5 && victorias2 == 2.5) {
            System.out.println("Es un Empate");
        }
    }
}
