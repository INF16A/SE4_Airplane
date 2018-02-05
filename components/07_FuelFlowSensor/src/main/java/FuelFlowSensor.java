public class FuelFlowSensor {
    private static FuelFlowSensor instance = new FuelFlowSensor();
    public Port port = new Port();
    private String manufacturer = "DHBW";
    private String type = "zero";
    private String id = "0";
    private int fuelFlow = 10;

    private FuelFlowSensor() {

    }

    public static FuelFlowSensor getInstance() {
        return instance;
    }

    public String version() {
        return "super fuel flow sensor extreme edition TM";
    }

    public int measure() {
        return fuelFlow;
    }

    public class Port implements IFuelFlowSensor {

        @Override
        public String version() {
            return instance.version();
        }

        @Override
        public int measure() {
            return instance.measure();
        }
    }
}
