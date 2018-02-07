package base;

import com.google.common.eventbus.EventBus;
import event.camera.*;
import event.gps.*;
import event.satcom.*;
import event.radar.RadarOff;
import event.radar.RadarScan;
import event.Subscriber;
import event.vhf.VHFOff;
import event.vhf.VHFOn;
import event.sensors.airflowSensor.AirflowSensorAlarm;
import event.sensors.airflowSensor.AirflowSensorMeasure;
import event.sensors.pitotTube.PitotTubeMeasureStaticPressure;
import event.sensors.pitotTube.PitotTubeMeasureTotalPressure;
import event.sensors.pitotTube.PitotTubeMeasureVelocity;
import event.sensors.radarAltimeter.*;
import event.sensors.tCAS.*;
import event.sensors.turbulentAirFlowSensor.TurbulentAirFlowSensorAlarm;
import event.sensors.turbulentAirFlowSensor.TurbulentAirFlowSensorMeasure;
import section.Body;
import section.Wing;

public class Airplane implements IAirplane {
    private EventBus eventBus;
    private Body body;
    private Wing leftWing;
    private Wing rightWing;

    public Airplane() {
        eventBus = new EventBus("EB-A380");
    }

    public Body getBody() {
        return body;
    }

    public Wing getLeftWing() {
        return leftWing;
    }

    public Wing getRightWing() {
        return rightWing;
    }

    public void addSubscriber(Subscriber subscriber) {
        eventBus.register(subscriber);
    }

    public void build() {
        body = new Body();
        addSubscriber(body);

        leftWing = new Wing(0);
        addSubscriber(leftWing);

        rightWing = new Wing(1);
        addSubscriber(rightWing);
    }

    public void startup() {
        String phase = "startup";
        eventBus.post(new CameraOn(phase));
        eventBus.post(new GPSOn(phase));
        eventBus.post(new SatComOn(phase));
        eventBus.post(new VHFOn(phase));
        eventBus.post(new RadarAltimeterOn(phase));
        eventBus.post(new TCASOn(phase));
        eventBus.post(new TCASConnect(phase,"123"));
        eventBus.post(new TCASSetAltitude(phase, 5));
        eventBus.post(new TCASScann(phase,"123"));
        eventBus.post(new AirflowSensorMeasure(phase,"645"));
        eventBus.post(new TurbulentAirFlowSensorMeasure(phase, "48654"));
    }

    public void taxi() {
        String phase = "taxi";
        eventBus.post(new TCASConnect(phase, "135614131654"));
        eventBus.post(new TCASSetAltitude(phase, 6));
        eventBus.post(new TCASScann(phase, "135614131654"));
        eventBus.post(new AirflowSensorMeasure(phase,"645"));
        eventBus.post(new TurbulentAirFlowSensorMeasure(phase, "48654"));

    }

    public void takeoff() {
        boolean cameraFactor = true;
        String phase = "takeoff";
        eventBus.post(new CameraZoomIn(phase, cameraFactor));
        eventBus.post(new AirflowSensorMeasure(phase,"645"));
        eventBus.post(new TurbulentAirFlowSensorMeasure(phase, "48654"));
        eventBus.post(new AirflowSensorAlarm(phase,5));
        eventBus.post(new TurbulentAirFlowSensorAlarm(phase));
    }

    public void climbing() {
        String phase = "climbing";
        String environment = "Cloud, Rain, Wind, CLoud";
        eventBus.post(new RadarScan(phase, environment));

        eventBus.post(new AirflowSensorMeasure(phase,"645"));
        eventBus.post(new TurbulentAirFlowSensorMeasure(phase, "48654"));
        eventBus.post(new AirflowSensorAlarm(phase,5));
        eventBus.post(new TurbulentAirFlowSensorAlarm(phase));
        eventBus.post(new RadarAltimeterSend(phase, "147"));
        eventBus.post(new PitotTubeMeasureVelocity(phase));
        eventBus.post(new PitotTubeMeasureStaticPressure(phase));
        eventBus.post(new PitotTubeMeasureTotalPressure(phase));
        eventBus.post(new TCASScann(phase,"45"));
        eventBus.post(new RadarAltimeterReceive(phase, "147"));
        eventBus.post(new TCASAlarm(phase));
        eventBus.post(new RadarAltimeterMeasureAltitude(phase));
    }

