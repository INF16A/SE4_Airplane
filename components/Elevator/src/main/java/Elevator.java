package main.java;

public class Elevator {
    public Port port;
    private static Elevator instance = new Elevator();

    private String manufacturer;
    private String type;
    private String id;
    private int degree;

    private Elevator() {
        port = new Port();
    }

    public static Elevator getInstance() {
        return instance;
    }

    private String innerVersion() {
        return "Version 1.0";
    }

    public class Port implements IElevator {

        public String version() {
            return innerVersion();
        }

        public int neutral() {
            return 0;
        }

        public int fullUp() {
            return 0;
        }

        public int fullDown() {
            return 0;
        }

        public int up(int degree) {
            return 0;
        }

        public int down(int degree) {
            return 0;
        }
    }
}