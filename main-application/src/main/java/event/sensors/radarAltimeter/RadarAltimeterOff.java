package event.sensors.radarAltimeter;

public class RadarAltimeterOff {

    String phase;

    public RadarAltimeterOff(String nPhase) {
        phase = nPhase;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "phase: " + phase + " RadarAltimeterOff";
    }

}
