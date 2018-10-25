import java.util.Random;
import java.util.Scanner;

public class Menu {

    private WashCard currentWashCard;
    private CreditCard currentCreditCard;
    private Wash currentWash;
    private Random rand = new Random();

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
                    makeRecharge(console);
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

            System.out.println("Please choose wash type:");
            System.out.println("1. Economy" + "\n" + "2. Standard" + "\n" + "3. Deluxe" + "\n" + "0. Cancel");
            choice2 = console.nextInt();

            if (choice2 < 0 || choice2 > 3) {
                System.out.println("Not a valid choice.");
            }

            switch (choice2){
                case 1:
                    currentWash = new Wash("Economy", "1:30", 50, 1);
                    System.out.println(currentWash);
                    makeWash(console);
                    choice2 = 0;
                    break;
                case 2:
                    currentWash = new Wash("Standard", "2:00", 80, 2);
                    System.out.println(currentWash);
                    makeWash(console);
                    choice2 = 0;
                    break;
                case 3:
                    currentWash = new Wash("Deluxe", "3:00", 120, 3);
                    System.out.println(currentWash);
                    makeWash(console);
                    choice2 = 0;
                    break;
            }
        } while(choice2 != 0);
    }

    private void makeWash(Scanner console){
        Transaction tr = new Transaction(currentWash.getPrice(), currentWashCard);
        currentWash.addStats();
        System.out.println("Thanks for your purchase, your wash will begin shortly");

        System.out.println("Do you want a Receipt? (Yes or No)");
        console.nextLine();
        if(console.nextLine().equalsIgnoreCase("yes")) {
            Receipt rec = new Receipt(rand.nextInt(10000), currentWash.getPrice(), currentWashCard.getName(),
                    currentWashCard.getId(), currentWash.getType());
            System.out.println(rec);
        }
    }
    private void makeRecharge(Scanner console){
        currentCreditCard = (CreditCard) CardReader.cardInsert("Credit", CarWashSystem.getCreditCards());
        currentWashCard = (WashCard) CardReader.cardInsert("Wash", CarWashSystem.getWashCards());

        System.out.println("Please enter amount to insert:");
        int amountToInsert = console.nextInt();
        while (amountToInsert < 200 || amountToInsert > 1000) {
            System.out.println("You can't deposit that amount. Deposits must be between 200 kr. and 1000 kr.");
            System.out.println("Please enter amount to insert:");
            amountToInsert = console.nextInt();
        }
        currentWashCard.recharge(amountToInsert);
        System.out.println( amountToInsert + " kr. successfully inserted!");

        System.out.println("Do you want a Receipt? (Yes or No)");
        console.nextLine();
        if(console.nextLine().equalsIgnoreCase("yes")) {
            Receipt rec = new Receipt(rand.nextInt(10000), amountToInsert, currentWashCard.getName(), currentWashCard.getId());
            System.out.println(rec);
        }
    }
}
