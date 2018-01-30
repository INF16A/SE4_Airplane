import java.lang.reflect.Method;

/**
 * Created by SolDeEcuador on 30/01/2018.
 */
public class CargoCompartmentLight {
    private String manufacturer;
    private String type;
    private String id;
    private boolean isOn;

    private static CargoCompartmentLight instance = new CargoCompartmentLight();
    public Port port;

    private CargoCompartmentLight() {
        port = new Port();
    }

    public static CargoCompartmentLight getInstance() {
        return instance;
    }

    public class Port implements ICargoCompartmentLight {
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
        return "CargoCompartmentLight";
    }
}