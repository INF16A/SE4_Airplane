public class TemperatureSensor implements  ITemperatureSensor{

    String manufacturer;
    String type;
    String id;
    int temperature;
    boolean isAlarm;

    public String version() {
        return null;
    }

    public int measure() {
        return 0;
    }

    public boolean alarm(int threshold) {
        return false;
    }
}
