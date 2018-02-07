public interface IOxygenBottle {
    String version();

    int refill(int amount);

    int refill();

    int takeOut(int amount);
}