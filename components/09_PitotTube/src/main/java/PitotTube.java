public class PitotTube {

    private static PitotTube Instance = new PitotTube();

    public static PitotTube getInstance() {
        return Instance;
    }

    public Port port = new Port();

    private String manufacturer = "ExampleManufacturer 1";
    private String type = "Tube101";
    private String id = "1";
    private boolean isOn = false;
    private int velocity = 10;

    public class Port implements IPitotTube {

        @Override
        public String version() {
            return innerVersion();
        }

        @Override
        public int measureStaticPressure() {
            return velocity / 7;
        }

        @Override
        public int measureTotalPressure() {
            return velocity / 5;
        }

        @Override
        public int measureVelocity() {
            return velocity;
        }
    }

    public String innerVersion() {
        return "Pitot Tube(id: " + id + ") by " + manufacturer + " type: " + type;
    }

}
