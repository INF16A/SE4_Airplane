import java.lang.reflect.Method;

/**
 * Created by Endrit Callaki on 30.01.2018.
 */
public class TCASLight {
    private String manufacturer;
    private String type;
    private String id;
    private boolean isOn;

    private static TCASLight instance = new TCASLight();
   // public Port port;

    private TCASLight() {
      //  port = new Port();
    }

    public static TCASLight getInstance() {
        return instance;
    }

    /*public class Port implements ITCASLight {
        private Method[] methods = getClass().getMethods();

        public String getVersion() {
            return innerMethodGetVersion();
        }
    }*/

    public String innerMethodGetVersion() {
        return "Lichtname";
    }
}
