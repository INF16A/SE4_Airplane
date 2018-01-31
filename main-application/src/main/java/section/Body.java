package section;

import java.util.ArrayList;
import java.lang.reflect.Method;
import base.PrimaryFlightDisplay;
import com.google.common.eventbus.Subscribe;
import event.gps.GPSOff;
import event.gps.GPSOn;
import event.satcom.SatComOff;
import event.satcom.SatComOn;
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
import event.Subscriber;
import factory.IceDetectorProbeFactory;
import logging.LogEngine;

import java.util.ArrayList;
import recorder.FlightRecorder;

// imports for sensor04
import factory.CameraFactory;
import factory.GPSFactory;
import factory.RadarFactory;
import factory.SatComFactory;
import factory.VHFFactory;
import event.camera.CameraOff;
import event.camera.CameraOn;
import event.camera.CameraZoomIn;
import event.radar.RadarOff;
import event.radar.RadarOn;
import event.radar.RadarScan;
import event.VHF.VHFOff;
import event.VHF.VHFOn;

import recorder.FlightRecorder;

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
        // Factory magic 2
        pitotTubes = new ArrayList<>();
        // Factory magic 2
        radarAltimeters = new ArrayList<>();
        // Factory magic 2
        tCASs = new ArrayList<>();
        // Factory magic 2
        turbulentAirFlowSensors = new ArrayList<>();
        // Factory magic 2

        // sensor04
        // Factory magic 2
        cameraPorts = new ArrayList<>();
        for (int cameraIndex = 0;cameraIndex < 2;cameraIndex++)
            cameraPorts.add(CameraFactory.build());
        // Factory magic 2
        gpsPorts = new ArrayList<>();
        for (int gpsIndex = 0;gpsIndex < 2;gpsIndex++)
            gpsPorts.add(GPSFactory.build());
        // Factory magic 2
        radarPorts = new ArrayList<>();
        for (int radarIndex = 0;radarIndex < 2;radarIndex++)
            radarPorts.add(RadarFactory.build());
        // Factory magic 2
        satComPorts = new ArrayList<>();
        for (int satComIndex = 0;satComIndex < 2;satComIndex++)
            satComPorts.add(SatComFactory.build());
        // Factory magic 2
        vhfPorts = new ArrayList<>();
        for (int vhfIndex = 0;vhfIndex < 2;vhfIndex++)
            vhfPorts.add(VHFFactory.build());

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

    // please add here

    @Subscribe
    public void receive(CameraOn cameraOn){
        LogEngine.instance.write("+ Body.receive(" + cameraOn + ")");

        try{
            for(int cameraIndex = 0; cameraIndex < 2; cameraIndex++){
                Method cameraOnMethod = cameraPorts.get(cameraIndex).getClass().getDeclaredMethod("on");
                LogEngine.instance.write("cameraOnMethod = " + cameraOnMethod + "");

                boolean isCameraOn = (boolean)cameraOnMethod.invoke(cameraPorts.get(cameraIndex));

                LogEngine.instance.write(cameraOn.getPhase() + " : isCameraOn = " + isCameraOn + "");

                PrimaryFlightDisplay.instance.isCameraOn = isCameraOn;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),cameraOn.getPhase() + " : camera (isOn) = " + isCameraOn);

                LogEngine.instance.write("+");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(CameraOff cameraOff){
        LogEngine.instance.write("+ Body.receive(" + cameraOff + ")");

        try{
            for(int cameraIndex = 0; cameraIndex < 2; cameraIndex++){
                Method cameraOffMethod = cameraPorts.get(cameraIndex).getClass().getDeclaredMethod("off");
                LogEngine.instance.write("cameraOnMethod = " + cameraOffMethod + "");

                boolean isCameraOff = (boolean)cameraOffMethod.invoke(cameraPorts.get(cameraIndex));

                LogEngine.instance.write(cameraOff.getPhase() + " : isCameraOn = " + isCameraOff + "");

                PrimaryFlightDisplay.instance.isCameraOn = isCameraOff;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),cameraOff.getPhase() + " : camera (isOff) = " + isCameraOff);

                LogEngine.instance.write("+");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(CameraZoomIn cameraZoomIn){
        LogEngine.instance.write("+ Body.receive(" + cameraZoomIn + ")");

        try{
            for(int cameraIndex = 0; cameraIndex < 2; cameraIndex++) {
                Method cameraZoomInMethod = cameraPorts.get(cameraIndex).getClass().getDeclaredMethod("zoomIn", boolean.class);
                LogEngine.instance.write("cameraZoomInMethod = " + cameraZoomInMethod + "");

                double cameraFactor = (double) cameraZoomInMethod.invoke(cameraPorts.get(cameraIndex), new Object[]{true});

                LogEngine.instance.write(cameraZoomIn.getPhase() + " : cameraFactor = " + cameraFactor + "");

                PrimaryFlightDisplay.instance.cameraFactor = cameraFactor;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(), cameraZoomIn.getPhase() + " : camera (Factor) = " + cameraFactor);

                LogEngine.instance.write("+");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(RadarOn radarOn){
        LogEngine.instance.write("+ Body.receive(" + radarOn + ")");

        try{
            for(int radarIndex = 0; radarIndex < 2; radarIndex++){
                Method radarOnMethod = radarPorts.get(radarIndex).getClass().getDeclaredMethod("on");
                LogEngine.instance.write("radarOnMethod = " + radarOnMethod + "");

                boolean isRadarOn = (boolean)radarOnMethod.invoke(radarPorts.get(radarIndex));

                LogEngine.instance.write(radarOn.getPhase() + " : isRadarOn = " + isRadarOn + "");

                PrimaryFlightDisplay.instance.isRadarOn = isRadarOn;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),radarOn.getPhase() + " : Radar (isOn) = " + isRadarOn);

                LogEngine.instance.write("+");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(RadarOff radarOff){
        LogEngine.instance.write("+ Body.receive(" + radarOff + ")");

        try{
            for(int radarIndex = 0; radarIndex < 2; radarIndex++){
                Method radarOffMethod = radarPorts.get(radarIndex).getClass().getDeclaredMethod("off");
                LogEngine.instance.write("radarOffMethod = " + radarOffMethod + "");

                boolean isRadarOff = (boolean)radarOffMethod.invoke(radarPorts.get(radarIndex));

                LogEngine.instance.write(radarOff.getPhase() + " : isRadarOff = " + isRadarOff + "");

                PrimaryFlightDisplay.instance.isRadarOn = isRadarOff;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),radarOff.getPhase() + " : Radar (isOn) = " + isRadarOff);

                LogEngine.instance.write("+");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(RadarScan radarScan){
        LogEngine.instance.write("+ Body.receive(" + radarScan + ")");

        try{
            for(int radarIndex = 0; radarIndex < 2; radarIndex++){
                Method radarScanMethod = radarPorts.get(radarIndex).getClass().getDeclaredMethod("scan",String.class);
                LogEngine.instance.write("radarScanMethod = " + radarScanMethod + "");

                boolean scanResult = (boolean)radarScanMethod.invoke(radarPorts.get(radarIndex), new Object[]{radarScan.getEnvironment()});

                LogEngine.instance.write(radarScan.getPhase() + " : scanResult = " + scanResult + "");

                PrimaryFlightDisplay.instance.isAirspaceFree = scanResult;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),radarScan.getPhase() + " : Radar (scan) = " + scanResult);

                LogEngine.instance.write("+");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(GPSOn isGpsOn){
        LogEngine.instance.write("+ Body.receive(" + isGpsOn + ")");

        try{
            for(int gpsOnIndex = 0; gpsOnIndex < 2; gpsOnIndex++){
                Method gpsOnMethod = gpsPorts.get(gpsOnIndex).getClass().getDeclaredMethod("on");
                LogEngine.instance.write("radarScanMethod = " + gpsOnMethod + "");

                boolean isGPSOn = (boolean)gpsOnMethod.invoke(gpsPorts.get(gpsOnIndex));

                LogEngine.instance.write(isGpsOn.getPhase() + " : isGPSOn = " + isGPSOn + "");

                PrimaryFlightDisplay.instance.isGPSOn = isGPSOn;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),isGpsOn.getPhase() + " : GPS (isOn) = " + isGPSOn);

                LogEngine.instance.write("+");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(GPSOff isGpsOff){
        LogEngine.instance.write("+ Body.receive(" + isGpsOff + ")");

        try{
            for(int gpsOffIndex = 0; gpsOffIndex < 2; gpsOffIndex++){
                Method gpsOffMethod = gpsPorts.get(gpsOffIndex).getClass().getDeclaredMethod("off");
                LogEngine.instance.write("radarScanMethod = " + gpsOffMethod + "");

                boolean isGPSOff = (boolean)gpsOffMethod.invoke(gpsPorts.get(gpsOffIndex));

                LogEngine.instance.write(isGpsOff.getPhase() + " : isGPSOff = " + isGPSOff + "");

                PrimaryFlightDisplay.instance.isGPSOn = isGPSOff;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),isGpsOff.getPhase() + " : GPS (isOff) = " + isGPSOff);

                LogEngine.instance.write("+");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(SatComOn isSatComOn){
        LogEngine.instance.write("+ Body.receive(" + isSatComOn + ")");

        try{
            for(int satComIndex = 0; satComIndex < 2; satComIndex++){
                Method satComOnMethod = satComPorts.get(satComIndex).getClass().getDeclaredMethod("on");
                LogEngine.instance.write("radarScanMethod = " + satComOnMethod + "");

                boolean isSatComConnected = (boolean)satComOnMethod.invoke(satComPorts.get(satComIndex));

                LogEngine.instance.write(isSatComOn.getPhase() + " : isSatComConnected = " + isSatComConnected + "");

                PrimaryFlightDisplay.instance.isSatComConnected = isSatComConnected;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),isSatComOn.getPhase() + " : SatCom (isConnected) = " + isSatComConnected);

                LogEngine.instance.write("+");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(SatComOff isSatComOff){
        LogEngine.instance.write("+ Body.receive(" + isSatComOff + ")");

        try{
            for(int satComIndex = 0; satComIndex < 2; satComIndex++){
                Method satComOffMethod = satComPorts.get(satComIndex).getClass().getDeclaredMethod("off");
                LogEngine.instance.write("radarScanMethod = " + satComOffMethod + "");

                boolean isSatComConnected = (boolean)satComOffMethod.invoke(satComPorts.get(satComIndex));

                LogEngine.instance.write(isSatComOff.getPhase() + " : isSatComConnected = " + isSatComConnected + "");

                PrimaryFlightDisplay.instance.isSatComConnected = isSatComConnected;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),isSatComOff.getPhase() + " : SatCom (isConnected) = " + isSatComConnected);

                LogEngine.instance.write("+");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(VHFOn isVHFOn){
        LogEngine.instance.write("+ Body.receive(" + isVHFOn + ")");

        try{
            for(int vhfOnIndex = 0; vhfOnIndex < 2; vhfOnIndex++){
                Method vhfOnMethod = vhfPorts.get(vhfOnIndex).getClass().getDeclaredMethod("on");
                LogEngine.instance.write("vhfOnMethod = " + vhfOnMethod + "");

                boolean isVhfOn = (boolean)vhfOnMethod.invoke(vhfPorts.get(vhfOnIndex));

                LogEngine.instance.write(isVHFOn.getPhase() + " : isVHFOn = " + isVhfOn + "");

                PrimaryFlightDisplay.instance.isVHFOn = isVhfOn;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),isVHFOn.getPhase() + " : VHFOn (isOn) = " + isVhfOn);

                LogEngine.instance.write("+");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(VHFOff isVHFOn){
        LogEngine.instance.write("+ Body.receive(" + isVHFOn + ")");

        try{
            for(int vhfOffIndex = 0; vhfOffIndex < 2; vhfOffIndex++){
                Method vhfOffMethod = vhfPorts.get(vhfOffIndex).getClass().getDeclaredMethod("off");
                LogEngine.instance.write("vhfOnMethod = " + vhfOffMethod + "");

                boolean isVhfOn = (boolean)vhfOffMethod.invoke(vhfPorts.get(vhfOffIndex));

                LogEngine.instance.write(isVHFOn.getPhase() + " : isVhfOff = " + isVhfOn + "");

                PrimaryFlightDisplay.instance.isVHFOn = isVhfOn;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),isVHFOn.getPhase() + " : VHFOff (isOn) = " + isVhfOn);

                LogEngine.instance.write("+");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
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

}