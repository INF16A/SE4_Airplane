public interface IRouteManagement {
    String version();

    boolean on();

    int add(Checkpoint checkpoint);

    int remove(Checkpoint checkpoint);

    void printCheckpoints();

    double setCostIndex(int value);

    boolean off();
}
