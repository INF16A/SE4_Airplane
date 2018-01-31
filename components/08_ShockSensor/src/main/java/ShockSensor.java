public class ShockSensor {

    private static ShockSensor Instance = new ShockSensor();

    public static ShockSensor getInstance() {
        return Instance;
    }

    public Port port = new Port();

    private String manufacturer = "Center Shock";
    private String type = "Shockwave 1000";
    private String id = "36214";
    private boolean isCalibrated = true;
    private boolean isShockDetected = false;

    public class Port implements IShockSensor {

        @Override
        public String version() {
            return innerVersion();
        }

        @Override
        public boolean calibrate() {
            return isCalibrated;
        }

        @Override
        public boolean calibrate(double level) {
            return isCalibrated;
        }

        @Override
        public int measure() {
            return 0;
        }

        @Override
        public boolean alarm() {
            return isShockDetected;
        }

        public String innerVersion() {
            return "ShockSensor(id: " + id + ") by " + manufacturer + " with Type " + type;
        }

    }
