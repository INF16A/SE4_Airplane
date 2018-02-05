public interface IWaterSystem {
    String version();

    boolean on();

    boolean refill();

    boolean off();

    boolean clean();
}
