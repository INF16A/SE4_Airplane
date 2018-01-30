package event.sensors.radarAltimeter;

public class RadarAltimeterReceive {

    String phase;
    String radioWave;

    public RadarAltimeterReceive(String nPhase, String nRadioWave)
    {
        phase=nPhase;
        radioWave=nRadioWave;
    }

    public String getRadioWave(){return radioWave;}

    public String getPhase() {
        return phase;
    }

    public String toString(){return "phase: "+phase+" TCASOff";}

}
