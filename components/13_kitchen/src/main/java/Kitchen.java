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
    }

    @Override
    public String version() {
        return "Kitchen 1.0";
    }

    @Override
    public boolean lock() {
        if(isLocked == true)
            return false;

        isLocked = true;
        return true;
    }

    @Override
    public boolean unlock() {
        if(isLocked == false)
            return false;

        isLocked = false;
        return true;
    }

    @Override
    public double getTotalWeightTrolleys() {
        return 0;
    }

    @Override
    public void addTrolley(Trolley trolley) {
        trolleyList.add(trolley);
    }

    @Override
    public void emptyTrolley(Trolley trolley) {
    }
}
