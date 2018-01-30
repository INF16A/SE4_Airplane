public class OxygenSensor implements IOxygenSensor{

    String manufacturer;
    String type;
    String id;
    boolean isAlarm;

    public String version() {
        return null;
    }

    public int measure(String airFlow) {
        return 0;
    }

    public boolean alarm() {
        return false;
    }
}
