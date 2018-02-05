/**
 * Created by Lenovo on 30.01.2018.
 */
public interface IGear {
    public String version();

    public GearType setType(String type);

    public boolean down();

    public boolean up();

    public int setBrake();

    public int setBreak(int percentage);

    public int releaseBrake();
}
