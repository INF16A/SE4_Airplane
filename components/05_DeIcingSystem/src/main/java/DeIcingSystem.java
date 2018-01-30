package main.java;

public class DeIcingSystem implements IDeIcingSystem {

    private String manufacturer;
    private String type;
    private String id;
    private int amount;
    private boolean isActivated;

    private DeIcingSystem() {
        this.manufacturer = "MDeIcingSystem";
        this.type = "TDeIceSystem";
        this.id = "ID53";
        this.isActivated = false;
        this.amount = 1000;
    }

    @Override
    public String version() {
        return "v1.0";
    }

    @Override
    public int deIce(int amount) {
        if (this.amount < amount) {
            this.amount = 0;
        } else {
            this.amount = this.amount - amount;
        }
        return amount;
    }

    @Override
    public int refill() {
        amount = 1000;
        return amount;
    }

    @Override
    public boolean activate() {
        isActivated = true;
        return isActivated;
    }

    @Override
    public boolean deactivate() {
        isActivated = false;
        return isActivated;
    }
}
