interface IStallingSensor {

    String version();

    int measure(String airFlow);

    boolean alarm();
}
