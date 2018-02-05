public class VHF {

    private static VHF instance = new VHF();
    public Port port;
    private String manufacturer = "EADS";
    private String type;
    private String id = "27";
    private boolean isOn;
    private String[] channelList = {"182.67", "133.70", "123.45", "120.42"};
    private String selectedChannel;

    private VHF() {
        port = new Port();
    }

    public static VHF getInstance() {
        return instance;
    }

    public String innerVersion() {
        return "VHF " + id;
    }

    public class Port implements IVHF {

        public String version() {
            return innerVersion();
        }

        public boolean on() {
            isOn = true;
            return isOn;
        }

        public String[] search() {
            return channelList;
        }

        public String forwardChannel() {
            return "Next channel selected";
        }

        public String backwardChannel() {
            return "Previous channel selected";
        }

        public String selectChannel(String channel) {
            selectedChannel = channel;
            return selectedChannel;
        }

        public boolean off() {
            isOn = false;
            return isOn;
        }
    }
}
