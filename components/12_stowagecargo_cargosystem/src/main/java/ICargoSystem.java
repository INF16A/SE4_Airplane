import java.lang.reflect.Array;
import java.util.ArrayList;

public interface ICargoSystem {
    String version();
    boolean unlock();
    double loadContainer(Stowage stowage, ArrayList<Container> container);
    double loadAirCargoPallet(Stowage stowage, ArrayList<AirCargoPallet> airCargoPalletList);
    double determineTotalWeightContainer(Stowage stowage);
    double determinetotalWeightAirCargoPallet(Stowage stowage);
    double determineTotalWeight(Stowage stowage);
    boolean secure();
    boolean lock();
    ArrayList<Container> unloadContainer(Stowage stowage);
    ArrayList<AirCargoPallet> unloadAirCargoPallet(Stowage stowage);
}