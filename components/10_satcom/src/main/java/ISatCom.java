public interface ISatCom {
    String version();
    boolean on();
    boolean off();
    boolean connect(String satellite, String frequency);
    void send(String request);
    String recieve();
}