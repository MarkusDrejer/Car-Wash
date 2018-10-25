import java.util.ArrayList;

    public abstract class Statistics {

    private int count;
    private int revenue = 0;
    private ArrayList<String> washTypes = new ArrayList<>();

    public void addWash() {
        count++;
    }

    public void addRevenue(int newRevenue) {
        revenue += newRevenue;
    }

    public void addWashType(String type) {
        washTypes.add(type);
    }

    private String findPopular() {
        return "lort";
    }

    public String toString() {
        return "lort";
    }

    }
