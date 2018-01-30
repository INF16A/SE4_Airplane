package event.sensors.tCAS;

public class TCASOn {

    String phase;

    public TCASOn(String nphase)
    {
        phase=nphase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString(){return "phase: "+phase+" TCASOn";}

}
