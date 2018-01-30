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
    private Engine instance = new Engine();

    private Engine()
    {
        port = new Port();
    }


    public class Port implements IEngine
    {

        public String vision() {
            return null;
        }

        public boolean start() {
            return false;
        }

        public int increaseRPM(int value) {
            return 0;
        }

        public int decreaseRPM(int value) {
            return 0;
        }

        public boolean shutdown() {
            return false;
        }

        public void extinguishFire() {

        }
    }


}
