package event.sensors.radarAltimeter;

public class RadarAltimeterMeasureAltitude {

    private String phase;

    public RadarAltimeterMeasureAltitude(String nphase) {
        phase = nphase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "phase: " + phase + " RadarAltimeterMeasureAltitude";
    }

}
