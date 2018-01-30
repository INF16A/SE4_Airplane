import java.util.ArrayList;

/**
 * Created by felixbertsch on 30.01.18.
 */
public class StowageNumberFive{
    private static StowageNumberFive instance = new StowageNumberFive();
    private int maximumNuberofItems = 50;
    private ArrayList<Baggage> baggageList;
    private ArrayList<SpecialGood> specialGoodsList;
    public Port port;

    private StowageNumberFive(){
        this.port = new Port();
    }

    public void setMaximumNuberofItems(int maximumNuberofItems) {
        this.maximumNuberofItems = maximumNuberofItems;
    }

    private class Port implements IStowageNumberFive {

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
}
