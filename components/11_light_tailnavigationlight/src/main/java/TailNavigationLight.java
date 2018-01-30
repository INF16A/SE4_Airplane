import java.lang.reflect.Method;

/**
 * Created by Endrit Callaki on 30.01.2018.
 */
public class TailNavigationLight {
    private String manufacturer;
    private String type;
    private String id;
    private boolean isOn;

    private static TailNavigationLight instance = new TailNavigationLight();
    public TailNavigationLight.Port port;

    private TailNavigationLight() {
        port = new TailNavigationLight.Port();
    }

    public static TailNavigationLight getInstance() {
        return instance;
    }

    public class Port implements ITailNavigationLight {
        private Method[] methods = getClass().getMethods();

        @Override
        public String version() {
            return null;
        }

        @Override
        public boolean on() {
            return false;
        }

        @Override
        public String off() {
            return null;
        }
    }

    public String innerMethodGetVersion() {
        return "LogoLight";
    }
}
