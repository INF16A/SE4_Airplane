package event;

public class RadarAltimeterOff {

    String phase;

    public RadarAltimeterOff(String nphase)
    {
        phase=nphase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString(){return "phase: "+phase+" RadarAltimeterOff";}

}
