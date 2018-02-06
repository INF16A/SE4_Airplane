import java.lang.reflect.Method;

/**
 * Created by Endrit Callaki on 30.01.2018.
 */
public class TaxiLight {
    private static TaxiLight instance = new TaxiLight();
    public TaxiLight.Port port;
    private String manufacturer;
    private String type;
    private String id;
    private boolean isOn;

    private TaxiLight() {
        port = new TaxiLight.Port();
    }

    public static TaxiLight getInstance() {
        return instance;
    }

    public String innerMethodGetVersion() {
        return "TaxiLight";
    }

    public class Port implements ITaxiLight {
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


