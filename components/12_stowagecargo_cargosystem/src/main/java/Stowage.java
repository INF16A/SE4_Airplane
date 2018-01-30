import java.util.ArrayList;

public class Stowage {
    private StowageType type;
    private int maximumNumberOfContainer = 14;
    private int maximumNumberOfAirPallets = 7;
    private ArrayList<Container> containerList;
    private ArrayList<AirCargoPallet> airCargoPalletList;

    public Stowage(StowageType type) {
        this.type = type;
    }

    public ArrayList<Container> getContainerList() {
        return containerList;
    }

    public void setContainerList(ArrayList<Container> containerList) {
        this.containerList = containerList;
    }

    public ArrayList<AirCargoPallet> getAirCargoPalletList() {
        return airCargoPalletList;
    }

    public void setAirCargoPalletList(ArrayList<AirCargoPallet> airCargoPalletList) {
        this.airCargoPalletList = airCargoPalletList;
    }

    public StowageType getType() {
        return type;
    }

    public void setType(StowageType type) {
        this.type = type;
    }

    public int getMaximumNumberOfContainer() {
        return maximumNumberOfContainer;
    }

    public int getMaximumNumberOfAirPallets() {
        return maximumNumberOfAirPallets;
    }
}
