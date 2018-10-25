import java.util.ArrayList;
import java.util.Scanner;

public abstract class Statistics {

    private static int count = 0;
    private static int revenue = 0;
    private static ArrayList<Integer> washTypes = new ArrayList<>();

    public static void addWash() {
        count++;
    }

    public static void addRevenue(int newRevenue) {
        revenue += newRevenue;
    }

    public static void addWashType(int type) {
        washTypes.add(type);
    }

    private static String findPopular() {

        int type1 = 0;
        int type2 = 0;
        int type3 = 0;

        for (int i = 0; i < washTypes.size(); i++) {
            switch (washTypes.get(i)) {
                case 1:
                    type1++;
                    break;
                case 2:
                    type2++;
                    break;
                case 3:
                    type3++;
                    break;
            }
        }

        if(type1 > type2 && type1 > type3){
            return "Economy";
        }
        else if(type2 > type1 && type2 > type3){
            return "Standard";
        }
        else if(type3 > type1 && type3 > type2){
            return "Deluxe";
        }
        else{
            return "No most popular wash";
        }
    }

    public static String showStats() {
        return "Number of washes: " + count + "\n" + "Revenue: " + revenue + "\n" + "Most popular wash: "
                + findPopular();
    }

    public static boolean verifyAdmin(Scanner console){
        System.out.println("Please enter Admin Password:");
        int password = console.nextInt();
        for(int i : CarWashSystem.getAdminPass()){
            if(password == i){
                return true;
            }
        }
        System.out.println("Wrong password, terminating stat access");
        return false;
    }
}
