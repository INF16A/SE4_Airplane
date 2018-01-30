public class Radar {

    private String manufacturer = "EADS";
    private String type = "flight radar";
    private String id = "0.18.123";
    private boolean isOn = false;

    private static Radar instance = new Radar();

    public Port port;

    private Radar() {
        port = new Port();
    }

    public static Radar getInstance() {
        return instance;
    }

    public String innerVersion() {
        return "Radar " + id;
    }

    public class Port implements IRadar {
        public String version() {
            return innerVersion();
        }

        public boolean on() {
            isOn = true;
            return isOn;
        }

        public boolean off() {
            isOn = false;
            return isOn;
        }

        public boolean scan(String environment) {
            return environment.contains("bird");
        }
    }
}