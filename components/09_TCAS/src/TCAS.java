public class TCAS implements ITCAS {

    private String manufacturer;
    private String type;
    private String id;
    private boolean isOn;
    private boolean isConnected;
    private boolean isAlarm;
    private int altitude;

    @Override
    public String version() {
        return null;
    }

    @Override
    public boolean on() {
        return false;
    }

    @Override
    public boolean connect(String frequency) {
        return false;
    }

    @Override
    public boolean scan(String environment) {
        return false;
    }

    @Override
    public boolean alarm() {
        return false;
    }

    @Override
    public int determineAltitude(String environment) {
        return 0;
    }

    @Override
    public int setAltitude(int value) {
        return 0;
    }

    @Override
    public boolean off() {
        return false;
    }
}
