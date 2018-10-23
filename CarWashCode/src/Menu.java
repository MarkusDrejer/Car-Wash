import java.util.Scanner;

public class Menu {

    private WashCard currentCard;

    public Menu(Scanner console){
        int choice;
        do {
            System.out.println("Welcome to the Car Wash System");
            System.out.println("1. Wash Car" + "\n" + "2. Balance" + "\n" + "3. Recharge" +
                    "\n" + "4. Statistics" + "\n" + "0. Exit");
            choice = console.nextInt();

            switch (choice){
                case 1:
                    currentCard = CardReader.CardInsert();
                    washTypeMenu(console);
                    break;
                case 2:
                    currentCard = CardReader.CardInsert();
                    System.out.println("Your balance is: " + currentCard.getBalance());
                    break;
                case 3:
                    currentCard = CardReader.CardInsert();
                    break;
                case 4:

                    break;


            }

        }while(choice != 0);
    }

    private void washTypeMenu(Scanner console){
        int choice2;
        do {
            System.out.println("Please choose wash type");
            System.out.println("1. Economy" + "\n" + "2. Standard" + "\n" + "3. Deluxe" + "\n" + "0. Cancel");
            choice2 = console.nextInt();

            switch (choice2){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
            }

        }while(choice2 != 0);
    }
}
