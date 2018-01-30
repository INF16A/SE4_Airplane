public interface IWasteSystem {
    String version();
    boolean on();
    int deposit(String[] waste);
    boolean off();
    boolean clean();
}
