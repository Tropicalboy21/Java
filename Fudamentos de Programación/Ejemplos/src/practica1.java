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

        double montoImpuestoRentaB = 0;
        double montoImpuestoRentaA = 0;

        double pagoImpuestoRenta = 0;

        cantidadFactura = Utils.leerEntero("\nIngrese la candidad de Facturas: ");
        conyuge = Utils.leerBoolean("\nEsta usted casado?: ");
        numeroHijos = Utils.leerEntero("\nIngrese el numero de hijos menores de 18 años: ");

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

        ingreso = montoTotalFacturas;

        int deduHijos = numeroHijos * 1400;

        if (conyuge == true) {

            deducciones = deduHijos + 4545;
        }

        utilidad = ingreso - deducciones;

        if (utilidad >= 863001 && utilidad <= 1267000) {
            impuestoRenta = 0.10;
        } else if (utilidad >= 1267000 && utilidad <= 2223000) {
            impuestoRenta = 0.15;
        } else if (utilidad >= 2223000 && utilidad <= 4445000) {
            impuestoRenta = 0.20;
        } else if (utilidad > 4445000) {
            impuestoRenta = 0.25;
        } else {
            impuestoRenta = 0;
        }

        montoImpuestoRentaB = utilidad * impuestoRenta;

        montoImpuestoRentaA = montoImpuestoRentaB - retenciones;

        pagoImpuestoRenta = utilidad + montoImpuestoRentaA;

        String str1 = "Total de ingresos por facturación";
        String str2 = "Total de gastos deducibles";
        String str3 = "Monto de impuesto de renta antes de retenciones";
        String str4 = "Total de ingresos por facturación";
        String str5 = "Total acumulado de retenciones";
        String str6 = "Monto de impuesto de renta después de retenciones";
        String str7 = "Monto total de deducciones";
        String str8 = "Monto de impuesto a pagar por renta";

        // System.out.println("\nTotal de ingresos por facturación" + "\t\t : " +
        // montoTotalFacturas);
        // System.out.println("Total de gastos deducibles" + "\t\t\t : " + deducciones);
        // System.out.println("Utilidad" + "\t\t\t\t\t: " + utilidad);
        // System.out.println("Monto de impuesto de renta antes de retenciones \t: " +
        // montoImpuestoRentaB);
        // System.out.println("Total acumulado de retenciones" + "\t\t\t: " +
        // retenciones);
        // System.out.println("Monto de impuesto de renta después de retenciones : " +
        // montoImpuestoRentaA);
        // System.out.println("Monto total de deducciones" + "\t\t\t\t: " + retenciones
        // + deducciones);
        // System.out.println("Monto de impuesto a pagar por renta" + "\t\t: " +
        // pagoImpuestoRenta);

        System.out.printf("\n%-50s: %s\n", str1, montoTotalFacturas);
        System.out.printf("%-50s: %s\n", str2, deducciones);
        System.out.printf("%-50s: %s\n", str3, utilidad);
        System.out.printf("%-50s: %s\n", str4, montoImpuestoRentaB);
        System.out.printf("%-50s: %s\n", str5, retenciones);
        System.out.printf("%-50s: %s\n", str6, montoImpuestoRentaA);
        System.out.printf("%-50s: %s\n", str7, retenciones + deducciones);
        System.out.printf("%-50s: %s\n", str8, pagoImpuestoRenta);

    }
}
