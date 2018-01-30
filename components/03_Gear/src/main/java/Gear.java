import java.util.ArrayList;

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
    private Gear instance = new Gear();

    private Gear()
    {
        port = new Port();
    }


    public class Port implements IGear
    {

        public String version() {
            return "Gear 1.0";
        }

        public GearType setType(String newType) {
           if(newType.equals(GearType.front))
               type = GearType.front;
            if(newType.equals(GearType.rear))
                type = GearType.rear;

            return type;
        }

        public boolean down() {
            return false;
        }

        public boolean up() {
            isDown = false;
            return isDown;
        }

        //brake active == 100
        //brake not active == 0
        public int setBrake() {
            return 100;
        }

        public int setBreak(int percentage) {
            return percentage;
        }

        public int releaseBrake() {
            return 0;
        }
    }


}
