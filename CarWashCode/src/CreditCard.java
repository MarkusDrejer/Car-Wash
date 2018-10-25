public class CreditCard extends Card{
    private int PIN;
    private int id;

    public CreditCard(int PIN, int id) {
        this.PIN = PIN;
        this.id = id;
    }

    public int getPin(){
        return PIN;
    }
    public int getId(){
        return id;
    }
}
