public interface IShockSensor {

    String version();

    boolean calibrate();

    boolean calibrate(double level);

    int measure();

    boolean alarm();
}
