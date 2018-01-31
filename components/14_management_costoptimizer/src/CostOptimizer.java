import java.util.ArrayList;

/**
 * Created by chag0709 on 30.01.18 - Kaufland Informationssysteme 2018.
 */
public class CostOptimizer implements ICostOptimizer {

    private String manufacturer;
    private String type;
    private String id;
    private boolean isOn;
    private ArrayList<CheckPoint> checkPointList;

    @Override
    public String version() {
        return null;
    }

    @Override
    public boolean on() {
        return false;
    }

    @Override
    public boolean off() {
        return false;
    }

    @Override
    public int add(CheckPoint checkPoint) {
        return 0;
    }

    @Override
    public int remove(int checkPoint) {
        return 0;
    }

    @Override
    public int optimize(ArrayList<CheckPoint> checkPointList) {
        return 0;
    }

    @Override
    public boolean validate(int costIndex) {
        return false;
    }


}
