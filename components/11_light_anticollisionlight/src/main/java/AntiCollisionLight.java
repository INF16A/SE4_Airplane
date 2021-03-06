import java.lang.reflect.Method;

/**
 * Created by SolDeEcuador on 30/01/2018.
 */
public class AntiCollisionLight {
    private static AntiCollisionLight instance = new AntiCollisionLight();
    public AntiCollisionLight.Port port;
    private String manufacturer;
    private String type;
    private String id;
    private boolean isOn;

    private AntiCollisionLight() {
        port = new AntiCollisionLight.Port();
    }

    public static AntiCollisionLight getInstance() {
        return instance;
    }

    public String innerMethodGetVersion() {
        return "AntiCollisionLight";
    }

    public class Port implements IAntiCollisionLight {
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