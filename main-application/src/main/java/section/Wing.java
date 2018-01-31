package section;

import base.PrimaryFlightDisplay;
import com.google.common.eventbus.Subscribe;
import event.Slat.*;
import event.flap.*;
import event.Subscriber;
import factory.*;
import event.engine.*;
import event.hydraulicPump.*;
import event.sensors.airflowSensor.*;
import event.sensors.turbulentAirFlowSensor.*;
import factory.AirflowSensorFactory;
import factory.CameraFactory;
import factory.ExhaustGasTemperatureSensorFactory;
import factory.FuelFlowSensorFactory;
import factory.FuelSensorFactory;
import factory.IceDetectorProbeFactory;
import logging.LogEngine;

import java.lang.reflect.Method;
import java.util.ArrayList;

// Factory import for sensor04

import factory.CameraFactory;
import recorder.FlightRecorder;
import event.Camera.*;


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
        for (int i = 0; i < 2; i++) droopNoses.add(DroopNoseFactory.build());
        flaps = new ArrayList<>();
        for (int i = 0; i < 2; i++) flaps.add(FlapFactory.build());
        slats = new ArrayList<>();
        for (int i = 0; i < 6; i++) slats.add(SlapFactory.build());

        // Flight Controls02
        leftAilerons = new ArrayList<>();
        for (int i = 0; i < 3; i++) leftAilerons.add(LeftAileronFactory.build("", "", ""));
        rightAilerons = new ArrayList<>();
        for (int i = 0; i < 3; i++) rightAilerons.add(RightAileronFactory.build("", "", ""));
        spoilers = new ArrayList<>();
        for (int i = 0; i < 8; i++) spoilers.add(SpoilerFactory.build("", "", ""));

        // apu_engine_gear_pump
        engines = new ArrayList<>();
        for (int i = 0; i < 2; i++) engines.add(EngineFactory.build());
        hydraulicPumps = new ArrayList<>();
        for (int i = 0; i < 4; i++) hydraulicPumps.add(HydraulicPumpFactory.build());

        // tank_bottle
        engineOilTanks = new ArrayList<>();
        for (int i = 0; i < 4; i++) engineOilTanks.add(EngineOilTankFactory.build());
        fuelTanks = new ArrayList<>();
        for (int i = 0; i < 3; i++) fuelTanks.add(FuelTankFactory.build());
        deIcingSystems = new ArrayList<>();
        for (int i = 0; i < 2; i++) deIcingSystems.add(DeIcingSystemFactory.build());

        // sensor01
        exhaustGasTemperatureSensors = new ArrayList<>();
        for (int i = 0; i < 4; i++) exhaustGasTemperatureSensors.add(ExhaustGasTemperatureSensorFactory.build());
        fuelFlowSensors = new ArrayList<>();
        for (int i = 0; i < 6; i++) fuelFlowSensors.add(FuelFlowSensorFactory.build());
        fuelSensors = new ArrayList<>();
        for (int i = 0; i < 6; i++) fuelSensors.add(FuelSensorFactory.build());

        iceDetectorProbes = new ArrayList<>();
        iceDetectorProbes.add(IceDetectorProbeFactory.build());
        iceDetectorProbes.add(IceDetectorProbeFactory.build());

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
        cameraPorts = new ArrayList<>();
        cameraPorts.add(CameraFactory.build());

        // light
        landingLights = new ArrayList<>();
        //for (int i = 0; i < 2; i++) landingLights.add(LandingLightFactory.build());
        leftNavigationLights = new ArrayList<>();
        //for (int i = 0; i < 1; i++) leftNavigationLights.add(LeftNavigationLightFactory.build());
        // Factory magic 1, LightType = red, Position = port
        rightNavigationLights = new ArrayList<>();
        //for (int i = 0; i < 1; i++) rightNavigationLights.add(RightNavigationLightFactory.build());
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

            //AirflowSensor
            for (Object port : airflowSensors) {
                Method versionMethod = port.getClass().getDeclaredMethod("version");
                String version = (String) versionMethod.invoke(port);
                LogEngine.instance.write("AirflowSensorPort :" + port.hashCode() + " - " + version);
            }

            //TurbulentAirFlowSensor
            for (Object port : turbulentAirFlowSensors) {
                Method versionMethod = port.getClass().getDeclaredMethod("version");
                String version = (String) versionMethod.invoke(port);
                LogEngine.instance.write("TurbulentAirflowSensorPort :" + port.hashCode() + " - " + version);
            }

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
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),cameraOn.getPhase() + " : camera (isOn) = " + isCameraOn);

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
            FlightRecorder.instance.insert(this.getClass().getSimpleName(),cameraOff.getPhase() + " : camera (isOff) = " + isCameraOff);

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
            FlightRecorder.instance.insert(this.getClass().getSimpleName(),cameraZoomIn.getPhase() + " : camera (Factor) = " + cameraFactor);

            LogEngine.instance.write("+");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // please add here
    //Engine
    @Subscribe
    public void receive(EngineDecreaseRPM engineDecreaseRPM) {
        LogEngine.instance.write("+ Body.receive(" + engineDecreaseRPM + ")");

        try {
            for (int engineIndex = 0;engineIndex < 2;engineIndex++) {
                Method engineDecreaseRPMMethod = engines.get(engineIndex).getClass().getDeclaredMethod("decreaseRPM", int.class);
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

    @Subscribe
    public void receive(EngineExtinguishFire engineExtinguishFire) {
        LogEngine.instance.write("+ Body.receive(" + engineExtinguishFire + ")");

        try {
            for (int engineIndex = 0;engineIndex < 2;engineIndex++) {
                Method engineExtinguishFireMMethod = engines.get(engineIndex).getClass().getDeclaredMethod("extinguishFire");
                LogEngine.instance.write("engineExtinguishFire = " + engineExtinguishFireMMethod);

                boolean isOnFire = (boolean) engineExtinguishFireMMethod.invoke(engines.get(engineIndex));
                LogEngine.instance.write(engineExtinguishFire.getPhase() + " : isOnFire = " + isOnFire);

//                PrimaryFlightDisplay.instance.isWeatherRadarOn = decreaseRPM;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),engineExtinguishFire.getPhase() + " : isOnFire = " + isOnFire);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(EngineIncreaseRPM engineIncreaseRPM) {
        LogEngine.instance.write("+ Body.receive(" + engineIncreaseRPM + ")");

        try {
            for (int engineIndex = 0;engineIndex < 2;engineIndex++) {
                Method engineIncreaseRPMMethod = engines.get(engineIndex).getClass().getDeclaredMethod("increaseRPM", int.class);
                LogEngine.instance.write("engineIncreaseRPMMethod = " + engineIncreaseRPMMethod);

                int increaseRPM = (int)engineIncreaseRPMMethod.invoke(engines.get(engineIndex), engineIncreaseRPM.getValue());
                LogEngine.instance.write(engineIncreaseRPM.getPhase() + " : increaseRPM = " + increaseRPM);

//                PrimaryFlightDisplay.instance.isWeatherRadarOn = increaseRPM;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),engineIncreaseRPM.getPhase() + " : increaseRPM = " + increaseRPM);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(EngineShutdown engineShutdown) {
        LogEngine.instance.write("+ Body.receive(" + engineShutdown + ")");

        try {
            for (int engineIndex = 0;engineIndex < 2;engineIndex++) {
                Method engineShutdownMethod = engines.get(engineIndex).getClass().getDeclaredMethod("shutdown");
                LogEngine.instance.write("engineShutdown = " + engineShutdownMethod);

                boolean isShutdown = (boolean) engineShutdownMethod.invoke(engines.get(engineIndex));
                LogEngine.instance.write(engineShutdown.getPhase() + " : isShutdown = " + !isShutdown);

//                PrimaryFlightDisplay.instance.isWeatherRadarOn = decreaseRPM;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),engineShutdown.getPhase() + " : isShutdown = " + !isShutdown);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(EngineStart engineStart) {
        LogEngine.instance.write("+ Body.receive(" + engineStart + ")");

        try {
            for (int engineIndex = 0;engineIndex < 2;engineIndex++) {
                Method engineStartMethod = engines.get(engineIndex).getClass().getDeclaredMethod("start");
                LogEngine.instance.write("engineStart = " + engineStartMethod);

                boolean isStarted = (boolean) engineStartMethod.invoke(engines.get(engineIndex));
                LogEngine.instance.write(engineStart.getPhase() + " : isStarted = " + isStarted);

//                PrimaryFlightDisplay.instance.isWeatherRadarOn = decreaseRPM;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),engineStart.getPhase() + " : isStarted = " + isStarted);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Hydraulic Pump
    @Subscribe
    public void receive (HydraulicPumpCompress hydraulicPumpCompress) {
        LogEngine.instance.write("+ Body.receive(" + hydraulicPumpCompress + ")");

        try {
            for (int hydraulicPumpCompressIndex = 0;hydraulicPumpCompressIndex <4 ;hydraulicPumpCompressIndex++) {
                Method hydraulicPumpCompressMethod = null;
                int compress = 0;
                if (hydraulicPumpCompress.getAmount() == 0){
                    hydraulicPumpCompressMethod = hydraulicPumps.get(hydraulicPumpCompressIndex).getClass().getDeclaredMethod("compress");
                    LogEngine.instance.write("hydraulicPumpCompress = " + hydraulicPumpCompressMethod);
                    compress = (int) hydraulicPumpCompressMethod.invoke(hydraulicPumps.get(hydraulicPumpCompressIndex));
                }
                else{
                    hydraulicPumpCompressMethod = hydraulicPumps.get(hydraulicPumpCompressIndex).getClass().getDeclaredMethod("compress", int.class);
                    LogEngine.instance.write("hydraulicPumpCompress = " + hydraulicPumpCompressMethod);
                    compress = (int) hydraulicPumpCompressMethod.invoke(hydraulicPumps.get(hydraulicPumpCompressIndex),hydraulicPumpCompress.getAmount());
                }
                LogEngine.instance.write(hydraulicPumpCompress.getPhase() + " : compress = " + compress);

//                PrimaryFlightDisplay.instance.isWeatherRadarOn = decreaseRPM;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),hydraulicPumpCompress.getPhase() + " : compress = " + compress);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive (HydraulicPumpDecompress hydraulicPumpDecompress) {
        LogEngine.instance.write("+ Body.receive(" + hydraulicPumpDecompress + ")");

        try {
            for (int hydraulicPumpDecompressIndex = 0;hydraulicPumpDecompressIndex < 4;hydraulicPumpDecompressIndex++) {
                Method hydraulicPumpDecompressMethod = hydraulicPumps.get(hydraulicPumpDecompressIndex).getClass().getDeclaredMethod("decompress");
                LogEngine.instance.write("hydraulicPumpDecompress = " + hydraulicPumpDecompressMethod);

                int    decompress = (int) hydraulicPumpDecompressMethod.invoke(hydraulicPumps.get(hydraulicPumpDecompressIndex));
                LogEngine.instance.write(hydraulicPumpDecompress.getPhase() + " : decompress = " + decompress);

//                PrimaryFlightDisplay.instance.isWeatherRadarOn = decreaseRPM;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),hydraulicPumpDecompress.getPhase() + " : decompress = " + decompress);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive (HydraulicPumpRefilOil hydraulicPumpRefilOil) {
        LogEngine.instance.write("+ Body.receive(" + hydraulicPumpRefilOil + ")");

        try {
            for (int hydraulicPumpRefilOilIndex = 0;hydraulicPumpRefilOilIndex < 4;hydraulicPumpRefilOilIndex++) {
                Method hydraulicPumpRefilOilMethod = null;
                int refilOil = 0;
                if (hydraulicPumpRefilOil.getAmount() == 0){
                    hydraulicPumpRefilOilMethod = hydraulicPumps.get(hydraulicPumpRefilOilIndex).getClass().getDeclaredMethod("refilOil");
                    LogEngine.instance.write("hydraulicPumpRefilOil = " + hydraulicPumpRefilOilMethod);
                    refilOil = (int) hydraulicPumpRefilOilMethod.invoke(hydraulicPumps.get(hydraulicPumpRefilOilIndex));
                }
                else{
                    hydraulicPumpRefilOilMethod = hydraulicPumps.get(hydraulicPumpRefilOilIndex).getClass().getDeclaredMethod("refilOil", int.class);
                    LogEngine.instance.write("hydraulicPumpRefilOil = " + hydraulicPumpRefilOilMethod);
                    refilOil = (int) hydraulicPumpRefilOilMethod.invoke(hydraulicPumps.get(hydraulicPumpRefilOilIndex),hydraulicPumpRefilOil.getAmount());
                }
                LogEngine.instance.write(hydraulicPumpRefilOil.getPhase() + " : refilOil = " + refilOil);

//                PrimaryFlightDisplay.instance.isWeatherRadarOn = decreaseRPM;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),hydraulicPumpRefilOil.getPhase() + " : refilOil = " + refilOil);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive (FlapSetLevel flapSetlevel) {
        LogEngine.instance.write("+ Wing.receive(" + flapSetlevel + ")");
        int level = flapSetlevel.getLevel();
        try {
            switch (level) {
                case 0:
                    for (int i = 0; i < 2; i++) {
                        Method method = null;
                        method = flaps.get(i).getClass().getDeclaredMethod("neutral");
                        LogEngine.instance.write("flapSetlevel = " + method);
                        int returnValue = (int) method.invoke(flaps.get(i));
                        LogEngine.instance.write(flapSetlevel.getId() + " : Current Degress = " + returnValue);
                        FlightRecorder.instance.insert(this.getClass().getSimpleName(), flapSetlevel.getId() + " : Current Degress = " + returnValue);
                        LogEngine.instance.write("+");
                    }
                    break;
                case 1:
                    for (int i = 0; i < 2; i++) {
                        Method method = null;
                        method = flaps.get(i).getClass().getDeclaredMethod("levelOne");
                        LogEngine.instance.write("flapSetlevel = " + method);
                        int returnValue = (int) method.invoke(flaps.get(i));
                        LogEngine.instance.write(flapSetlevel.getId() + " : Current Degress = " + returnValue);
                        FlightRecorder.instance.insert(this.getClass().getSimpleName(), flapSetlevel.getId() + " : Current Degress = " + returnValue);
                        LogEngine.instance.write("+");

                    }
                    break;
                case 2:
                    for (int i = 0; i < 2; i++) {
                        Method method = null;
                        method = flaps.get(i).getClass().getDeclaredMethod("levelTwo");
                        LogEngine.instance.write("flapSetlevel = " + method);
                        int returnValue = (int) method.invoke(flaps.get(i));
                        LogEngine.instance.write(flapSetlevel.getId() + " : Current Degress = " + returnValue);
                        FlightRecorder.instance.insert(this.getClass().getSimpleName(), flapSetlevel.getId() + " : Current Degress = " + returnValue);
                        LogEngine.instance.write("+");

                    }
                    break;
                case 3:
                    for (int i = 0; i < 2; i++) {
                        Method method = null;
                        method = flaps.get(i).getClass().getDeclaredMethod("levelThree");
                        LogEngine.instance.write("flapSetlevel = " + method);
                        int returnValue = (int) method.invoke(flaps.get(i));
                        LogEngine.instance.write(flapSetlevel.getId() + " : Current Degress = " + returnValue);
                        FlightRecorder.instance.insert(this.getClass().getSimpleName(), flapSetlevel.getId() + " : Current Degress = " + returnValue);
                        LogEngine.instance.write("+");

                    }
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Subscribe
    public void receive (SlatSetFix slatSetFix) {
        LogEngine.instance.write("+ Wing.receive(" + slatSetFix + ")");
        int level = slatSetFix.getLevel();
        try {
            switch (level) {
                case 0:
                    for (int i = 0; i < 6; i++) {
                        Method method = null;
                        method = flaps.get(i).getClass().getDeclaredMethod("neutral");
                        LogEngine.instance.write("slatSetFix = " + method);
                        int returnValue = (int) method.invoke(flaps.get(i));
                        LogEngine.instance.write(slatSetFix.getId() + " : Current Degress = " + returnValue);
                        FlightRecorder.instance.insert(this.getClass().getSimpleName(), slatSetFix.getId() + " : Current Degress = " + returnValue);
                        LogEngine.instance.write("+");
                    }
                    break;
                case 1:
                    for (int i = 0; i < 6; i++) {
                        Method method = null;
                        method = flaps.get(i).getClass().getDeclaredMethod("fullDown");
                        LogEngine.instance.write("slatSetFix = " + method);
                        int returnValue = (int) method.invoke(flaps.get(i));
                        LogEngine.instance.write(slatSetFix.getId() + " : Current Degress = " + returnValue);
                        FlightRecorder.instance.insert(this.getClass().getSimpleName(), slatSetFix.getId() + " : Current Degress = " + returnValue);
                        LogEngine.instance.write("+");

                    }
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Subscribe
    public void receive (SlatSetVariable slatSetVariable) {
        LogEngine.instance.write("+ Wing.receive(" + slatSetVariable + ")");
        int direction = slatSetVariable.getDirection();
        int degree = slatSetVariable.getDirection();
        try {
            if(direction<0){
                for (int i = 0; i < 6; i++) {
                    Method method = null;
                    method = flaps.get(i).getClass().getDeclaredMethod("down", int.class);
                    LogEngine.instance.write("slatSetVariable = " + method);
                    int returnValue = (int) method.invoke(flaps.get(i),slatSetVariable.getDegree());
                    LogEngine.instance.write(slatSetVariable.getId() + " : Current Degress = " + returnValue);
                    FlightRecorder.instance.insert(this.getClass().getSimpleName(), slatSetVariable.getId() + " : Current Degress = " + returnValue);
                    LogEngine.instance.write("+");
                }
            } else {
                for (int i = 0; i < 6; i++) {
                    Method method = null;
                    method = flaps.get(i).getClass().getDeclaredMethod("up", int.class);
                    LogEngine.instance.write("slatSetVariable = " + method);
                    int returnValue = (int) method.invoke(flaps.get(i),slatSetVariable.getDegree());
                    LogEngine.instance.write(slatSetVariable.getId() + " : Current Degress = " + returnValue);
                    FlightRecorder.instance.insert(this.getClass().getSimpleName(), slatSetVariable.getId() + " : Current Degress = " + returnValue);
                    LogEngine.instance.write("+");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //sensor03
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
        return cameraPorts;
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