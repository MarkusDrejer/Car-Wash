public class Transaction {

    private int price;

    WashCard currentCard;

    public void deductBalance(int washPrice) {
        currentCard.getBalance();
        int balance = currentCard.getBalance();
        balance = balance - washPrice;
    }
    
    public Transaction(int price) {

        this.price = price;

    }

}
