public class Flap implements IFlap {
    private String manufacturer;
    private String type;
    private String id;
    private int degree;

    @Override
    public String version() {
        return null;
    }

    @Override
    public int neutral() {
        return 0;
    }

    @Override
    public int levelOne() {
        return 0;
    }

    @Override
    public int levelTwo() {
        return 0;
    }

    @Override
    public int levelThree() {
        return 0;
    }
}
