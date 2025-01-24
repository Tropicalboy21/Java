import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Ejercicio5 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        calculateAge();
    }

    public static void calculateAge(){
        int y = 0;
        int m = 0;
        int d = 0;
        LocalDate currentDate = LocalDate.now();
        int years = 0;

        System.out.print("Porfavor ingrese su año de nacimiento: ");
        y = sc.nextInt();

        System.out.print("Porfavor ingrese su mes de nacimiento: ");
        m = sc.nextInt();

        System.out.print("Porfavor ingrese su dia de nacimiento: ");
        d = sc.nextInt();

        LocalDate birthDay = LocalDate.of(y,m,d);

        years =
                currentDate.getYear() - birthDay.getYear();

        System.out.println("\nFecha actual:" + currentDate);
        System.out.println("\nFecha de nacimiento: " + birthDay);
        System.out.println("\nHan transcurrido " + years + " años entre ambas fechas." );


    }
}