    public void rightTurn() {
        String phase = "rightTurn";
        String environment = "Cloud, Rain, Wind, CLoud";
        eventBus.post(new RadarScan(phase, environment));

        eventBus.post(new AirflowSensorMeasure(phase,"645"));
        eventBus.post(new TurbulentAirFlowSensorMeasure(phase, "48654"));
        eventBus.post(new AirflowSensorAlarm(phase,5));
        eventBus.post(new TurbulentAirFlowSensorAlarm(phase));

        eventBus.post(new RadarAltimeterSend(phase, "147"));
        eventBus.post(new PitotTubeMeasureVelocity(phase));
        eventBus.post(new PitotTubeMeasureStaticPressure(phase));
        eventBus.post(new PitotTubeMeasureTotalPressure(phase));
        eventBus.post(new TCASScann(phase,"45"));
        eventBus.post(new RadarAltimeterReceive(phase, "147"));
        eventBus.post(new TCASAlarm(phase));
        eventBus.post(new RadarAltimeterMeasureAltitude(phase));
    }

    public void leftTurn() {

        String phase = "leftTurn";
        String environment = "Cloud, Rain, Wind, CLoud";
        eventBus.post(new RadarScan(phase, environment));

        eventBus.post(new AirflowSensorMeasure(phase,"645"));
        eventBus.post(new TurbulentAirFlowSensorMeasure(phase, "48654"));
        eventBus.post(new AirflowSensorAlarm(phase,5));
        eventBus.post(new TurbulentAirFlowSensorAlarm(phase));

        eventBus.post(new RadarAltimeterSend(phase, "147"));
        eventBus.post(new PitotTubeMeasureVelocity(phase));
        eventBus.post(new PitotTubeMeasureStaticPressure(phase));
        eventBus.post(new PitotTubeMeasureTotalPressure(phase));
        eventBus.post(new TCASScann(phase,"45"));
        eventBus.post(new RadarAltimeterReceive(phase, "147"));
        eventBus.post(new TCASAlarm(phase));
        eventBus.post(new RadarAltimeterMeasureAltitude(phase));
    }

    public void descent() {
        String phase = "descent";
        String environment = "Cloud, Rain, Wind, CLoud";
        eventBus.post(new RadarScan(phase, environment));

        eventBus.post(new AirflowSensorMeasure(phase,"645"));
        eventBus.post(new TurbulentAirFlowSensorMeasure(phase, "48654"));
        eventBus.post(new AirflowSensorAlarm(phase,5));
        eventBus.post(new TurbulentAirFlowSensorAlarm(phase));

        eventBus.post(new RadarAltimeterSend(phase, "147"));
        eventBus.post(new PitotTubeMeasureVelocity(phase));
        eventBus.post(new PitotTubeMeasureStaticPressure(phase));
        eventBus.post(new PitotTubeMeasureTotalPressure(phase));
        eventBus.post(new TCASScann(phase,"45"));
        eventBus.post(new RadarAltimeterReceive(phase, "147"));
        eventBus.post(new TCASAlarm(phase));
        eventBus.post(new RadarAltimeterMeasureAltitude(phase));
    }

    public void landing() {
        String phase = "landing";
        String environment = "Cloud, Rain, Wind, CLoud";
        eventBus.post(new AirflowSensorMeasure(phase,"645"));

        eventBus.post(new TurbulentAirFlowSensorMeasure(phase, "48654"));
        eventBus.post(new AirflowSensorAlarm(phase,5));
        eventBus.post(new TurbulentAirFlowSensorAlarm(phase));

        eventBus.post(new RadarAltimeterSend(phase, "147"));
        eventBus.post(new PitotTubeMeasureVelocity(phase));
        eventBus.post(new PitotTubeMeasureStaticPressure(phase));
        eventBus.post(new PitotTubeMeasureTotalPressure(phase));
        eventBus.post(new TCASScann(phase,"45"));
        eventBus.post(new RadarAltimeterReceive(phase, "147"));
        eventBus.post(new TCASAlarm(phase));
        eventBus.post(new RadarAltimeterMeasureAltitude(phase));
    }

    public void shutdown() {
        String phase = "shutdown";

        eventBus.post(new CameraOff(phase));
        eventBus.post(new RadarOff(phase));
        eventBus.post(new SatComOff(phase));
        eventBus.post(new GPSOff(phase));
        eventBus.post(new VHFOff(phase));

        eventBus.post(new RadarAltimeterOff(phase));
        eventBus.post(new TCASOff(phase));
    }
}