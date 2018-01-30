public class Airflowsensor implements IAirflowSensor {

    private String manufacutrer;
    private String type;
    private int airPressure;
    private boolean isAlarm;

    @Override
    public String version() {
        return "Airflowsensor by " + manufacutrer + " " + type;
    }

    @Override
    public int measure(String airFlow) {
        return 0;
    }

    @Override
    public boolean alarm(int threshhold) {
        return false;
    }
}
