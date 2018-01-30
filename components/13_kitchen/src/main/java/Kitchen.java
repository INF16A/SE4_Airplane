import java.util.ArrayList;

public class Kitchen implements IKitchen {
    private String manufacturer;
    private KitchenType kitchenType;
    private String id;
    private ArrayList<Trolley> trolleyList;
    private boolean isLocked;
    private boolean isFilled;

    public Kitchen() {
        trolleyList = new ArrayList<Trolley>();
        manufacturer = "INF16B";
        id = "1";
    }

    public String version() {
        return "Kitchen 1.0";
    }

    public boolean lock() {
        if(isLocked == true)
            return false;

        isLocked = true;
        return true;
    }

    public boolean unlock() {
        if(isLocked == false)
            return false;

        isLocked = false;
        return true;
    }

    public double getTotalWeightTrolleys() {
        return 0;
    }

    public void addTrolley(Trolley trolley) {
        trolleyList.add(trolley);
    }

    public void emptyTrolley(Trolley trolley) {
    }
}
