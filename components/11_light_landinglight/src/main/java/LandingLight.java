import java.lang.reflect.Method;

/**
 * Created by SolDeEcuador on 30/01/2018.
 */
public class LandingLight {
    private static LandingLight instance = new LandingLight();
    public LandingLight.Port port;
    private String manufacturer;
    private String type;
    private String id;
    private boolean isOn;

    private LandingLight() {
        port = new LandingLight.Port();
    }

    public static LandingLight getInstance() {
        return instance;
    }

    public String innerMethodGetVersion() {
        return "LandingLight";
    }

    public class Port implements ILandingLight {
        private Method[] methods = getClass().getMethods();

        @Override
        public String version() {
            return innerMethodGetVersion();
        }

        @Override
        public boolean on() {

            return isOn = true;
        }

        @Override
        public boolean off() {
            return isOn = false;
        }
    }
}