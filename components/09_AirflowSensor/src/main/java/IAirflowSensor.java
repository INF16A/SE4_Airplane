public interface IAirflowSensor {

    String version();

    int measure(String airFlow);

    boolean alarm(int threshhold);

}
