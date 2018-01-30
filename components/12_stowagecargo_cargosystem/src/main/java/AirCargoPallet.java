public class AirCargoPallet {
    private String id;
    private double weight;

    public AirCargoPallet(String id, double weight) {
        this.id = id;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }
}
