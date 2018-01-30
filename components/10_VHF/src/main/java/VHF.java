public class VHF implements IVHF{

    private String manufacturer = "EADS";
    private String type;
    private String id = "27";
    private boolean isOn;
    private String[] channelList = {"182.67", "133.70", "123.45", "120.42"};
    private String selectedChannel;

    public String version() { return "VHF " + this.id; }

    public boolean on() {
        this.isOn = true;
        return isOn;
    }

    public String[] search() {
        return this.channelList;
    }

    public String forwardChannel() {
        return "Next channel selected";
    }

    public String backwardChannel() {
        return "Previous channel selected";
    }

    public String selectChannel(String channel) {
        this.selectedChannel = channel;
        return this.selectedChannel;
    }

    public boolean off() {
        this.isOn = false;
        return isOn;
    }
}
