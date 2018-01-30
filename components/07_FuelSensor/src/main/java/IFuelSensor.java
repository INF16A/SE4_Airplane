public interface IFuelSensor {
    String version();

    int measure();

    boolean alarmReserve(int threshold);

    boolean alarmMajor(int threshold);

    boolean alarmCritical(int threshold);
}
