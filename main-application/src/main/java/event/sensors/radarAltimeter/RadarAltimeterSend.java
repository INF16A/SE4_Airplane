package event.sensors.radarAltimeter;

public class RadarAltimeterSend {

    String phase;
    String radioWave;

    public RadarAltimeterSend(String nPhase, String nRadioWave) {
        phase = nPhase;
        radioWave = nRadioWave;
    }

    public String getRadioWave() {
        return radioWave;
    }

    public String getPhase() {
        return phase;
    }

    public String toString() {
        return "phase: " + phase + " TCASOff";
    }

}
