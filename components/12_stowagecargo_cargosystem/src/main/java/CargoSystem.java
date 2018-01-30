import java.util.ArrayList;

public class CargoSystem implements ICargoSystem {
    private String manufacturer;
    private String type;
    private String id;
    private ArrayList<Stowage> stowage;
    private boolean isLocked = false;
    private boolean isSecured;
    private double totalWeightContainer;
    private double totalWeightAirCargoPallet;
    private double totalWeight;

    public CargoSystem(String manufacturer, String type, String id) {
        this.manufacturer = manufacturer;
        this.type = type;
        this.id = id;
    }

    public String version() {
        return null;
    }

    public boolean unlock() {
        isLocked = false;
        return !isLocked;
    }

    public double load(Stowage stowage, ArrayList<Container> container) {
        /*for (Container con : container) {
            ArrayList<Container> list = stowage.getContainerList();
            list.add(con);
        }*/
        return 0.0;
    }

    public double determineTotalWeightContainer(Stowage stowage) {
        double sum = 0.0;
        for (Container container : stowage.getContainerList()) {
            for (Baggage baggage : container.getBaggageList()) {
                sum += baggage.getWeight();
            }
        }
        return sum;
    }

    public double determinetotalWeightAirCargoPallet(Stowage stowage) {
        double sum = 0.0;
        for (AirCargoPallet pallet : stowage.getAirCargoPalletList()) {
            sum += pallet.getWeight();
        }
        return sum;
    }

    public double determineTotalWeight(Stowage stowage) {
        double sum = 0.0;
        sum += determinetotalWeightAirCargoPallet(stowage);
        sum += determineTotalWeightContainer(stowage);
        return sum;
    }

    public boolean secure() {
        isSecured = true;
        return isSecured;
    }

    public boolean lock() {
        isLocked = true;
        return isLocked;
    }

    public ArrayList<Container> unloadContainer(Stowage stowage) {
        return null;
    }

    public ArrayList<AirCargoPallet> unloadAirCargoPallet(Stowage stowage) {
        return null;
    }

    public ArrayList<Stowage> getStowage() {
        return stowage;
    }

    public void setStowage(ArrayList<Stowage> stowage) {
        this.stowage = stowage;
    }

    public double getTotalWeightContainer() {
        return totalWeightContainer;
    }

    public void setTotalWeightContainer(double totalWeightContainer) {
        this.totalWeightContainer = totalWeightContainer;
    }

    public double getTotalWeightAirCargoPallet() {
        return totalWeightAirCargoPallet;
    }

    public void setTotalWeightAirCargoPallet(double totalWeightAirCargoPallet) {
        this.totalWeightAirCargoPallet = totalWeightAirCargoPallet;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }
}
