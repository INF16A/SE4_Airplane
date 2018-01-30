public class FuelSensor implements IFuelSensor {
    public String version() {
        return "FuelSensor (c)";
    }

    public boolean alarmReserve(int threshold) {
        return isAlarmReserve;
    }

    public boolean alarmMajor(int threshold) {
        return isAlarmMajor;
    }

    public boolean alarmCritical(int threshold) {
        return isAlarmCritical;
    }

    public int measure() {
        return 99;
    }

    private String manufacturer = "DHBW";
    private String type = "zero";
    private String id = "0";
    private boolean isAlarmReserve = false;
    private boolean isAlarmCritical = false;
    private boolean isAlarmMajor = false;
}
