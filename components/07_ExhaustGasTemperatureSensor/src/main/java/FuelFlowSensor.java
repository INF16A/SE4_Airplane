public class FuelFlowSensor implements  IFuelFlowSensor {
    public String version() {
        return "super fuel flow sensor extreme edition TM";
    }

    public int measure() {
        return fuelFlow;
    }
    private  String manufacturer="DHBW";
    private  String type="zero";
    private  String id="0";
    private  int fuelFlow=10;

}
