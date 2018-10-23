public class CreditCard {
    private int PIN;
    private int balance = 0;
    private int id;

    public CreditCard(int PIN, int balance, int id) {
        this.PIN = PIN;
        this.balance = balance;
        this.id = id;
    }
}
