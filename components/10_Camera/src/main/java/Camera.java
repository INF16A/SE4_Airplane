public class Camera {

    private static Camera instance = new Camera();
    public Port port;
    private String manufacturer = "EADS";
    private CameraType type;
    private String id = "23";
    private boolean isOn;
    private double factor = 1.0;

    private Camera() {
        port = new Port();
    }

    public static Camera getInstance() {
        return instance;
    }

    public String innerVersion() {
        return "Camera " + id;
    }

    public class Port implements ICamera {
        public String version() {
            return innerVersion();
        }

        public CameraType setType(String t) {

            type = t.equals(CameraType.tail.toString()) ?
                    CameraType.tail : t.equals(CameraType.wing.toString()) ?
                    CameraType.wing : CameraType.taxi;

            return type;
        }

        public boolean on() {
            isOn = true;
            return isOn;
        }

        public String record() {
            return "Camera " + manufacturer;
        }

        public double zoomIn(boolean f) {
            return f ? factor * 2.0 : 2.0;
        }

        public boolean off() {
            isOn = false;
            return isOn;
        }
    }
}
