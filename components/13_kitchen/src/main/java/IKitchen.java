public interface IKitchen {
    String version();
    boolean lock();
    boolean unlock();
    double getTotalWeightTrolleys();
    void addTrolley(Trolley trolley);
    void emptyTrolley(Trolley trolley);
}
