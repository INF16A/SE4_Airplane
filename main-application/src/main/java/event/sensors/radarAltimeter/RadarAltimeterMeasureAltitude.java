package event.sensors.radarAltimeter;

public class RadarAltimeterMeasureAltitude {

    String phase;

    public RadarAltimeterMeasureAltitude(String nphase)
    {
        phase=nphase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString(){return "phase: "+phase+" RadarAltimeterOn";}


}
