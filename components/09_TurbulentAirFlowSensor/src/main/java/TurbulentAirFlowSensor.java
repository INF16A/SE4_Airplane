public class TurbulentAirFlowSensor implements ITurbulentAirFlowSensor {

    private String  manufacturer;
    private String type;
    private String id;
    private boolean isAlarm;

    @Override
    public String version() {
        return null;
    }

    @Override
    public int measure(String airFlow) {
        return 0;
    }

    @Override
    public boolean alarm() {
        return false;
    }
}
