/**
 * Created by Lenovo on 30.01.2018.
 */
public class APU {
    public Port port;
    private static APU instance = new APU();


    private String manufacturer;
    private String type;
    private String id;
    private boolean isStarted;
    private int rpm;


    private APU()
    {
        port = new Port();
        this.id = "1";
        this.type = "Best APU";
        this.manufacturer = "Best APU Customer";
    }

    public class Port implements IAPU
    {

        @Override
        public String version() {
            return "APU 1.0";
        }

        @Override
        public boolean start() {
            isStarted = true;
            return isStarted;
        }

        @Override
        public int increaseRPM(int value) {
            rpm += value;
            return rpm;
        }

        @Override
        public int decreaseRPM(int value) {
            rpm -= value;
            return rpm;
        }

        @Override
        public boolean shutdown() {
            isStarted = false;
            return isStarted;
        }
    }

}
