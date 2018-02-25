package test;

import base.Airplane;
import base.Cockpit;
import base.PrimaryFlightDisplay;
import logging.LogEngine;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProcedureTest {
    /*
    private static Airplane airplane;
    private static Cockpit cockpit;

    @Before
    public void init() {
        LogEngine.instance.init();

        airplane = new Airplane();
        airplane.build();

        cockpit = new Cockpit(airplane);
    }

    @Test
    public void setup() {
        //DroopNose
        Assert.assertNotNull(airplane.getLeftWing().getDroopNoses());
        assertEquals(2, airplane.getLeftWing().getDroopNoses().size());
        Assert.assertNotNull(airplane.getRightWing().getDroopNoses());
        assertEquals(2, airplane.getRightWing().getDroopNoses().size());
        assertEquals(0, PrimaryFlightDisplay.instance.leftWingDroopNoseDegree);
        assertEquals(0, PrimaryFlightDisplay.instance.rightWingDroopNoseDegree);

        //Elevator
        Assert.assertNotNull(airplane.getBody().getElevators());
        assertEquals(4, airplane.getBody().getElevators().size());
        assertEquals(0, PrimaryFlightDisplay.instance.elevatorDegree);

        //Flap
        Assert.assertNotNull(airplane.getLeftWing().getFlaps());
        assertEquals(2, airplane.getLeftWing().getFlaps().size());
        Assert.assertNotNull(airplane.getRightWing().getFlaps());
        assertEquals(2, airplane.getRightWing().getFlaps().size());
        assertEquals(0, PrimaryFlightDisplay.instance.leftWingFlapDegree);
        assertEquals(0, PrimaryFlightDisplay.instance.rightWingFlapDegree);

        //slat
        Assert.assertNotNull(airplane.getLeftWing().getSlats());
        assertEquals(6, airplane.getLeftWing().getSlats().size());
        Assert.assertNotNull(airplane.getRightWing().getSlats());
        assertEquals(6, airplane.getRightWing().getSlats().size());
        assertEquals(0, PrimaryFlightDisplay.instance.leftWingSlatDegree);
        assertEquals(0, PrimaryFlightDisplay.instance.rightWingSlatDegree);

        //LeftAileron
        Assert.assertNotNull(airplane.getLeftWing().getLeftAilerons());
        assertEquals(3, airplane.getLeftWing().getLeftAilerons().size());
        Assert.assertNotNull(airplane.getRightWing().getLeftAilerons());
        assertEquals(3, airplane.getRightWing().getLeftAilerons().size());
        assertEquals(0, PrimaryFlightDisplay.instance.leftWingLeftAileronDegree);
        assertEquals(0, PrimaryFlightDisplay.instance.rightWingLeftAileronDegree);

        //RightAileron
        Assert.assertNotNull(airplane.getLeftWing().getRightAilerons());
        assertEquals(3, airplane.getLeftWing().getRightAilerons().size());
        Assert.assertNotNull(airplane.getRightWing().getRightAilerons());
        assertEquals(3, airplane.getRightWing().getRightAilerons().size());
        assertEquals(0, PrimaryFlightDisplay.instance.leftWingRightAileronDegree);
        assertEquals(0, PrimaryFlightDisplay.instance.rightWingRightAileronDegree);

        //Rudder
        Assert.assertNotNull(airplane.getBody().getRudders());
        assertEquals(2, airplane.getBody().getRudders().size());
        assertEquals(0, PrimaryFlightDisplay.instance.rudderDegree);

        //Spoiler
        Assert.assertNotNull(airplane.getLeftWing().getSpoilers());
        assertEquals(8, airplane.getLeftWing().getSpoilers().size());
        Assert.assertNotNull(airplane.getRightWing().getSpoilers());
        assertEquals(8, airplane.getRightWing().getSpoilers().size());
        assertEquals(0, PrimaryFlightDisplay.instance.leftWingSpoilerDegree);
        assertEquals(0, PrimaryFlightDisplay.instance.rightWingSpoilerDegree);

        //IAPU
        Assert.assertNotNull(airplane.getBody().getAPUs());
        assertEquals(1, airplane.getBody().getAPUs().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isIAPUStarted);
        assertEquals(0, PrimaryFlightDisplay.instance.iAPURpm);

        //Engine
        Assert.assertNotNull(airplane.getLeftWing().getEngines());
        assertEquals(2, airplane.getLeftWing().getEngines().size());
        Assert.assertNotNull(airplane.getRightWing().getEngines());
        assertEquals(2, airplane.getRightWing().getEngines().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isLeftWingStarted);
        assertEquals(0, PrimaryFlightDisplay.instance.leftWingRpm);
        assertEquals(false, PrimaryFlightDisplay.instance.isLeftWingFire);
        assertEquals(false, PrimaryFlightDisplay.instance.isRightWingStarted);
        assertEquals(0, PrimaryFlightDisplay.instance.rightWingRpm);
        assertEquals(false, PrimaryFlightDisplay.instance.isRightWingFire);

        //Gear
        Assert.assertNotNull(airplane.getBody().getGears());
        assertEquals(3, airplane.getBody().getGears().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isDown);

        //HydraulicPump
        Assert.assertNotNull(airplane.getBody().getHydraulicPumps());
        assertEquals(6, airplane.getBody().getHydraulicPumps().size());
        Assert.assertNotNull(airplane.getLeftWing().getHydraulicPumps());
        assertEquals(4, airplane.getLeftWing().getHydraulicPumps().size());
        Assert.assertNotNull(airplane.getRightWing().getHydraulicPumps());
        assertEquals(4, airplane.getRightWing().getHydraulicPumps().size());
        assertEquals(0, PrimaryFlightDisplay.instance.leftWingHydraulicPumpAmoumt);
        assertEquals(0, PrimaryFlightDisplay.instance.rightWingHydraulicPumpAmoumt);
        assertEquals(0, PrimaryFlightDisplay.instance.bodyHydraulicPumpAmoumt);

        //BulkCargoDoor
        Assert.assertNotNull(airplane.getBody().getBulkCargoDoors());
        //assertEquals(2,airplane.getBody().getBulkCargoDoors().size()); // TODO: FIX right amount of Doors?
        assertEquals(false, PrimaryFlightDisplay.instance.isBulkCargoDoorClosed);
        assertEquals(false, PrimaryFlightDisplay.instance.isBulkCargoDoorLocked);

        //CrewDoor
        Assert.assertNotNull(airplane.getBody().getCrewDoors());
        //assertEquals(2,airplane.getBody().getCrewDoors().size()); // TODO: FIX right amount of Doors?
        assertEquals(false, PrimaryFlightDisplay.instance.isCrewDoorClosed);
        assertEquals(false, PrimaryFlightDisplay.instance.isCrewDoorLocked);

        //EmergencyExitDoor
        Assert.assertNotNull(airplane.getBody().getEmergencyExitDoors());
        //assertEquals(14,airplane.getBody().getEmergencyExitDoors().size()); // TODO: FIX right amount of Doors?
        assertEquals(false, PrimaryFlightDisplay.instance.isEmergencyExitDoorClosed);
        assertEquals(false, PrimaryFlightDisplay.instance.isEmergencyExitDoorLocked);
        assertEquals(false, PrimaryFlightDisplay.instance.isEmergencyExitDoorEscapeSlideActivated);

        //GearDoor
        Assert.assertNotNull(airplane.getBody().getGearDoors());
        //assertEquals(6,airplane.getBody().getGearDoors().size()); // TODO: FIX right amount of Doors?
        assertEquals(false, PrimaryFlightDisplay.instance.isGearDoorClosed);
        assertEquals(false, PrimaryFlightDisplay.instance.isGearDoorLocked);

        //APUOilTank
        Assert.assertNotNull(airplane.getBody().getAPUOilTanks());
        assertEquals(2, airplane.getBody().getAPUOilTanks().size());
        assertEquals(0, PrimaryFlightDisplay.instance.aPUOilTankLevel);

        //Battery
        Assert.assertNotNull(airplane.getBody().getBatteries());
        assertEquals(24, airplane.getBody().getBatteries().size());
        assertEquals(0, PrimaryFlightDisplay.instance.batteryPercentage);

        //EngineOilTank
        Assert.assertNotNull(airplane.getLeftWing().getEngineOilTanks());
        assertEquals(4, airplane.getLeftWing().getEngineOilTanks().size());
        Assert.assertNotNull(airplane.getRightWing().getEngineOilTanks());
        assertEquals(4, airplane.getRightWing().getEngineOilTanks().size());
        assertEquals(0, PrimaryFlightDisplay.instance.leftWingEngineOilTankLevel);
        assertEquals(0, PrimaryFlightDisplay.instance.rightWingEngineOilTankLevel);

        //FuelTank
        Assert.assertNotNull(airplane.getLeftWing().getFuelTanks());
        assertEquals(3, airplane.getLeftWing().getFuelTanks().size());
        Assert.assertNotNull(airplane.getRightWing().getFuelTanks());
        assertEquals(3, airplane.getRightWing().getFuelTanks().size());
        //assertEquals(1000, PrimaryFlightDisplay.instance.leftWingFuelTankAmount);  // TODO: FIX right amount?
        //assertEquals(1000, PrimaryFlightDisplay.instance.rightWingFuelTankAmount); // TODO: FIX right amount?

        //NitrogenBottle
        Assert.assertNotNull(airplane.getBody().getNitrogenBottles());
        assertEquals(6, airplane.getBody().getNitrogenBottles().size());
        //assertEquals(250, PrimaryFlightDisplay.instance.nitrogenBottleAmount); // TODO: FIX right amount?

        //OxygenBottle
        Assert.assertNotNull(airplane.getBody().getOxygenBottles());
        assertEquals(10, airplane.getBody().getOxygenBottles().size());
        //assertEquals(100, PrimaryFlightDisplay.instance.oxygenBottleAmount); // TODO: FIX right amount?

        //PotableWaterTank
        Assert.assertNotNull(airplane.getBody().getPotableWaterTanks());
        assertEquals(8, airplane.getBody().getPotableWaterTanks().size());
        //assertEquals(1000, PrimaryFlightDisplay.instance.potableWaterTankAmount); // TODO: FIX right amount?
        assertEquals(false, PrimaryFlightDisplay.instance.isPotableWaterTankLocked);

        //WasteWaterTank
        Assert.assertNotNull(airplane.getBody().getWasteWaterTanks());
        assertEquals(4, airplane.getBody().getWasteWaterTanks().size());
        //assertEquals(1000, PrimaryFlightDisplay.instance.wasteWaterTankCapacity); // TODO: FIX right amount?
        assertEquals(false, PrimaryFlightDisplay.instance.isWasteWaterTankLocked);

        //FireExtinguisher
        Assert.assertNotNull(airplane.getBody().getFireExtinguishers());
        assertEquals(14, airplane.getBody().getFireExtinguishers().size());
        //assertEquals(100, PrimaryFlightDisplay.instance.fireExtinguisherPercentage); // TODO: FIX right amount?

        //DeIcingSystem
        Assert.assertNotNull(airplane.getBody().getDeIcingSystems());
        assertEquals(2, airplane.getBody().getDeIcingSystems().size());
        Assert.assertNotNull(airplane.getLeftWing().getDeIcingSystems());
        assertEquals(2, airplane.getLeftWing().getDeIcingSystems().size());
        Assert.assertNotNull(airplane.getRightWing().getDeIcingSystems());
        assertEquals(2, airplane.getRightWing().getDeIcingSystems().size());
        //assertEquals(1000, PrimaryFlightDisplay.instance.bodyDeIcingSystemAmount); // TODO: FIX right amount?
        assertEquals(false, PrimaryFlightDisplay.instance.isBodyDeIcingSystemActivated);
        //assertEquals(1000, PrimaryFlightDisplay.instance.leftWingDeIcingSystemAmount); // TODO: FIX`right amount?
        assertEquals(false, PrimaryFlightDisplay.instance.isLeftDeIcingSystemActivated);
        //assertEquals(1000, PrimaryFlightDisplay.instance.rightWingDeIcingSystemAmount); // TODO: FIX right amount?
        assertEquals(false, PrimaryFlightDisplay.instance.isRightDeIcingSystemActivated);

        //FirstClassSeat
        Assert.assertNotNull(airplane.getBody().getFirstClassSeats());
        //assertEquals(16,airplane.getBody().getFirstClassSeats().size()); // TODO: FIX right number of Seats?
        assertEquals(0, PrimaryFlightDisplay.instance.firstClassSeatLevel);
        assertEquals(false, PrimaryFlightDisplay.instance.isFirstClassSeatSmokingSignOn);
        assertEquals(false, PrimaryFlightDisplay.instance.isFirstClassSeatSeatBeltSignOn);

        //BusinessClassSeat
        Assert.assertNotNull(airplane.getBody().getBusinessClassSeats());
        //assertEquals(72,airplane.getBody().getBusinessClassSeats().size()); // TODO: FIX right number of Seats?
        assertEquals(0, PrimaryFlightDisplay.instance.businessClassSeatLevel);
        assertEquals(false, PrimaryFlightDisplay.instance.isBusinessClassSeatSmokingSignOn);
        assertEquals(false, PrimaryFlightDisplay.instance.isBusinessClassSeatSeatBeltSignOn);

        //TouristClassSeat
        Assert.assertNotNull(airplane.getBody().getTouristClassSeats());
        //assertEquals(480,airplane.getBody().getTouristClassSeats().size()); // TODO: FIX right number of Seats?
        assertEquals(0, PrimaryFlightDisplay.instance.touristClassSeatLevel);
        assertEquals(false, PrimaryFlightDisplay.instance.isTouristClassSeatSmokingSignOn);
        assertEquals(false, PrimaryFlightDisplay.instance.isTouristClassSeatBeltSignOn);

        //CrewSeat
        Assert.assertNotNull(airplane.getBody().getCrewSeats());
        //assertEquals(14,airplane.getBody().getCrewSeats().size()); // TODO: FIX right number of Seats?

        //ExhaustGasTemperatureSensor
        Assert.assertNotNull(airplane.getLeftWing().getExhaustGasTemperatureSensors());
        assertEquals(4, airplane.getLeftWing().getExhaustGasTemperatureSensors().size());
        Assert.assertNotNull(airplane.getRightWing().getExhaustGasTemperatureSensors());
        assertEquals(4, airplane.getRightWing().getExhaustGasTemperatureSensors().size());
        assertEquals(0, PrimaryFlightDisplay.instance.leftWingExhaustGasTemperatureSensorTemperature);
        assertEquals(false, PrimaryFlightDisplay.instance.isLeftExhaustGasTemperatureSensorAlarmMajor);
        assertEquals(false, PrimaryFlightDisplay.instance.isLeftExhaustGasTemperatureSensorAlarmCritical);
        assertEquals(0, PrimaryFlightDisplay.instance.rightWingExhaustGasTemperatureSensorTemperature);
        assertEquals(false, PrimaryFlightDisplay.instance.isRightExhaustGasTemperatureSensorAlarmMajor);
        assertEquals(false, PrimaryFlightDisplay.instance.isRightExhaustGasTemperatureSensorAlarmCritical);

        //FuelFlowSensor
        Assert.assertNotNull(airplane.getLeftWing().getFuelFlowSensors());
        assertEquals(6, airplane.getLeftWing().getFuelFlowSensors().size());
        Assert.assertNotNull(airplane.getRightWing().getFuelFlowSensors());
        assertEquals(6, airplane.getRightWing().getFuelFlowSensors().size());
        assertEquals(0, PrimaryFlightDisplay.instance.leftWingFuelFlowSensorFuelFlow);
        assertEquals(0, PrimaryFlightDisplay.instance.rightWingFuelFlowSensorFuelFlow);

        //FuelSensor
        Assert.assertNotNull(airplane.getLeftWing().getFuelSensors());
        assertEquals(6, airplane.getLeftWing().getFuelSensors().size());
        Assert.assertNotNull(airplane.getRightWing().getFuelSensors());
        assertEquals(6, airplane.getRightWing().getFuelSensors().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isLeftWingAlarmReserve);
        assertEquals(false, PrimaryFlightDisplay.instance.isLeftWingAlarmMajor);
        assertEquals(false, PrimaryFlightDisplay.instance.isLeftWingAlarmCritical);
        assertEquals(false, PrimaryFlightDisplay.instance.isRightWingAlarmReserve);
        assertEquals(false, PrimaryFlightDisplay.instance.isRightWingAlarmMajor);
        assertEquals(false, PrimaryFlightDisplay.instance.isRightWingAlarmCritical);

        //IceDetectorProbe
        Assert.assertNotNull(airplane.getBody().getIceDetectorProbes());
        assertEquals(2, airplane.getBody().getIceDetectorProbes().size());
        Assert.assertNotNull(airplane.getLeftWing().getIceDetectorProbes());
        assertEquals(2, airplane.getLeftWing().getIceDetectorProbes().size());
        Assert.assertNotNull(airplane.getRightWing().getIceDetectorProbes());
        assertEquals(2, airplane.getRightWing().getIceDetectorProbes().size());
        assertEquals(true, PrimaryFlightDisplay.instance.isBodyIceDetectorProbeActivated);
        assertEquals(false, PrimaryFlightDisplay.instance.isBodyIceDetected);
        assertEquals(true, PrimaryFlightDisplay.instance.isLeftWingIceDetectorProbeActivated);
        assertEquals(false, PrimaryFlightDisplay.instance.isLeftIceDetected);
        assertEquals(true, PrimaryFlightDisplay.instance.isRightWingIceDetectorProbeActivated);
        assertEquals(false, PrimaryFlightDisplay.instance.isRightIceDetected);

        //FireDetector
        Assert.assertNotNull(airplane.getBody().getFireDetectors());
        assertEquals(14, airplane.getBody().getFireDetectors().size());
        Assert.assertNotNull(airplane.getLeftWing().getFireDetectors());
        assertEquals(4, airplane.getLeftWing().getFireDetectors().size());
        Assert.assertNotNull(airplane.getRightWing().getFireDetectors());
        assertEquals(4, airplane.getRightWing().getFireDetectors().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isBodyFireDetectorAlarm);
        assertEquals(false, PrimaryFlightDisplay.instance.isLeftWingFireDetectorAlarm);
        assertEquals(false, PrimaryFlightDisplay.instance.isRightWingFireDetectorAlarm);

        //OxygenSensor
        Assert.assertNotNull(airplane.getBody().getOxygenSensors());
        assertEquals(8, airplane.getBody().getOxygenSensors().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isBodyOxygenSensorAlarm);

        //ShockSensor
        Assert.assertNotNull(airplane.getBody().getShockSensors());
        assertEquals(2, airplane.getBody().getShockSensors().size());
        Assert.assertNotNull(airplane.getLeftWing().getShockSensors());
        assertEquals(2, airplane.getLeftWing().getShockSensors().size());
        Assert.assertNotNull(airplane.getRightWing().getShockSensors());
        assertEquals(2, airplane.getRightWing().getShockSensors().size());
        assertEquals(true, PrimaryFlightDisplay.instance.isBodyShockSensorCalibrated);
        assertEquals(true, PrimaryFlightDisplay.instance.isLeftWingShockSensorCalibrated);
        assertEquals(true, PrimaryFlightDisplay.instance.isRightWingShockSensorCalibrated);
        assertEquals(false, PrimaryFlightDisplay.instance.isBodyhockSensorShockDetected);
        assertEquals(false, PrimaryFlightDisplay.instance.isLeftWingSensorShockDetected);
        assertEquals(false, PrimaryFlightDisplay.instance.isRightWingSensorShockDetected);

        //StallingSensor
        Assert.assertNotNull(airplane.getBody().getStallingSensors());
        assertEquals(2, airplane.getBody().getStallingSensors().size());
        Assert.assertNotNull(airplane.getLeftWing().getStallingSensors());
        assertEquals(4, airplane.getLeftWing().getStallingSensors().size());
        Assert.assertNotNull(airplane.getRightWing().getStallingSensors());
        assertEquals(4, airplane.getRightWing().getStallingSensors().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isBodyStallingSensorAlarm);
        assertEquals(false, PrimaryFlightDisplay.instance.isLeftWingStallingSensorAlarm);
        assertEquals(false, PrimaryFlightDisplay.instance.isRightWingStallingSensorAlarm);

        //TemperatureSensor
        Assert.assertNotNull(airplane.getBody().getTemperatureSensors());
        assertEquals(2, airplane.getBody().getTemperatureSensors().size());
        Assert.assertNotNull(airplane.getLeftWing().getTemperatureSensors());
        assertEquals(4, airplane.getLeftWing().getTemperatureSensors().size());
        Assert.assertNotNull(airplane.getRightWing().getTemperatureSensors());
        assertEquals(4, airplane.getRightWing().getTemperatureSensors().size());
        //TODO Which Temperature at Start?
        //assertEquals(0, PrimaryFlightDisplay.instance.bodyTemperatureSensortemperature);
        //assertEquals(0, PrimaryFlightDisplay.instance.leftWingTemperatureSensortemperature);
        //assertEquals(0, PrimaryFlightDisplay.instance.rightWingTemperatureSensortemperature);
        assertEquals(false, PrimaryFlightDisplay.instance.isBodyTemperatureSensorAlarm);
        assertEquals(false, PrimaryFlightDisplay.instance.isLeftWingTemperatureSensorAlarm);
        assertEquals(false, PrimaryFlightDisplay.instance.isRightWingTemperatureSensorAlarm);

        //AirflowSensor
        Assert.assertNotNull(airplane.getBody().getAirflowSensors());
        assertEquals(2, airplane.getBody().getAirflowSensors().size());
        Assert.assertNotNull(airplane.getLeftWing().getAirflowSensors());
        assertEquals(2, airplane.getLeftWing().getAirflowSensors().size());
        Assert.assertNotNull(airplane.getRightWing().getAirflowSensors());
        assertEquals(2, airplane.getRightWing().getAirflowSensors().size());
        //TODO which Pressure at Startup?
        //assertEquals(0, PrimaryFlightDisplay.instance.bodyAirflowSensorAirPressure);
        //assertEquals(0, PrimaryFlightDisplay.instance.leftWingAirflowSensorAirPressure);
        //assertEquals(0, PrimaryFlightDisplay.instance.rightWingAirflowSensorAirPressure);
        assertEquals(false, PrimaryFlightDisplay.instance.isBodyAirflowSensorAlarm);
        assertEquals(false, PrimaryFlightDisplay.instance.isLeftWingAirflowSensorAlarm);
        assertEquals(false, PrimaryFlightDisplay.instance.isRightWingAirflowSensorAlarm);

        //PitotTube
        Assert.assertNotNull(airplane.getBody().getPitotTubes());
        assertEquals(2, airplane.getBody().getPitotTubes().size());
        //TODO Velocity at Startup?
        //assertEquals(0, PrimaryFlightDisplay.instance.pitotTubeVelocity);
        assertEquals(true, PrimaryFlightDisplay.instance.isPitotTubeCleaned);

        //RadarAltimeter
        Assert.assertNotNull(airplane.getBody().getRadarAltimeters());
        assertEquals(2, airplane.getBody().getRadarAltimeters().size());
        //TODO Altitude?
        //assertEquals(0, PrimaryFlightDisplay.instance.radarAltimeterAltitude);
        assertEquals(false, PrimaryFlightDisplay.instance.isRadarAltimeterOn);

        //TCAS
        Assert.assertNotNull(airplane.getBody().gettCASs());
        assertEquals(2, airplane.getBody().gettCASs().size());
        assertEquals(0, PrimaryFlightDisplay.instance.tCASAltitude);
        assertEquals(false, PrimaryFlightDisplay.instance.isTCASOn);
        assertEquals(false, PrimaryFlightDisplay.instance.isTCASConnected);
        assertEquals(false, PrimaryFlightDisplay.instance.isTCASAlarm);

        //TurbulentAirFlowSensor
        Assert.assertNotNull(airplane.getBody().getTurbulentAirFlowSensors());
        assertEquals(2, airplane.getBody().getTurbulentAirFlowSensors().size());
        Assert.assertNotNull(airplane.getLeftWing().getTurbulentAirFlowSensors());
        assertEquals(4, airplane.getLeftWing().getTurbulentAirFlowSensors().size());
        Assert.assertNotNull(airplane.getRightWing().getTurbulentAirFlowSensors());
        assertEquals(4, airplane.getRightWing().getTurbulentAirFlowSensors().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isBodyTurbulentAirFlowSensorAlarm);
        assertEquals(false, PrimaryFlightDisplay.instance.isLeftWingTurbulentAirFlowSensorAlarm);
        assertEquals(false, PrimaryFlightDisplay.instance.isRightWingTurbulentAirFlowSensorAlarm);

        //Camera
        Assert.assertNotNull(airplane.getBody().getCameras());
        assertEquals(2, airplane.getBody().getCameras().size());
        // TODO Factor??
        //assertEquals(0, PrimaryFlightDisplay.instance.cameraFactor);
        assertEquals(false, PrimaryFlightDisplay.instance.isCameraOn);

        //GPS
        Assert.assertNotNull(airplane.getBody().getgPSs());
        assertEquals(2, airplane.getBody().getgPSs().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isGPSOn);

        //Radar
        Assert.assertNotNull(airplane.getBody().getRadars());
        assertEquals(2, airplane.getBody().getRadars().size());
        assertEquals(true, PrimaryFlightDisplay.instance.isRadarOn);

        //SatCom
        Assert.assertNotNull(airplane.getBody().getSatComs());
        assertEquals(2, airplane.getBody().getSatComs().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isSatComConnected);

        //VHF
        Assert.assertNotNull(airplane.getBody().getvHFs());
        assertEquals(2, airplane.getBody().getvHFs().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isVHFOn);

        //AntiCollisionLight
        Assert.assertNotNull(airplane.getBody().getAntiCollisionLights());
        assertEquals(2, airplane.getBody().getAntiCollisionLights().size());
        assertEquals(true, PrimaryFlightDisplay.instance.isAntiCollisionLightOn);

        //CargoCompartmentLight
        Assert.assertNotNull(airplane.getBody().getCargoCompartmentLights());
        assertEquals(4, airplane.getBody().getCargoCompartmentLights().size());
        assertEquals(true, PrimaryFlightDisplay.instance.isCargoCompartmentLightOn);

        //LandingLight
        Assert.assertNotNull(airplane.getBody().getLandingLights());
        assertEquals(2, airplane.getBody().getLandingLights().size());
        Assert.assertNotNull(airplane.getLeftWing().getLandingLights());
        assertEquals(2, airplane.getLeftWing().getLandingLights().size());
        Assert.assertNotNull(airplane.getRightWing().getLandingLights());
        assertEquals(2, airplane.getRightWing().getLandingLights().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isBodyLandingLightOn);
        assertEquals(false, PrimaryFlightDisplay.instance.isLeftWingLandingLightOn);
        assertEquals(false, PrimaryFlightDisplay.instance.isRightWingLandingLightOn);

        //LeftNavigationLight
        Assert.assertNotNull(airplane.getLeftWing().getLeftNavigationLights());
        assertEquals(1, airplane.getLeftWing().getLeftNavigationLights().size());
        Assert.assertNotNull(airplane.getRightWing().getLeftNavigationLights());
        assertEquals(1, airplane.getRightWing().getLeftNavigationLights().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isLeftWingLeftNavigationLightOn);
        assertEquals(false, PrimaryFlightDisplay.instance.isRightWingLeftNavigationLightOn);

        //LogoLight
        Assert.assertNotNull(airplane.getBody().getLogoLights());
        assertEquals(2, airplane.getBody().getLogoLights().size());;
        assertEquals(true, PrimaryFlightDisplay.instance.isLogoLightOn);

        //RightNavigationLight
        Assert.assertNotNull(airplane.getLeftWing().getRightNavigationLights());
        assertEquals(1, airplane.getLeftWing().getRightNavigationLights().size());
        Assert.assertNotNull(airplane.getRightWing().getRightNavigationLights());
        assertEquals(1, airplane.getRightWing().getRightNavigationLights().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isLeftWingRightNavigationLightOn);
        assertEquals(false, PrimaryFlightDisplay.instance.isRightWingRightNavigationLightOn);

        //TailNavigationLight
        Assert.assertNotNull(airplane.getBody().getTailNavigationLights());
        assertEquals(2, airplane.getBody().getTailNavigationLights().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isTailNavigationLightOn);

        //TaxiLight
        Assert.assertNotNull(airplane.getBody().getTaxiLights());
        assertEquals(2, airplane.getBody().getTaxiLights().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isTaxiLightOn);

        //TCASLight
        Assert.assertNotNull(airplane.getBody().gettCASLights());
        assertEquals(2, airplane.getBody().gettCASLights().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isTCASLightOn);

        //CargoSystem
        Assert.assertNotNull(airplane.getBody().getCargoSystems());
        assertEquals(2, airplane.getBody().getCargoSystems().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isCargoSystemLocked);
        assertEquals(false, PrimaryFlightDisplay.instance.isCargoSystemSecured);
        //TODO TotalWeight?
        //assertEquals(0, PrimaryFlightDisplay.instance.cargoSystemTotalWeightContainer);
        //assertEquals(0, PrimaryFlightDisplay.instance.cargoSystemTotalWeightAirCargoPallet);
        //assertEquals(0, PrimaryFlightDisplay.instance.cargoSystemTotalWeigth);

        //StowageNumberFive
        Assert.assertNotNull(airplane.getBody().getStowageNumberFives());
        assertEquals(1, airplane.getBody().getStowageNumberFives().size());
        //TODO Items?
        //assertEquals(0, PrimaryFlightDisplay.instance.stowageNumberFiveNumberOfItems);
        assertEquals(true, PrimaryFlightDisplay.instance.stowageNumberFiveBaggageList.isEmpty());
        //assertEquals(true, PrimaryFlightDisplay.instance.stowageNumberFiveSpecialGoodList.isEmpty());

        //AirConditioning
        Assert.assertNotNull(airplane.getBody().getAirConditionings());
        assertEquals(2, airplane.getBody().getAirConditionings().size());
        //TODO Temperature?
        //assertEquals(0, PrimaryFlightDisplay.instance.airConditioningTemperature);
        assertEquals(true, PrimaryFlightDisplay.instance.isAirConditioningOn);

        //Kitchen
        Assert.assertNotNull(airplane.getBody().getKitchens());
        assertEquals(4, airplane.getBody().getKitchens().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isKitchenLocked);
        assertEquals(true, PrimaryFlightDisplay.instance.isKitchenFilled);
        //assertEquals(false, PrimaryFlightDisplay.instance.kitchenTrolleyList.isEmpty());

        //Lavatory
        Assert.assertNotNull(airplane.getBody().getLavatories());
        assertEquals(8, airplane.getBody().getLavatories().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isLavatoryLocked);
        assertEquals(true, PrimaryFlightDisplay.instance.isLavatoryCleaned);

        //WasteSystem
        Assert.assertNotNull(airplane.getBody().getWasteSystems());
        assertEquals(10, airplane.getBody().getWasteSystems().size());
        assertEquals(true, PrimaryFlightDisplay.instance.isWasteSystemOn);
        assertEquals(true, PrimaryFlightDisplay.instance.isWasteSystemCleaned);
        assertEquals(false, PrimaryFlightDisplay.instance.wasteSystemWaste.length > 0);

        //WaterSystem
        Assert.assertNotNull(airplane.getBody().getWaterSystems());
        assertEquals(4, airplane.getBody().getWaterSystems().size());
        assertEquals(true, PrimaryFlightDisplay.instance.isWaterSystemOn);
        assertEquals(true, PrimaryFlightDisplay.instance.isWaterSystemFilled);
        assertEquals(true, PrimaryFlightDisplay.instance.isWaterSystemCleaned);

        //EscapeSlide
        Assert.assertNotNull(airplane.getBody().getEscapeSlides());
        assertEquals(14, airplane.getBody().getEscapeSlides().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isEscapeSlideActivated);

        //CostOptimizer
        Assert.assertNotNull(airplane.getBody().getCostOptimizers());
        assertEquals(2, airplane.getBody().getCostOptimizers().size());
        assertEquals(true, PrimaryFlightDisplay.instance.isCostOptimizerOn);
        // TODO Index?
        //assertEquals(0, PrimaryFlightDisplay.instance.costOptimizerCostIndex);
        //assertEquals(false, PrimaryFlightDisplay.instance.costOptimizerCheckPointList.isEmpty());

        //RouteManagement
        Assert.assertNotNull(airplane.getBody().getRouteManagements());
        assertEquals(2, airplane.getBody().getRouteManagements().size());
        assertEquals(true, PrimaryFlightDisplay.instance.isRouteManagementOn);
        //TODO CostIndex?
        //assertEquals(0, PrimaryFlightDisplay.instance.routeManagementCostIndex);
        //assertEquals(false, PrimaryFlightDisplay.instance.routeManagementCheckPointList.isEmpty());

        //SeatManagement
        Assert.assertNotNull(airplane.getBody().getSeatManagements());
        assertEquals(1, airplane.getBody().getSeatManagements().size());
        //TODO Numbers?
        //assertEquals(false, PrimaryFlightDisplay.instance.seatManagementNumberOfPassengersFirstClassAssigned);
        //assertEquals(false, PrimaryFlightDisplay.instance.seatManagementNumberOfPassengersBusinessClassAssigned);
        //assertEquals(false, PrimaryFlightDisplay.instance.seatManagementNumberOfPassengersEconomyClassAssigned);
        //assertEquals(false, PrimaryFlightDisplay.instance.seatManagementSeats.isEmpty());
    }

    @Test
    public void startUp() {
        cockpit.startup();
        //Camera
        assertEquals(true, PrimaryFlightDisplay.instance.isCameraOn);

        //GPS
        assertEquals(true, PrimaryFlightDisplay.instance.isGPSOn);

        //SatCom
        assertEquals(true, PrimaryFlightDisplay.instance.isSatComConnected);

        //VHF
        assertEquals(true, PrimaryFlightDisplay.instance.isVHFOn);

        //RadarAltimeter
        assertEquals(true, PrimaryFlightDisplay.instance.isRadarAltimeterOn);

        //TCAS
        assertEquals(5, PrimaryFlightDisplay.instance.tCASAltitude);
        assertEquals(true, PrimaryFlightDisplay.instance.isTCASOn);
        assertEquals(true, PrimaryFlightDisplay.instance.isTCASConnected);

        //AirflowSensor
        assertEquals(645, PrimaryFlightDisplay.instance.bodyAirflowSensorAirPressure);
        assertEquals(645, PrimaryFlightDisplay.instance.leftWingAirflowSensorAirPressure);
        assertEquals(645, PrimaryFlightDisplay.instance.rightWingAirflowSensorAirPressure);
    }

    @Test
    public void taxi() {
        cockpit.taxi();
        //TCAS
        assertEquals(true, PrimaryFlightDisplay.instance.isTCASOn);
        assertEquals(true, PrimaryFlightDisplay.instance.isTCASConnected);
        assertEquals(6, PrimaryFlightDisplay.instance.tCASAltitude);

        //AirflowSensor
        assertEquals(645, PrimaryFlightDisplay.instance.bodyAirflowSensorAirPressure);
        assertEquals(645, PrimaryFlightDisplay.instance.leftWingAirflowSensorAirPressure);
        assertEquals(645, PrimaryFlightDisplay.instance.rightWingAirflowSensorAirPressure);
    }

    @Test
    public void takeOff() {
        cockpit.takeoff();
        //AirflowSensor
        assertEquals(645, PrimaryFlightDisplay.instance.bodyAirflowSensorAirPressure);
        assertEquals(645, PrimaryFlightDisplay.instance.leftWingAirflowSensorAirPressure);
        assertEquals(645, PrimaryFlightDisplay.instance.rightWingAirflowSensorAirPressure);
        assertEquals(true, PrimaryFlightDisplay.instance.isBodyAirflowSensorAlarm);
        assertEquals(true, PrimaryFlightDisplay.instance.isLeftWingAirflowSensorAlarm);
        assertEquals(true, PrimaryFlightDisplay.instance.isRightWingAirflowSensorAlarm);

        //TurbulentAirFlowSensor
        assertEquals(true, PrimaryFlightDisplay.instance.isBodyTurbulentAirFlowSensorAlarm);
        assertEquals(true, PrimaryFlightDisplay.instance.isLeftWingTurbulentAirFlowSensorAlarm);
        assertEquals(true, PrimaryFlightDisplay.instance.isRightWingTurbulentAirFlowSensorAlarm);

    }

    @Test
    public void climbing() {
        cockpit.climbing();
        //AirflowSensor
        assertEquals(645, PrimaryFlightDisplay.instance.bodyAirflowSensorAirPressure);
        assertEquals(645, PrimaryFlightDisplay.instance.leftWingAirflowSensorAirPressure);
        assertEquals(645, PrimaryFlightDisplay.instance.rightWingAirflowSensorAirPressure);
        assertEquals(true, PrimaryFlightDisplay.instance.isBodyAirflowSensorAlarm);
        assertEquals(true, PrimaryFlightDisplay.instance.isLeftWingAirflowSensorAlarm);
        assertEquals(true, PrimaryFlightDisplay.instance.isRightWingAirflowSensorAlarm);

        //TurbulentAirFlowSensor
        assertEquals(true, PrimaryFlightDisplay.instance.isBodyTurbulentAirFlowSensorAlarm);
        assertEquals(true, PrimaryFlightDisplay.instance.isLeftWingTurbulentAirFlowSensorAlarm);
        assertEquals(true, PrimaryFlightDisplay.instance.isRightWingTurbulentAirFlowSensorAlarm);

        //TCAS
        assertEquals(true, PrimaryFlightDisplay.instance.isTCASAlarm);
    }

    @Test
    public void rightTurn() {
        cockpit.rightTurn();
        //AirflowSensor
        assertEquals(645, PrimaryFlightDisplay.instance.bodyAirflowSensorAirPressure);
        assertEquals(645, PrimaryFlightDisplay.instance.leftWingAirflowSensorAirPressure);
        assertEquals(645, PrimaryFlightDisplay.instance.rightWingAirflowSensorAirPressure);
        assertEquals(true, PrimaryFlightDisplay.instance.isBodyAirflowSensorAlarm);
        assertEquals(true, PrimaryFlightDisplay.instance.isLeftWingAirflowSensorAlarm);
        assertEquals(true, PrimaryFlightDisplay.instance.isRightWingAirflowSensorAlarm);

        //TurbulentAirFlowSensor
        assertEquals(true, PrimaryFlightDisplay.instance.isBodyTurbulentAirFlowSensorAlarm);
        assertEquals(true, PrimaryFlightDisplay.instance.isLeftWingTurbulentAirFlowSensorAlarm);
        assertEquals(true, PrimaryFlightDisplay.instance.isRightWingTurbulentAirFlowSensorAlarm);

        //TCAS
        assertEquals(true, PrimaryFlightDisplay.instance.isTCASAlarm);
    }

    @Test
    public void leftTurn() {
        cockpit.leftTurn();
        //AirflowSensor
        assertEquals(645, PrimaryFlightDisplay.instance.bodyAirflowSensorAirPressure);
        assertEquals(645, PrimaryFlightDisplay.instance.leftWingAirflowSensorAirPressure);
        assertEquals(645, PrimaryFlightDisplay.instance.rightWingAirflowSensorAirPressure);
        assertEquals(true, PrimaryFlightDisplay.instance.isBodyAirflowSensorAlarm);
        assertEquals(true, PrimaryFlightDisplay.instance.isLeftWingAirflowSensorAlarm);
        assertEquals(true, PrimaryFlightDisplay.instance.isRightWingAirflowSensorAlarm);

        //TurbulentAirFlowSensor
        assertEquals(true, PrimaryFlightDisplay.instance.isBodyTurbulentAirFlowSensorAlarm);
        assertEquals(true, PrimaryFlightDisplay.instance.isLeftWingTurbulentAirFlowSensorAlarm);
        assertEquals(true, PrimaryFlightDisplay.instance.isRightWingTurbulentAirFlowSensorAlarm);

        //TCAS
        assertEquals(true, PrimaryFlightDisplay.instance.isTCASAlarm);
    }

    @Test
    public void descent() {
        cockpit.descent();
        //AirflowSensor
        assertEquals(645, PrimaryFlightDisplay.instance.bodyAirflowSensorAirPressure);
        assertEquals(645, PrimaryFlightDisplay.instance.leftWingAirflowSensorAirPressure);
        assertEquals(645, PrimaryFlightDisplay.instance.rightWingAirflowSensorAirPressure);
        assertEquals(true, PrimaryFlightDisplay.instance.isBodyAirflowSensorAlarm);
        assertEquals(true, PrimaryFlightDisplay.instance.isLeftWingAirflowSensorAlarm);
        assertEquals(true, PrimaryFlightDisplay.instance.isRightWingAirflowSensorAlarm);

        //TurbulentAirFlowSensor
        assertEquals(true, PrimaryFlightDisplay.instance.isBodyTurbulentAirFlowSensorAlarm);
        assertEquals(true, PrimaryFlightDisplay.instance.isLeftWingTurbulentAirFlowSensorAlarm);
        assertEquals(true, PrimaryFlightDisplay.instance.isRightWingTurbulentAirFlowSensorAlarm);

        //TCAS
        assertEquals(true, PrimaryFlightDisplay.instance.isTCASAlarm);
    }

    @Test
    public void landing() {
        cockpit.landing();
        //AirflowSensor
        assertEquals(645, PrimaryFlightDisplay.instance.bodyAirflowSensorAirPressure);
        assertEquals(645, PrimaryFlightDisplay.instance.leftWingAirflowSensorAirPressure);
        assertEquals(645, PrimaryFlightDisplay.instance.rightWingAirflowSensorAirPressure);
        assertEquals(true, PrimaryFlightDisplay.instance.isBodyAirflowSensorAlarm);
        assertEquals(true, PrimaryFlightDisplay.instance.isLeftWingAirflowSensorAlarm);
        assertEquals(true, PrimaryFlightDisplay.instance.isRightWingAirflowSensorAlarm);

        //TurbulentAirFlowSensor
        assertEquals(true, PrimaryFlightDisplay.instance.isBodyTurbulentAirFlowSensorAlarm);
        assertEquals(true, PrimaryFlightDisplay.instance.isLeftWingTurbulentAirFlowSensorAlarm);
        assertEquals(true, PrimaryFlightDisplay.instance.isRightWingTurbulentAirFlowSensorAlarm);

        //TCAS
        assertEquals(true, PrimaryFlightDisplay.instance.isTCASAlarm);
    }

    @Test
    public void shutdown() {
        cockpit.shutdown();
        //Camera
        assertEquals(false, PrimaryFlightDisplay.instance.isCameraOn);

        //GPS
        assertEquals(false, PrimaryFlightDisplay.instance.isGPSOn);

        //SatCom
        assertEquals(false, PrimaryFlightDisplay.instance.isSatComConnected);

        //VHF
        assertEquals(false, PrimaryFlightDisplay.instance.isVHFOn);

        //RadarAltimeter
        assertEquals(false, PrimaryFlightDisplay.instance.isRadarAltimeterOn);

        //TCAS
        assertEquals(false, PrimaryFlightDisplay.instance.isTCASOn);
        assertEquals(false, PrimaryFlightDisplay.instance.isTCASConnected);

        //Radar
        assertEquals(false, PrimaryFlightDisplay.instance.isRadarOn);
    }

    @After
    public void logEngineClose() {
        LogEngine.instance.close();
    }
    */
}