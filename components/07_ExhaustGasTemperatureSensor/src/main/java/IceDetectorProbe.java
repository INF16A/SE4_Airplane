public class IceDetectorProbe {
    private IceDetectorProbe() {

    }

    public String version() {
        return "IceDetectorProbe Serious Edition";
    }

    public boolean activate() {
        isActivated = true;
        return true;
    }

    public boolean detect() {
        return true;
    }

    public boolean detect(String surface) {
        return false;
    }

    public boolean detect(String surface, String pattern) {
        return isIceDetected = surface.matches(pattern);
    }

    public boolean deactivate() {
        isActivated = false;
        return true;
    }

    private String manufacturer = "DHBW";
    private String type = "zero";
    private String id = "0";
    private boolean isActivated = false;
    private boolean isIceDetected = false;
    private static IceDetectorProbe instance = new IceDetectorProbe();
    public Port port = new Port();

    public class Port implements IIceDetectorProbe {
        @Override
        public String version() {
            return instance.version();
        }

        @Override
        public boolean activate() {
            return instance.activate();
        }

        @Override
        public boolean detect() {
            return instance.detect();
        }

        @Override
        public boolean detect(String surface) {
            return instance.detect(surface);
        }

        @Override
        public boolean detect(String surface, String pattern) {
            return instance.detect(surface, pattern);
        }

        @Override
        public boolean deactivate() {
            return instance.deactivate();
        }
    }
}
