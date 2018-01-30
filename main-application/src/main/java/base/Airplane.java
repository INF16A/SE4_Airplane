package base;

import com.google.common.eventbus.EventBus;
import event.Subscriber;
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

        leftWing = new Wing();
        addSubscriber(leftWing);

        rightWing = new Wing();
        addSubscriber(rightWing);
    }

    public void startup() {
        String phase = "startup";
    }

    public void taxi() {
        String phase = "taxi";
    }

    public void takeoff() {
        String phase = "takeoff";
    }

    public void climbing() {
        String phase = "climbing";
    }

    public void rightTurn() {
        String phase = "rightTurn";
    }

    public void leftTurn() {
        String phase = "leftTurn";
    }

    public void descent() {
        String phase = "descent";
    }

    public void landing() {
        String phase = "landing";
    }

    public void shutdown() {
        String phase = "shutdown";
    }
}