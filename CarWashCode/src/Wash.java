import java.util.Calendar;
import java.util.Date;

public class Wash {

    private String type;
    private String length;
    private int price;
    private int day;
    private int time;
    Date now = new Date();

    public Wash(String type, String length, int price) {
        this.type = type;
        this.length = length;
        this.price = price;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        day = calendar.get(Calendar.DAY_OF_WEEK);
        time = calendar.get(Calendar.HOUR_OF_DAY);

    }

    public void checkDiscount() {
        int diff;
    if( day != 7 && day != 6 && time < 14) {
        diff = price * 20 / 100;
        price = price - diff;
    }
    }

    public String getInfo() {
    return "hejd";
    }

    public void addStats() {

    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }


}
