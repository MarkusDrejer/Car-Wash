import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CarWashSystem {

    private static ArrayList<Card> washCardData = new ArrayList<>();
    private static ArrayList<Card> creditCardData = new ArrayList<>();
    private static ArrayList<Integer> adminPass = new ArrayList<>();

    private static Scanner console = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        //Preload Wash-Cards//
        Scanner input = new Scanner(new File("resources/washcards.txt"));
        while (input.hasNextLine()) {
            String text1 = input.nextLine();
            processLineW(text1);
        }
        //Preload CreditCards//
        Scanner input2 = new Scanner(new File("resources/creditcards.txt"));
        while (input2.hasNextLine()) {
            String text2 = input2.nextLine();
            processLineC(text2);
        }
        //Preload Admin Passwords//
        Scanner input3 = new Scanner(new File("resources/adminpass.txt"));
        while (input3.hasNextLine()) {
            String text3 = input3.nextLine();
            processLineA(text3);
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
    private static void processLineC(String text) {
        Scanner data = new Scanner(text);
        int PIN = data.nextInt();
        int Id = data.nextInt();
        creditCardData.add(new CreditCard(PIN, Id));
    }
    private static void processLineA(String text){
        Scanner data = new Scanner(text);
        int pass = data.nextInt();
        adminPass.add(pass);
    }
    public static ArrayList<Card> getWashCards(){
        return washCardData;
    }
    public static ArrayList<Card> getCreditCards(){
        return creditCardData;
    }
    public static ArrayList<Integer> getAdminPass(){
        return adminPass;
    }
}
