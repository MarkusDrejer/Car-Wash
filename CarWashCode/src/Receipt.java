public class Receipt {
    private int orderID;
    private int total;
    private String costumerName;
    private int washCardId;
    private String washType;

    public String printReceipt() {
        return "hej";
    }
    public Receipt(int orderID, String costumerName, int washCardId, String washType) {
        this.orderID = orderID;
        this.costumerName = costumerName;
        this.washCardId = washCardId;
        this.washType = washType;
    }
    public Receipt(int orderID, String costumerName, int washCard) {

    }
}
