import java.util.Scanner;

public class Menu {

    public Menu(Scanner console){
        System.out.println("Welcome to the Car Wash System");
        int choice = console.nextInt();
        do {
            System.out.println("1. Wash Car" + "\n" + "2. Balance" + "\n" + "3. Recharge" +
                    "\n" + "4. Statistics" + "\n" + "0. Exit");
            choice = console.nextInt();

            switch (choice){

            }

        }while(choice != 0);
    }
}
