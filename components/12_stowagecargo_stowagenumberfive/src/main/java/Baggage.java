/**
 * Created by felixbertsch on 30.01.18.
 */
public class Baggage {
    private String id;
    private double weight;
    private BaggageType baggageType;

    public Baggage(String id, double weight, BaggageType baggageType) {
        this.id = id;
        this.weight = weight;
        this.baggageType = baggageType;
    }

    public double getWeight() {
        return weight;
    }

}
