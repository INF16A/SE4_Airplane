import java.lang.reflect.Method;

/**
 * Created by SolDeEcuador on 30/01/2018.
 */
public class LogoLight {
    private static LogoLight instance = new LogoLight();
    public LogoLight.Port port;
    private String manufacturer;
    private String type;
    private String id;
    private boolean isOn;

    private LogoLight() {
        port = new LogoLight.Port();
    }

    public static LogoLight getInstance() {
        return instance;
    }

    public String innerMethodGetVersion() {
        return "LogoLight";
    }

    public class Port implements ILogoLight {
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