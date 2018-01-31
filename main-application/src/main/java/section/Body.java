package section;

import base.PrimaryFlightDisplay;
import com.google.common.eventbus.Subscribe;
import event.Subscriber;
import event.sensors.airflowSensor.AirflowSensorAlarm;
import event.sensors.airflowSensor.AirflowSensorMeasure;
import event.sensors.pitotTube.PitotTubeMeasureStaticPressure;
import event.sensors.pitotTube.PitotTubeMeasureTotalPressure;
import event.sensors.pitotTube.PitotTubeMeasureVelocity;
import event.sensors.radarAltimeter.RadarAltimeterMeasureAltitude;
import event.sensors.radarAltimeter.RadarAltimeterOff;
import event.sensors.radarAltimeter.RadarAltimeterOn;
import event.sensors.radarAltimeter.RadarAltimeterReceive;
import event.sensors.radarAltimeter.RadarAltimeterSend;
import event.sensors.tCAS.TCASAlarm;
import event.sensors.tCAS.TCASConnect;
import event.sensors.tCAS.TCASDetermineAltitude;
import event.sensors.tCAS.TCASOff;
import event.sensors.tCAS.TCASOn;
import event.sensors.tCAS.TCASScann;
import event.sensors.tCAS.TCASSetAltitude;
import event.sensors.turbulentAirFlowSensor.TurbulentAirFlowSensorAlarm;
import event.sensors.turbulentAirFlowSensor.TurbulentAirFlowSensorMeasure;
import factory.CameraFactory;
import factory.GPSFactory;
import factory.RadarFactory;
import factory.SatComFactory;
import factory.VHFFactory;
import logging.LogEngine;

import java.lang.reflect.Method;
import java.util.ArrayList;

import base.PrimaryFlightDisplay;
import com.google.common.eventbus.Subscribe;
import java.lang.reflect.Method;
import java.util.ArrayList;

import com.google.common.eventbus.Subscribe;
import event.apu.APUDecreaseRPM;
import event.apu.APUIncreaseRPM;
import event.apu.APUShutdown;
import event.apu.APUStart;
import event.gear.*;
import event.hydraulicPump.HydraulicPumpCompress;
import event.hydraulicPump.HydraulicPumpDecompress;
import event.hydraulicPump.HydraulicPumpRefilOil;
import factory.*;
import logging.LogEngine;
import event.sensors.airflowSensor.AirflowSensorAlarm;
import event.sensors.airflowSensor.AirflowSensorMeasure;
import event.sensors.pitotTube.PitotTubeMeasureStaticPressure;
import event.sensors.pitotTube.PitotTubeMeasureTotalPressure;
import event.sensors.pitotTube.PitotTubeMeasureVelocity;
import event.sensors.radarAltimeter.RadarAltimeterMeasureAltitude;
import event.sensors.radarAltimeter.RadarAltimeterOff;
import event.sensors.radarAltimeter.RadarAltimeterOn;
import event.sensors.radarAltimeter.RadarAltimeterReceive;
import event.sensors.radarAltimeter.RadarAltimeterSend;
import event.sensors.tCAS.TCASAlarm;
import event.sensors.tCAS.TCASConnect;
import event.sensors.tCAS.TCASDetermineAltitude;
import event.sensors.tCAS.TCASOff;
import event.sensors.tCAS.TCASOn;
import event.sensors.tCAS.TCASScann;
import event.sensors.tCAS.TCASSetAltitude;
import event.sensors.turbulentAirFlowSensor.TurbulentAirFlowSensorAlarm;
import event.sensors.turbulentAirFlowSensor.TurbulentAirFlowSensorMeasure;
import factory.AirflowSensorFactory;
import factory.CameraFactory;
import factory.GPSFactory;
import factory.PitotTubeFactory;
import factory.RadarAltimeterFactory;
import factory.RadarFactory;
import factory.SatComFactory;
import factory.TCASFactory;
import factory.TurbulentAirFlowSensorFactory;
import factory.VHFFactory;
import logging.LogEngine;

import javax.print.DocFlavor;
import java.lang.reflect.Method;
import java.util.ArrayList;

import factory.IceDetectorProbeFactory;
import logging.LogEngine;

import java.util.ArrayList;
import recorder.FlightRecorder;

// import factorys for sensor04


public class Body extends Subscriber {

