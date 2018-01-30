package main.java;

public class EngineOilTank implements IEngineOilTank{

    private String manufacturer;
    private String type;
    private String id;
    private int level;
    public static final int START_LEVEL = 10;

    private EngineOilTank() {
        this.manufacturer="mEngingeOilTank";
        this.type = "TEngingeOilTank";
        this.id = "ID54";
        this.level = START_LEVEL;
    }

    public int getLevel() {
        return this.level;
    }

    @Override
    public String version() {
        return "v1";
    }

    @Override
    public int increaseLevel(int value) {
        this.level = this.level + value;
        return level;
    }

    @Override
    public int decreaseLevel(int value) {
        this.level -=value;
        if (this.level < 0) {
            level = 0;
        }
        return level;
    }
}
