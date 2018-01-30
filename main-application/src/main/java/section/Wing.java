package section;

import base.PrimaryFlightDisplay;
import com.google.common.eventbus.Subscribe;
import event.Subscriber;
import logging.LogEngine;

import java.lang.reflect.Method;
import java.util.ArrayList;

// Factory import for sensor04
import factory.CameraFactory;
import recorder.FlightRecorder;
import event.Camera.CameraOn;
import event.Camera.CameraOff;
import event.Camera.CameraRecord;
import event.Camera.CameraSetType;
import event.Camera.CameraZoomIn;


public class Wing extends Subscriber {
    private int wingIndex;

    // Flight Controls01
    private ArrayList<Object> droopNoses;
    private ArrayList<Object> flaps;
    private ArrayList<Object> slats;
    // Flight Controls02
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
    private ArrayList<Object> cameraPorts;
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
        // Flight Controls01
        droopNoses = new ArrayList<>();
        // Factory magic 2
        flaps = new ArrayList<>();
        // Factory magic 2
        slats = new ArrayList<>();
        // Factory magic 6

        // Flight Controls02
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
        engineOilTanks = new ArrayList<>();
        // Factory magic 4
        fuelTanks = new ArrayList<>();
        // Factory magic 3
        deIcingSystems = new ArrayList<>();
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
        //Factory magic 1
        cameraPorts = new ArrayList<>();
        cameraPorts.add(CameraFactory.build());

        // light
        landingLights = new ArrayList<>();
        // Factory magic 2
        leftNavigationLights = new ArrayList<>();
        // Factory magic 1, LightType = red, Position = port
        rightNavigationLights = new ArrayList<>();
        // Factory magic 1, LightType = green, Position = starboard
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

    @Subscribe
    public void receive(CameraOn cameraOn){
        LogEngine.instance.write("+ Body.receive(" + cameraOn + ")");

        try{
                Method cameraOnMethod = cameraPorts.get(0).getClass().getDeclaredMethod("on");
                LogEngine.instance.write("cameraOnMethod = " + cameraOnMethod + "");

                boolean isCameraOn = (boolean)cameraOnMethod.invoke(cameraPorts.get(0));

                LogEngine.instance.write(cameraOn.getPhase() + " : isCameraOn = " + isCameraOn + "");

                PrimaryFlightDisplay.instance.isCameraOn = isCameraOn;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),cameraOn.getPhase() + " : Camera (isOn) = " + isCameraOn);

                LogEngine.instance.write("+");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(CameraOff cameraOff){
        LogEngine.instance.write("+ Body.receive(" + cameraOff + ")");

        try{
            Method cameraOffMethod = cameraPorts.get(0).getClass().getDeclaredMethod("off");
            LogEngine.instance.write("cameraOffMethod = " + cameraOffMethod + "");

            boolean isCameraOff = (boolean)cameraOffMethod.invoke(cameraPorts.get(0));

            LogEngine.instance.write(cameraOff.getPhase() + " : isCameraOff = " + isCameraOff + "");

            PrimaryFlightDisplay.instance.isCameraOn = isCameraOff;
            FlightRecorder.instance.insert(this.getClass().getSimpleName(),cameraOff.getPhase() + " : Camera (isOff) = " + isCameraOff);

            LogEngine.instance.write("+");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void receive(CameraZoomIn cameraZoomIn){
        LogEngine.instance.write("+ Body.receive(" + cameraZoomIn + ")");

        try{
            Method cameraZoomInMethod = cameraPorts.get(0).getClass().getDeclaredMethod("zoomIn", boolean.class);
            LogEngine.instance.write("cameraZoomInMethod = " + cameraZoomInMethod + "");

            double cameraFactor = (double)cameraZoomInMethod.invoke(cameraPorts.get(0), new Object[]{true});

            LogEngine.instance.write(cameraZoomIn.getPhase() + " : cameraFactor = " + cameraFactor + "");

            PrimaryFlightDisplay.instance.cameraFactor = cameraFactor;
            FlightRecorder.instance.insert(this.getClass().getSimpleName(),cameraZoomIn.getPhase() + " : Camera (Factor) = " + cameraFactor);

            LogEngine.instance.write("+");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // please add here
}