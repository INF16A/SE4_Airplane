package section;

import com.google.common.eventbus.Subscribe;
import event.Subscriber;
import event.engine.EngineDecreaseRPM;
import logging.LogEngine;

import java.lang.reflect.Method;
import java.util.ArrayList;

// Factory import for sensor04
import factory.CameraFactory;
import recorder.FlightRecorder;

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
        cameras = new ArrayList<>();
        cameras.add(CameraFactory.build());

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

            //Engine
            for (int enginesIndex = 0; enginesIndex < 2; enginesIndex++){
                Method engineVersionMethod = engines.get(enginesIndex).getClass().getDeclaredMethod("version");
                String engineVersion = (String) engineVersionMethod.invoke(engines.get(enginesIndex));
                LogEngine.instance.write("enginePort : " + engines.get(enginesIndex).hashCode() + " - " + engineVersion);
            }

            //Hydraulic Pump
            for (int hydraulicPumpIndex = 0; hydraulicPumpIndex < 4; hydraulicPumpIndex++){
                Method hydraulicPumpVersionMethod = hydraulicPumps.get(hydraulicPumpIndex).getClass().getDeclaredMethod("version");
                String hydraulicPumpVersion = (String) hydraulicPumpVersionMethod.invoke(hydraulicPumps.get(hydraulicPumpIndex));
                LogEngine.instance.write("hydraulicPumpPort : " + hydraulicPumps.get(hydraulicPumpIndex).hashCode() + " - " + hydraulicPumpVersion);
            }
            // please add here

            LogEngine.instance.write("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Engine
    @Subscribe
    public void receive(EngineDecreaseRPM engineDecreaseRPM) {
        LogEngine.instance.write("+ Body.receive(" + engineDecreaseRPM + ")");

        try {
            for (int engineIndex = 0;engineIndex < 2;engineIndex++) {
                Method engineDecreaseRPMMethod = engines.get(engineIndex).getClass().getDeclaredMethod("increaseRPM", int.class);
                LogEngine.instance.write("engineDecreaseRPM = " + engineDecreaseRPMMethod);

                int decreaseRPM = (int)engineDecreaseRPMMethod.invoke(engines.get(engineIndex), engineDecreaseRPM.getValue());
                LogEngine.instance.write(engineDecreaseRPM.getPhase() + " : decreaseRPM = " + decreaseRPM);

//                PrimaryFlightDisplay.instance.isWeatherRadarOn = decreaseRPM;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),engineDecreaseRPM.getPhase() + " : decreaseRPM = " + decreaseRPM);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    public ArrayList<Object> getDroopNoses()
    {
        return droopNoses;
    }

    public ArrayList<Object> getFlaps()
    {
        return flaps;
    }

    public ArrayList<Object> getSlats()
    {
        return slats;
    }

    public ArrayList<Object> getLeftAilerons()
    {
        return leftAilerons;
    }

    public ArrayList<Object> getRightAilerons()
    {
        return rightAilerons;
    }

    public ArrayList<Object> getSpoilers()
    {
        return spoilers;
    }

    public ArrayList<Object> getEngines()
    {
        return engines;
    }

    public ArrayList<Object> getHydraulicPumps()
    {
        return hydraulicPumps;
    }

    public ArrayList<Object> getEngineOilTanks()
    {
        return engineOilTanks;
    }

    public ArrayList<Object> getFuelTanks()
    {
        return fuelTanks;
    }

    public ArrayList<Object> getDeIcingSystems()
    {
        return deIcingSystems;
    }

    public ArrayList<Object> getExhaustGasTemperatureSensors()
    {
        return exhaustGasTemperatureSensors;
    }

    public ArrayList<Object> getFuelFlowSensors()
    {
        return fuelFlowSensors;
    }

    public ArrayList<Object> getFuelSensors()
    {
        return fuelSensors;
    }

    public ArrayList<Object> getIceDetectorProbes()
    {
        return iceDetectorProbes;
    }

    public ArrayList<Object> getFireDetectors()
    {
        return fireDetectors;
    }

    public ArrayList<Object> getShockSensors()
    {
        return shockSensors;
    }

    public ArrayList<Object> getStallingSensors()
    {
        return stallingSensors;
    }

    public ArrayList<Object> getTemperatureSensors()
    {
        return temperatureSensors;
    }

    public ArrayList<Object> getAirflowSensors()
    {
        return airflowSensors;
    }

    public ArrayList<Object> getTurbulentAirFlowSensors()
    {
        return turbulentAirFlowSensors;
    }

    public ArrayList<Object> getCameras()
    {
        return cameras;
    }

    public ArrayList<Object> getLandingLights()
    {
        return landingLights;
    }

    public ArrayList<Object> getLeftNavigationLights()
    {
        return leftNavigationLights;
    }

    public ArrayList<Object> getRightNavigationLights()
    {
        return rightNavigationLights;
    }
    
}