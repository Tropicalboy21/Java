public class practica1 {
    public static void main(String[] args) {
        int cantidadFactura;

        double ingreso = 0;

        double montoTotalFacturas = 0;

        boolean retencion = false;

        double retenciones = 0;

        double deducciones = 0;

        int numeroHijos = 0;

        boolean conyuge = false;

        double utilidad = 0;

        double impuestoRenta = 0;

        cantidadFactura = Utils.leerEntero("\ningrese la candidad de Facturas: ");
        conyuge = Utils.leerBoolean("\nEsta usted casado?: ");
        numeroHijos = Utils.leerEntero("\n Ingrese el numero de hijos menores de 18 años: ");

        for (int i = 0; i < cantidadFactura; i++) {

            double montoFactura = Utils.leerDoble("\nFactura #" + (i + 1) + "\n\ningrese el monto: ");

            retencion = Utils.leerBoolean("\nFue la retencion del 2% Impuesto de renta aplicada: ");

            if (retencion == true) {
                double renta = montoFactura * 0.02;
                retenciones += renta;
                montoTotalFacturas += montoFactura;
            } else {
                montoTotalFacturas += montoFactura;
            }
        }

        ingreso = montoTotalFacturas - retenciones;

        int deduHijos = numeroHijos * 1400;

        if (conyuge == true) {

            deducciones = deduHijos + 4545;
        }

        utilidad = ingreso - deducciones;

        System.out.println(utilidad);
    }
}
