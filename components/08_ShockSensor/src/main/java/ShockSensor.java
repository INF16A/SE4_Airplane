public class ShockSensor implements IShockSensor{

    String manufacturer;
    String type;
    String id;
    boolean isCalibrated;
    boolean isShockDetected;

    public String version() {
        return null;
    }

    public boolean calibrate() {
        return false;
    }

    public boolean calibrate(double level) {
        return false;
    }

    public int measure() {
        return 0;
    }

    public boolean alarm() {
        return false;
    }
}
