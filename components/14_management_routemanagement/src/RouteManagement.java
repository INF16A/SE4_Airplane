import java.util.ArrayList;

/**
 * Created by chag0709 on 30.01.18 - Kaufland Informationssysteme 2018.
 */
public class RouteManagement {

    public Port port;
    private static RouteManagement instance = new RouteManagement();

    private RouteManagement() {
        this.port = new Port();
    }

    public static RouteManagement getInstance() {
        return instance;
    }

    private String manufacturer;
    private String type;
    private String id;
    private boolean isOn;
    private ArrayList<CheckPoint> checkPointList;

    @SuppressWarnings("ConstantConditions") // It may not be possible to start or turn off the system
    private class Port implements IRouteManagement {
        public String version() {
            return null;
        }

        public boolean on() {
            isOn = true;
            return isOn;
        }

        public boolean off() {
            isOn = false;
            return isOn;
        }

        public int add(CheckPoint checkPoint) {
            return checkPointList.add(checkPoint) ? 1 : 0;
        }

        public int remove(CheckPoint checkPoint) {
            return checkPointList.remove(checkPoint) ? 1 : 0;
        }

        public void printCheckPoints() {
            for (CheckPoint checkpoint: checkPointList) {
                System.out.println("Checkpoint: " + checkpoint.toString());
            }
        }

        public double setCostIndex(int value) {
            return 0;
        }
    }
}
