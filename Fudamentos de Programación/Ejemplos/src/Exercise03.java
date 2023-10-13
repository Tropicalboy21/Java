public class Exercise03 {
    public static void main(String[] args) {
        int elenasAge;
        int anasAge;

        elenasAge = Utils.leerEntero("\nEnter Elena's current Age: ");

        anasAge = elenasAge * 2;

        System.out.println("\nIf Ana's age is double the current age of Elena. \nAna is " + anasAge
                + " years old. \nAnd in 10 years from now, she will be " + (anasAge + 10) + " years old.");
    }
}
