import java.util.ArrayList;

public class Container {
    private ContainerType type;
    private int id;
    private ContainerCategory category;
    private ContainerProfile profile;
    private String barCodeIDCategory;
    private String qrCodeIDCategory;
    private int maximumNumberOfBaggages;
    private ArrayList<Baggage> baggageList;

    public ContainerType getType() {
        return type;
    }

    public void setType(ContainerType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ContainerCategory getCategory() {
        return category;
    }

    public void setCategory(ContainerCategory category) {
        this.category = category;
    }

    public ContainerProfile getProfile() {
        return profile;
    }

    public void setProfile(ContainerProfile profile) {
        this.profile = profile;
    }

    public String getBarCodeIDCategory() {
        return barCodeIDCategory;
    }

    public void setBarCodeIDCategory(String barCodeIDCategory) {
        this.barCodeIDCategory = barCodeIDCategory;
    }

    public String getQrCodeIDCategory() {
        return qrCodeIDCategory;
    }

    public void setQrCodeIDCategory(String qrCodeIDCategory) {
        this.qrCodeIDCategory = qrCodeIDCategory;
    }

    public int getMaximumNumberOfBaggages() {
        return maximumNumberOfBaggages;
    }

    public void setMaximumNumberOfBaggages(int maximumNumberOfBaggages) {
        this.maximumNumberOfBaggages = maximumNumberOfBaggages;
    }

    public ArrayList<Baggage> getBaggageList() {
        return baggageList;
    }

    public void setBaggageList(ArrayList<Baggage> baggageList) {
        this.baggageList = baggageList;
    }
}
