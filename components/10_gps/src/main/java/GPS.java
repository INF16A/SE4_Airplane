public class GPS
{
    private String manufacturer = "EADS";
    private String type = "flight gps";
    private String id = "17.34";
    private boolean isOn = false;
    private boolean isConnected = false;

    private static GPS instance = new GPS();

    public Port port;

    private GPS() {
        port = new Port();
    }

    public static GPS getInstance() {
        return instance;
    }

    public String innerVersion() {
        return "GPS" + id;
    }

    public class Port implements IGPS {
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

        public boolean connect(String satellite) {
            if(!isOn)
                return false;
            else
                isConnected = true;
                return isConnected;
        }

        public String receive(){
            if(! isConnected)
                return "no satellite connection";
            else
                return "position is 52°31'12.025 N and 13°24'17.834 E";
        }

        public void send(String request){
            if(!isConnected)
                System.out.println("No connection");
            else
                System.out.println(request + "has been send successfully");
        }
    }
}