package section;

import base.PrimaryFlightDisplay;
import com.google.common.eventbus.Subscribe;
import event.Subscriber;
import event.sensors.airflowSensor.AirflowSensorAlarm;
import event.sensors.airflowSensor.AirflowSensorMeasure;
import event.sensors.turbulentAirFlowSensor.TurbulentAirFlowSensorAlarm;
import event.sensors.turbulentAirFlowSensor.TurbulentAirFlowSensorMeasure;
import factory.AirflowSensorFactory;
import factory.CameraFactory;
import factory.ExhaustGasTemperatureSensorFactory;
import factory.FuelFlowSensorFactory;
import factory.FuelSensorFactory;
import factory.IceDetectorProbeFactory;
import factory.TurbulentAirFlowSensorFactory;
import logging.LogEngine;

import java.lang.reflect.Method;
import java.util.ArrayList;

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
        for (int i = 0; i < 4; i++) {
            exhaustGasTemperatureSensors.add(ExhaustGasTemperatureSensorFactory.build());
        }
        // Factory magic 4
        fuelFlowSensors = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            fuelFlowSensors.add(FuelFlowSensorFactory.build());
        }
        // Factory magic 6

        fuelSensors = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            fuelSensors.add(FuelSensorFactory.build());
        }
        // Factory magic 6

        iceDetectorProbes = new ArrayList<>();
        iceDetectorProbes.add(IceDetectorProbeFactory.build());
        iceDetectorProbes.add(IceDetectorProbeFactory.build());
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
        airflowSensors.add(AirflowSensorFactory.build());
        airflowSensors.add(AirflowSensorFactory.build());
        turbulentAirFlowSensors = new ArrayList<>();
        turbulentAirFlowSensors.add(TurbulentAirFlowSensorFactory.build());
        turbulentAirFlowSensors.add(TurbulentAirFlowSensorFactory.build());
        turbulentAirFlowSensors.add(TurbulentAirFlowSensorFactory.build());
        turbulentAirFlowSensors.add(TurbulentAirFlowSensorFactory.build());

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
            for (int enginesIndex = 0; enginesIndex < 2; enginesIndex++) {
                Method engineVersionMethod = engines.get(enginesIndex).getClass().getDeclaredMethod("version");
                String engineVersion = (String) engineVersionMethod.invoke(engines.get(enginesIndex));
                LogEngine.instance.write("enginePort : " + engines.get(enginesIndex).hashCode() + " - " + engineVersion);
            }

            //Hydraulic Pump
            for (int hydraulicPumpIndex = 0; hydraulicPumpIndex < 4; hydraulicPumpIndex++) {
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

    @Subscribe
    public void recieve(AirflowSensorAlarm airflowSensorAlarm) {
        LogEngine.instance.write("+ Wing.receive(" + airflowSensorAlarm + ")");
        try {
            for (int i = 0; i < airflowSensors.size(); i++) {
                Method alarmMethod = airflowSensors.get(i).getClass().getDeclaredMethod("alarm", int.class);
                LogEngine.instance.write("airflowSensorAlarmMethod = " + alarmMethod);

                boolean alarmResult = (boolean) alarmMethod.invoke(airflowSensors.get(i), airflowSensorAlarm.getThreshhold());
                LogEngine.instance.write(airflowSensorAlarm.getPhase() + " : isAlarm" + alarmResult);
                if (wingIndex == 0)
                    PrimaryFlightDisplay.instance.isLeftWingAirflowSensorAlarm = alarmResult;
                else
                    PrimaryFlightDisplay.instance.isRightWingAirflowSensorAlarm = alarmResult;
                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void recieve(AirflowSensorMeasure airflowSensorMeasure) {
        LogEngine.instance.write("+ Wing.receive(" + airflowSensorMeasure + ")");
        try {
            for (int i = 0; i < airflowSensors.size(); i++) {
                Method measureMethod = airflowSensors.get(i).getClass().getDeclaredMethod("measure", String.class);
                LogEngine.instance.write("airflowSensorMeasureMethod = " + measureMethod);

                int measureResult = (int) measureMethod.invoke(airflowSensors.get(i), airflowSensorMeasure.getAirFlow());
                LogEngine.instance.write(airflowSensorMeasure.getPhase() + " : measure" + measureResult);
                if (wingIndex == 0)
                    PrimaryFlightDisplay.instance.leftWingAirflowSensorAirPressure = measureResult;
                else
                    PrimaryFlightDisplay.instance.rightWingAirflowSensorAirPressure = measureResult;
                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void recieve(TurbulentAirFlowSensorAlarm turbulentAirFlowSensorAlarm) {
        LogEngine.instance.write("+ Wing.receive(" + turbulentAirFlowSensorAlarm + ")");

        try {
            for (int momSensor = 0; momSensor < turbulentAirFlowSensors.size(); momSensor++) {
                Method turbulentAirFlowSensorAlarmMethod = turbulentAirFlowSensors.get(momSensor).getClass().getDeclaredMethod("alarm");
                LogEngine.instance.write("turbulentAirFlowSensorMeasureMethod = " + turbulentAirFlowSensorAlarmMethod);

                boolean measuredValue = (boolean) turbulentAirFlowSensorAlarmMethod.invoke(turbulentAirFlowSensors.get(momSensor));
                LogEngine.instance.write(turbulentAirFlowSensorAlarm.getPhase() + " : turbulentAirFlowSensorAlarm = " + measuredValue);

                if (wingIndex == 0)
                    PrimaryFlightDisplay.instance.isLeftWingTurbulentAirFlowSensorAlarm = measuredValue;
                else
                    PrimaryFlightDisplay.instance.isRightWingTurbulentAirFlowSensorAlarm = measuredValue;

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void recieve(TurbulentAirFlowSensorMeasure turbulentAirFlowSensorMeasure) {
        LogEngine.instance.write("+ Wing.receive(" + turbulentAirFlowSensorMeasure + ")");

        try {
            for (int momSensor = 0; momSensor < turbulentAirFlowSensors.size(); momSensor++) {
                Method turbulentAirFlowSensorMeasureMethod = turbulentAirFlowSensors.get(momSensor).getClass().getDeclaredMethod("measure", int.class);
                LogEngine.instance.write("turbulentAirFlowSensorMeasureMethod = " + turbulentAirFlowSensorMeasureMethod);

                int measuredValue = (int) turbulentAirFlowSensorMeasureMethod.invoke(turbulentAirFlowSensors.get(momSensor), turbulentAirFlowSensorMeasure.getAirFlow());
                LogEngine.instance.write(turbulentAirFlowSensorMeasure.getPhase() + " : turbulentAirFlowSensorMeasure = " + measuredValue);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public ArrayList<Object> getDroopNoses() {
        return droopNoses;
    }

    public ArrayList<Object> getFlaps() {
        return flaps;
    }

    public ArrayList<Object> getSlats() {
        return slats;
    }

    public ArrayList<Object> getLeftAilerons() {
        return leftAilerons;
    }

    public ArrayList<Object> getRightAilerons() {
        return rightAilerons;
    }

    public ArrayList<Object> getSpoilers() {
        return spoilers;
    }

    public ArrayList<Object> getEngines() {
        return engines;
    }

    public ArrayList<Object> getHydraulicPumps() {
        return hydraulicPumps;
    }

    public ArrayList<Object> getEngineOilTanks() {
        return engineOilTanks;
    }

    public ArrayList<Object> getFuelTanks() {
        return fuelTanks;
    }

    public ArrayList<Object> getDeIcingSystems() {
        return deIcingSystems;
    }

    public ArrayList<Object> getExhaustGasTemperatureSensors() {
        return exhaustGasTemperatureSensors;
    }

    public ArrayList<Object> getFuelFlowSensors() {
        return fuelFlowSensors;
    }

    public ArrayList<Object> getFuelSensors() {
        return fuelSensors;
    }

    public ArrayList<Object> getIceDetectorProbes() {
        return iceDetectorProbes;
    }

    public ArrayList<Object> getFireDetectors() {
        return fireDetectors;
    }

    public ArrayList<Object> getShockSensors() {
        return shockSensors;
    }

    public ArrayList<Object> getStallingSensors() {
        return stallingSensors;
    }

    public ArrayList<Object> getTemperatureSensors() {
        return temperatureSensors;
    }

    public ArrayList<Object> getAirflowSensors() {
        return airflowSensors;
    }

    public ArrayList<Object> getTurbulentAirFlowSensors() {
        return turbulentAirFlowSensors;
    }

    public ArrayList<Object> getCameras() {
        return cameras;
    }

    public ArrayList<Object> getLandingLights() {
        return landingLights;
    }

    public ArrayList<Object> getLeftNavigationLights() {
        return leftNavigationLights;
    }

    public ArrayList<Object> getRightNavigationLights() {
        return rightNavigationLights;
    }

}