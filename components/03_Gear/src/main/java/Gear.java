/**
 * Created by Lenovo on 30.01.2018.
 */
public class Gear {
    private String manufacturer;
    private GearType type;
    private String id;
    private ArrayList<Wheel> wheels;
    private boolean isDown;


    public Port port;
    private Gear instance = new Gear;

    private Gear()
    {
        port = new Port();
    }


    public class Port implements IGear
    {

    }


}
