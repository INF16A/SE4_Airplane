package event.sensors.tCAS;

public class TCASDetermineAltitude {

    String phase;
    String environment;

    public TCASDetermineAltitude(String nPhase, String nEnvironment)
    {
        phase=nPhase;
        environment=nEnvironment;
    }

    public String getEnvironment(){return environment;}

    public String getPhase() {
        return phase;
    }

    public String toString(){return "phase: "+phase+" TCASOff";}

}
