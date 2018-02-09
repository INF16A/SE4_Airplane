public class Elevator {
    private static Elevator instance = new Elevator();
    public Port port;
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
            for (; degree < 0; degree++) {
                stepsTaken++;
                // Elevator up?
            }
        } else if (degree > 0) {
            for (; degree > 0; degree--) {
                stepsTaken++;
                // Elevator down?
            }
        }
        return stepsTaken;
    }

    private int innerFullDown() {
        int stepsTaken = 0;
        for (; degree > -maxDegree; degree--) {
            stepsTaken++;
            // Elevator down?
        }
        return stepsTaken;
    }

    private int innerFullUp() {
        int stepsTaken = 0;
        for (; degree < maxDegree; degree++) {
            stepsTaken++;
            // Elevator up?
        }
        return stepsTaken;
    }

    private int innerUp(int degree) {
        for (int i = 0; i < degree; i++) {
            if (this.degree < maxDegree) {
                this.degree++;
                //Elevator up?
            }
        }
        return this.degree;
    }

    private int innerDown(int degree) {
        for (int i = 0; i < degree; i++) {
            if (this.degree > -maxDegree) {
                this.degree--;
                //Elevator down?
            }
        }
        return this.degree;
    }

    public class Port implements IElevator {

        public String version() {
            return innerVersion();
        }

        public int neutral() {
            return innerNeutral();
        }

        public int fullUp() {
            return innerFullUp();
        }

        public int fullDown() {
            return innerFullDown();
        }

        public int up(int degree) {
            return innerUp(degree);
        }

        public int down(int degree) {
            return innerDown(degree);
        }
    }
}