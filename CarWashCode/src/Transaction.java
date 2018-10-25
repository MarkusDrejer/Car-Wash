public class Transaction {

    private int price;

    public void deductBalance(int washPrice, WashCard currentCard) {
        currentCard.recharge(-washPrice);
    }
    
    public Transaction(int price) {

        this.price = price;

    }

}
