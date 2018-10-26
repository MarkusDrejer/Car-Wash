import java.util.ArrayList;
import java.util.Scanner;

public abstract class CardReader {

    private static Scanner console = new Scanner(System.in);
    private static Card currentCard;

    public static Card cardInsert(String type, ArrayList<Card> arr) {
        currentCard = null;
        System.out.println(type + " ID please:");
        int userId = console.nextInt();

        while(currentCard == null) {
            for (Card c : arr) {
                if (userId == c.getId()) {
                    currentCard = c;
                    break;
                }
            }
            if(currentCard == null) {
                System.out.println("No such Id, please enter a new Id");
                userId = console.nextInt();
            }
        }
        enterPin();

        return currentCard;
    }

    public static void enterPin(){
        System.out.println("Please enter PIN:");
        int userInput = console.nextInt();
        int count = 0;
        while (userInput != currentCard.getPin()) {
            System.out.println("Wrong PIN, please try again:");
            count++;
            if (count >= 3) {
                System.out.println("Please get your shit together");
            }
            userInput = console.nextInt();
        }
    }
}
