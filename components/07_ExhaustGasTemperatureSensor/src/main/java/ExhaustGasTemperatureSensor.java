public class ExhaustGasTemperatureSensor implements IExhaustGasTemperatureSensor {

    public String version() {
        return "Super fancy exhaust sensor 99.NaN.1e-10";
    }

    public int measure() {
        return 0;
    }

    public boolean alarmMajor(int threshold) {
        return threshold==100;
    }

    public boolean alarmCritical(int threshold) {
        return threshold==200;
    }
    private  String manufacturer="DHBW";
    private  String type="zero";
    private  String id="0";
}