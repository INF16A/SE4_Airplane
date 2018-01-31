package test;

import base.Airplane;
import base.Cockpit;
import base.PrimaryFlightDisplay;
import logging.LogEngine;
import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.assertEquals;
//Primary Flight Display

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProcedureTest {
    private Airplane airplane;
    private Cockpit cockpit;

    @Before
    public void init() {
        LogEngine.instance.init();

        airplane = new Airplane();
        airplane.build();

        cockpit = new Cockpit(airplane);
    }

    @Test
    public void setup() {
        //immer für alle Testen?!
        //DroopNose
        Assert.assertNotNull(airplane.getLeftWing().getDroopNosePorts());
        assertEquals(2,airplane.getLeftWing().getDroopNosePorts().size());
        Assert.assertNotNull(airplane.getRightWing().getDroopNosePorts());
        assertEquals(2,airplane.getRightWing().getDroopNosePorts().size());
        assertEquals(0, PrimaryFlightDisplay.instance.leftWingDroopNoseDegree);
        assertEquals(0, PrimaryFlightDisplay.instance.rightWingDroopNoseDegree);

        //Elevator
        Assert.assertNotNull(airplane.getBody().getElevatorPorts());
        assertEquals(4,airplane.getBody().getElevatorPorts().size());
        assertEquals(0, PrimaryFlightDisplay.instance.elevatorDegree);

        //Flap
        Assert.assertNotNull(airplane.getLeftWing().getFlapPorts());
        assertEquals(2,airplane.getLeftWing().getFlapPorts().size());
        Assert.assertNotNull(airplane.getRightWing().getFlapPorts());
        assertEquals(2,airplane.getRightWing().getFlapPorts().size());
        assertEquals(0, PrimaryFlightDisplay.instance.leftWingFlapDegree);
        assertEquals(0, PrimaryFlightDisplay.instance.rightWingFlapDegree);

        //Slat
        Assert.assertNotNull(airplane.getLeftWing().getSlatPorts());
        assertEquals(6,airplane.getLeftWing().getSlatPorts().size());
        Assert.assertNotNull(airplane.getRightWing().getSlatPorts());
        assertEquals(6,airplane.getRightWing().getSlatPorts().size());
        assertEquals(0, PrimaryFlightDisplay.instance.leftWingSlatDegree);
        assertEquals(0, PrimaryFlightDisplay.instance.rightWingSlatDegree);

        //LeftAileron
        Assert.assertNotNull(airplane.getLeftWing().getLeftAileronPorts());
        assertEquals(3,airplane.getLeftWing().getLeftAileronPorts().size());
        Assert.assertNotNull(airplane.getRightWing().getLeftAileronPorts());
        assertEquals(3,airplane.getRightWing().getLeftAileronPorts().size());
        assertEquals(0, PrimaryFlightDisplay.instance.leftWingLeftAileronDegree);
        assertEquals(0, PrimaryFlightDisplay.instance.rightWingLeftAileronDegree);

        //RightAileron
        Assert.assertNotNull(airplane.getLeftWing().getRightAileronPorts());
        assertEquals(3,airplane.getLeftWing().getRightAileronPorts().size());
        Assert.assertNotNull(airplane.getRightWing().getRightAileronPorts());
        assertEquals(3,airplane.getRightWing().getRightAileronPorts().size());
        assertEquals(0, PrimaryFlightDisplay.instance.leftWingRightAileronDegree);
        assertEquals(0, PrimaryFlightDisplay.instance.rightWingRightAileronDegree);

        //Rudder
        Assert.assertNotNull(airplane.getBody().getRudderPorts());
        assertEquals(2,airplane.getBody().getRudderPorts().size());
        assertEquals(0, PrimaryFlightDisplay.instance.rudderDegree);

        //Spoiler
        Assert.assertNotNull(airplane.getLeftWing().getSpoilerPorts());
        assertEquals(8,airplane.getLeftWing().getSpoilerPorts().size());
        Assert.assertNotNull(airplane.getRightWing().getSpoilerPorts());
        assertEquals(8,airplane.getRightWing().getSpoilerPorts().size());
        assertEquals(0, PrimaryFlightDisplay.instance.leftWingSpoilerDegree);
        assertEquals(0, PrimaryFlightDisplay.instance.rightWingSpoilerDegree);

        //IAPU
        Assert.assertNotNull(airplane.getBody().getIAPUPorts());
        assertEquals(1,airplane.getBody().getIAPUPorts().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isIAPUStarted);
        assertEquals(0, PrimaryFlightDisplay.instance.iAPURpm);

        //Engine
        Assert.assertNotNull(airplane.getLeftWing().getEnginePorts());
        assertEquals(2,airplane.getLeftWing().getEnginePorts().size());
        Assert.assertNotNull(airplane.getRightWing().getEnginePorts());
        assertEquals(2,airplane.getRightWing().getEnginePorts().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isLeftWingStarted);
        assertEquals(0, PrimaryFlightDisplay.instance.leftWingRpm);
        assertEquals(false, PrimaryFlightDisplay.instance.isLeftWingFire);
        assertEquals(false, PrimaryFlightDisplay.instance.isRightWingStarted);
        assertEquals(0, PrimaryFlightDisplay.instance.rightWingRpm);
        assertEquals(false, PrimaryFlightDisplay.instance.isRightWingFire);

        //Gear
        Assert.assertNotNull(airplane.getBody().getGearPorts());
        assertEquals(3,airplane.getBody().getGearPorts().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isDown);

        //HydraulicPump
        Assert.assertNotNull(airplane.getBody().getHydraulicPumpPorts());
        assertEquals(6,airplane.getBody().getHydraulicPumpPorts().size());
        Assert.assertNotNull(airplane.getLeftWing().getHydraulicPumpPorts());
        assertEquals(4,airplane.getLeftWing().getHydraulicPumpPorts().size());
        Assert.assertNotNull(airplane.getRightWing().getHydraulicPumpPorts());
        assertEquals(4,airplane.getRightWing().getHydraulicPumpPorts().size());
        assertEquals(0, PrimaryFlightDisplay.instance.leftWingHydraulicPumpAmoumt);
        assertEquals(0, PrimaryFlightDisplay.instance.rightWingHydraulicPumpAmoumt);
        assertEquals(0, PrimaryFlightDisplay.instance.bodyHydraulicPumpAmoumt);

        //BulkCargoDoor
        Assert.assertNotNull(airplane.getBody().getBulkCargoDoorPorts());
        assertEquals(2,airplane.getBody().getBulkCargoDoorPorts().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isBulkCargoDoorClosed);
        assertEquals(false, PrimaryFlightDisplay.instance.isBulkCargoDoorLocked);

        //CrewDoor
        Assert.assertNotNull(airplane.getBody().getCrewDoorPorts());
        assertEquals(2,airplane.getBody().getCrewDoorPorts().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isCrewDoorClosed);
        assertEquals(false, PrimaryFlightDisplay.instance.isCrewDoorLocked);

        //EmergencyExitDoor
        Assert.assertNotNull(airplane.getBody().getEmergencyExitDoorPorts());
        assertEquals(14,airplane.getBody().getEmergencyExitDoorPorts().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isEmergencyExitDoorClosed);
        assertEquals(false, PrimaryFlightDisplay.instance.isEmergencyExitDoorLocked);
        assertEquals(false, PrimaryFlightDisplay.instance.isEmergencyExitDoorEscapeSlideActivated);

        //GearDoor
        Assert.assertNotNull(airplane.getBody().getGearDoorPorts());
        assertEquals(6,airplane.getBody().getGearDoorPorts().size());
        assertEquals(false, PrimaryFlightDisplay.instance.isGearDoorClosed);
        assertEquals(false, PrimaryFlightDisplay.instance.isGearDoorLocked);

        //APUOilTank
        Assert.assertNotNull(airplane.getBody().getAPUOilTankPorts());
        assertEquals(2,airplane.getBody().getAPUOilTankPorts().size());
        assertEquals(0, PrimaryFlightDisplay.instance.aPUOilTankLevel);

        //Battery
        Assert.assertNotNull(airplane.getBody().getBatteryPorts());
        assertEquals(24,airplane.getBody().getBatteryPorts().size());
        assertEquals(0, PrimaryFlightDisplay.instance.batteryPercentage);

        //EngineOilTank
        Assert.assertNotNull(airplane.getLeftWing().getEngineOilTankPorts());
        assertEquals(4,airplane.getLeftWing().getEngineOilTankPorts().size());
        Assert.assertNotNull(airplane.getRightWing().getEngineOilTankPorts());
        assertEquals(4,airplane.getRightWing().getEngineOilTankPorts().size());
        assertEquals(0, PrimaryFlightDisplay.instance.leftWingEngineOilTankLevel);
        assertEquals(0, PrimaryFlightDisplay.instance.rightWingEngineOilTankLevel);

        //FuelTank
        Assert.assertNotNull(airplane.getLeftWing().getFuelTankPorts());
        assertEquals(3,airplane.getLeftWing().getFuelTankPorts().size());
        Assert.assertNotNull(airplane.getRightWing().getFuelTankPorts());
        assertEquals(3,airplane.getRightWing().getFuelTankPorts().size());
        assertEquals(1000, PrimaryFlightDisplay.instance.leftWingFuelTankAmount);
        assertEquals(1000, PrimaryFlightDisplay.instance.rightWingFuelTankAmount);

        //NitrogenBottle
        Assert.assertNotNull(airplane.getBody().getNitrogenBottlePorts());
        assertEquals(6,airplane.getBody().getNitrogenBottlePorts().size());
        assertEquals(250, PrimaryFlightDisplay.instance.nitrogenBottleAmount);

        //OxygenBottle
        Assert.assertNotNull(airplane.getBody().getOxygenBottlePorts());
        assertEquals(10,airplane.getBody().getOxygenBottlePorts().size());
        assertEquals(100, PrimaryFlightDisplay.instance.oxygenBottleAmount);

        //PotableWaterTank
        Assert.assertNotNull(airplane.getBody().getPotableWaterTankPorts());
        assertEquals(8,airplane.getBody().getPotableWaterTankPorts().size());
        assertEquals(1000, PrimaryFlightDisplay.instance.potableWaterTankAmount);
        assertEquals(false, PrimaryFlightDisplay.instance.isPotableWaterTankLocked);

        //WasteWaterTank
        Assert.assertNotNull(airplane.getBody().getWasteWaterTankPorts());
        assertEquals(4,airplane.getBody().getWasteWaterTankPorts().size());
        assertEquals(1000, PrimaryFlightDisplay.instance.wasteWaterTankCapacity);
        assertEquals(false, PrimaryFlightDisplay.instance.isWasteWaterTankLocked);

        //FireExtinguisher
        Assert.assertNotNull(airplane.getBody().getFireExtinguisherPorts());
        assertEquals(14,airplane.getBody().getFireExtinguisherPorts().size());
        assertEquals(100, PrimaryFlightDisplay.instance.fireExtinguisherPercentage);

        //DeIcingSystem
        Assert.assertNotNull(airplane.getBody().getDeIcingSystemPorts());
        assertEquals(2,airplane.getBody().getDeIcingSystemPorts().size());
        Assert.assertNotNull(airplane.getLeftWing().getDeIcingSystemPorts());
        assertEquals(2,airplane.getLeftWing().getDeIcingSystemPorts().size());
        Assert.assertNotNull(airplane.getRightWing().getDeIcingSystemPorts());
        assertEquals(2,airplane.getRightWing().getDeIcingSystemPorts().size());
        assertEquals(1000, PrimaryFlightDisplay.instance.bodyDeIcingSystemAmount);
        assertEquals(false, PrimaryFlightDisplay.instance.isBodyDeIcingSystemActivated);
        assertEquals(1000, PrimaryFlightDisplay.instance.leftWingDeIcingSystemAmount);
        assertEquals(false, PrimaryFlightDisplay.instance.isLeftDeIcingSystemActivated);
        assertEquals(1000, PrimaryFlightDisplay.instance.rightWingDeIcingSystemAmount);
        assertEquals(false, PrimaryFlightDisplay.instance.isRightDeIcingSystemActivated);

        //FirstClassSeat
        Assert.assertNotNull(airplane.getBody().getFirstClassSeatPorts());
        assertEquals(16,airplane.getBody().getFirstClassSeatPorts().size());
        assertEquals(0, PrimaryFlightDisplay.instance.firstClassSeatLevel);
        assertEquals(false, PrimaryFlightDisplay.instance.isFirstClassSeatSmokingSignOn);
        assertEquals(false, PrimaryFlightDisplay.instance.isFirstClassSeatSeatBeltSignOn);

        //BusinessClassSeat
        Assert.assertNotNull(airplane.getBody().getBusinessClassSeatPorts());
        assertEquals(72,airplane.getBody().getBusinessClassSeatPorts().size());
        assertEquals(0, PrimaryFlightDisplay.instance.businessClassSeatLevel);
        assertEquals(false, PrimaryFlightDisplay.instance.isBusinessClassSeatSmokingSignOn);
        assertEquals(false, PrimaryFlightDisplay.instance.isBusinessClassSeatSeatBeltSignOn);

        //TouristClassSeat
        Assert.assertNotNull(airplane.getBody().getTouristClassSeatPorts());
        assertEquals(480,airplane.getBody().getTouristClassSeatPorts().size());
        assertEquals(0, PrimaryFlightDisplay.instance.touristClassSeatLevel);
        assertEquals(false, PrimaryFlightDisplay.instance.isTouristClassSeatSmokingSignOn);
        assertEquals(false, PrimaryFlightDisplay.instance.isTouristClassSeatBeltSignOn);

        //CrewSeat
        Assert.assertNotNull(airplane.getBody().getCrewSeatPorts());
        assertEquals(14,airplane.getBody().getCrewSeatPorts().size());

        //ExhaustGasTemperatureSensor
        Assert.assertNotNull(airplane.getLeftWing().getExhaustGasTemperatureSensorPorts());
        assertEquals(4,airplane.getLeftWing().getExhaustGasTemperatureSensorPorts().size());
        Assert.assertNotNull(airplane.getRightWing().getExhaustGasTemperatureSensorPorts());
        assertEquals(4,airplane.getRightWing().getExhaustGasTemperatureSensorPorts().size());
        assertEquals(0, PrimaryFlightDisplay.instance.leftWingExhaustGasTemperatureSensorTemperature);
        assertEquals(false, PrimaryFlightDisplay.instance.isLeftExhaustGasTemperatureSensorAlarmMajor);
        assertEquals(false, PrimaryFlightDisplay.instance.isLeftExhaustGasTemperatureSensorAlarmCritical);
        assertEquals(0, PrimaryFlightDisplay.instance.rightWingExhaustGasTemperatureSensorTemperature);
        assertEquals(false, PrimaryFlightDisplay.instance.isRightExhaustGasTemperatureSensorAlarmMajor);
        assertEquals(false, PrimaryFlightDisplay.instance.isRightExhaustGasTemperatureSensorAlarmCritical);

        //FuelFlowSensor
        Assert.assertNotNull(airplane.getLeftWing().getFuelFlowSensorPorts());
        assertEquals(6,airplane.getLeftWing().getFuelFlowSensorPorts().size());
        Assert.assertNotNull(airplane.getRightWing().getFuelFlowSensorPorts());
        assertEquals(6,airplane.getRightWing().getFuelFlowSensorPorts().size());
        assertEquals(0, PrimaryFlightDisplay.instance.leftWingFuelFlowSensorFuelFlow);
        assertEquals(0, PrimaryFlightDisplay.instance.rightWingFuelFlowSensorFuelFlow);



        // assertNotNull auf AllePorts
        /* schauen ob alles vorhanden ist
        vollgetankt

         */
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