package lights;

/**
 * Created by Endrit Callaki on 30.01.2018.
 */
public interface ILeftNavigationLight {
    public String version();
    public LightType setLightType(String type);
    public Position setPosition(String position);
    public boolean on();
    public boolean off();
}
