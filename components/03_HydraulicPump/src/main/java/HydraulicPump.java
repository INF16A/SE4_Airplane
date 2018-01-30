/**
 * Created by Lenovo on 30.01.2018.
 */
public class HydraulicPump {
    private String manufacturer;
    private String type;
    private String id;
    private int amount = 1000;

    public Port port;
    private HydraulicPump instance = new HydraulicPump();

    private HydraulicPump()
    {
        port = new Port();
    }


    public class Port implements IHydraulicPump
    {

        public String version() {
            return null;
        }

        public int compress() {
            return 0;
        }

        public int compress(int amount) {
            return 0;
        }

        public int decompress() {
            return 0;
        }

        public int refilOil() {
            return 0;
        }

        public int refillOil(int amount) {
            return 0;
        }
    }


}
