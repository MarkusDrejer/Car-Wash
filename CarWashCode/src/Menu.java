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

            if (choice < 0 || choice > 4) {
                System.out.println("Not a valid choice.");
            }

            switch (choice){
                //Wash Car
                case 1:
                    currentWashCard = (WashCard) CardReader.cardInsert("Wash", CarWashSystem.getWashCards());
                    washTypeMenu(console);
                    break;
                //Balance
                case 2:
                    currentWashCard = (WashCard) CardReader.cardInsert("Wash", CarWashSystem.getWashCards());
                    System.out.println("Your balance is: " + currentWashCard.getBalance() + " kr.");
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
                    currentWash = new Wash("Economy", "2", 50, 1, 2);
                    System.out.println(currentWash);
                    makeWash(console);
                    choice2 = 0;
                    break;
                case 2:
                    currentWash = new Wash("Standard", "3", 80, 2, 3);
                    System.out.println(currentWash);
                    makeWash(console);
                    choice2 = 0;
                    break;
                case 3:
                    currentWash = new Wash("Deluxe", "4", 120, 3, 4);
                    System.out.println(currentWash);
                    makeWash(console);
                    choice2 = 0;
                    break;
            }

        } while(choice2 != 0);
    }

    private void makeWash(Scanner console){

        if (currentWash.getPrice() > currentWashCard.getBalance()) {
            System.out.println("Insufficient funds - please recharge your WashCard.");
            System.out.println();
        } else {
            Transaction tr = new Transaction(currentWash.getPrice(), currentWashCard);
            currentWash.addStats();
            System.out.println("Thank you for your purchase, your wash will begin shortly");

            System.out.println("Do you want a Receipt? (1 for Yes or 2 for No)");

            int receiptChoice = console.nextInt();

            while (receiptChoice != 1 && receiptChoice != 2) {
                System.out.println("I didn't understand that. Do you want a Receipt? (1 for Yes or 2 for No):");
                receiptChoice = console.nextInt();
            }

            if (receiptChoice == 1) {
                Receipt rec = new Receipt(rand.nextInt(10000), currentWash.getPrice(), currentWashCard.getName(),
                        currentWashCard.getId(), currentWash.getType());
                System.out.println(rec);
            }
            //Not in the final delivery
            timer();
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

        System.out.println("Do you want a Receipt? (1 for Yes or 2 for No):");

        int receiptChoice = console.nextInt();

        while (receiptChoice != 1 && receiptChoice != 2) {
            System.out.println("I didn't understand that. Do you want a Receipt? (1 for Yes or 2 for No):");
            receiptChoice = console.nextInt();
        }

        if (receiptChoice == 1) {
            Receipt rec = new Receipt(rand.nextInt(10000), amountToInsert, currentWashCard.getName(), currentWashCard.getId());
            System.out.println(rec);
        }
    }


    //Not in the final delivery
    public void timer() {
        int timet = currentWash.getLengthStat() * 60; // Convert to seconds
        long delay = timet * 1000;

        System.out.println("Your wash will be done in");

        do {
            int minutes = timet / 60;
            int seconds = timet % 60;
            System.out.println(minutes + " minute(s), " + seconds + " second(s)");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt(); // Here!
                throw new RuntimeException(ex);
            }
            timet = timet - 1;
            delay = delay - 1000;

        } while (delay != 0);
        System.out.println("Your wash is now finished");
    }
}
