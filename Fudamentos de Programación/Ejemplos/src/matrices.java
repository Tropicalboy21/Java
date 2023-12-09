public class matrices {
    public static String[] obtenerFechaConCantidad(int[][] matriz, String[] etiquetas) {
        String[] fechas = null;
        int mayor = cantidadMayor(matriz);
        int cantidad = contarNumeroEnMatriz(matriz, mayor);
        fechas = new String[cantidad];
        int index = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (mayor == matriz[i][j]) {
                    fechas[index++] = String.format("%10s - %2d", etiquetas[i], j + 1);
                }
            }
        }

        return fechas;
    }

    public static int cantidadMayor(int[][] matriz) {
        int mayor = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                mayor = Math.max(mayor, matriz[i][j]);
            }
        }
        return mayor;
    }

    public static int contarNumeroEnMatriz(int[][] matriz, int numero) {
        int cantidad = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (numero == matriz[i][j]) {
                    cantidad++;
                }
            }
        }
        return cantidad;
    }

    public static void imprimir(int[][] matriz, String[] etiquetas) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.printf("%10s", etiquetas[i]);
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf(" %2d", matriz[i][j]);
            }
            System.out.println();
        }
    }

    public static void registrar(int[][] matriz, String[] etiquetas) {
        Utils.limpiarConsola();
        int mes = Utils.seleccionarElementoTexto("Seleccione su mes de cumpleaños", etiquetas) - 1;
        int diasDelMes = matriz[mes].length;
        int dia = Utils.leerRangosEnteros("Digite su día de nacimiento", 1, diasDelMes) - 1;

        matriz[mes][dia] = matriz[mes][dia] + 1;

    }

    public static void main(String[] args) {
        int[][] conteoPorFecha = new int[12][];
        conteoPorFecha[0] = new int[31];
        conteoPorFecha[1] = new int[28];
        conteoPorFecha[2] = new int[31];
        conteoPorFecha[3] = new int[30];
        conteoPorFecha[4] = new int[31];
        conteoPorFecha[5] = new int[30];
        conteoPorFecha[6] = new int[31];
        conteoPorFecha[7] = new int[31];
        conteoPorFecha[8] = new int[30];
        conteoPorFecha[9] = new int[31];
        conteoPorFecha[10] = new int[30];
        conteoPorFecha[11] = new int[31];

        String[] meses = new String[] { "Enero", "Febrero", "Marzo",
                "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Setiembre",
                "Octubre", "Noviembre", "Diciembre" };

        String[] opciones = { "Imprimir total calendario", "Registrar", "Días más festivos", "Salir" };
        int opcion = 0;
        do {
            Utils.limpiar();
            opcion = Utils.seleccionarElementoTexto("MENU", opciones) - 1;
            switch (opciones[opcion]) {
                case "Imprimir total calendario":
                    imprimir(conteoPorFecha, meses);
                    Utils.leerString("<Enter> para continuar");
                    break;
                case "Registrar":
                    System.out.println("Registrar");
                    registrar(conteoPorFecha, meses);
                    Utils.leerString("<Enter> para continuar");
                    break;
                case "Días más festivos":
                    System.out.println("Días más festivos");
                    String[] fechas = obtenerFechaConCantidad(conteoPorFecha, meses);
                    for (String valor : fechas) {
                        System.out.println(valor);
                    }
                    Utils.leerString("<Enter> para continuar");
                    break;
                case "Salir":
                    System.out.println("Te vamos extrañar, regresa pronto");
                    break;
                default:
                    break;
            }
        } while (!"Salir".equalsIgnoreCase(opciones[opcion]));

    }
}