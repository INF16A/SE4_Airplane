package event;

public class RadarAltimeterOn {

    String phase;

    public RadarAltimeterOn(String nphase)
    {
        phase=nphase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString(){return "phase: "+phase+" RadarAltimeterOn";}

}
