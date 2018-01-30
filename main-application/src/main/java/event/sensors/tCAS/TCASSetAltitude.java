package event.sensors.tCAS;

public class TCASSetAltitude {

    String phase;
    int value;

    public TCASSetAltitude(String nPhase, int nValue)
    {
        phase=nPhase;
        value=nValue;
    }

    public int getValue(){return value;}

    public String getPhase() {
        return phase;
    }

    public String toString(){return "phase: "+phase+" TCASOff";}

}
