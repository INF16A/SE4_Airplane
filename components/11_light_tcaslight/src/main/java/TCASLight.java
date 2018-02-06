import java.lang.reflect.Method;

/**
 * Created by Endrit Callaki on 30.01.2018.
 */
public class TCASLight {
    private static TCASLight instance = new TCASLight();
    public Port port;
    private String manufacturer;
    private String type;
    private String id;
    private boolean isOn;

    private TCASLight() {
        port = new Port();
    }

    public static TCASLight getInstance() {
        return instance;
    }

    public String innerMethodGetVersion() {
        return "TCASLight";
    }

    public class Port implements ITCASLight {
        private Method[] methods = getClass().getMethods();

        @Override
        public boolean on() {
            return isOn = true;
        }

        @Override
        public String off() {
            isOn = false;
            return innerMethodGetVersion() + " is off.";
        }

        @Override
        public String version() {
            return innerMethodGetVersion();
        }
    }
}
