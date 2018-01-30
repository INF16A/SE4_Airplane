package event.sensors.tCAS;

public class TCASOff {

    String phase;

    public TCASOff(String nphase)
    {
        phase=nphase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString(){return "phase: "+phase+" TCASOff";}
}
