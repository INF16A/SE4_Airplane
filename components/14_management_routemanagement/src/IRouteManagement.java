/**
 * Created by chag0709 on 30.01.18 - Kaufland Informationssysteme 2018.
 */
public interface IRouteManagement {
    String version();
    boolean on();
    boolean off();
    int add(CheckPoint checkPoint);
    int remove(CheckPoint checkPoint);
    void printCheckPoints();
    double setCostIndex(int value);
}