    // Flight Controls01
    private ArrayList<Object> elevators;
    // Flight Controls02
    private ArrayList<Object> rudders;
    // apu_engine_gear_pump
    private ArrayList<Object> apus;
    private ArrayList<Object> gears;
    private ArrayList<Object> hydraulicPumps;
    // doors
    private ArrayList<Object> bulkCargoDoors;
    private ArrayList<Object> crewDoors;
    private ArrayList<Object> emergencyExitDoors;
    private ArrayList<Object> gearDoors;
    // tank_bottle
    private ArrayList<Object> aPUOilTanks;
    private ArrayList<Object> batteries;
    private ArrayList<Object> nitrogenBottles;
    private ArrayList<Object> oxygenBottles;
    private ArrayList<Object> potableWaterTanks;
    private ArrayList<Object> wasteWaterTanks;
    private ArrayList<Object> fireExtinguishers;
    private ArrayList<Object> deIcingSystems;
    // seats
    private ArrayList<Object> firstClassSeats;
    private ArrayList<Object> businessClassSeats;
    private ArrayList<Object> touristClassSeats;
    private ArrayList<Object> crewSeats;
    // sensor01
    private ArrayList<Object> iceDetectorProbes;
    // sensor02
    private ArrayList<Object> fireDetectors;
    private ArrayList<Object> oxygenSensors;
    private ArrayList<Object> shockSensors;
    private ArrayList<Object> stallingSensors;
    private ArrayList<Object> temperatureSensors;
    // sensor03
    private ArrayList<Object> airflowSensors;
    private ArrayList<Object> pitotTubes;
    private ArrayList<Object> radarAltimeters;
    private ArrayList<Object> tCASs;
    private ArrayList<Object> turbulentAirFlowSensors;
    // sensor04
    private ArrayList<Object> cameras;
    private ArrayList<Object> gPSs;
    private ArrayList<Object> radars;
    private ArrayList<Object> satComs;
    private ArrayList<Object> vHFs;
    // light
    private ArrayList<Object> antiCollisionLights;
    private ArrayList<Object> cargoCompartmentLights;
    private ArrayList<Object> landingLights;
    private ArrayList<Object> logoLights;
    private ArrayList<Object> tailNavigationLights;
    private ArrayList<Object> taxiLights;
    private ArrayList<Object> tCASLights;
    // stowage_cargo
    private ArrayList<Object> cargoSystems;
    private ArrayList<Object> stowageNumberFives;
    // cabin
    private ArrayList<Object> airConditionings;
    private ArrayList<Object> kitchens;
    private ArrayList<Object> lavatories;
    private ArrayList<Object> wasteSystems;
    private ArrayList<Object> waterSystems;
    private ArrayList<Object> escapeSlides;
    // management
    private ArrayList<Object> costOptimizers;
    private ArrayList<Object> routeManagements;
    private ArrayList<Object> seatManagements;

    public Body() {
        build();
        printStatus();
    }

    public void build() {
        // Flight Controls01
        elevators = new ArrayList<>();
        // Factory magic 4 (full = +/- 45 degrees, left -; right +)

        // Flight Controls02
        rudders = new ArrayList<>();
        // Factory magic 2

        // apu_engine_gear_pump
        apus = new ArrayList<>();
        // Factory magic 1
        gears = new ArrayList<>();
        // Factory magic 3 (1 front, 2 rear)
        hydraulicPumps = new ArrayList<>();
        // Factory magic 6

        // doors
        bulkCargoDoors = new ArrayList<>();
        // Factory magic 2
        crewDoors = new ArrayList<>();
        // Factory magic 2
        emergencyExitDoors = new ArrayList<>();
        // Factory magic 14
        gearDoors = new ArrayList<>();
        // Factory magic 6 (2 front, 4 gear)

        // tank_bottle
        aPUOilTanks = new ArrayList<>();
        for (int i = 0; i < 2; i++) aPUOilTanks.add(APUOilTankFactory.build());
        batteries = new ArrayList<>();
        for (int i = 0; i < 24; i++) batteries.add(BatteryFactory.build());
        nitrogenBottles = new ArrayList<>();
        for (int i = 0; i < 6; i++) nitrogenBottles.add(NitrogenBottleFactory.build());
        oxygenBottles = new ArrayList<>();
        for (int i = 0; i < 10; i++) oxygenBottles.add(OxygenBottleFactory.build());
        potableWaterTanks = new ArrayList<>();
        for (int i = 0; i < 8; i++) potableWaterTanks.add(PotableWaterTankFactory.build());
        wasteWaterTanks = new ArrayList<>();
        for (int i = 0; i < 4; i++) wasteWaterTanks.add(WasteWaterTankFactory.build());
        fireExtinguishers = new ArrayList<>();
        for (int i = 0; i < 14; i++) fireExtinguishers.add(FireExtinguisherFactory.build());
        deIcingSystems = new ArrayList<>();
        for (int i = 0; i < 2; i++) deIcingSystems.add(DeIcingSystemFactory.build());

        // seats
        firstClassSeats = new ArrayList<>();
        // Factory magic 16
        businessClassSeats = new ArrayList<>();
        // Factory magic 72
        touristClassSeats = new ArrayList<>();
        // Factory magic 480
        crewSeats = new ArrayList<>();
        // Factory magic 14

        // sensor01
        iceDetectorProbes = new ArrayList<>();
        iceDetectorProbes.add(IceDetectorProbeFactory.build());
        iceDetectorProbes.add(IceDetectorProbeFactory.build());
        // Factory magic 2

        // sensor02
        fireDetectors = new ArrayList<>();
        // Factory magic 14
        oxygenSensors = new ArrayList<>();
        // Factory magic 8
        shockSensors = new ArrayList<>();
        // Factory magic 2
        stallingSensors = new ArrayList<>();
        // Factory magic 2
        temperatureSensors = new ArrayList<>();
        // Factory magic 2

        // sensor03
        airflowSensors = new ArrayList<>();
        airflowSensors.add(AirflowSensorFactory.build());
        airflowSensors.add(AirflowSensorFactory.build());
        pitotTubes = new ArrayList<>();
        pitotTubes.add(PitotTubeFactory.build());
        pitotTubes.add(PitotTubeFactory.build());
        radarAltimeters = new ArrayList<>();
        radarAltimeters.add(RadarAltimeterFactory.build());
        radarAltimeters.add(RadarAltimeterFactory.build());
        tCASs = new ArrayList<>();
        tCASs.add(TCASFactory.build());
        tCASs.add(TCASFactory.build());
        turbulentAirFlowSensors = new ArrayList<>();
        turbulentAirFlowSensors.add(TurbulentAirFlowSensorFactory.build());
        turbulentAirFlowSensors.add(TurbulentAirFlowSensorFactory.build());

        // sensor04
        cameras = new ArrayList<>();
        for (int cameraIndex = 0; cameraIndex < 2; cameraIndex++)
            cameras.add(CameraFactory.build());
        gPSs = new ArrayList<>();
        for (int gpsIndex = 0; gpsIndex < 2; gpsIndex++)
            gPSs.add(GPSFactory.build());
        radars = new ArrayList<>();
        for (int radarIndex = 0; radarIndex < 2; radarIndex++)
            radars.add(RadarFactory.build());
        satComs = new ArrayList<>();
        for (int satComIndex = 0; satComIndex < 2; satComIndex++)
            satComs.add(SatComFactory.build());
        vHFs = new ArrayList<>();
        for (int vhfIndex = 0; vhfIndex < 2; vhfIndex++)
            vHFs.add(VHFFactory.build());

        // light
        antiCollisionLights = new ArrayList<>();
        // Factory magic 2
        cargoCompartmentLights = new ArrayList<>();
        // Factory magic 4
        landingLights = new ArrayList<>();
        // Factory magic 2
        logoLights = new ArrayList<>();
        // Factory magic 2
        tailNavigationLights = new ArrayList<>();
        // Factory magic 2
        taxiLights = new ArrayList<>();
        // Factory magic 2
        tCASLights = new ArrayList<>();
        // Factory magic 2

        // stowage_cargo
        cargoSystems = new ArrayList<>();
        // Factory magic 2
        stowageNumberFives = new ArrayList<>();
        // Factory magic 1

        // cabin
        airConditionings = new ArrayList<>();
        for(int i = 0; i < 4; i++)
            airConditionings.add(AirConditioningFactory.build());
        // Factory magic 4
        kitchens = new ArrayList<>();
        kitchens.add(KitchenFactory.build("FIRST"));
        kitchens.add(KitchenFactory.build("BUSINESS"));
        kitchens.add(KitchenFactory.build("ECONOMY"));
        kitchens.add(KitchenFactory.build("ECONOMY"));
        // Factory magic 4 1x First, 1x Business, 2x Economy
        lavatories = new ArrayList<>();
        for(int i = 0; i < 8; i++)
            lavatories.add(LavatoryFactory.build());
        // Factory magic 8
        wasteSystems = new ArrayList<>();
        for(int i = 0; i < 10; i++)
            wasteSystems.add(WasteSystemFactory.build());
        // Factory magic 10
        waterSystems = new ArrayList<>();
        for(int i = 0; i < 4; i++)
            waterSystems.add(WaterSystemFactory.build());
        // Factory magic 4
        escapeSlides = new ArrayList<>();
        for(int i = 0; i < 14; i++)
            escapeSlides.add(EscapeSlideFactory.build());
        // Factory magic 14

        // management
        costOptimizers = new ArrayList<>();
        // Factory magic 2
        routeManagements = new ArrayList<>();
        // Factory magic 2
        seatManagements = new ArrayList<>();
        // Factory magic 1
    }

