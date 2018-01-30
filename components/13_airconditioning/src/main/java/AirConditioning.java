public class AirConditioning {
    private static AirConditioning instance = new AirConditioning();

    public static AirConditioning getInstance() {
        return instance;
    }

    public Port port;

    private String manufacturer;
    private String type;
    private String id;
    private int temperature;
    private boolean isOn;

    public class Port implements IAirConditioning {

        public String version() {
            return innerVersion();
        }

        public boolean on() {
            return innerOn();
        }

        public String clean(String airFlow) {
            return innerClean(airFlow);
        }

        public String heat(String airFlow, int temperature) {
            return innerHeat(airFlow, temperature);
        }

        public String cool(String airFlow, int temperature) {
            return innerCool(airFlow, temperature);
        }

        public boolean off() {
            return innerOff();
        }
    }

    private AirConditioning() {
        manufacturer = "INF16B";
        type = "A good one";
        id = "1";
        temperature = 20;
        port = new Port();
    }

    private String innerVersion() {
        return "AirConditioning 1.0";
    }

    private boolean innerOn() {
        if(isOn == true)
            return false;

        isOn = true;
        return true;
    }

    private String innerClean(String airFlow) {
        return "Cleaned airflow " + airFlow;
    }

    private String innerHeat(String airFlow, int temperature) {
        this.temperature+=temperature;
        return "Heated airflow " + airFlow + " to " + temperature;
    }

    private String innerCool(String airFlow, int temperature) {
        this.temperature-=temperature;
        return "cooled airflow " + airFlow + " to " + temperature;
    }

    private boolean innerOff() {
        if(isOn == false)
            return false;

        isOn = false;
        return true;
    }
}
