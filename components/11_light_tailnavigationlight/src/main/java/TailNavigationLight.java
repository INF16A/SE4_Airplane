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

    public String innerMethodGetVersion() {
        return "TailNavigationLight";
    }
}
