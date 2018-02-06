package test;

import base.Airplane;
import base.Cockpit;
import base.PrimaryFlightDisplay;
import logging.LogEngine;
import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProcedureTest {
    private static Airplane airplane;
    private static Cockpit cockpit;

    @BeforeClass
    public static void init() {
        LogEngine.instance.init();

        airplane = new Airplane();
        airplane.build();

        cockpit = new Cockpit(airplane);
    }

    @Test
    public void setup() {
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
        //assertEquals(2,airplane.getBody().getBulkCargoDoors().size()); // TODO: FIX
        assertEquals(false, PrimaryFlightDisplay.instance.isBulkCargoDoorClosed);
        assertEquals(false, PrimaryFlightDisplay.instance.isBulkCargoDoorLocked);
        //CrewDoor
        Assert.assertNotNull(airplane.getBody().getCrewDoors());
        //assertEquals(2,airplane.getBody().getCrewDoors().size()); // TODO: FIX
        assertEquals(false, PrimaryFlightDisplay.instance.isCrewDoorClosed);
        assertEquals(false, PrimaryFlightDisplay.instance.isCrewDoorLocked);
        //EmergencyExitDoor
        Assert.assertNotNull(airplane.getBody().getEmergencyExitDoors());
        //assertEquals(14,airplane.getBody().getEmergencyExitDoors().size()); // TODO: FIX
        assertEquals(false, PrimaryFlightDisplay.instance.isEmergencyExitDoorClosed);
        assertEquals(false, PrimaryFlightDisplay.instance.isEmergencyExitDoorLocked);
        assertEquals(false, PrimaryFlightDisplay.instance.isEmergencyExitDoorEscapeSlideActivated);
        //GearDoor
        Assert.assertNotNull(airplane.getBody().getGearDoors());
        //assertEquals(6,airplane.getBody().getGearDoors().size()); // TODO: FIX
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
        //assertEquals(1000, PrimaryFlightDisplay.instance.leftWingFuelTankAmount);  // TODO: FIX
        //assertEquals(1000, PrimaryFlightDisplay.instance.rightWingFuelTankAmount); // TODO: FIX
        //NitrogenBottle
        Assert.assertNotNull(airplane.getBody().getNitrogenBottles());
        assertEquals(6, airplane.getBody().getNitrogenBottles().size());
        //assertEquals(250, PrimaryFlightDisplay.instance.nitrogenBottleAmount); // TODO: FIX
        //OxygenBottle
        Assert.assertNotNull(airplane.getBody().getOxygenBottles());
        assertEquals(10, airplane.getBody().getOxygenBottles().size());
        //assertEquals(100, PrimaryFlightDisplay.instance.oxygenBottleAmount); // TODO: FIX
        //PotableWaterTank
        Assert.assertNotNull(airplane.getBody().getPotableWaterTanks());
        assertEquals(8, airplane.getBody().getPotableWaterTanks().size());
        //assertEquals(1000, PrimaryFlightDisplay.instance.potableWaterTankAmount); // TODO: FIX
        assertEquals(false, PrimaryFlightDisplay.instance.isPotableWaterTankLocked);
        //WasteWaterTank
        Assert.assertNotNull(airplane.getBody().getWasteWaterTanks());
        assertEquals(4, airplane.getBody().getWasteWaterTanks().size());
        //assertEquals(1000, PrimaryFlightDisplay.instance.wasteWaterTankCapacity); // TODO: FIX
        assertEquals(false, PrimaryFlightDisplay.instance.isWasteWaterTankLocked);
        //FireExtinguisher
        Assert.assertNotNull(airplane.getBody().getFireExtinguishers());
        assertEquals(14, airplane.getBody().getFireExtinguishers().size());
        //assertEquals(100, PrimaryFlightDisplay.instance.fireExtinguisherPercentage); // TODO: FIX
        //DeIcingSystem
        Assert.assertNotNull(airplane.getBody().getDeIcingSystems());
        assertEquals(2, airplane.getBody().getDeIcingSystems().size());
        Assert.assertNotNull(airplane.getLeftWing().getDeIcingSystems());
        assertEquals(2, airplane.getLeftWing().getDeIcingSystems().size());
        Assert.assertNotNull(airplane.getRightWing().getDeIcingSystems());
        assertEquals(2, airplane.getRightWing().getDeIcingSystems().size());
        //assertEquals(1000, PrimaryFlightDisplay.instance.bodyDeIcingSystemAmount); // TODO: FIX
        assertEquals(false, PrimaryFlightDisplay.instance.isBodyDeIcingSystemActivated);
        //assertEquals(1000, PrimaryFlightDisplay.instance.leftWingDeIcingSystemAmount); // TODO: FIX
        assertEquals(false, PrimaryFlightDisplay.instance.isLeftDeIcingSystemActivated);
        //assertEquals(1000, PrimaryFlightDisplay.instance.rightWingDeIcingSystemAmount); // TODO: FIX
        assertEquals(false, PrimaryFlightDisplay.instance.isRightDeIcingSystemActivated);
        //FirstClassSeat
        Assert.assertNotNull(airplane.getBody().getFirstClassSeats());
        //assertEquals(16,airplane.getBody().getFirstClassSeats().size()); // TODO: FIX
        assertEquals(0, PrimaryFlightDisplay.instance.firstClassSeatLevel);
        assertEquals(false, PrimaryFlightDisplay.instance.isFirstClassSeatSmokingSignOn);
        assertEquals(false, PrimaryFlightDisplay.instance.isFirstClassSeatSeatBeltSignOn);
        //BusinessClassSeat
        Assert.assertNotNull(airplane.getBody().getBusinessClassSeats());
        //assertEquals(72,airplane.getBody().getBusinessClassSeats().size()); // TODO: FIX
        assertEquals(0, PrimaryFlightDisplay.instance.businessClassSeatLevel);
        assertEquals(false, PrimaryFlightDisplay.instance.isBusinessClassSeatSmokingSignOn);
        assertEquals(false, PrimaryFlightDisplay.instance.isBusinessClassSeatSeatBeltSignOn);
        //TouristClassSeat
        Assert.assertNotNull(airplane.getBody().getTouristClassSeats());
        //assertEquals(480,airplane.getBody().getTouristClassSeats().size()); // TODO: FIX
        assertEquals(0, PrimaryFlightDisplay.instance.touristClassSeatLevel);
        assertEquals(false, PrimaryFlightDisplay.instance.isTouristClassSeatSmokingSignOn);
        assertEquals(false, PrimaryFlightDisplay.instance.isTouristClassSeatBeltSignOn);
        //CrewSeat
        Assert.assertNotNull(airplane.getBody().getCrewSeats());
        //assertEquals(14,airplane.getBody().getCrewSeats().size()); // TODO: FIX
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
    }

    @Test
    public void startUp() {
        cockpit.startup();
    }

    @Test
    public void taxi() {
        cockpit.taxi();
    }

    @Test
    public void takeOff() {
        cockpit.takeoff();
    }

    @Test
    public void climbing() {
        cockpit.climbing();
    }

    @Test
    public void rightTurn() {
        cockpit.rightTurn();
    }

    @Test
    public void leftTurn() {
        cockpit.leftTurn();
    }

    @Test
    public void descent() {
        cockpit.descent();
    }

    @Test
    public void landing() {
        cockpit.landing();
    }

    @Test
    public void shutdown() {
        cockpit.shutdown();
    }

    @After
    public void logEngineClose() {
        LogEngine.instance.close();
    }
}