/**
 * Created by Lenovo on 30.01.2018.
 */
public class HydraulicPump {
    private String manufacturer;
    private String type;
    private String id;
    private int amount = 1000;

    public Port port;
    private static HydraulicPump instance = new HydraulicPump();

    private HydraulicPump()
    {
        port = new Port();
        this.manufacturer = "Best HydraulicPump Customer";
        this.type = "Best HydraulicPump Type";
        this.id = "1";
    }

    public static HydraulicPump getInstance(){
        return instance;
    }

    public class Port implements IHydraulicPump
    {

        public String version() {
            return "Hydraulic Pump 1,0";
        }

        public int compress() {
            amount /= 2;
            return amount;
        }

        public int compress(int newAmount) {
            amount -= newAmount;
            return 0;
        }

        public int decompress() {
            amount *= 2;
            return amount;
        }

        public int refilOil() {
            amount = 100;
            return amount;
        }

        public int refillOil(int newAmount) {
            amount += newAmount;
            return amount;
        }
    }


}
