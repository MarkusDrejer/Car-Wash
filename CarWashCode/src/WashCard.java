public class WashCard {

    private int pin;
    private int id;
    private String name;
    private int balance = 0;

    public WashCard(int pin, int id, String name) {

    }

    public void recharge(int newAmount) {
        balance = balance + newAmount;
    }

    public int getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }


}
