package event.sensors.radarAltimeter;

public class RadarAltimeterOn {

    private String phase;

    public RadarAltimeterOn(String nPhase) {
        phase = nPhase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "phase: " + phase + " RadarAltimeterOn";
    }

}
