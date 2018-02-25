public class Flap {
    private static Flap instance = new Flap();
    public Port port;
    private String manufacturer;
    private String type;
    private String id;
    private int degree;

    private Flap() {
        port = new Port();
    }

    public static Flap getInstance() {
        return instance;
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

    public int getDegree() {
        return degree;
    }

    private String innerVersion() {
        return "main.java.Flap XYZ";
    }

    public class Port implements IFlap {
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
}