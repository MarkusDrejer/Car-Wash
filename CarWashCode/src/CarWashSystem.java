import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CarWashSystem {

    private static ArrayList<WashCard> washCardData = new ArrayList<>();
    private static ArrayList<CreditCard> creditCardData = new ArrayList<>();
    private static ArrayList<Integer> adminPass = new ArrayList<>();

    private static Scanner console = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        //Preload Wash-Cards//
        Scanner input = new Scanner(new File("resources/washcards.txt"));
        while (input.hasNextLine()) {
            String text1 = input.nextLine();
            processLineW(text1);
        }
        
        Menu m = new Menu(console);
        
    }
    
    private static void processLineW(String text) {
        Scanner data = new Scanner(text);
        int PIN = data.nextInt();
        String name = data.next();
        int id = data.nextInt();
        washCardData.add(new WashCard(PIN, name, id));
    }
}
