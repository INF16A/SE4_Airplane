package event.sensors.tCAS;

public class TCASConnect {

    String phase;
    String frequency;

    public TCASConnect(String nPhase, String nFrequency)
    {
        phase=nPhase;
        frequency=nFrequency;
    }

    public String getFrequency(){return frequency;}

    public String getPhase() {
        return phase;
    }

    public String toString(){return "phase: "+phase+" TCASOff";}

}
