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
    private static Gear instance = new Gear();

    public static Gear getInstance(){
        return instance;
    }

    private Gear()
    {
        port = new Port();
        wheels = new ArrayList<>();
        Wheel w1 = new Wheel("0", System.currentTimeMillis());
        w1.setBrake(new Brake("0", System.currentTimeMillis()));
        wheels.add(w1);
        Wheel w2 = new Wheel("1", System.currentTimeMillis());
        w2.setBrake(new Brake("1", System.currentTimeMillis()));
        wheels.add(w2);
    }


    public class Port implements IGear
    {

        public String version() {
            return "Gear 1.0";
        }

        public GearType setType(String newType) {
           if(newType.equals(GearType.front.name()))
               type = GearType.front;
            if(newType.equals(GearType.rear.name()))
                type = GearType.rear;

            return type;
        }

        public boolean down() {
            isDown = true;
            return isDown;
        }

        public boolean up() {
            isDown = false;
            return isDown;
        }

        //brake active == 100
        //brake not active == 0
        public int setBrake() {
            for(Wheel wheel : wheels)
                wheel.getBrake().setPercentage(100);
            return 100;
        }

        public int setBreak(int percentage) {
            for(Wheel wheel : wheels)
                wheel.getBrake().setPercentage(percentage);
            return percentage;
        }

        public int releaseBrake() {
            for(Wheel wheel : wheels)
                wheel.getBrake().setPercentage(0);
            return 0;
        }
    }


}
