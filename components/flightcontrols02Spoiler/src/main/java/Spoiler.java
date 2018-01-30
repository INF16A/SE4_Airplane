package main.java;

public class Spoiler {

    private static Spoiler instance = new Spoiler();

    public static Spoiler getInstance() {
        return instance;
    }

    public Port port;

    private Spoiler() {
        port = new Port();
    }

    private String manufacturer = "Manni";
    private String type = "Typ";
    private String id;
    private int degree;

    public static final int MAX_DEGREE = 21;
    public static final int MIN_DEGREE = -21;

    public class Port implements ISpoiler {

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
        public int fullUp() {
            setDegree(MAX_DEGREE);
            return getDegree();
        }

        @Override
        public int up(int degree) {
            addDegree(degree);
            return getDegree();
        }

        @Override
        public int down(int degree) {
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