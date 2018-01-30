package section;

import event.Subscriber;
import logging.LogEngine;

import java.util.ArrayList;

public class Wing extends Subscriber {
    private int wingIndex;

    // Flight Controls 2
    private ArrayList<Object> leftAilerons;
    private ArrayList<Object> rightAilerons;
    private ArrayList<Object> spoilers;
    // apu_engine_gear_pump
    private ArrayList<Object> engines;
    private ArrayList<Object> hydraulicPumps;
    // tank_bottle
    private ArrayList<Object> engineOilTanks;
    private ArrayList<Object> fuelTanks;
    private ArrayList<Object> deIcingSystems;
    // sensor01
    private ArrayList<Object> exhaustGasTemperatureSensors;
    private ArrayList<Object> fuelFlowSensors;
    private ArrayList<Object> fuelSensors;
    private ArrayList<Object> iceDetectorProbes;
    // sensor02
    private ArrayList<Object> fireDetectors;
    private ArrayList<Object> shockSensors;
    private ArrayList<Object> stallingSensors;
    private ArrayList<Object> temperatureSensors;
    // sensor03
    private ArrayList<Object> airflowSensors;
    private ArrayList<Object> turbulentAirFlowSensors;
    // sensor04
    private ArrayList<Object> cameras;
    // light
    private ArrayList<Object> landingLights;
    private ArrayList<Object> leftNavigationLights;
    private ArrayList<Object> rightNavigationLights;

    public Wing(int wingIndex) {
        this.wingIndex = wingIndex;

        build();
        printStatus();
    }

    public void build() {
        // Flight Controls 2
        leftAilerons = new ArrayList<>();
        // Factory magic 3
        rightAilerons = new ArrayList<>();
        // Factory magic 3
        spoilers = new ArrayList<>();
        // Factory magic 8

        // apu_engine_gear_pump
        engines = new ArrayList<>();
        // Factory magic 2
        hydraulicPumps = new ArrayList<>();
        // Factory magic 4

        // tank_bottle
        leftAilerons = new ArrayList<>();
        // Factory magic 4
        rightAilerons = new ArrayList<>();
        // Factory magic 3
        spoilers = new ArrayList<>();
        // Factory magic 2

        // sensor01
        exhaustGasTemperatureSensors = new ArrayList<>();
        // Factory magic 4
        fuelFlowSensors = new ArrayList<>();
        // Factory magic 6
        fuelSensors = new ArrayList<>();
        // Factory magic 6
        iceDetectorProbes = new ArrayList<>();
        // Factory magic 2

        // sensor02
        fireDetectors = new ArrayList<>();
        // Factory magic 4
        shockSensors = new ArrayList<>();
        // Factory magic 2
        stallingSensors = new ArrayList<>();
        // Factory magic 2
        temperatureSensors = new ArrayList<>();
        // Factory magic 4

        // sensor03
        airflowSensors = new ArrayList<>();
        // Factory magic 2
        turbulentAirFlowSensors = new ArrayList<>();
        // Factory magic 4

        // sensor04
        cameras = new ArrayList<>();
        // Factory magic 1

        // light
        landingLights = new ArrayList<>();
        // Factory magic 2
        leftNavigationLights = new ArrayList<>();
        // Factory magic 1
        rightNavigationLights = new ArrayList<>();
        // Factory magic 1
    }

    public void printStatus() {
        try {
            LogEngine.instance.write(wingIndex == 0 ? "--- left Wing ---" : "--- right Wing ---");

            // please add here

            LogEngine.instance.write("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // please add here
}