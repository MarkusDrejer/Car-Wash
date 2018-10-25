import java.util.ArrayList;

    public abstract class Statistics {

    private int count = 0;
    private int revenue = 0;
    private ArrayList<Integer> washTypes = new ArrayList<>();

    public void addWash() {
        count++;
    }

    public void addRevenue(int newRevenue) {
        revenue += newRevenue;
    }

    public void addWashType(int type) {
        washTypes.add(type);
    }

    private int findPopular() {

        int type1 = 0;
        int type2 = 0;
        int type3 = 0;

        for (int i = 0; i < washTypes.size(); i++) {
            switch (washTypes) {
                case 1:
                    type1++;
                    break;
                case 2:
                    type2++;
                    break;
                case 3:
                    type3++;
                    break;
            }
        }

        if (type1 == type2 || type2 == type3 || type3 == type1) {
            return -1;
        } else {

            int max = Math.max(type1, type2);

            max = Math.max(max, type3);

            return max;

        }
    }

    public String toString() {
        return "lort";
    }

    }
