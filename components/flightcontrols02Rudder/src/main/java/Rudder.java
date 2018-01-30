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
            setDegree(0);
            return getDegree();
        }

        @Override
        public int fullRight() {
            setDegree(MAX_DEGREE);
            return getDegree();
        }

        @Override
        public int fullLeft() {
            setDegree(MIN_DEGREE);
            return getDegree();
        }

        @Override
        public int right(int degree) {
            addDegree(degree);
            return getDegree();
        }

        @Override
        public int left(int degree) {
            addDegree(degree * -1);
            return getDegree();
        }
    }

    private void addDegree(int addValue) {
        setDegree(this.degree + addValue);
    }

    private void setDegree(int totalValue) {
        if (totalValue < MIN_DEGREE) {
            this.degree = MIN_DEGREE;
        } else if (totalValue > MAX_DEGREE) {
            this.degree = MAX_DEGREE;
        } else {
            this.degree = totalValue;
        }
    }

    private int getDegree() {
        return degree;
    }

    private String innerMethodGetVersion() {
        return manufacturer + " - " + type + ", v0.01";
    }

}
