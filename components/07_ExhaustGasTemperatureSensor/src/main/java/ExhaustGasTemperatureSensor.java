public class ExhaustGasTemperatureSensor {

    private ExhaustGasTemperatureSensor() {

    }

    public String version() {
        return "Super fancy exhaust sensor 99.NaN.1e-10";
    }

    public int measure() {
        return 0;
    }

    public boolean alarmMajor(int threshold) {
        return threshold == 100;
    }

    public boolean alarmCritical(int threshold) {
        return threshold == 200;
    }

    private String manufacturer = "DHBW";
    private String type = "zero";
    private String id = "0";
    public Port port = new Port();
    private static ExhaustGasTemperatureSensor instance = new ExhaustGasTemperatureSensor();

    public class Port implements IExhaustGasTemperatureSensor {
        @Override
        public boolean alarmCritical(int threshold) {
            return instance.alarmCritical(threshold);
        }

        @Override
        public boolean alarmMajor(int threshold) {
            return instance.alarmMajor(threshold);
        }

        @Override
        public int measure() {
            return instance.measure();
        }

        @Override
        public String version() {
            return instance.version();
        }
    }
}