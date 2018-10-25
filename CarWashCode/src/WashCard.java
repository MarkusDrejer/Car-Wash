public class WashCard extends Card{

    private int pin;
    private int id;
    private String name;
    private int balance = 0;

    public WashCard(int pin, String name, int id) {

        this.pin = pin;
        this.id = id;
        this.name = name;

    }

    public void recharge(int newAmount) {
        if (balance <= 0) {
            System.out.println("Please recharge your WashCard.");
        } else {
            balance = balance + newAmount;
        }
    }

    public int getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public int getPin(){
        return pin;
    }

    public String getName(){
        return name;
    }


}
