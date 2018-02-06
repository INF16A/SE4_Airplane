import java.lang.reflect.Method;

/**
 * Created by SolDeEcuador on 30/01/2018.
 */
public class RightNavigationLight {
    private static RightNavigationLight instance = new RightNavigationLight();
    public RightNavigationLight.Port port;
    private String manufacturer;
    private String type;
    private String id;
    private boolean isOn;

    private RightNavigationLight() {
        port = new RightNavigationLight.Port();
    }

    public static RightNavigationLight getInstance() {
        return instance;
    }

    public String innerMethodGetVersion() {
        return "RightNavigationLight";
    }

    public LightType innerMethodSetType(String type) {
        for (LightType lightType : LightType.values()) {
            if (lightType.toString() == type) {
                this.type = lightType.toString();
                return lightType;
            }
        }
        return null;
    }

    public Position innerMethodSetPosition(String pos) {

        for (Position position : Position.values()) {
            if (position.toString() == pos) return position;
        }
        return null;
    }

    public class Port implements IRightNavigationLight {
        private Method[] methods = getClass().getMethods();

        @Override
        public String version() {
            return innerMethodGetVersion();
        }

        @Override
        public LightType setLightType(String type) {
            return innerMethodSetType(type);
        }

        @Override
        public Position setPosition(String position) {
            return innerMethodSetPosition(position);
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
