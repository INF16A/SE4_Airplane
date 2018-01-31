package section;

import java.lang.reflect.Method;
import java.util.ArrayList;

import base.PrimaryFlightDisplay;
import com.google.common.eventbus.Subscribe;
import event.gps.GPSOff;
import event.gps.GPSOn;
import event.satcom.SatComOff;
import event.satcom.SatComOn;
import logging.LogEngine;
import event.Subscriber;

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
        // Factory magic 2
        batteries = new ArrayList<>();
        // Factory magic 24
        nitrogenBottles = new ArrayList<>();
        // Factory magic 6
        oxygenBottles = new ArrayList<>();
        // Factory magic 10
        potableWaterTanks = new ArrayList<>();
        // Factory magic 8
        wasteWaterTanks = new ArrayList<>();
        // Factory magic 4
        fireExtinguishers = new ArrayList<>();
        // Factory magic 14
        deIcingSystems = new ArrayList<>();
        // Factory magic 2

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
        // Factory magic 4
        kitchens = new ArrayList<>();
        // Factory magic 4 1x First, 1x Business, 2x Economy
        lavatories = new ArrayList<>();
        // Factory magic 8
        wasteSystems = new ArrayList<>();
        // Factory magic 10
        waterSystems = new ArrayList<>();
        // Factory magic 4
        escapeSlides = new ArrayList<>();
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
}