    public void printStatus() {
        try {
            LogEngine.instance.write("--- Body ---");


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

            //PitotTube
            for (Object port : pitotTubes) {
                Method versionMethod = port.getClass().getDeclaredMethod("version");
                String version = (String) versionMethod.invoke(port);
                LogEngine.instance.write("PitotTubePort :" + port.hashCode() + " - " + version);
            }
            //RadarAltimeter
            for (Object port : radarAltimeters) {
                Method versionMethod = port.getClass().getDeclaredMethod("version");
                String version = (String) versionMethod.invoke(port);
                LogEngine.instance.write("RadarAltimeterPort :" + port.hashCode() + " - " + version);
            }
            //TCAS
            for (Object port : tCASs) {
                Method versionMethod = port.getClass().getDeclaredMethod("version");
                String version = (String) versionMethod.invoke(port);
                LogEngine.instance.write("TCASPort :" + port.hashCode() + " - " + version);
            }

            // please add here

            LogEngine.instance.write("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Object> getElevators() {
        return elevators;
    }

    public ArrayList<Object> getRudders() {
        return rudders;
    }

    public ArrayList<Object> getApus() {
        return apus;
    }

    public ArrayList<Object> getGears() {
        return gears;
    }

    public ArrayList<Object> getHydraulicPumps() {
        return hydraulicPumps;
    }

    public ArrayList<Object> getBulkCargoDoors() {
        return bulkCargoDoors;
    }

    public ArrayList<Object> getCrewDoors() {
        return crewDoors;
    }

    public ArrayList<Object> getEmergencyExitDoors() {
        return emergencyExitDoors;
    }

    public ArrayList<Object> getGearDoors() {
        return gearDoors;
    }

    public ArrayList<Object> getaPUOilTanks() {
        return aPUOilTanks;
    }

    public ArrayList<Object> getBatteries() {
        return batteries;
    }

    public ArrayList<Object> getNitrogenBottles() {
        return nitrogenBottles;
    }

    public ArrayList<Object> getOxygenBottles() {
        return oxygenBottles;
    }

    public ArrayList<Object> getPotableWaterTanks() {
        return potableWaterTanks;
    }

    public ArrayList<Object> getWasteWaterTanks() {
        return wasteWaterTanks;
    }

    public ArrayList<Object> getFireExtinguishers() {
        return fireExtinguishers;
    }

    public ArrayList<Object> getDeIcingSystems() {
        return deIcingSystems;
    }

    public ArrayList<Object> getFirstClassSeats() {
        return firstClassSeats;
    }

    public ArrayList<Object> getBusinessClassSeats() {
        return businessClassSeats;
    }

    public ArrayList<Object> getTouristClassSeats() {
        return touristClassSeats;
    }

    public ArrayList<Object> getCrewSeats() {
        return crewSeats;
    }

    public ArrayList<Object> getIceDetectorProbes() {
        return iceDetectorProbes;
    }

    public ArrayList<Object> getFireDetectors() {
        return fireDetectors;
    }

    public ArrayList<Object> getOxygenSensors() {
        return oxygenSensors;
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

    public ArrayList<Object> getPitotTubes() {
        return pitotTubes;
    }

    public ArrayList<Object> getRadarAltimeters() {
        return radarAltimeters;
    }

    public ArrayList<Object> gettCASs() {
        return tCASs;
    }

    public ArrayList<Object> getTurbulentAirFlowSensors() {
        return turbulentAirFlowSensors;
    }

    public ArrayList<Object> getCameras() {
        return cameras;
    }

    public ArrayList<Object> getgPSs() {
        return gPSs;
    }

    public ArrayList<Object> getRadars() {
        return radars;
    }

    public ArrayList<Object> getSatComs() {
        return satComs;
    }

    public ArrayList<Object> getvHFs() {
        return vHFs;
    }

    public ArrayList<Object> getAntiCollisionLights() {
        return antiCollisionLights;
    }

    public ArrayList<Object> getCargoCompartmentLights() {
        return cargoCompartmentLights;
    }

    public ArrayList<Object> getLandingLights() {
        return landingLights;
    }

    public ArrayList<Object> getLogoLights() {
        return logoLights;
    }

    public ArrayList<Object> getTailNavigationLights() {
        return tailNavigationLights;
    }

    public ArrayList<Object> getTaxiLights() {
        return taxiLights;
    }

    public ArrayList<Object> gettCASLights() {
        return tCASLights;
    }

    public ArrayList<Object> getCargoSystems() {
        return cargoSystems;
    }

    public ArrayList<Object> getStowageNumberFives() {
        return stowageNumberFives;
    }

    public ArrayList<Object> getAirConditionings() {
        return airConditionings;
    }

    public ArrayList<Object> getKitchens() {
        return kitchens;
    }

    public ArrayList<Object> getLavatories() {
        return lavatories;
    }

    public ArrayList<Object> getWasteSystems() {
        return wasteSystems;
    }

    public ArrayList<Object> getWaterSystems() {
        return waterSystems;
    }

    public ArrayList<Object> getEscapeSlides() {
        return escapeSlides;
    }

    public ArrayList<Object> getCostOptimizers() {
        return costOptimizers;
    }

    public ArrayList<Object> getRouteManagements() {
        return routeManagements;
    }

    public ArrayList<Object> getSeatManagements() {
        return seatManagements;
    }

    @Subscribe
    public void receive(APUStart apuStart) {
        LogEngine.instance.write("+ Body.receive(" + apuStart + ")");

        try {

            Method apuStartMethod = apus.get(0).getClass().getDeclaredMethod("start", int.class);

            LogEngine.instance.write("apuStartMethode = " + apuStartMethod);

            apuStartMethod.invoke(apus.get(0));
            LogEngine.instance.write(apuStart.getPhase() + " : apuStarted");

            FlightRecorder.instance.insert(this.getClass().getSimpleName(), apuStart.getPhase() + " : apuStarted");

            LogEngine.instance.write("+");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Subscribe
    public void receive(APUDecreaseRPM apuDecreaseRPM) {
        LogEngine.instance.write("+ Body.receive(" + apuDecreaseRPM + ")");

        try {

            Method apuDecreaseRPMMethod = apus.get(0).getClass().getDeclaredMethod("decreaseRPM", int.class);

            LogEngine.instance.write("decreaseRPMMethod = " + apuDecreaseRPMMethod);

            int decreasedRPM = (int) apuDecreaseRPMMethod.invoke(apus.get(0), apuDecreaseRPM.getValue());
            LogEngine.instance.write(apuDecreaseRPM.getPhase() + " : decreasedRPM = " + decreasedRPM);

            FlightRecorder.instance.insert(this.getClass().getSimpleName(), apuDecreaseRPM.getPhase() + " : DecreasedRPM = " + decreasedRPM);

            LogEngine.instance.write("+");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(APUIncreaseRPM apuIncreaseRPM) {
        LogEngine.instance.write("+ Body.receive(" + apuIncreaseRPM + ")");

        try {

            Method apuIncreaseRPMMethod = apus.get(0).getClass().getDeclaredMethod("increaseRPM", int.class);

            LogEngine.instance.write("increaseRPMMethod = " + apuIncreaseRPMMethod);

            int increasedRPM = (int) apuIncreaseRPMMethod.invoke(apus.get(0), apuIncreaseRPM.getValue());
            LogEngine.instance.write(apuIncreaseRPM.getPhase() + " : increasedRPM = " + increasedRPM);

            FlightRecorder.instance.insert(this.getClass().getSimpleName(), apuIncreaseRPM.getPhase() + " : IncreasedRPM = " + increasedRPM);

            LogEngine.instance.write("+");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(APUShutdown apuShutdown) {
        LogEngine.instance.write("+ Body.receive(" + apuShutdown + ")");

        try {

            Method apuShutdownMethod = apus.get(0).getClass().getDeclaredMethod("shutdown", int.class);

            LogEngine.instance.write("apuStartMethode = " + apuShutdownMethod);

            apuShutdownMethod.invoke(apus.get(0));
            LogEngine.instance.write(apuShutdown.getPhase() + " : apuShutdown");

            FlightRecorder.instance.insert(this.getClass().getSimpleName(), apuShutdown.getPhase() + " : apuShutdown");

            LogEngine.instance.write("+");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(GearSetType gearSetType) {
        LogEngine.instance.write("+ Body.receive(" + gearSetType + ")");

        try {
            for (int i = 0; i < 3; i++) {
                Method gearSetTypeMethod = gears.get(i).getClass().getDeclaredMethod("setType", String.class);

                LogEngine.instance.write("increaseRPMMethod = " + gearSetTypeMethod);

                int newGearSetType = (int) gearSetTypeMethod.invoke(gears.get(i), gearSetType.getType());
                LogEngine.instance.write(gearSetType.getPhase() + " : increasedRPM = " + newGearSetType);

                FlightRecorder.instance.insert(this.getClass().getSimpleName(), gearSetType.getPhase() + " : gearSetType = " + newGearSetType);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(GearDown gearDown) {
        LogEngine.instance.write("+ Body.receive(" + gearDown + ")");

        try {
            for (int i = 0; i < 3; i++) {
                Method gearDownMethod = gears.get(i).getClass().getDeclaredMethod("down", String.class);

                LogEngine.instance.write("gearDownMethode = " + gearDownMethod);

                boolean newGearDown = (boolean) gearDownMethod.invoke(gears.get(i));
                LogEngine.instance.write(gearDown.getPhase() + " : gearDown = " + newGearDown);

                FlightRecorder.instance.insert(this.getClass().getSimpleName(), gearDown.getPhase() + " : gearDown = " + gearDown);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(GearUp gearUp) {
        LogEngine.instance.write("+ Body.receive(" + gearUp + ")");

        try {
            for (int i = 0; i < 3; i++) {
                Method gearUpMethod = gears.get(i).getClass().getDeclaredMethod("up", String.class);

                LogEngine.instance.write("gearUpMethode = " + gearUpMethod);

                boolean newGearUp = (boolean) gearUpMethod.invoke(gears.get(i));
                LogEngine.instance.write(gearUp.getPhase() + " : gearUp = " + newGearUp);

                FlightRecorder.instance.insert(this.getClass().getSimpleName(), gearUp.getPhase() + " : gearUp = " + gearUp);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(GearSetBrake gearSetBrake) {
        LogEngine.instance.write("+ Body.receive(" + gearSetBrake + ")");

        try {
            for (int i = 0; i < 3; i++) {
                Method gearSetBrakeMethod;
                int newGearUp;
                if(gearSetBrake.getPercent() == 0)
                {
                    gearSetBrakeMethod = gears.get(i).getClass().getDeclaredMethod("setBrake");
                    LogEngine.instance.write("gearSetBrakeMethode = " + gearSetBrakeMethod);
                    newGearUp = (int) gearSetBrakeMethod.invoke(gears.get(i));
                }else
                {
                    gearSetBrakeMethod = gears.get(i).getClass().getDeclaredMethod("setBrake", int.class);

                    LogEngine.instance.write("gearSetBrakeMethode = " + gearSetBrakeMethod);
                    newGearUp = (int) gearSetBrakeMethod.invoke(gears.get(i), gearSetBrake.getPercent());
                }

                LogEngine.instance.write(gearSetBrake.getPhase() + " : gearSetBrake = " + newGearUp);

                FlightRecorder.instance.insert(this.getClass().getSimpleName(), gearSetBrake.getPhase() + " : gearSetBrake = " + gearSetBrake);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(GearReleaseBrake gearReleaseBrake) {
        LogEngine.instance.write("+ Body.receive(" + gearReleaseBrake + ")");

        try {
            for (int i = 0; i < 3; i++) {
                Method gearReleaseBrakeMethod = gears.get(i).getClass().getDeclaredMethod("releaseBrake");

                LogEngine.instance.write("gearReleaseBrakeMethode = " + gearReleaseBrakeMethod);

                int newGearUp = (int) gearReleaseBrakeMethod.invoke(gears.get(i));
                LogEngine.instance.write(gearReleaseBrake.getPhase() + " : gearReleaseBrake = " + newGearUp);

                FlightRecorder.instance.insert(this.getClass().getSimpleName(), gearReleaseBrake.getPhase() + " : gearReleaseBrake = " + gearReleaseBrake);

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
            for (int hydraulicPumpCompressIndex = 0;hydraulicPumpCompressIndex < 6;hydraulicPumpCompressIndex++) {
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
            for (int hydraulicPumpDecompressIndex = 0;hydraulicPumpDecompressIndex < 6;hydraulicPumpDecompressIndex++) {
                Method hydraulicPumpDecompressMethod = hydraulicPumps.get(hydraulicPumpDecompressIndex).getClass().getDeclaredMethod("decompress");
                LogEngine.instance.write("hydraulicPumpDecompress = " + hydraulicPumpDecompressMethod);

                int    decompress = (int) hydraulicPumpDecompressMethod.invoke(hydraulicPumps.get(hydraulicPumpDecompressIndex));
                LogEngine.instance.write(hydraulicPumpDecompress.getPhase() + " : decompress = " + decompress);

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
            for (int hydraulicPumpRefilOilIndex = 0;hydraulicPumpRefilOilIndex < 6;hydraulicPumpRefilOilIndex++) {
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

                FlightRecorder.instance.insert(this.getClass().getSimpleName(),hydraulicPumpRefilOil.getPhase() + " : refilOil = " + refilOil);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void recieve(AirflowSensorAlarm airflowSensorAlarm) {
        LogEngine.instance.write("+ Body.receive(" + airflowSensorAlarm + ")");
        try {
            for (int i = 0; i < airflowSensors.size(); i++) {
                Method alarmMethod = airflowSensors.get(i).getClass().getDeclaredMethod("alarm", int.class);
                LogEngine.instance.write("airflowSensorAlarmMethod = " + alarmMethod);

                boolean alarmResult = (boolean) alarmMethod.invoke(airflowSensors.get(i), airflowSensorAlarm.getThreshhold());
                LogEngine.instance.write(airflowSensorAlarm.getPhase() + " : isAlarm" + alarmResult);
                PrimaryFlightDisplay.instance.isBodyAirflowSensorAlarm = alarmResult;
                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void recieve(AirflowSensorMeasure airflowSensorMeasure) {
        LogEngine.instance.write("+ Body.receive(" + airflowSensorMeasure + ")");
        try {
            for (int i = 0; i < airflowSensors.size(); i++) {
                Method measureMethod = airflowSensors.get(i).getClass().getDeclaredMethod("measure", String.class);
                LogEngine.instance.write("airflowSensorMeasureMethod = " + measureMethod);

                int measureResult = (int) measureMethod.invoke(airflowSensors.get(i), airflowSensorMeasure.getAirFlow());
                LogEngine.instance.write(airflowSensorMeasure.getPhase() + " : measure" + measureResult);
                PrimaryFlightDisplay.instance.bodyAirflowSensorAirPressure = measureResult;
                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void recieve(PitotTubeMeasureStaticPressure pitotTubeMeasureStaticPressure) {
        LogEngine.instance.write("+ Body.receive(" + pitotTubeMeasureStaticPressure + ")");
        try {
            for (int i = 0; i < pitotTubes.size(); i++) {
                Method measureStaticPressureMethod = pitotTubes.get(i).getClass().getDeclaredMethod("measureStaticPressure");
                LogEngine.instance.write("pitotTubeMeasureStaticPressureMethod = " + measureStaticPressureMethod);

                int measureResult = (int) measureStaticPressureMethod.invoke(pitotTubes.get(i));
                LogEngine.instance.write(pitotTubeMeasureStaticPressure.getPhase() + " : measureStaticPressure is " + measureResult);
                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void recieve(PitotTubeMeasureTotalPressure pitotTubeMeasureTotalPressure) {
        LogEngine.instance.write("+ Body.receive(" + pitotTubeMeasureTotalPressure + ")");
        try {
            for (int i = 0; i < pitotTubes.size(); i++) {
                Method measureTotalPressureMethod = pitotTubes.get(i).getClass().getDeclaredMethod("measureTotalPressure");
                LogEngine.instance.write("pitotTubeMeasureTotalPressureMethod = " + measureTotalPressureMethod);

                int measureResult = (int) measureTotalPressureMethod.invoke(pitotTubes.get(i));
                LogEngine.instance.write(pitotTubeMeasureTotalPressure.getPhase() + " : measureTotalPressure is " + measureResult);
                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void recieve(PitotTubeMeasureVelocity pitotTubeMeasureVelocity) {
        LogEngine.instance.write("+ Body.receive(" + pitotTubeMeasureVelocity + ")");
        try {
            for (int i = 0; i < pitotTubes.size(); i++) {
                Method pitotTubeMeasureVelocityMethod = pitotTubes.get(i).getClass().getDeclaredMethod("measureVelocity");
                LogEngine.instance.write("pitotTubeMeasureTotalPressureMethod = " + pitotTubeMeasureVelocityMethod);

                int measureResult = (int) pitotTubeMeasureVelocityMethod.invoke(pitotTubes.get(i));
                LogEngine.instance.write(pitotTubeMeasureVelocity.getPhase() + " : measureVelocity is " + measureResult);
                PrimaryFlightDisplay.instance.pitotTubeVelocity = measureResult;
                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void recieve(RadarAltimeterMeasureAltitude radarAltimeterMeasureAltitude) {
        LogEngine.instance.write("+ Body.receive(" + radarAltimeterMeasureAltitude + ")");
        try {
            for (int i = 0; i < radarAltimeters.size(); i++) {
                Method radarAltimeterMeasureAltitudeMethod = radarAltimeters.get(i).getClass().getDeclaredMethod("measureAltitude");
                LogEngine.instance.write("radarAltimeterMeasureAltitudeMethod = " + radarAltimeterMeasureAltitudeMethod);

                int measureResult = (int) radarAltimeterMeasureAltitudeMethod.invoke(radarAltimeters.get(i));
                LogEngine.instance.write(radarAltimeterMeasureAltitude.getPhase() + " : measureAltitude is " + measureResult);
                PrimaryFlightDisplay.instance.radarAltimeterAltitude = measureResult;
                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void recieve(RadarAltimeterOff radarAltimeterOff) {
        LogEngine.instance.write("+ Body.receive(" + radarAltimeterOff + ")");
        try {
            for (int i = 0; i < radarAltimeters.size(); i++) {
                Method radarAltimeterOffMethod = radarAltimeters.get(i).getClass().getDeclaredMethod("off");
                LogEngine.instance.write("radarAltimeterOffMethod = " + radarAltimeterOffMethod);

                boolean result = (boolean) radarAltimeterOffMethod.invoke(radarAltimeters.get(i));
                LogEngine.instance.write(radarAltimeterOff.getPhase() + " : off ->" + result);
                PrimaryFlightDisplay.instance.isRadarAltimeterOn = result;
                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void recieve(RadarAltimeterOn radarAltimeterOn) {
        LogEngine.instance.write("+ Body.receive(" + radarAltimeterOn + ")");
        try {
            for (int i = 0; i < radarAltimeters.size(); i++) {
                Method radarAltimeterOnMethod = radarAltimeters.get(i).getClass().getDeclaredMethod("on");
                LogEngine.instance.write("radarAltimeterOffMethod = " + radarAltimeterOnMethod);

                boolean result = (boolean) radarAltimeterOnMethod.invoke(radarAltimeters.get(i));
                LogEngine.instance.write(radarAltimeterOn.getPhase() + " : on ->" + result);

                PrimaryFlightDisplay.instance.isRadarAltimeterOn = result;

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void recieve(RadarAltimeterReceive radarAltimeterReceive) {
        LogEngine.instance.write("+ Body.receive(" + radarAltimeterReceive + ")");

        try {
            for (int momSensor = 0; momSensor < radarAltimeters.size(); momSensor++) {
                Method RadarAltimeterReceiveMethod = radarAltimeters.get(momSensor).getClass().getDeclaredMethod("receive", String.class);
                LogEngine.instance.write("RadarAltimeterReceive = " + RadarAltimeterReceiveMethod);

                int measuredValue = (int) RadarAltimeterReceiveMethod.invoke(radarAltimeters.get(momSensor), radarAltimeterReceive.getRadioWave());
                LogEngine.instance.write(radarAltimeterReceive.getPhase() + " : RadarAltimeterReceive = " + measuredValue);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void recieve(RadarAltimeterSend radarAltimeterSend) {
        LogEngine.instance.write("+ Body.receive(" + radarAltimeterSend + ")");

        try {
            for (int momSensor = 0; momSensor < radarAltimeters.size(); momSensor++) {
                Method RadarAltimeterSendMethod = radarAltimeters.get(momSensor).getClass().getDeclaredMethod("send", String.class);
                LogEngine.instance.write("RadarAltimeterSend = " + RadarAltimeterSendMethod);

                RadarAltimeterSendMethod.invoke(radarAltimeters.get(momSensor), radarAltimeterSend.getRadioWave());


                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void recieve(TCASAlarm tcasAlarm) {
        LogEngine.instance.write("+ Body.receive(" + tcasAlarm + ")");

        try {
            for (int momSensor = 0; momSensor < tCASs.size(); momSensor++) {
                Method TCASAlarmMethod = tCASs.get(momSensor).getClass().getDeclaredMethod("alarm");
                LogEngine.instance.write("TCASAlarm = " + TCASAlarmMethod);

                boolean measuredValue = (boolean) TCASAlarmMethod.invoke(tCASs.get(momSensor));
                LogEngine.instance.write(tcasAlarm.getPhase() + " : TCASAlarm = " + measuredValue);

                PrimaryFlightDisplay.instance.isTCASAlarm = measuredValue;

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void recieve(TCASConnect tcasConnect) {
        LogEngine.instance.write("+ Body.receive(" + tcasConnect + ")");

        try {
            for (int momSensor = 0; momSensor < tCASs.size(); momSensor++) {
                Method TCASConnectMethod = tCASs.get(momSensor).getClass().getDeclaredMethod("connect", String.class);
                LogEngine.instance.write("TCASConnect = " + TCASConnectMethod);

                boolean measuredValue = (boolean) TCASConnectMethod.invoke(tCASs.get(momSensor), tcasConnect.getFrequency());
                LogEngine.instance.write(tcasConnect.getPhase() + " : TCASConnect = " + measuredValue);

                PrimaryFlightDisplay.instance.isTCASConnected = measuredValue;

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void recieve(TCASDetermineAltitude tcasDetermineAltitude) {
        LogEngine.instance.write("+ Body.receive(" + tcasDetermineAltitude + ")");

        try {
            for (int momSensor = 0; momSensor < tCASs.size(); momSensor++) {
                Method TCASDetermineAltitudeMethod = tCASs.get(momSensor).getClass().getDeclaredMethod("determineAltitude", String.class);
                LogEngine.instance.write("TCASDetermineAltitude = " + TCASDetermineAltitudeMethod);

                int measuredValue = (int) TCASDetermineAltitudeMethod.invoke(tCASs.get(momSensor), tcasDetermineAltitude.getEnvironment());
                LogEngine.instance.write(tcasDetermineAltitude.getPhase() + " : TCASDetermineAltitude = " + measuredValue);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void recieve(TCASOff tcasOff) {
        LogEngine.instance.write("+ Body.receive(" + tcasOff + ")");

        try {
            for (int momSensor = 0; momSensor < tCASs.size(); momSensor++) {
                Method TCASOffMethod = tCASs.get(momSensor).getClass().getDeclaredMethod("off");
                LogEngine.instance.write("TCASOff = " + TCASOffMethod);

                boolean measuredValue = (boolean) TCASOffMethod.invoke(tCASs.get(momSensor));
                LogEngine.instance.write(tcasOff.getPhase() + " : TCASOff = " + measuredValue);

                PrimaryFlightDisplay.instance.isTCASOn = measuredValue;

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void recieve(TCASOn tcasOn) {
        LogEngine.instance.write("+ Body.receive(" + tcasOn + ")");

        try {
            for (int momSensor = 0; momSensor < tCASs.size(); momSensor++) {
                Method TCASOnMethod = tCASs.get(momSensor).getClass().getDeclaredMethod("on");
                LogEngine.instance.write("TCASOn = " + TCASOnMethod);

                boolean measuredValue = (boolean) TCASOnMethod.invoke(tCASs.get(momSensor));
                LogEngine.instance.write(tcasOn.getPhase() + " : TCASOn = " + measuredValue);

                PrimaryFlightDisplay.instance.isTCASOn = measuredValue;

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void recieve(TCASScann tcasScann) {
        LogEngine.instance.write("+ Body.receive(" + tcasScann + ")");

        try {
            for (int momSensor = 0; momSensor < tCASs.size(); momSensor++) {
                Method TCASScanMethod = tCASs.get(momSensor).getClass().getDeclaredMethod("scan", String.class);
                LogEngine.instance.write("TCASScan = " + TCASScanMethod);

                boolean measuredValue = (boolean) TCASScanMethod.invoke(tCASs.get(momSensor), tcasScann.getEnvironment());
                LogEngine.instance.write(tcasScann.getPhase() + " : TCASScan = " + measuredValue);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void recieve(TCASSetAltitude tcasSetAltitude) {
        LogEngine.instance.write("+ Body.receive(" + tcasSetAltitude + ")");

        try {
            for (int momSensor = 0; momSensor < tCASs.size(); momSensor++) {
                Method TCASSetAltitudeMethod = tCASs.get(momSensor).getClass().getDeclaredMethod("setAltitude", int.class);
                LogEngine.instance.write("TCASSetAltitude = " + TCASSetAltitudeMethod);

                int measuredValue = (int) TCASSetAltitudeMethod.invoke(tCASs.get(momSensor), tcasSetAltitude.getValue());
                LogEngine.instance.write(tcasSetAltitude.getPhase() + " : TCASSetAltitude = " + measuredValue);

                PrimaryFlightDisplay.instance.zCASAltitude = measuredValue;

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void recieve(TurbulentAirFlowSensorAlarm turbulentAirFlowSensorAlarm) {
        LogEngine.instance.write("+ Body.receive(" + turbulentAirFlowSensorAlarm + ")");

        try {
            for (int momSensor = 0; momSensor < turbulentAirFlowSensors.size(); momSensor++) {
                Method turbulentAirFlowSensorAlarmMethod = turbulentAirFlowSensors.get(momSensor).getClass().getDeclaredMethod("alarm");
                LogEngine.instance.write("turbulentAirFlowSensorMeasureMethod = " + turbulentAirFlowSensorAlarmMethod);

                boolean measuredValue = (boolean) turbulentAirFlowSensorAlarmMethod.invoke(turbulentAirFlowSensors.get(momSensor));
                LogEngine.instance.write(turbulentAirFlowSensorAlarm.getPhase() + " : turbulentAirFlowSensorAlarm = " + measuredValue);

                PrimaryFlightDisplay.instance.isBodyTurbulentAirFlowSensorAlarm = measuredValue;

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void recieve(TurbulentAirFlowSensorMeasure turbulentAirFlowSensorMeasure) {
        LogEngine.instance.write("+ Body.receive(" + turbulentAirFlowSensorMeasure + ")");

        try {
            for (int momSensor = 0; momSensor < turbulentAirFlowSensors.size(); momSensor++) {
                Method turbulentAirFlowSensorMeasureMethod = turbulentAirFlowSensors.get(momSensor).getClass().getDeclaredMethod("measure", String.class);
                LogEngine.instance.write("turbulentAirFlowSensorMeasureMethod = " + turbulentAirFlowSensorMeasureMethod);

                int measuredValue = (int) turbulentAirFlowSensorMeasureMethod.invoke(turbulentAirFlowSensors.get(momSensor), turbulentAirFlowSensorMeasure.getAirFlow());
                LogEngine.instance.write(turbulentAirFlowSensorMeasure.getPhase() + " : turbulentAirFlowSensorMeasure = " + measuredValue);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}