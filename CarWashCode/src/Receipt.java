public class Receipt {
    private int orderID;
    private int total;
    private String costumerName;
    private int washCardId;
    private String washType;

    public Receipt(int orderID, int total, String costumerName, int washCardId, String washType) {
        this.orderID = orderID;
        this.total = total;
        this.costumerName = costumerName;
        this.washCardId = washCardId;
        this.washType = washType;
    }
    public Receipt(int orderID, int total, String costumerName, int washCardId) {
        this.orderID = orderID;
        this.total = total;
        this.costumerName = costumerName;
        this.washCardId = washCardId;
    }
    public String toString() {
        if(washType == null){
            return "Your order ID: " + orderID + "\n" + "Your total: " + total + "\n" + "Your name: " + costumerName + "\n" +
                    "Your WashCard ID: " + washCardId + "\n";
        }
        return "Your order ID: " + orderID + "\n" + "Your total: " + total + " kr." + "\n" + "Your name: " + costumerName + "\n" +
                "Your WashCard ID: " + washCardId + "\n" + "Wash type: " + washType + "\n";

    }
}
