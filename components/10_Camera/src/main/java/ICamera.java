public interface ICamera {

    public String version();

    public CameraType setType(String type);

    public boolean on();

    public String record();

    public double zoomIn(boolean f);

    public boolean off();
}
