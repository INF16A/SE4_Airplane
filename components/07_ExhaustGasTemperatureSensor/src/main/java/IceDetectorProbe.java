public class IceDetectorProbe implements IIceDetectorProbe {
    public String version() {
        return "IceDetectorProbe Serious Edition";
    }

    public boolean activate() {
        isActivated=true;
        return true;
    }

    public boolean detect() {
        return true;
    }

    public boolean detect(String surface) {
        return false;
    }

    public boolean detect(String surface, String pattern) {
        return isIceDetected=surface.matches(pattern);
    }

    public boolean deactivate() {
        isActivated=false;
        return true;
    }
    private  String manufacturer="DHBW";
    private  String type="zero";
    private  String id="0";
    private  boolean isActivated=false;
    private  boolean isIceDetected=false;
}
