public class RadarAltimeter implements IRadarAltimeter{

    private String manufacturer;
    private String type;
    private String id;
    private boolean isOn;
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
    public void send(String radioWave) {

    }

    @Override
    public int receive(String radioWave) {
        return 0;
    }

    @Override
    public int measureAltitude() {
        return 0;
    }

    @Override
    public boolean off() {
        return false;
    }
}
