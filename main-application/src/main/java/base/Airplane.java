package base;

import com.google.common.eventbus.EventBus;
import event.Subscriber;
import section.Body;
import section.Wing;

// import for sensor04
import event.Camera.CameraOff;
import event.Camera.CameraOn;
import event.Camera.CameraZoomIn;
import event.Camera.CameraSetType;
import event.Camera.CameraRecord;
import event.radar.RadarOn;
import event.radar.RadarOff;
import event.radar.RadarScan;

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
    }

    public void taxi() {
        String phase = "taxi";
    }

    public void takeoff() {
        boolean cameraFactor = true;
        String phase = "takeoff";
        eventBus.post(new CameraZoomIn(phase, cameraFactor));
        eventBus.post(new RadarOn(phase));
    }

    public void climbing() {
        String phase = "climbing";
        String environment = "Cloud, Rain, Wind, CLoud";
        eventBus.post(new RadarScan(phase, environment));
    }

    public void rightTurn() {
        String phase = "rightTurn";
        String environment = "Cloud, Rain, Wind, CLoud";
        eventBus.post(new RadarScan(phase, environment));
    }

    public void leftTurn() {

        String phase = "leftTurn";
        String environment = "Cloud, Rain, Wind, CLoud";
        eventBus.post(new RadarScan(phase, environment));
    }

    public void descent() {

        String phase = "descent";
        String environment = "Cloud, Rain, Wind, CLoud";
        eventBus.post(new RadarScan(phase, environment));
    }

    public void landing() {

        String phase = "landing";
        String environment = "Cloud, Rain, Wind, CLoud";
    }

    public void shutdown() {
        String phase = "shutdown";

        eventBus.post(new CameraOff(phase));
        eventBus.post(new RadarOff(phase));
    }
}