public class Exercise02 {
    public static void main(String[] args) {
        final double kmStart;
        double kmEnd, totalTrip;

        kmStart = Utils
                .leerDoble("\nPlease enter the current kilometers in the Odograph of your vehicle (before the trip):");

        kmEnd = Utils.leerDoble("\nPlease enter the kilometers in the Odograph of your vehicle after the trip:");

        totalTrip = kmEnd - kmStart;

        System.out.println("\nTotal Distance Traveled " + totalTrip + "km");
    }
}
