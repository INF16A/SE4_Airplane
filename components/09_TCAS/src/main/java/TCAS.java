public class TCAS implements ITCAS {

    private String manufacturer = "ExampleManufacturer 1";
    private String type = "Tube101";
    private String id = "1";
    private boolean isOn = true;
    private boolean isConnected;
    private boolean isAlarm = false;
    private int altitude;

    @Override
    public String version() {
        return "TCAS(id: " + id + ") by " + manufacturer + " type: " + type;
    }

    @Override
    public boolean on() {
        isOn = !isOn;
        return isOn;
    }

    @Override
    public boolean connect(String frequency) {
        isConnected = !frequency.isEmpty();
        return isConnected;
    }

    @Override
    public boolean scan(String environment) {
        return !environment.isEmpty();
    }

    @Override
    public boolean alarm() {
        isAlarm = !isAlarm;
        return isAlarm;
    }

    @Override
    public int determineAltitude(String environment) {
        return environment.length();
    }

    @Override
    public int setAltitude(int value) {
        altitude = value;
        return altitude;
    }

    @Override
    public boolean off() {
        return !isOn;
    }

}
