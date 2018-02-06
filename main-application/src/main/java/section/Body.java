package section;

import base.PrimaryFlightDisplay;
import com.google.common.eventbus.Subscribe;
import event.Subscriber;
import event.apu.APUDecreaseRPM;
import event.apu.APUIncreaseRPM;
import event.apu.APUShutdown;
import event.apu.APUStart;
import event.apuoiltank.APUOilTankDecreaseLevel;
import event.apuoiltank.APUOilTankIncreaseLevel;
import event.battery.BatteryCharge;
import event.battery.BatteryDischarge;
import event.camera.CameraOff;
import event.camera.CameraOn;
import event.camera.CameraZoomIn;
import event.deicingsystem.DeIcingSystemActivate;
import event.deicingsystem.DeIcingSystemDeIce;
import event.deicingsystem.DeIcingSystemDeactivate;
import event.deicingsystem.DeIcingSystemRefill;
import event.fireextinguisher.FireExtinguisherApply;
import event.fireextinguisher.FireExtinguisherRefill;
import event.gear.*;
import event.gps.GPSOff;
import event.gps.GPSOn;
import event.hydraulicPump.HydraulicPumpCompress;
import event.hydraulicPump.HydraulicPumpDecompress;
import event.hydraulicPump.HydraulicPumpRefilOil;
import event.nitrogenbottle.NitrogenBottleRefill;
import event.nitrogenbottle.NitrogenBottleTakeOut;
import event.oxygenbottle.OxygenBottleRefill;
import event.oxygenbottle.OxygenBottleTakeOut;
import event.potablewatertank.PotableWaterTankLock;
import event.potablewatertank.PotableWaterTankRefill;
import event.potablewatertank.PotableWaterTankTakeOut;
import event.potablewatertank.PotableWaterTankUnlock;
import event.radar.RadarOff;
import event.radar.RadarOn;
import event.radar.RadarScan;
import event.satcom.SatComOff;
import event.satcom.SatComOn;
import event.sensors.airflowSensor.AirflowSensorAlarm;
import event.sensors.airflowSensor.AirflowSensorMeasure;
import event.sensors.pitotTube.PitotTubeMeasureStaticPressure;
import event.sensors.pitotTube.PitotTubeMeasureTotalPressure;
import event.sensors.pitotTube.PitotTubeMeasureVelocity;
import event.sensors.radarAltimeter.*;
import event.sensors.tCAS.*;
import event.sensors.turbulentAirFlowSensor.TurbulentAirFlowSensorAlarm;
import event.sensors.turbulentAirFlowSensor.TurbulentAirFlowSensorMeasure;
import event.vhf.VHFOff;
import event.vhf.VHFOn;
import event.wastewatertank.WasteWaterLock;
import event.wastewatertank.WasteWaterTankAdd;
import event.wastewatertank.WasteWaterTankPumpOut;
import event.wastewatertank.WasteWaterUnlock;
import factory.*;
import logging.LogEngine;
import recorder.FlightRecorder;

import java.lang.reflect.Method;
import java.util.ArrayList;

