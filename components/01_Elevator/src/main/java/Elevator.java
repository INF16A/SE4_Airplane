import com.google.common.eventbus.EventBus;

public class Elevator {
    public Port port;
    private static Elevator instance = new Elevator();
    private EventBus eventBus;

    private String manufacturer;
    private String type;
    private String id;
    private int degree;
    private int maxDegree;

    private Elevator() {
        this.degree = 0;
        this.maxDegree = 45;
        port = new Port();
    }

    public static Elevator getInstance() {
        return instance;
    }

    private String innerVersion() {
        return "Version 1.0";
    }

    private int innerNeutral() {
        int stepsTaken = 0;
        if (degree < 0) {
            for(;degree < 0; degree++) {
                stepsTaken++;
                // send ElevatorUp Event?
            }
        } else if(degree > 0) {
            for(;degree > 0; degree--) {
                stepsTaken++;
                // send ElevatorDown Event?
            }
        }
        return stepsTaken;
    }

    private int innerFullDown() {
        int stepsTaken = 0;
        for(; degree > -maxDegree; degree--) {
            stepsTaken++;
            // send ElevatorDown Event?
        }
        return stepsTaken;
    }

    private int innerFullUp() {
        int stepsTaken = 0;
        for(; degree < maxDegree; degree++) {
            stepsTaken++;
            // send ElevatorUp Event?
        }
        return stepsTaken;
    }

    private int innerUp(int degree) {
        for(int i = 0; i < degree; i++) {
            if(degree < maxDegree) {
                degree++;
                //send ElevatorUp Event?
            }
        }
        return this.degree;
    }

    private int innerDown(int degree) {
        for(int i = 0; i < degree; i++) {
            if (degree > -maxDegree) {
                degree--;
                //send ElevatorDown Event?
            }
        }
        return this.degree;
    }

    public class Port implements IElevator {

        public String version() {
            return innerVersion();
        }

        public int neutral() { return innerNeutral(); }

        public int fullUp() { return innerFullUp(); }

        public int fullDown() { return innerFullDown(); }

        public int up(int degree) { return innerUp(degree); }

        public int down(int degree) {
            return innerDown(degree);
        }
    }
}