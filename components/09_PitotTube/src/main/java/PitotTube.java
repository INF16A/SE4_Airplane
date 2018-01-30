public class PitotTube implements IPitotTube {

    private String manufacturer = "ExampleManufacturer 1";
    private String type = "Tube101";
    private String id = "1";
    private boolean isOn = false;
    private int velocity = 10;

    @Override
    public String version() {
        return "Pitot Tube(id: " + id + ") by " + manufacturer + " type: " + type;
    }

    @Override
    public int measureStaticPressure() {
        return 10;
    }

    @Override
    public int measureTotalPressure() {
        return 25;
    }

    @Override
    public int measureVelocity() {
        return velocity;
    }

}
