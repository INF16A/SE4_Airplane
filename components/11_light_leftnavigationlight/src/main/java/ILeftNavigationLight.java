/**
 * Created by SolDeEcuador on 30/01/2018.
 */
public interface ILeftNavigationLight {
    String version();

    LightType setLightType(String type);

    Position setPosition(String position);

    boolean on();

    boolean off();
}
