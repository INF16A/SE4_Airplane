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


    public String version() {
        return null;
    }

    public boolean unlock() {
        return false;
    }

    public double load(Stowage stowage, ArrayList<Container> container) {
        return 0;
    }

    public double determineTotalWeightContainer(Stowage stowage) {
        return 0;
    }

    public double determinetotalWeightAirCargoPallet(Stowage stowage) {
        return 0;
    }

    public double determineTotalWeight(Stowage stowage) {
        return 0;
    }

    public boolean secure() {
        return false;
    }

    public boolean lock() {
        return false;
    }

    public ArrayList<Container> unlockContainer(Stowage stowage) {
        return null;
    }

    public ArrayList<AirCargoPallet> unloadAirCargoPallet(Stowage stowage) {
        return null;
    }
}
