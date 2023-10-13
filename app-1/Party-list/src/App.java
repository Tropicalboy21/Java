import java.util.Scanner;

public class App {

        public static void main(String[] args) throws Exception {

                Scanner sc = new Scanner(System.in);

                System.out.println(
                                "\nHello welcome to the party List!\n\nPlease enter your name and age to check if your in the list\n");

                System.out.println("Enter your name:\n");
                String name = sc.nextLine();

                char firstLetter = name.charAt(0);

                System.out.println("\nNow enter your age:\n");
                Integer age = sc.nextInt();

                char letter = 'L';

                if (firstLetter == letter && age >= 18) {
                        System.out.println("\nYou are invited, We hope to see you there, Enjoy!\n");
                } else {
                        System.out.println("\nI'm sorry you're not invited.\n");
                }
        }
}
