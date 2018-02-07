public class DroopNose {
    private static DroopNose instance = new DroopNose();
    public Port port;
    private String manufacturer;
    private String type;
    private String id;
    private int degree;
    private int maxDegree;

    private DroopNose() {
        degree = 0;
        maxDegree = 45;
        manufacturer = "aManufacturer";
        port = new Port();
    }

    public static DroopNose getInstance() {
        return instance;
    }

    private String innerVersion() {
        return manufacturer + " - Version 1.0";
    }

    private int innerNeutral() {
        int stepsTaken = 0;
        if (degree < 0) {
            for (; degree < 0; degree++) {
                stepsTaken++;
                //send NoseUp Event
            }
        } else if (degree > 0) {
            for (; degree > 0; degree--) {
                stepsTaken++;
                //send NoseDown Event
            }
        }
        return stepsTaken;
    }

    private int innerFullDown() {
        int stepsTaken = 0;
        for (; degree > -maxDegree; degree--) {
            stepsTaken++;
            //send NoseDown Event
        }
        return stepsTaken;
    }

    private int innerDown(int degree)  {
        for (int i = 0; i < degree; i++) {
            if (this.degree > -maxDegree) {
                this.degree--;
                //send NoseDown Event
            }
        }
        return this.degree;
    }

    private int innerUp(int degree) {
        for (int i = 0; i < degree; i++) {
            if (degree < maxDegree) {
                degree++;
                //send NoseDown Event
            }
        }
        return this.degree;
    }

    public class Port implements IDroopNose {
        public String version() {
            return innerVersion();
        }

        public int neutral() {
            return innerNeutral();
        }

        public int fullDown() {
            return innerFullDown();
        }

        public int down(int degree) {
            return innerDown(degree);
        }

        public int up(int degree) {
            return innerUp(degree);
        }
    }
}
