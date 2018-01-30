public class FuelFlowSensor {
    private FuelFlowSensor() {

    }

    public String version() {
        return "super fuel flow sensor extreme edition TM";
    }

    public int measure() {
        return fuelFlow;
    }

    private String manufacturer = "DHBW";
    private String type = "zero";
    private String id = "0";
    private int fuelFlow = 10;
    public Port port = new Port();
    private static FuelFlowSensor instance = new FuelFlowSensor();

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
