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
            return setDegree(0);
        }

        @Override
        public int fullUp() {
            return setDegree(MAX_DEGREE);
        }

        @Override
        public int up(int degree) {
            return addDegree(degree);
        }

        @Override
        public int down(int degree) {
            return addDegree(degree * -1);
        }
    }

    private int addDegree(int addValue) {
        setDegree(this.degree + addValue);
        return this.degree;
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