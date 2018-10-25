public class Transaction {

    public Transaction(int washPrice, WashCard currentCard) {
        currentCard.recharge(-washPrice);
    }

}
