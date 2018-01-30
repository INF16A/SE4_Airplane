package main.java;

public class Rudder {

    private static Rudder instance = new Rudder();

    public static Rudder getInstance() {
        return instance;
    }

    public Port port;

    private Rudder() {
        port = new Port();
    }

    private String manufacturer = "Manni";
    private String type = "Typ";
    private String id;
    private int degree; // negative = left, positive = right

    public static final int MAX_DEGREE = 26;
    public static final int MIN_DEGREE = -26;

    public class Port implements IRudder {

        @Override
        public String version() {
            return innerMethodGetVersion();
        }

        @Override
        public int neutral() {
            return setDegree(0);
        }

        @Override
        public int fullRight() {
            return setDegree(MAX_DEGREE);
        }

        @Override
        public int fullLeft() {
            return setDegree(MIN_DEGREE);
        }

        @Override
        public int right(int degree) {
            return addDegree(degree);
        }

        @Override
        public int left(int degree) {
            return addDegree(degree * -1);
        }
    }

    private int addDegree(int addValue) {
        return setDegree(this.degree + addValue);
    }

    private int setDegree(int totalValue) {
        if(totalValue < MIN_DEGREE) {
            this.degree = MIN_DEGREE;
        } else if(totalValue > MAX_DEGREE) {
            this.degree = MAX_DEGREE;
        } else {
            this.degree = totalValue;
        }
        return this.degree;
    }

    private String innerMethodGetVersion() {
        return manufacturer + " - " + type + ", v0.01";
    }

}
