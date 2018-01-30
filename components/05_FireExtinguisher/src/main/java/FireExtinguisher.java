package main.java;

public class FireExtinguisher implements IFireExtinguisher {

    private String manufacturer;
    private String type;
    private String id;
    private int percentage;

    private FireExtinguisher() {
        this.manufacturer = "MFireExinguisher";
        this.type = "TFireExtinguisher";
        this.id = "ID55";
        this.percentage = 100;
    }

    @Override
    public String version() {
        return "v1.0";
    }

    @Override
    public int refill() {
        return 0;
    }

    @Override
    public int apply() {
        return 0;
    }
}
