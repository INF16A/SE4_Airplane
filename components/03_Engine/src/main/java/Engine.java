/**
 * Created by Lenovo on 30.01.2018.
 */
public class Engine {
    private String manufacturer;
    private String type;
    private String id;
    private boolean isStarted;
    private int rpm;
    private boolean isFire;

    public Port port;
    private static Engine instance = new Engine();

    private Engine()
    {
        port = new Port();
        this.manufacturer = "Best Engine Customer";
        this.type = "Best Engine Type";
        this.id = "1";
        this.rpm = 0;

    }

    public static Engine getInstance(){
        return instance;
    }

    public class Port implements IEngine
    {

        public String vision() {
            return "Engine 1.0";
        }

        public boolean start() {
            isStarted = true;
            return isStarted;
        }

        public int increaseRPM(int value) {
            if(value <= 0)
                return rpm;
            rpm += value;
            if(rpm>10500)
                rpm = 10500;
            return rpm;
        }

        public int decreaseRPM(int value) {
            if(value <= 0)
                return rpm;
            rpm -= value;
            return rpm;
        }

        public boolean shutdown() {
            isStarted = false;
            rpm = 0;
            return isStarted;
        }

        public void extinguishFire() {
            isFire = false;
        }
    }


}
