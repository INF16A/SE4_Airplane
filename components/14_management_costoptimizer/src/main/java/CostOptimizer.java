import java.util.ArrayList;

public class CostOptimizer {

    private static final int COST_INDEX_HARDCODE = 2;
    private static CostOptimizer instance = new CostOptimizer();
    public Port port;
    private String manufacturer;
    private String type;
    private String id;
    private boolean isOn;
    private ArrayList<CheckPoint> checkPointList;

    private CostOptimizer() {
        this.port = new Port();
    }

    public static CostOptimizer getInstance() {
        return instance;
    }

    @SuppressWarnings("ConstantConditions") // It may not be possible to start or turn off the system
    private class Port implements ICostOptimizer {

        public String version() {
            return "main.java.CostOptimizer 1.0.0";
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

        // theoretisch remove(int checkPoint), das macht aber wenig Sinn weil die anderen beiden Methoden main.java.CheckPoint benutzen
        // Das UML ist hier inkonsistent. Vielleicht wieder auf (int checkPoint) ändern.
        public int remove(CheckPoint checkPoint) {
            return checkPointList.remove(checkPoint) ? 1 : 0;
        }

        public int optimize(ArrayList<CheckPoint> checkPointList) {
            // do voodoo aka https://de.wikipedia.org/wiki/Cost_Index
            return COST_INDEX_HARDCODE;
        }

        public boolean validate(int costIndex) {
            return costIndex >= 1 || costIndex <= 3;
        }
    }
}
