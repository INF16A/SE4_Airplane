import java.util.ArrayList;

public class Routemanagement {
    private IRouteManagement port = new Port();
    private static Routemanagement instance = new Routemanagement();
    private String manufacturer = "airbus";
    private String type = "Model A";
    private String id = "A98JDKF87KDJSXCM";
    private boolean isOn = false;
    private ArrayList<Checkpoint> checkpoints = new ArrayList<>();
    private double costIndex = 2; // default

    public static Routemanagement getInstance() {
        return instance;
    }

    private class Port implements IRouteManagement {
        public String version() {
            return "#1";
        }

        public boolean on() {
            isOn = true;
            return true;
        }

        public int add(Checkpoint checkpoint) {
            return checkpoints.add(checkpoint) ? 1 : 0;
        }

        public int remove(Checkpoint checkpoint) {
            return checkpoints.remove(checkpoint) ? 1 : 0;
        }

        public void printCheckpoints() {
            checkpoints.forEach(c -> System.out.println(c.getName() + ":"  + c.getSequenceID() +
                    " " + c.getLongitude() + " " + c.getLatitude()));
        }

        public double setCostIndex(int value) {
            costIndex = value;
            return costIndex;
        }

        public boolean off() {
            isOn = false;
            return false;
        }
    }
}