// imports for sensor04


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
    private ArrayList<Object> cameraPorts;
    private ArrayList<Object> gpsPorts;
    private ArrayList<Object> radarPorts;
    private ArrayList<Object> satComPorts;
    private ArrayList<Object> vhfPorts;
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
        FlightRecorder.instance.startup();
    }

    public void build() {
        // Flight Controls01
        elevators = new ArrayList<>();
        for (int i = 0; i < 4; i++) elevators.add(ElevatorFactory.build());
        // Factory magic 4 (full = +/- 45 degrees, left -; right +)

        // Flight Controls02
        rudders = new ArrayList<>();
        for (int i = 0; i < 2; i++) rudders.add(RudderFactory.build("", "", ""));

        // apu_engine_gear_pump
        apus = new ArrayList<>();
        for (int i = 0; i < 1; i++) apus.add(APUFactory.build());
        gears = new ArrayList<>();
        for (int i = 0; i < 3; i++) gears.add(GearFactory.build());
        hydraulicPumps = new ArrayList<>();
        for (int i = 0; i < 6; i++) hydraulicPumps.add(HydraulicPumpFactory.build());

        // doors

        // TODO: Add a lot of doors

        bulkCargoDoors = new ArrayList<>();
        // Factory magic 2

        crewDoors = new ArrayList<>();
        //for (int i = 0; i < 2; i++)
        // Factory magic 2

        emergencyExitDoors = new ArrayList<>();
        //for (int i = 0; i < 2; i++)
        // Factory magic 14

        gearDoors = new ArrayList<>();
        //for (int i = 0; i < 2; i++)
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
        // TODO: Add a LOTTTTT of seats
        firstClassSeats = new ArrayList<>();
        //for (int i = 0; i < 16; i++) firstClassSeats.add(SeatFactory.buildFirstSeat());
        businessClassSeats = new ArrayList<>();
        //for (int i = 0; i < 72; i++) businessClassSeats.add(SeatFactory.buildBusinessSeat());
        touristClassSeats = new ArrayList<>();
        //for (int i = 0; i < 480; i++) touristClassSeats.add(SeatFactory.buildTouristSeat());
        crewSeats = new ArrayList<>();
        //for (int i = 0; i < 14; i++) crewSeats.add(SeatFactory.buildCrewSeat());

        // sensor01
        iceDetectorProbes = new ArrayList<>();
        iceDetectorProbes.add(IceDetectorProbeFactory.build());
        iceDetectorProbes.add(IceDetectorProbeFactory.build());
        // Factory magic 2

        // sensor02

        fireDetectors = new ArrayList<>();
        for(int i = 0; i < 14; ++i)
            fireDetectors.add(FireDetectorFactory.build());
        oxygenSensors = new ArrayList<>();
        for(int i = 0; i < 8; ++i)
            oxygenSensors.add(OxygenBottleFactory.build());
        shockSensors = new ArrayList<>();
        for(int i = 0; i < 2; ++i)
            shockSensors.add(ShockSensorFactory.build());
        stallingSensors = new ArrayList<>();
        for(int i = 0; i < 2; ++i)
            stallingSensors.add(StallingSensorFactory.build());
        temperatureSensors = new ArrayList<>();
        for(int i = 0; i < 2; ++i)
            temperatureSensors.add(TemperatureSensorFactory.build());

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
        // Factory magic 2
        cameraPorts = new ArrayList<>();
        for (int cameraIndex = 0; cameraIndex < 2; cameraIndex++)
            cameraPorts.add(CameraFactory.build());
        // Factory magic 2
        gpsPorts = new ArrayList<>();
        for (int gpsIndex = 0; gpsIndex < 2; gpsIndex++)
            gpsPorts.add(GPSFactory.build());
        // Factory magic 2
        radarPorts = new ArrayList<>();
        for (int radarIndex = 0; radarIndex < 2; radarIndex++)
            radarPorts.add(RadarFactory.build());
        // Factory magic 2
        satComPorts = new ArrayList<>();
        for (int satComIndex = 0; satComIndex < 2; satComIndex++)
            satComPorts.add(SatComFactory.build());
        // Factory magic 2
        vhfPorts = new ArrayList<>();
        for (int vhfIndex = 0; vhfIndex < 2; vhfIndex++)
            vhfPorts.add(VHFFactory.build());

        // light
        antiCollisionLights = new ArrayList<>();
        for (int i = 0; i < 2; i++) antiCollisionLights.add(AntiCollisionLightFactory.build());
        cargoCompartmentLights = new ArrayList<>();
        for (int i = 0; i < 4; i++) cargoCompartmentLights.add(CargoCompartmentLightFactory.build());
        landingLights = new ArrayList<>();
        for (int i = 0; i < 2; i++) landingLights.add(LandingLightFactory.build());
        logoLights = new ArrayList<>();
        for (int i = 0; i < 2; i++) logoLights.add(LogoLightFactory.build());
        tailNavigationLights = new ArrayList<>();
        for (int i = 0; i < 2; i++) tailNavigationLights.add(TailNavigationLightFactory.build());
        taxiLights = new ArrayList<>();
        for (int i = 0; i < 2; i++) taxiLights.add(TaxiLightFactory.build());
        tCASLights = new ArrayList<>();
        for (int i = 0; i < 2; i++) tCASLights.add(TCASLightFactory.build());

        // stowage_cargo
        // TODO: Add some of these too

        cargoSystems = new ArrayList<>();
        // Factory magic 2
        stowageNumberFives = new ArrayList<>();
        // Factory magic 1

        // cabin
        airConditionings = new ArrayList<>();
        for (int i = 0; i < 4; i++) airConditionings.add(AirConditioningFactory.build());
        kitchens = new ArrayList<>();
        kitchens.add(KitchenFactory.build("FIRST"));
        kitchens.add(KitchenFactory.build("BUSINESS"));
        kitchens.add(KitchenFactory.build("ECONOMY"));
        kitchens.add(KitchenFactory.build("ECONOMY"));
        lavatories = new ArrayList<>();
        for (int i = 0; i < 8; i++) lavatories.add(LavatoryFactory.build());
        wasteSystems = new ArrayList<>();
        for (int i = 0; i < 10; i++) wasteSystems.add(WasteSystemFactory.build());
        waterSystems = new ArrayList<>();
        for (int i = 0; i < 4; i++) waterSystems.add(WaterSystemFactory.build());
        escapeSlides = new ArrayList<>();
        for (int i = 0; i < 14; i++) escapeSlides.add(EscapeSlideFactory.build());

        // management
        // TODO: Add management stuff
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

    public ArrayList<Object> getAPUs() {
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

    public ArrayList<Object> getAPUOilTanks() {
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
        return cameraPorts;
    }

    public ArrayList<Object> getgPSs() {
        return gpsPorts;
    }

    public ArrayList<Object> getRadars() {
        return radarPorts;
    }

    public ArrayList<Object> getSatComs() {
        return satComPorts;
    }

    public ArrayList<Object> getvHFs() {
        return vhfPorts;
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

    // please add here

    @Subscribe
    public void receive(CameraOn cameraOn) {
        LogEngine.instance.write("+ Body.receive(" + cameraOn + ")");

        try {
            for (int cameraIndex = 0; cameraIndex < 2; cameraIndex++) {
                Method cameraOnMethod = cameraPorts.get(cameraIndex).getClass().getDeclaredMethod("on");
                LogEngine.instance.write("cameraOnMethod = " + cameraOnMethod + "");

                boolean isCameraOn = (boolean) cameraOnMethod.invoke(cameraPorts.get(cameraIndex));

                LogEngine.instance.write(cameraOn.getPhase() + " : isCameraOn = " + isCameraOn + "");

                PrimaryFlightDisplay.instance.isCameraOn = isCameraOn;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(), cameraOn.getPhase() + " : camera (isOn) = " + isCameraOn);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(CameraOff cameraOff) {
        LogEngine.instance.write("+ Body.receive(" + cameraOff + ")");

        try {
            for (int cameraIndex = 0; cameraIndex < 2; cameraIndex++) {
                Method cameraOffMethod = cameraPorts.get(cameraIndex).getClass().getDeclaredMethod("off");
                LogEngine.instance.write("cameraOnMethod = " + cameraOffMethod + "");

                boolean isCameraOff = (boolean) cameraOffMethod.invoke(cameraPorts.get(cameraIndex));

                LogEngine.instance.write(cameraOff.getPhase() + " : isCameraOn = " + isCameraOff + "");

                PrimaryFlightDisplay.instance.isCameraOn = isCameraOff;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(), cameraOff.getPhase() + " : camera (isOff) = " + isCameraOff);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(CameraZoomIn cameraZoomIn) {
        LogEngine.instance.write("+ Body.receive(" + cameraZoomIn + ")");

        try {
            for (int cameraIndex = 0; cameraIndex < 2; cameraIndex++) {
                Method cameraZoomInMethod = cameraPorts.get(cameraIndex).getClass().getDeclaredMethod("zoomIn", boolean.class);
                LogEngine.instance.write("cameraZoomInMethod = " + cameraZoomInMethod + "");

                double cameraFactor = (double) cameraZoomInMethod.invoke(cameraPorts.get(cameraIndex), new Object[]{true});

                LogEngine.instance.write(cameraZoomIn.getPhase() + " : cameraFactor = " + cameraFactor + "");

                PrimaryFlightDisplay.instance.cameraFactor = cameraFactor;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(), cameraZoomIn.getPhase() + " : camera (Factor) = " + cameraFactor);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(RadarOn radarOn) {
        LogEngine.instance.write("+ Body.receive(" + radarOn + ")");

        try {
            for (int radarIndex = 0; radarIndex < 2; radarIndex++) {
                Method radarOnMethod = radarPorts.get(radarIndex).getClass().getDeclaredMethod("on");
                LogEngine.instance.write("radarOnMethod = " + radarOnMethod + "");

                boolean isRadarOn = (boolean) radarOnMethod.invoke(radarPorts.get(radarIndex));

                LogEngine.instance.write(radarOn.getPhase() + " : isRadarOn = " + isRadarOn + "");

                PrimaryFlightDisplay.instance.isRadarOn = isRadarOn;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(), radarOn.getPhase() + " : Radar (isOn) = " + isRadarOn);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(RadarOff radarOff) {
        LogEngine.instance.write("+ Body.receive(" + radarOff + ")");

        try {
            for (int radarIndex = 0; radarIndex < 2; radarIndex++) {
                Method radarOffMethod = radarPorts.get(radarIndex).getClass().getDeclaredMethod("off");
                LogEngine.instance.write("radarOffMethod = " + radarOffMethod + "");

                boolean isRadarOff = (boolean) radarOffMethod.invoke(radarPorts.get(radarIndex));

                LogEngine.instance.write(radarOff.getPhase() + " : isRadarOff = " + isRadarOff + "");

                PrimaryFlightDisplay.instance.isRadarOn = isRadarOff;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(), radarOff.getPhase() + " : Radar (isOn) = " + isRadarOff);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(RadarScan radarScan) {
        LogEngine.instance.write("+ Body.receive(" + radarScan + ")");

        try {
            for (int radarIndex = 0; radarIndex < 2; radarIndex++) {
                Method radarScanMethod = radarPorts.get(radarIndex).getClass().getDeclaredMethod("scan", String.class);
                LogEngine.instance.write("radarScanMethod = " + radarScanMethod + "");

                boolean scanResult = (boolean) radarScanMethod.invoke(radarPorts.get(radarIndex), new Object[]{radarScan.getEnvironment()});

                LogEngine.instance.write(radarScan.getPhase() + " : scanResult = " + scanResult + "");

                PrimaryFlightDisplay.instance.isAirspaceFree = scanResult;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(), radarScan.getPhase() + " : Radar (scan) = " + scanResult);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(GPSOn isGpsOn) {
        LogEngine.instance.write("+ Body.receive(" + isGpsOn + ")");

        try {
            for (int gpsOnIndex = 0; gpsOnIndex < 2; gpsOnIndex++) {
                Method gpsOnMethod = gpsPorts.get(gpsOnIndex).getClass().getDeclaredMethod("on");
                LogEngine.instance.write("radarScanMethod = " + gpsOnMethod + "");

                boolean isGPSOn = (boolean) gpsOnMethod.invoke(gpsPorts.get(gpsOnIndex));

                LogEngine.instance.write(isGpsOn.getPhase() + " : isGPSOn = " + isGPSOn + "");

                PrimaryFlightDisplay.instance.isGPSOn = isGPSOn;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(), isGpsOn.getPhase() + " : GPS (isOn) = " + isGPSOn);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(GPSOff isGpsOff) {
        LogEngine.instance.write("+ Body.receive(" + isGpsOff + ")");

        try {
            for (int gpsOffIndex = 0; gpsOffIndex < 2; gpsOffIndex++) {
                Method gpsOffMethod = gpsPorts.get(gpsOffIndex).getClass().getDeclaredMethod("off");
                LogEngine.instance.write("radarScanMethod = " + gpsOffMethod + "");

                boolean isGPSOff = (boolean) gpsOffMethod.invoke(gpsPorts.get(gpsOffIndex));

                LogEngine.instance.write(isGpsOff.getPhase() + " : isGPSOff = " + isGPSOff + "");

                PrimaryFlightDisplay.instance.isGPSOn = isGPSOff;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(), isGpsOff.getPhase() + " : GPS (isOff) = " + isGPSOff);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(SatComOn isSatComOn) {
        LogEngine.instance.write("+ Body.receive(" + isSatComOn + ")");

        try {
            for (int satComIndex = 0; satComIndex < 2; satComIndex++) {
                Method satComOnMethod = satComPorts.get(satComIndex).getClass().getDeclaredMethod("on");
                LogEngine.instance.write("radarScanMethod = " + satComOnMethod + "");

                boolean isSatComConnected = (boolean) satComOnMethod.invoke(satComPorts.get(satComIndex));

                LogEngine.instance.write(isSatComOn.getPhase() + " : isSatComConnected = " + isSatComConnected + "");

                PrimaryFlightDisplay.instance.isSatComConnected = isSatComConnected;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(), isSatComOn.getPhase() + " : SatCom (isConnected) = " + isSatComConnected);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(SatComOff isSatComOff) {
        LogEngine.instance.write("+ Body.receive(" + isSatComOff + ")");

        try {
            for (int satComIndex = 0; satComIndex < 2; satComIndex++) {
                Method satComOffMethod = satComPorts.get(satComIndex).getClass().getDeclaredMethod("off");
                LogEngine.instance.write("radarScanMethod = " + satComOffMethod + "");

                boolean isSatComConnected = (boolean) satComOffMethod.invoke(satComPorts.get(satComIndex));

                LogEngine.instance.write(isSatComOff.getPhase() + " : isSatComConnected = " + isSatComConnected + "");

                PrimaryFlightDisplay.instance.isSatComConnected = isSatComConnected;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(), isSatComOff.getPhase() + " : SatCom (isConnected) = " + isSatComConnected);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(VHFOn isVHFOn) {
        LogEngine.instance.write("+ Body.receive(" + isVHFOn + ")");

        try {
            for (int vhfOnIndex = 0; vhfOnIndex < 2; vhfOnIndex++) {
                Method vhfOnMethod = vhfPorts.get(vhfOnIndex).getClass().getDeclaredMethod("on");
                LogEngine.instance.write("vhfOnMethod = " + vhfOnMethod + "");

                boolean isVhfOn = (boolean) vhfOnMethod.invoke(vhfPorts.get(vhfOnIndex));

                LogEngine.instance.write(isVHFOn.getPhase() + " : isVHFOn = " + isVhfOn + "");

                PrimaryFlightDisplay.instance.isVHFOn = isVhfOn;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(), isVHFOn.getPhase() + " : VHFOn (isOn) = " + isVhfOn);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(VHFOff isVHFOn) {
        LogEngine.instance.write("+ Body.receive(" + isVHFOn + ")");

        try {
            for (int vhfOffIndex = 0; vhfOffIndex < 2; vhfOffIndex++) {
                Method vhfOffMethod = vhfPorts.get(vhfOffIndex).getClass().getDeclaredMethod("off");
                LogEngine.instance.write("vhfOnMethod = " + vhfOffMethod + "");

                boolean isVhfOn = (boolean) vhfOffMethod.invoke(vhfPorts.get(vhfOffIndex));

                LogEngine.instance.write(isVHFOn.getPhase() + " : isVhfOff = " + isVhfOn + "");

                PrimaryFlightDisplay.instance.isVHFOn = isVhfOn;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(), isVHFOn.getPhase() + " : VHFOff (isOn) = " + isVhfOn);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            e.printStackTrace();
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
                if (gearSetBrake.getPercent() == 0) {
                    gearSetBrakeMethod = gears.get(i).getClass().getDeclaredMethod("setBrake");
                    LogEngine.instance.write("gearSetBrakeMethode = " + gearSetBrakeMethod);
                    newGearUp = (int) gearSetBrakeMethod.invoke(gears.get(i));
                } else {
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
    public void receive(HydraulicPumpCompress hydraulicPumpCompress) {
        LogEngine.instance.write("+ Body.receive(" + hydraulicPumpCompress + ")");

        try {
            for (int hydraulicPumpCompressIndex = 0; hydraulicPumpCompressIndex < 6; hydraulicPumpCompressIndex++) {
                Method hydraulicPumpCompressMethod = null;
                int compress = 0;
                if (hydraulicPumpCompress.getAmount() == 0) {
                    hydraulicPumpCompressMethod = hydraulicPumps.get(hydraulicPumpCompressIndex).getClass().getDeclaredMethod("compress");
                    LogEngine.instance.write("hydraulicPumpCompress = " + hydraulicPumpCompressMethod);
                    compress = (int) hydraulicPumpCompressMethod.invoke(hydraulicPumps.get(hydraulicPumpCompressIndex));
                } else {
                    hydraulicPumpCompressMethod = hydraulicPumps.get(hydraulicPumpCompressIndex).getClass().getDeclaredMethod("compress", int.class);
                    LogEngine.instance.write("hydraulicPumpCompress = " + hydraulicPumpCompressMethod);
                    compress = (int) hydraulicPumpCompressMethod.invoke(hydraulicPumps.get(hydraulicPumpCompressIndex), hydraulicPumpCompress.getAmount());
                }
                LogEngine.instance.write(hydraulicPumpCompress.getPhase() + " : compress = " + compress);

                FlightRecorder.instance.insert(this.getClass().getSimpleName(), hydraulicPumpCompress.getPhase() + " : compress = " + compress);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(HydraulicPumpDecompress hydraulicPumpDecompress) {
        LogEngine.instance.write("+ Body.receive(" + hydraulicPumpDecompress + ")");

        try {
            for (int hydraulicPumpDecompressIndex = 0; hydraulicPumpDecompressIndex < 6; hydraulicPumpDecompressIndex++) {
                Method hydraulicPumpDecompressMethod = hydraulicPumps.get(hydraulicPumpDecompressIndex).getClass().getDeclaredMethod("decompress");
                LogEngine.instance.write("hydraulicPumpDecompress = " + hydraulicPumpDecompressMethod);

                int decompress = (int) hydraulicPumpDecompressMethod.invoke(hydraulicPumps.get(hydraulicPumpDecompressIndex));
                LogEngine.instance.write(hydraulicPumpDecompress.getPhase() + " : decompress = " + decompress);

                FlightRecorder.instance.insert(this.getClass().getSimpleName(), hydraulicPumpDecompress.getPhase() + " : decompress = " + decompress);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(HydraulicPumpRefilOil hydraulicPumpRefilOil) {
        LogEngine.instance.write("+ Body.receive(" + hydraulicPumpRefilOil + ")");

        try {
            for (int hydraulicPumpRefilOilIndex = 0; hydraulicPumpRefilOilIndex < 6; hydraulicPumpRefilOilIndex++) {
                Method hydraulicPumpRefilOilMethod = null;
                int refilOil = 0;
                if (hydraulicPumpRefilOil.getAmount() == 0) {
                    hydraulicPumpRefilOilMethod = hydraulicPumps.get(hydraulicPumpRefilOilIndex).getClass().getDeclaredMethod("refilOil");
                    LogEngine.instance.write("hydraulicPumpRefilOil = " + hydraulicPumpRefilOilMethod);
                    refilOil = (int) hydraulicPumpRefilOilMethod.invoke(hydraulicPumps.get(hydraulicPumpRefilOilIndex));
                } else {
                    hydraulicPumpRefilOilMethod = hydraulicPumps.get(hydraulicPumpRefilOilIndex).getClass().getDeclaredMethod("refilOil", int.class);
                    LogEngine.instance.write("hydraulicPumpRefilOil = " + hydraulicPumpRefilOilMethod);
                    refilOil = (int) hydraulicPumpRefilOilMethod.invoke(hydraulicPumps.get(hydraulicPumpRefilOilIndex), hydraulicPumpRefilOil.getAmount());
                }
                LogEngine.instance.write(hydraulicPumpRefilOil.getPhase() + " : refilOil = " + refilOil);

                FlightRecorder.instance.insert(this.getClass().getSimpleName(), hydraulicPumpRefilOil.getPhase() + " : refilOil = " + refilOil);

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


    //// TANK BOTTLES
    // WasteWaterTank
    @Subscribe
    public void receive(WasteWaterTankAdd wasteWaterTankAdd) {
        LogEngine.instance.write("+ Body.receive(" + wasteWaterTankAdd + ")");

        try {

            for (int i = 0; i < wasteWaterTanks.size(); i++) {
                Method wasteWaterTankAddMethod = wasteWaterTanks.get(i).getClass().getDeclaredMethod("add", int.class);
                LogEngine.instance.write("wasteWaterTankAddMethod = " + wasteWaterTankAddMethod);

                int value = (int) wasteWaterTankAddMethod.invoke(wasteWaterTanks.get(i), wasteWaterTankAdd.getFillValue());
                LogEngine.instance.write(wasteWaterTankAdd.getPhase() + " : wasteWaterTankAdd = " + value);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(WasteWaterTankPumpOut wasteWaterTankPumpOut) {
        LogEngine.instance.write("+ Body.receive(" + wasteWaterTankPumpOut + ")");

        try {

            for (int i = 0; i < wasteWaterTanks.size(); i++) {
                Method wasteWaterTankPumpOutMethod = wasteWaterTanks.get(i).getClass().getDeclaredMethod("pumpOut");
                LogEngine.instance.write("wasteWaterTankPumpOut = " + wasteWaterTankPumpOutMethod);

                int value = (int) wasteWaterTankPumpOutMethod.invoke(wasteWaterTanks.get(i));
                LogEngine.instance.write(wasteWaterTankPumpOut.getPhase() + " : wasteWaterTankPumpOut = " + value);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(WasteWaterLock wasteWaterLock) {
        LogEngine.instance.write("+ Body.receive(" + wasteWaterLock + ")");

        try {

            for (int i = 0; i < wasteWaterTanks.size(); i++) {
                Method wasteWaterLockMethod = wasteWaterTanks.get(i).getClass().getDeclaredMethod("lock");
                LogEngine.instance.write("wasteWaterLock = " + wasteWaterLockMethod);

                boolean value = (boolean) wasteWaterLockMethod.invoke(wasteWaterTanks.get(i));
                LogEngine.instance.write(wasteWaterLock.getPhase() + " : wasteWaterLock = " + value);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(WasteWaterUnlock wasteWaterUnlock) {
        LogEngine.instance.write("+ Body.receive(" + wasteWaterUnlock + ")");

        try {

            for (int i = 0; i < wasteWaterTanks.size(); i++) {
                Method wasteWaterUnlockMethod = wasteWaterTanks.get(i).getClass().getDeclaredMethod("unlock");
                LogEngine.instance.write("wasteWaterUnlock = " + wasteWaterUnlock);

                boolean value = (boolean) wasteWaterUnlockMethod.invoke(wasteWaterTanks.get(i));
                LogEngine.instance.write(wasteWaterUnlock.getPhase() + " : wasteWaterUnlock = " + value);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // PotableWaterTank
    @Subscribe
    public void receive(PotableWaterTankRefill potableWaterTankRefill) {
        LogEngine.instance.write("+ Body.receive(" + potableWaterTankRefill + ")");

        try {

            for (int i = 0; i < potableWaterTanks.size(); i++) {
                Method potableWaterTankRefillMethod = potableWaterTanks.get(i).getClass().getDeclaredMethod("refill", int.class);
                LogEngine.instance.write("potableWaterTankRefillMethod = " + potableWaterTankRefillMethod);

                int value = (int) potableWaterTankRefillMethod.invoke(potableWaterTanks.get(i), potableWaterTankRefill.getFillValue());
                LogEngine.instance.write(potableWaterTankRefill.getPhase() + " : potableWaterTankRefill = " + value);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(PotableWaterTankTakeOut potableWaterTankTakeOut) {
        LogEngine.instance.write("+ Body.receive(" + potableWaterTankTakeOut + ")");

        try {

            for (int i = 0; i < potableWaterTanks.size(); i++) {
                Method potableWaterTankTakeOutMethod = potableWaterTanks.get(i).getClass().getDeclaredMethod("takeOut", int.class);
                LogEngine.instance.write("potableWaterTankTakeOut = " + potableWaterTankTakeOutMethod);

                int value = (int) potableWaterTankTakeOutMethod.invoke(potableWaterTanks.get(i), potableWaterTankTakeOut.getFillValue());
                LogEngine.instance.write(potableWaterTankTakeOut.getPhase() + " : potableWaterTankTakeOut = " + value);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(PotableWaterTankLock potableWaterTankLock) {
        LogEngine.instance.write("+ Body.receive(" + potableWaterTankLock + ")");

        try {

            for (int i = 0; i < potableWaterTanks.size(); i++) {
                Method potableWaterTankLockMethode = potableWaterTanks.get(i).getClass().getDeclaredMethod("lock");
                LogEngine.instance.write("potableWaterTankLockMethode = " + potableWaterTankLockMethode);

                boolean value = (boolean) potableWaterTankLockMethode.invoke(potableWaterTanks.get(i));
                LogEngine.instance.write(potableWaterTankLock.getPhase() + " : potableWaterTankLock = " + value);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(PotableWaterTankUnlock potableWaterTankUnlock) {
        LogEngine.instance.write("+ Body.receive(" + potableWaterTankUnlock + ")");

        try {

            for (int i = 0; i < potableWaterTanks.size(); i++) {
                Method potableWaterTankUnlockMethod = potableWaterTanks.get(i).getClass().getDeclaredMethod("unlock");
                LogEngine.instance.write("potableWaterTankUnlockMethod = " + potableWaterTankUnlockMethod);

                boolean value = (boolean) potableWaterTankUnlockMethod.invoke(potableWaterTanks.get(i));
                LogEngine.instance.write(potableWaterTankUnlock.getPhase() + " : wasteWaterUnlock = " + value);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Oxygen Bottle
    @Subscribe
    public void receive(OxygenBottleRefill oxygenBottleRefill) {
        LogEngine.instance.write("+ Body.receive(" + oxygenBottleRefill + ")");
        try {

            for (int i = 0; i < oxygenBottles.size(); i++) {
                Method oxygenBottleRefillMethod = oxygenBottles.get(i).getClass().getDeclaredMethod("refill", int.class);
                LogEngine.instance.write("oxygenBottleRefillMethod = " + oxygenBottleRefillMethod);

                int value = (int) oxygenBottleRefillMethod.invoke(oxygenBottles.get(i), oxygenBottleRefill.getFillValue());
                LogEngine.instance.write(oxygenBottleRefill.getPhase() + " : oxygenBottleRefill = " + value);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(OxygenBottleTakeOut oxygenBottleTakeOut) {
        LogEngine.instance.write("+ Body.receive(" + oxygenBottleTakeOut + ")");
        try {

            for (int i = 0; i < oxygenBottles.size(); i++) {
                Method oxygenBottleTakeOutMethod = oxygenBottles.get(i).getClass().getDeclaredMethod("takeOut", int.class);
                LogEngine.instance.write("oxygenBottleTakeOutMethod = " + oxygenBottleTakeOutMethod);

                int value = (int) oxygenBottleTakeOutMethod.invoke(oxygenBottles.get(i), oxygenBottleTakeOut.getFillValue());
                LogEngine.instance.write(oxygenBottleTakeOut.getPhase() + " : oxygenBottleTakeOut = " + value);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Nitrogen Bottle
    @Subscribe
    public void receive(NitrogenBottleRefill nitrogenBottleRefill) {
        LogEngine.instance.write("+ Body.receive(" + nitrogenBottleRefill + ")");
        try {

            for (int i = 0; i < nitrogenBottles.size(); i++) {
                Method nitrogenBottleRefillMethod = nitrogenBottles.get(i).getClass().getDeclaredMethod("refill", int.class);
                LogEngine.instance.write("nitrogenBottleRefillMethod = " + nitrogenBottleRefillMethod);

                int value = (int) nitrogenBottleRefillMethod.invoke(nitrogenBottles.get(i), nitrogenBottleRefill.getFillValue());
                LogEngine.instance.write(nitrogenBottleRefill.getPhase() + " : oxygenBottleRefill = " + value);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(NitrogenBottleTakeOut nitrogenBottleTakeOut) {
        LogEngine.instance.write("+ Body.receive(" + nitrogenBottleTakeOut + ")");
        try {

            for (int i = 0; i < nitrogenBottles.size(); i++) {
                Method nitrogenBottleTakeOutMethod = nitrogenBottles.get(i).getClass().getDeclaredMethod("takeOut", int.class);
                LogEngine.instance.write("nitrogenBottleTakeOutMethod = " + nitrogenBottleTakeOutMethod);

                int value = (int) nitrogenBottleTakeOutMethod.invoke(nitrogenBottles.get(i), nitrogenBottleTakeOut.getFillValue());
                LogEngine.instance.write(nitrogenBottleTakeOut.getPhase() + " : nitrogenBottleTakeOut = " + value);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(APUOilTankDecreaseLevel apuOilTankDecreaseLevel) {
        LogEngine.instance.write("+ Body.receive(" + apuOilTankDecreaseLevel + ")");
        try {

            for (int i = 0; i < aPUOilTanks.size(); i++) {
                Method apuOilTankDecreaseLevelMethod = aPUOilTanks.get(i).getClass().getDeclaredMethod("decreaseLevel", int.class);
                LogEngine.instance.write("apuOilTankDecreaseLevelMethod = " + apuOilTankDecreaseLevelMethod);

                int value = (int) apuOilTankDecreaseLevelMethod.invoke(aPUOilTanks.get(i), apuOilTankDecreaseLevel.getFillValue());
                LogEngine.instance.write(apuOilTankDecreaseLevel.getPhase() + " : apuOilTankDecreaseLevel = " + value);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(APUOilTankIncreaseLevel apuOilTankIncreaseLevel) {
        LogEngine.instance.write("+ Body.receive(" + apuOilTankIncreaseLevel + ")");
        try {

            for (int i = 0; i < aPUOilTanks.size(); i++) {
                Method method = aPUOilTanks.get(i).getClass().getDeclaredMethod("increaseLevel", int.class);
                LogEngine.instance.write("apuOilTankIncreaseLevelMethod = " + method);

                int value = (int) method.invoke(aPUOilTanks.get(i), apuOilTankIncreaseLevel.getFillValue());
                LogEngine.instance.write(apuOilTankIncreaseLevel.getPhase() + " : apuOilTankIncreaseLevel = " + value);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(BatteryCharge batteryCharge) {
        LogEngine.instance.write("+ Body.receive(" + batteryCharge + ")");
        try {

            for (int i = 0; i < batteries.size(); i++) {
                Method method = batteries.get(i).getClass().getDeclaredMethod("charge");
                LogEngine.instance.write("batteryChargeMethod = " + method);

                int value = (int) method.invoke(batteries.get(i));
                LogEngine.instance.write(batteryCharge.getPhase() + " : batteryCharge = " + value);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(BatteryDischarge batteryDischarge) {
        LogEngine.instance.write("+ Body.receive(" + batteryDischarge + ")");
        try {

            for (int i = 0; i < batteries.size(); i++) {
                Method method = batteries.get(i).getClass().getDeclaredMethod("discharge");
                LogEngine.instance.write("batteryDischargeMethod = " + method);

                int value = (int) method.invoke(batteries.get(i));
                LogEngine.instance.write(batteryDischarge.getPhase() + " : batteryDischarge = " + value);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(FireExtinguisherApply fireExtinguisherApply) {
        LogEngine.instance.write("+ Body.receive(" + fireExtinguisherApply + ")");
        try {

            for (int i = 0; i < fireExtinguishers.size(); i++) {
                Method method = fireExtinguishers.get(i).getClass().getDeclaredMethod("apply");
                LogEngine.instance.write("fireExtinguisherApplyMethod = " + method);

                int value = (int) method.invoke(fireExtinguishers.get(i));
                LogEngine.instance.write(fireExtinguisherApply.getPhase() + " : fireExtinguisherApply = " + value);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(FireExtinguisherRefill fireExtinguisherRefill) {
        LogEngine.instance.write("+ Body.receive(" + fireExtinguisherRefill + ")");
        try {

            for (int i = 0; i < fireExtinguishers.size(); i++) {
                Method method = fireExtinguishers.get(i).getClass().getDeclaredMethod("refill");
                LogEngine.instance.write("fireExtinguisherRefillMethod = " + method);

                int value = (int) method.invoke(fireExtinguishers.get(i));
                LogEngine.instance.write(fireExtinguisherRefill.getPhase() + " : fireExtinguisherRefill = " + value);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(DeIcingSystemActivate deIcingSystemActivate) {
        LogEngine.instance.write("+ Body.receive(" + deIcingSystemActivate + ")");
        try {

            for (int i = 0; i < deIcingSystems.size(); i++) {
                Method method = deIcingSystems.get(i).getClass().getDeclaredMethod("activate");
                LogEngine.instance.write("deIcingSystemActivateMethod = " + method);

                int value = (int) method.invoke(deIcingSystems.get(i));
                LogEngine.instance.write(deIcingSystemActivate.getPhase() + " : deIcingSystemActivate = " + value);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(DeIcingSystemDeactivate deIcingSystemDeactivate) {
        LogEngine.instance.write("+ Body.receive(" + deIcingSystemDeactivate + ")");
        try {

            for (int i = 0; i < deIcingSystems.size(); i++) {
                Method method = deIcingSystems.get(i).getClass().getDeclaredMethod("deactivate");
                LogEngine.instance.write("deIcingSystemDeactivateMethod = " + method);

                int value = (int) method.invoke(deIcingSystems.get(i));
                LogEngine.instance.write(deIcingSystemDeactivate.getPhase() + " : deIcingSystemDeactivate = " + value);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(DeIcingSystemDeIce deIcingSystemDeIce) {
        LogEngine.instance.write("+ Body.receive(" + deIcingSystemDeIce + ")");
        try {

            for (int i = 0; i < deIcingSystems.size(); i++) {
                Method method = deIcingSystems.get(i).getClass().getDeclaredMethod("deIce", int.class);
                LogEngine.instance.write("deIcingSystemDeIceMethod = " + method);

                int value = (int) method.invoke(deIcingSystems.get(i), deIcingSystemDeIce.getFillValue());
                LogEngine.instance.write(deIcingSystemDeIce.getPhase() + " : deIcingSystemDeIce = " + value);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Subscribe
    public void receive(DeIcingSystemRefill deIcingSystemRefill) {
        LogEngine.instance.write("+ Body.receive(" + deIcingSystemRefill + ")");
        try {

            for (int i = 0; i < deIcingSystems.size(); i++) {
                Method method = deIcingSystems.get(i).getClass().getDeclaredMethod("refill");
                LogEngine.instance.write("deIcingSystemRefillMethod = " + method);

                int value = (int) method.invoke(deIcingSystems.get(i));
                LogEngine.instance.write(deIcingSystemRefill.getPhase() + " : deIcingSystemRefill = " + value);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}