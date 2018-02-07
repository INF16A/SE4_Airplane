import java.util.ArrayList;

public class Kitchen {
    private static Kitchen instance = new Kitchen();
    public Port port;
    private String manufacturer;
    private KitchenType kitchenType;
    private String id;
    private ArrayList<Trolley> trolleyList;
    private boolean isLocked;
    private boolean isFilled;
    private Kitchen() {
        trolleyList = new ArrayList<Trolley>();
        manufacturer = "INF16B";
        id = "1";
        port = new Port();
    }

    public static Kitchen getInstance() {
        return instance;
    }

    public String innerVersion() {
        return "Kitchen 1.0";
    }

    public boolean innerLock() {
        if (isLocked == true)
            return false;

        isLocked = true;
        return true;
    }

    public boolean innerUnlock() {
        if (isLocked == false)
            return false;

        isLocked = false;
        return true;
    }

    public void innerSetKitchenType(KitchenType type) {
        kitchenType = type;
    }

    public double innerGetTotalWeightTrolleys() {
        return 0;
    }

    public void innerAddTrolley(Trolley trolley) {
        trolleyList.add(trolley);
    }

    public void innerEmptyTrolley(Trolley trolley) {
    }

    public class Port implements IKitchen {

        public String version() {
            return innerVersion();
        }

        public boolean lock() {
            return innerLock();
        }

        public boolean unlock() {
            return innerUnlock();
        }

        public double getTotalWeightTrolleys() {
            return innerGetTotalWeightTrolleys();
        }

        public void addTrolley(Trolley trolley) {
            innerAddTrolley(trolley);
        }

        public void emptyTrolley(Trolley trolley) {
            innerEmptyTrolley(trolley);
        }

        public void setKitchenType(String kitchenType) {
            for (KitchenType type : KitchenType.values()) {
                if (!type.toString().equals(kitchenType))
                    continue;

                innerSetKitchenType(type);
                return;
            }
        }
    }
}
