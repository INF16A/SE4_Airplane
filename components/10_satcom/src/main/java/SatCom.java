public class SatCom {


    private String manufacturer = "Motorola";
    private String type = "multi-frequency iridium SatCom";
    private String id = "312.54";
    private boolean isConnected = false;
    private boolean isOn;

    private static SatCom instance = new SatCom();

    public Port port;

    private SatCom() {
        port = new Port();
    }

    public static SatCom getInstance() {
        return instance;
    }

    public String innerVersion() {
        return "SatCom " + id;
    }

    public class Port implements ISatCom {
        public String version() {
            return innerVersion();
        }

        public boolean on() {
            isOn = true;
            return isOn;
        }

        public boolean off() {
            isOn = false;
            isConnected = false;
            return isOn;
        }

        public boolean connect(String satellite, String frequency) {
            if(!isOn)
                return false;
            else{
                isConnected = true;
                return true;
            }
        }

        public void send(String request){
            if(!isConnected)
                System.out.println("No connection");
            else
                System.out.println("Signal has been send");
        }

        public String receive() {
            if(!isConnected)
                return "no satellite connection";
            else
                return "No weather warning ahead";
        }
    }
}