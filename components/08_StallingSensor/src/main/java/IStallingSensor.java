interface IStallingSensor {

    String version();

    int measure(int airFlow);

    boolean alarm();
}
