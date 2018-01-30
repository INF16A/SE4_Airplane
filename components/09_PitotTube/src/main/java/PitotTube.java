public class PitotTube implements IPitotTube {

    private String manufacturer;
    private String type;
    private String id;
    private boolean isOn;
    private int velocity;

    @Override
    public String version() {
        return "Pitot Tube by "+manufacturer+" type: "+type;
    }

    @Override
    public int measureStaticPressure() {
        return 0;
    }

    @Override
    public int measureTotalPressure() {
        return 0;
    }

    @Override
    public int measureVelocity() {
        return 0;
    }
}
