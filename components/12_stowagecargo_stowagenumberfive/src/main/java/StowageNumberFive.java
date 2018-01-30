import java.util.ArrayList;

/**
 * Created by felixbertsch on 30.01.18.
 */
public class StowageNumberFive implements IStowageNumberFive {
    private int maximumNuberofItems = 50;
    private ArrayList<Baggage> baggageList;
    private ArrayList<SpecialGood> specialGoodsList;

    public double loadBaggage(ArrayList<Baggage> baggageList) {
        return 0;
    }

    public double loadSpecialGood(ArrayList<SpecialGood> specialGoodList) {
    return 0;
    }
}
