package event.sensors.turbulentAirFlowSensor;

public class TurbulentAirFlowSensorMeasure {

    String phase;
    int airFlow;

    public TurbulentAirFlowSensorMeasure(String nPhase, int nAirFlow)
    {
        airFlow = nAirFlow;
        phase=nPhase;
    }

    public int getAirFlow() {return airFlow;}

    public String getPhase() {
        return phase;
    }

    public String toString(){return "phase: "+phase+" TCASOff";}

}
