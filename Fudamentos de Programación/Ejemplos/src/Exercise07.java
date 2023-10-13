public class Exercise07 {
    public static void main(String[] args) {
        double purchaseAmount, finalAmount, discount;
        int previousPurchases;
        String message;

        purchaseAmount = Utils.leerDoble("\nEnter the purchase amount: ");
        previousPurchases = Utils.leerEntero("\nEnter number of previous purchases: ");

        if (previousPurchases >= 6 && purchaseAmount >= 10000) {
            discount = purchaseAmount * 0.35;
            finalAmount = purchaseAmount - discount;
            System.out.println("\nYour purchase is: " + purchaseAmount + "\nPrevious purchases: " + previousPurchases
                    + "\nAmazing! You are elegible for the 35% discount \nYour final purchase amount is: "
                    + finalAmount);
        } else {
            discount = purchaseAmount * 0.35;
            finalAmount = purchaseAmount;
            System.out.println("\nYour purchase is: " + purchaseAmount + "\nPrevious purchases: " + previousPurchases
                    + "\nI'm sorry! You are not elegible for the 35% discount \nYour final purchase amount is: "
                    + finalAmount);
        }
    }
}
