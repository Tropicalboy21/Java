package view;

import controller.CourseController;
import controller.ProfesorController;

import java.util.Scanner;

public class CourseView {
    public static void main(String[] args) {
        CourseController courseController= new CourseController();
        Scanner scann = new Scanner(System.in);

        while(true){
            System.out.println("--- Cursos ---");
            System.out.println("1-mostrar datos");
            System.out.println("2-agregar datos");

            System.out.println("Ingrese su opcion");
            int opcionDigitada = scann.nextInt();
            scann.nextLine();

            switch (opcionDigitada){

                case 1:
                    System.out.println("Lista de Cursos");
                    courseController.getCourse();
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del Curso");
                    String nombre = scann.nextLine();

                    System.out.println("Ingrese su descripción");
                    String descripcion = scann.nextLine();

                    courseController.addCourse(nombre, descripcion, true);
                    break;
                default:
                    System.out.println("No existe esta opcion.");
                    break;

            }
        }
    }
}
