import dummies.Passenger;

import java.util.ArrayList;

/**
 * Created by npor1112 on 30.01.2018.
 */
public interface ISeatManagement {
    String version();
    int assign(ArrayList<Passenger> passengers);
}
