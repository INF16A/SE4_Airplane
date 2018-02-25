import java.util.ArrayList;

public interface ICostOptimizer {

    String version();

    boolean on();

    boolean off();

    int add(CheckPoint checkPoint);

    // theoretisch remove(int checkPoint), das macht aber wenig Sinn weil die anderen beiden Methoden main.java.CheckPoint benutzen
    // Das UML ist hier inkonsistent. Vielleicht wieder auf (int checkPoint) ändern.

    int remove(CheckPoint checkPoint);

    int optimize(ArrayList<CheckPoint> checkPointList);

    boolean validate(int costIndex);
}
