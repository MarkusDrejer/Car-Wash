import java.util.Calendar;
import java.util.Date;

public class Wash {

    private String type;
    private String length;
    private int price;
    private int typeStat;
    private int day;
    private int time;
    Date now = new Date();

    public Wash(String type, String length, int price, int typeStat) {
        this.type = type;
        this.length = length;
        this.price = price;
        this.typeStat = typeStat;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        day = calendar.get(Calendar.DAY_OF_WEEK);
        time = calendar.get(Calendar.HOUR_OF_DAY);

    }

    private void checkDiscount() {
        int diff;
        if( day != 7 && day != 6 && time < 14) {
            diff = price * 20 / 100;
            price = price - diff;
        }
    }

    public String toString() {
        checkDiscount();
    return "Type: " + type + "\n" + "Length: " + length + "\n" + "Price: " + price;
    }

    public void addStats() {
        Statistics.addWash();
        Statistics.addRevenue(price);
        Statistics.addWashType(typeStat);
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }


}
