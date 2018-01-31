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

        public String version() {
            return innerVersion();
        }

        public boolean calibrate() {
            return isCalibrated;
        }

        public boolean calibrate(double level) {
            return isCalibrated;
        }

        public int measure() {
            return 0;
        }

        public boolean alarm() {
            return isShockDetected;
        }
    }

    public String innerVersion() {
        return "ShockSensor(id: " + id + ") by " + manufacturer + " with Type " + type;
    }

}
