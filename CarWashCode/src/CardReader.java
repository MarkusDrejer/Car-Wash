import java.util.ArrayList;
import java.util.Scanner;

public abstract class CardReader {

    private static Scanner console = new Scanner(System.in);
    private static Card currentCard = null;

    public static Card cardInsert(ArrayList<Card> arr) {
        System.out.println("Id please");
        int userId = console.nextInt();

        //Cant loop properly on after 1st attempt
        for (Card c : arr) {
            if (userId == c.getId()) {
                currentCard = c;
                break;
            }
        }
        if (currentCard == null) {
            System.out.println("No such Id, please try again");
            cardInsert(arr);
        }
        else {
            enterPin();
        }
        return currentCard;
    }

    public static void enterPin(){
        System.out.println("Please enter PIN");
        int userInput = console.nextInt();
        int count = 0;
        while (userInput != currentCard.getPin()) {
            System.out.println("Wrong PIN, please try again");
            count++;
            if (count >= 3) {
                System.out.println("Please get your shit together");
            }
            userInput = console.nextInt();
        }
    }
}
