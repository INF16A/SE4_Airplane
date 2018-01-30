public interface IAirConditioning {
    String version();
    boolean on();
    String clean(String airFlow);
    String heat(String airFlow, int temperature);
    String cool(String airFlow, int temperature);
    boolean off();
}
