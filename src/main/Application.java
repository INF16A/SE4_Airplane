// please do not modify

package main;

import base.Airplane;
import base.Cockpit;
import logging.LogEngine;
import recorder.FlightRecorder;

public class Application {
    public static void main(String... args) {
        LogEngine.instance.init();

        FlightRecorder.instance.startup();
        FlightRecorder.instance.init();

        Airplane airplane = new Airplane();
        airplane.build();

        Cockpit cockpit = new Cockpit(airplane);
        cockpit.startSimulation();

        FlightRecorder.instance.shutdown();

        LogEngine.instance.close();
    }
}