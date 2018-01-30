public class FireDetector implements IFireDetector{

    String manufacturer;
    String type;
    String id;
    boolean isAlarm;

    public String version() {
        return null;
    }

    public boolean scan(String air) {
        return false;
    }

    public boolean alarm() {
        return false;
    }
}
