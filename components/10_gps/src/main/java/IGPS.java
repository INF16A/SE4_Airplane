public interface IGPS {
    String version();
    boolean on();
    boolean off();
    boolean connect(String satellite);
    void send(String request);
    String receive();
}