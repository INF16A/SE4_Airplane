import java.lang.reflect.Method;

/**
 * Created by SolDeEcuador on 30/01/2018.
 */
public class LeftNavigationLight {
    private String manufacturer;
    private String type;
    private String id;
    private boolean isOn;

    private static LeftNavigationLight instance = new LeftNavigationLight();
    public LeftNavigationLight.Port port;

    private LeftNavigationLight() {
        port = new LeftNavigationLight.Port();
    }

    public static LeftNavigationLight getInstance() {
        return instance;
    }

    public class Port implements ILeftNavigationLight {
        private Method[] methods = getClass().getMethods();

        @Override
        public String version() {
            return null;
        }

        @Override
        public LightType setLightType(String type) {
            return null;
        }

        @Override
        public Position setPosition(String position) {
            return null;
        }

        @Override
        public boolean on() {
            return false;
        }

        @Override
        public boolean off() {
            return false;
        }
    }

    public String innerMethodGetVersion() {
        return "LeftNavigationLight";
    }
}
