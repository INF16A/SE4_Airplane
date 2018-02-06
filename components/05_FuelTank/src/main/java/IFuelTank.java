public interface IFuelTank {
    String version();

    int refill(int amount);

    int refill();

    int takeOut(int amount);
}