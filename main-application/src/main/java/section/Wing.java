package section;

import com.google.common.eventbus.Subscribe;
import event.Subscriber;
import event.engine.*;
import event.hydraulicPump.HydraulicPumpCompress;
import event.hydraulicPump.HydraulicPumpDecompress;
import event.hydraulicPump.HydraulicPumpRefilOil;
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