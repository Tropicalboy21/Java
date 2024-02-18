import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Test {

    public static void main(String args[])

    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter date of birth in YYYY-MM-DD format: ");
        // reads the date of birth from the user
        String nacimientoV2 = sc.nextLine();

        // the parse() method obtains an instance of LocalDate from a text string such
        // as 1992-08-11
        LocalDate dob = LocalDate.parse(nacimientoV2);
        // prints the age
        System.out.println("You are " + CalcularEdad(dob) + " years old.");

    }

    public static int CalcularEdad(LocalDate dob) {
        LocalDate curDate = LocalDate.now();
        if ((dob != null) && (curDate != null)) {
            return Period.between(dob, curDate).getYears();
        } else {
            return 0;
        }
    }
}