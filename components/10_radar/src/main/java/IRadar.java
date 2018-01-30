public interface IRadar {
    String version();
    boolean on();
    boolean off();
    boolean scan(String environment);
}