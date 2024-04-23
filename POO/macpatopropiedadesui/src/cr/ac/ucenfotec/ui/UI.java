package cr.ac.ucenfotec.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UI {

    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void mostrarMenu(){
        System.out.println("**** Sistema gestión de propiedades ****");
        System.out.println("1. Registrar una propiedad.");
        System.out.println("2. Listar propiedades.");
        System.out.println("3. Registrar un inquilino.");
        System.out.println("4. Listar Inquilinos.");
        System.out.println("5. Agregar un inquilino a una propiedad (Agregación).");
        System.out.println("6. Asignar dimensiones de la propiedad (Composición).");
        System.out.println("0. Salir.");
        System.out.print("Por favor digite la opción: ");
    }

    public int leerNumero(){
        int numero = 0;
        boolean existeError = true;
        do {
            try {
                numero = Integer.parseInt(in.readLine());
                if (numero < 0) {
                    throw new Exception("Por favor ingrese un número mayor o igual a cero.");
                }
                existeError = false;
            }catch(NumberFormatException nfe){
                existeError = true;
                System.out.println("El dato ingresado no es un número, intentelo nuevamente!");
            }catch(Exception e){
                existeError = true;
                System.out.println(e.getMessage());
            }
        }while (existeError);
        return numero;
    }

    public String leerTexto(){
        String texto="";
        boolean existeError = true;
        do {
            try {
                texto = in.readLine();
                existeError = false;
            } catch(Exception e) {
                existeError = true;
                System.out.println("El dato ingresado presenta errores, intentelo nuevamente!");
            }
        }while(existeError);
        return texto;
    }

    public boolean leerBoleano() {
        boolean valor;
        try {
            valor = in.readLine().equals("S");
            return valor;
        }catch(Exception e){
            System.out.println("Error al ingresar el valor!");
            return false;
        }
    }

    public double leerDecimales(){
        double decimal=0.0;
        boolean existeError = true;
        do {
            try {
                decimal = Double.parseDouble(in.readLine());
                existeError = false;
            } catch(Exception e) {
                existeError = true;
                System.out.println("El dato ingresado presenta errores, intentelo nuevamente!");
            }
        }while(existeError);
        return decimal;
    }

    public LocalDate leerFecha(){
        String fecha = "";
        LocalDate fechaNueva = null;
        boolean existeError;
        do {
            try {
                fecha = in.readLine().toLowerCase();
                fechaNueva = LocalDate.parse(fecha, formatter);
                existeError = false;
            } catch (Exception e) {
                existeError = true;
                System.out.println("El formato de la fecha es incorrecto, debe ser de tipo dd/MM/yyyy.");
            }
        } while (existeError);
        return fechaNueva;
    }

    public void imprimirMensaje(String mensaje){
        System.out.println(mensaje);
    }
}
