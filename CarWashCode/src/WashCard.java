public class WashCard {

    private int pin;
    private int id;
    private String name;
    private int balance = 0;

    public WashCard(int pin, String name) {

    }

    public void updateBalance(int newAmount) {
        balance = balance + newAmount;
    }

    public int getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }


}
