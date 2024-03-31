package ucenfotec.ac.cr.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UI {
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public void mostrarMenu(){
        System.out.printf("---------------------------------%n");
        System.out.printf("    Bienvenido a SalvaHogar      %n");
        System.out.printf("              Menu               %n");
        System.out.printf("---------------------------------%n");
        System.out.printf("    1.   Registrar casa          %n");
        System.out.printf("    2.   Listar casas            %n");
        System.out.printf("    3.   Registrar vecino        %n");
        System.out.printf("    4.   Listar vecinos          %n");
        System.out.printf("    5.   Agregar Vecino a casa   %n");
        System.out.printf("    6.   Cerrar Sesion           %n");
        System.out.print("    Porfavor ingrese una opcion:    ");
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

    public boolean leerBoleano() throws Exception{
        return in.readLine().equals("S");
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

    public LocalDate leerFecha() throws Exception{
        return LocalDate.parse(in.readLine(),formatter);
    }

    public void imprimirMensaje(String mensaje){
        System.out.println(mensaje);
    }
}
