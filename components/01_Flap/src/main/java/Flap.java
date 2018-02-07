

public class Flap {

    private static Flap instance = new Flap();
    private String manufacturer;
    private String type;
    private String id;
    private int degree;

    public Port port;

    public class Port implements main.java.IFlap {
        @Override
        public String version() {
            return innerVersion();
        }

        @Override
        public int neutral() {
            return innerNeutral();
        }

        @Override
        public int levelOne() {
            return innerLevelOne();
        }

        @Override
        public int levelTwo() {
            return innerLevelTwo();
        }

        @Override
        public int levelThree() {
            return innerLevelThree();
        }
    }

    private int innerLevelThree() {
        degree = 45;
        return degree;
    }

    private int innerLevelTwo() {
        degree = 30;
        return degree;
    }

    private int innerLevelOne() {
        degree = 15;
        return degree;
    }

    private int innerNeutral() {
        degree = 0;
        return degree;
    }

    public static Flap getInstance() {
        return instance;
    }

    public int getDegree() {
        return degree;
    }

    public Flap() {
        port = new Port();
    }

    private String innerVersion() {
        return "Flap v1.0";
    }
}