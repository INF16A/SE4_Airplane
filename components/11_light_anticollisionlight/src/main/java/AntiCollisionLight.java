import java.lang.reflect.Method;

/**
 * Created by SolDeEcuador on 30/01/2018.
 */
public class AntiCollisionLight {
    private String manufacturer;
    private String type;
    private String id;
    private boolean isOn;

    private static AntiCollisionLight instance = new AntiCollisionLight();
    public AntiCollisionLight.Port port;

    private AntiCollisionLight() {
        port = new AntiCollisionLight.Port();
    }

    public static AntiCollisionLight getInstance() {
        return instance;
    }

    public class Port implements IAntiCollisionLight {
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
        public boolean off() {
            return false;
        }
    }

    public String innerMethodGetVersion() {
        return "AntiCollisionLight";
    }
}