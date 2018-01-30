import java.lang.reflect.Method;

/**
 * Created by SolDeEcuador on 30/01/2018.
 */
public class RightNavigationLight {
    private String manufacturer;
    private String type;
    private String id;
    private boolean isOn;

    private static RightNavigationLight instance = new RightNavigationLight();
    public RightNavigationLight.Port port;

    private RightNavigationLight() {
        port = new RightNavigationLight.Port();
    }

    public static RightNavigationLight getInstance() {
        return instance;
    }

    public class Port implements IRightNavigationLight {
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
}
