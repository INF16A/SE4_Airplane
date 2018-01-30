import java.util.ArrayList;

/**
 * Created by chag0709 on 30.01.18 - Kaufland Informationssysteme 2018.
 */
public class CostOptimizer {

    public Port port;
    private static CostOptimizer instance = new CostOptimizer();

    private String manufacturer;
    private String type;
    private String id;
    private boolean isOn;
    private ArrayList<CheckPoint> checkPointList;

    private static final int COST_INDEX_HARDCODE = 2;

    private CostOptimizer() {
        this.port = new Port();
    }

    public static CostOptimizer getInstance() {
        return instance;
    }

    @SuppressWarnings("ConstantConditions") // It may not be possible to start or turn off the system
    private class Port implements ICostOptimizer {

        public String version() {
            return "CostOptimizer 1.0.0";
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
            checkPointList.add(checkPoint);
            return checkPointList.size();
        }

        public int remove(int checkPoint) {
            checkPointList.remove(checkPoint);
            return checkPointList.size();
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
