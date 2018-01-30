public class FuelSensor {
    private FuelSensor() {

    }

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
    private static FuelSensor instance = new FuelSensor();
    public Port port = new Port();

    public class Port implements IFuelSensor {
        @Override
        public String version() {
            return instance.version();
        }

        @Override
        public int measure() {
            return instance.measure();
        }

        @Override
        public boolean alarmReserve(int threshold) {
            return instance.alarmReserve(threshold);
        }

        @Override
        public boolean alarmMajor(int threshold) {
            return instance.alarmMajor(threshold);
        }

        @Override
        public boolean alarmCritical(int threshold) {
            return instance.alarmCritical(threshold);
        }
    }
}
