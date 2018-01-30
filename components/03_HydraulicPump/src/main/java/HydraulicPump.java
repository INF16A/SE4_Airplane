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

    }


}
