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
                    currentWashCard = (WashCard) CardReader.cardInsert("Wash", CarWashSystem.getWashCards());
                    washTypeMenu(console);
                    break;
                //Balance
                case 2:
                    currentWashCard = (WashCard) CardReader.cardInsert("Wash", CarWashSystem.getWashCards());
                    System.out.println("Your balance is: " + currentWashCard.getBalance());
                    break;
                //Recharge
                case 3:
                    //currentCard = CardReader.CardInsert();
                    break;
                //Statistics
                case 4:
                    if(Statistics.verifyAdmin(console)){
                        System.out.println(Statistics.showStats());
                    }
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
                    currentWash = new Wash("Economy", "1:30", 50, 1);
                    System.out.println(currentWash);
                    makeWash();
                    break;
                case 2:
                    currentWash = new Wash("Standard", "2:00", 80, 2);
                    System.out.println(currentWash);
                    makeWash();
                    break;
                case 3:
                    currentWash = new Wash("Deluxe", "3:00", 120, 3);
                    System.out.println(currentWash);
                    makeWash();
                    break;
            }
        } while(choice2 != 0);
    }

    private void makeWash(){
        currentWash.addStats();
        Transaction tr = new Transaction(currentWash.getPrice(), currentWashCard);
        Receipt rec = new Receipt(0, currentWash.getPrice(), currentWashCard.getName(),
                currentWashCard.getId(), currentWash.getType());
        System.out.println("Thanks for your purchase, your wash will begin shortly");
        System.out.println(rec);
    }
}
