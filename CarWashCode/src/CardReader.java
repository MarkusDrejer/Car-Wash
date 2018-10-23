import java.util.Scanner;

public abstract class CardReader {

    private static Scanner console = new Scanner(System.in);
    private static WashCard currentCard;

    public static WashCard CardInsert(){
        System.out.println("Id please");
        int userId = console.nextInt();
        for(int i = 0; i < CarWashSystem.getWashCards().size(); i++){
            WashCard temp = CarWashSystem.getWashCards().get(i);
            if(userId == temp.getId()){
                currentCard = temp;
                break;
            }
        }
        System.out.println("Please enter PIN");
        int userInput = console.nextInt();
        int count = 0;
        while(userInput != currentCard.getPin()){
            System.out.println("Wrong PIN, please try again");
            count++;
            if(count >= 3){
                System.out.println("Please get your shit together");
            }
            userInput = console.nextInt();
        }
        return currentCard;
    }
}
