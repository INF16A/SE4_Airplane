package main.java;

import com.google.common.eventbus.EventBus;

public class Elevator {
    public Port port;
    private static Elevator instance = new Elevator();
    private EventBus eventBus;

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

    private int innerNeutral() {
        return 0;
    }

    private int innerFullDown() {
        return 0;
    }

    private int innerFullUp() {
        return 0;
    }

    private int innerUp(int degree) {
        return 0;
    }

    private int innerDown(int degree) {
        return 0;
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