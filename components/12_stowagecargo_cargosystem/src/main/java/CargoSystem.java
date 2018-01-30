import java.lang.reflect.Method;
import java.util.ArrayList;

public class CargoSystem {
    private static CargoSystem instance = new CargoSystem();

    private String manufacturer;
    private String type;
    private String id;
    private ArrayList<Stowage> stowage;
    private boolean isLocked = false;
    private boolean isSecured;
    private double totalWeightContainer;
    private double totalWeightAirCargoPallet;
    private double totalWeight;
    private Port port;

    private CargoSystem() {
        this.manufacturer = "CargoManufacturer";
        this.type =  "123.2";
        this.id = "23";
        this.port = new Port();
    }

    public String innerVersion() {
        return "V1";
    }

    public boolean innerUnlock() {
        isLocked = false;
        return !isLocked;
    }

    public double innerLoadContainer(Stowage stowage, ArrayList<Container> container) {
        ArrayList<Container> list = stowage.getContainerList();
        double sum = 0.0;
        for (Container con : container) {
            for (Baggage baggage : con.getBaggageList()) {
                sum += baggage.getWeight();
            }
            list.add(con);
        }
        return sum;
    }

    public double innerLoadAirCargoPallet(Stowage stowage, ArrayList<AirCargoPallet> airCargoPalletList) {
        ArrayList<AirCargoPallet> list = stowage.getAirCargoPalletList();
        double sum = 0.0;
        for (AirCargoPallet airCargo : airCargoPalletList) {
            sum += airCargo.getWeight();
            list.add(airCargo);
        }
        return sum;
    }

    public double innerDetermineTotalWeightContainer(Stowage stowage) {
        double sum = 0.0;
        for (Container container : stowage.getContainerList()) {
            for (Baggage baggage : container.getBaggageList()) {
                sum += baggage.getWeight();
            }
        }
        return sum;
    }

    public double innerDeterminetotalWeightAirCargoPallet(Stowage stowage) {
        double sum = 0.0;
        for (AirCargoPallet pallet : stowage.getAirCargoPalletList()) {
            sum += pallet.getWeight();
        }
        return sum;
    }

    public double innerDetermineTotalWeight(Stowage stowage) {
        double sum = 0.0;
        sum += innerDeterminetotalWeightAirCargoPallet(stowage);
        sum += innerDetermineTotalWeightContainer(stowage);
        return sum;
    }

    public boolean innerSecure() {
        isSecured = true;
        return isSecured;
    }

    public boolean innerLock() {
        isLocked = true;
        return isLocked;
    }

    public ArrayList<Container> innerUnloadContainer(Stowage stowage) {
        ArrayList<Container> conList = stowage.getContainerList();
        stowage.getContainerList().clear();
        return conList;
    }

    public ArrayList<AirCargoPallet> innerUnloadAirCargoPallet(Stowage stowage) {
        ArrayList<AirCargoPallet> airCargoList = stowage.getAirCargoPalletList();
        stowage.getAirCargoPalletList().clear();
        return airCargoList;
    }

    public class Port implements ICargoSystem {
        private Method[] methods = getClass().getMethods();

        public void listMethods() {
            System.out.println("--- public methods for " + getClass().getName());
            for (int i = 0; i < methods.length; i++)
                if (!methods[i].toString().contains("Object") && !methods[i].toString().contains("list"))
                    System.out.println(methods[i]);
            System.out.println("---");
        }

        public String version() {
            return innerVersion();
        }

        public boolean unlock() {
            return innerUnlock();
        }

        public double loadContainer(Stowage stowage, ArrayList<Container> container) {
            return innerLoadContainer(stowage, container);
        }

        public double loadAirCargoPallet(Stowage stowage, ArrayList<AirCargoPallet> airCargoPalletList) {
            return innerLoadAirCargoPallet(stowage, airCargoPalletList);
        }

        public double determineTotalWeightContainer(Stowage stowage) {
            return innerDetermineTotalWeightContainer(stowage);
        }

        public double determinetotalWeightAirCargoPallet(Stowage stowage) {
            return innerDeterminetotalWeightAirCargoPallet(stowage);
        }

        public double determineTotalWeight(Stowage stowage) {
            return innerDetermineTotalWeight(stowage);
        }

        public boolean secure() {
            return innerSecure();
        }

        public boolean lock() {
            return innerLock();
        }

        public ArrayList<Container> unloadContainer(Stowage stowage) {
            return innerUnloadContainer(stowage);
        }

        public ArrayList<AirCargoPallet> unloadAirCargoPallet(Stowage stowage) {
            return innerUnloadAirCargoPallet(stowage);
        }
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
