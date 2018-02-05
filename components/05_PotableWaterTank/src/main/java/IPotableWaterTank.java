public interface IPotableWaterTank {
    String version();

    boolean lock();

    boolean unlock();

    int refill(int amount);

    int refill();

    int takeOut(int amount);
}