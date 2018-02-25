import java.util.ArrayList;

public class StowageNumberFive implements IStowageNumberFive {
    private int maximumNuberofItems = 50;
    private ArrayList<Baggage> baggageList;
    private ArrayList<SpecialGood> specialGoodsList;

    public StowageNumberFive(int maximumNuberofItems) {
        this.maximumNuberofItems = maximumNuberofItems;
    }

    public double loadBaggage(ArrayList<Baggage> baggageList) {
        double totalWeight = 0;
        for (int i = 0; i < baggageList.size(); i++) {
            totalWeight += baggageList.get(i).getWeight();
        }
        return totalWeight;
    }

    public double loadSpecialGood(ArrayList<SpecialGood> specialGoodList) {
        return 0;
    }
}
