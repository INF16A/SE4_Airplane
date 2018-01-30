import javafx.geometry.Pos;

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

    public String innerMethodGetVersion() {
        return "LeftNavigationLight";
    }
}
