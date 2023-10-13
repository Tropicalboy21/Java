public class Exercise04 {
    public static void main(String[] args) {
        String nationality = null;
        boolean admition = false;

        nationality = Utils.leerString("\nPlease enter your nationality: ");
        admition = "Costarican".equalsIgnoreCase(nationality);

        if (admition) {
            System.out.println("Welcome to Costa Rica");
        } else {
            System.out.println("We regret to tell you that you won't be able to enter the nation.");
        }
    }
}
