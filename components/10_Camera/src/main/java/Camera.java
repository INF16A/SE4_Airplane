public class Camera implements ICamera {

    private String manufacturer = "EADS";
    private CameraType type;
    private String id = "23";
    private boolean isOn;
    private double factor = 1.0;

    public String version() {
        return "Camera " + id;
    }

    public CameraType setType(String type) {

        this.type = type.equals(CameraType.tail.toString()) ?
                    CameraType.tail : type.equals(CameraType.wing.toString()) ?
                    CameraType.wing : CameraType.taxi;

        return this.type;
    }

    public boolean on() {
        this.isOn = true;
        return isOn;
    }

    public String record() {
        return "Camera " + this.manufacturer;
    }

    public double zoomIn(boolean factor) {
        return factor ? this.factor*2.0 : 2.0 ;
    }

    public boolean off() {
        this.isOn = false;
        return isOn;
    }
}
