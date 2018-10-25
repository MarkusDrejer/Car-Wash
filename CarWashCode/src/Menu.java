import java.util.Scanner;

public class Menu {

    private WashCard currentWashCard;
    private CreditCard currentCreditCard;
    private Wash currentWash;

    public Menu(Scanner console){
        int choice;
        do {
            System.out.println("Welcome to the Car Wash System");
            System.out.println("1. Wash Car" + "\n" + "2. Balance" + "\n" + "3. Recharge" +
                    "\n" + "4. Statistics" + "\n" + "0. Exit");
            choice = console.nextInt();

            switch (choice){
                //Wash Car
                case 1:
                    currentWashCard = (WashCard) CardReader.cardInsert(CarWashSystem.getWashCards());
                    washTypeMenu(console);
                    break;
                //Balance
                case 2:
                    currentWashCard = (WashCard) CardReader.cardInsert(CarWashSystem.getWashCards());
                    System.out.println("Your balance is: " + currentWashCard.getBalance());
                    break;
                //Recharge
                case 3:
                    //currentCard = CardReader.CardInsert();
                    break;
                //Statistics
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
                    currentWash = new Wash("Economy", "1:30", 50);
                    Transaction tr1 = new Transaction(50, currentWashCard);
                    break;
                case 2:
                    currentWash = new Wash("Standard", "2:00", 80);
                    Transaction tr2 = new Transaction(80, currentWashCard);
                    break;
                case 3:
                    currentWash = new Wash("Deluxe", "3:00", 120);
                    Transaction tr3 = new Transaction(120, currentWashCard);
                    break;
            }

        } while(choice2 != 0);
    }
}
