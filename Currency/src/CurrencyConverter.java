import java.util.Scanner;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class CurrencyConverter {
    public static void main(String[] args) {

        HashMap<Integer, String> currencyCodes = new HashMap<Integer, String>();

        // Add currency codes
        currencyCodes.put(1, "USD");
        currencyCodes.put(2, "CAD");
        currencyCodes.put(3, "EUR");
        currencyCodes.put(4, "HKD");
        currencyCodes.put(5, "INR");
        currencyCodes.put(6, "CCR");

        String fromCode, toCode;
        double amount;

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the currency converter 2023");

        System.out.println("currency converting FROM?");

        System.out.println(
                "1:USD (US Dollar) \t  2:CAD (Canadian Dollar) \t 3:EUR (Euro) \t HKD (Hong Kong Dollar)\t INR (Indian Ruppie)\t CCR (Costarican Colon)");
        fromCode = currencyCodes.get(sc.nextInt());

        System.out.println("currency converting TO?");

        System.out.println(
                "1:USD (US Dollar) \t  2:CAD (Canadian Dollar) \t 3:EUR (Euro) \t HKD (Hong Kong Dollar)\t INR (Indian Ruppie)\t CCR (Costarican Colon)");
        toCode = currencyCodes.get(sc.nextInt());

        System.out.println("Amount you wish to convert?");
        amount = sc.nextFloat();

        // sendHttpGetRequest(fromCode, toCode, amount);

        System.out.println("thank you for using the currency converter!");
    }

    private static void sendHttpGetRequest(String fromCode, String toCode, double amount) throws MalformedURLException {

        String GET_URL = "http://data.fixer.io/api/latest?access_key=50a374314f68d740b880df3ee12a89f1&symbols=" + toCode
                + "," + fromCode + ",&format=1";

        URL url = new URL(GET_URL);

    }

}
