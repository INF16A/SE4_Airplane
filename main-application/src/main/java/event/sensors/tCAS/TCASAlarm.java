package event.sensors.tCAS;

public class TCASAlarm {

    String phase;

    public TCASAlarm(String nphase)
    {
        phase=nphase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString(){return "phase: "+phase+" TCASOff";}

}
