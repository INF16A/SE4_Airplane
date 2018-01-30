interface ITemperatureSensor {

    String version();

    int measure();

    boolean alarm(int threshold);
}
