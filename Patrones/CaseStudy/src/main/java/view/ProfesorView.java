package view;

import controller.ProfesorController;
import controller.StudentController;

import java.util.Scanner;

public class ProfesorView {
    public static void main(String[] args) {
        ProfesorController profesorController= new ProfesorController();
        Scanner scann = new Scanner(System.in);

        while(true){
            System.out.println("--- Profesores ---");
            System.out.println("1-mostrar datos");
            System.out.println("2-agregar datos");

            System.out.println("Ingrese su opcion");
            int opcionDigitada = scann.nextInt();
            scann.nextLine();

            switch (opcionDigitada){

                case 1:
                    System.out.println("Lista de datos");
                    profesorController.getProfesor();
                    break;
                case 2:
                    System.out.println("Ingrese su nombre");
                    String nombre = scann.nextLine();

                    System.out.println("Ingrese su apellido");
                    String apellidos = scann.nextLine();

                    System.out.println("Ingrese su identificación");
                    String identificacion = scann.nextLine();

                    System.out.println("Ingrese su email");
                    String email = scann.nextLine();

                    System.out.println("Ingrese su fecha nacimiento");
                    String fechanacimiento = scann.nextLine();

                    System.out.println("Ingrese su departamento");
                    String departamento = scann.nextLine();

                    profesorController.addProfesor(nombre, apellidos, identificacion, email, fechanacimiento, departamento, true);
                    break;
                default:
                    System.out.println("No existe esta opcion.");
                    break;

            }
        }
    }
}
