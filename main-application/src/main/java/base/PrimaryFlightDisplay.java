package base;

import java.util.ArrayList;

public enum PrimaryFlightDisplay {
    instance;

    // please add value(s)

    //DroopNose
    public int leftWingDroopNoseDegree;
    public int rightWingDroopNoseDegree;

    //Elevator
    public int elevatorDegree;

    //Flap
    public int leftWingFlapDegree;
    public int rightWingFlapDegree;

    //Slat
    public int leftWingSlatDegree;
    public int rightWingSlatDegree;

    //LeftAileron
    public int leftWingLeftAileronDegree;
    public int rightWingLeftAileronDegree;

    //RightAileron
    public int leftWingRightAileronDegree;
    public int rightWingRightAileronDegree;

    //Rudder
    //Rudder
    public int rudderDegree;

    //Spoiler
    public int leftWingSpoilerDegree;
    public int rightWingSpoilerDegree;

    //IAPU
    public boolean isIAPUStarted;
    public int iAPURpm;

    //Engine
    public boolean isLeftWingStarted;
    public int leftWingRpm;
    public boolean isLeftWingFire;
    public boolean isRightWingStarted;
    public int rightWingRpm;
    public boolean isRightWingFire;

    //Gear
    public boolean isDown;

    //HydraulicPump
    public int leftWingHydraulicPumpAmoumt;
    public int rightWingHydraulicPumpAmoumt;
    public int bodyHydraulicPumpAmoumt;

    //BulkCargoDoor
    public boolean isBulkCargoDoorClosed;
    public boolean isBulkCargoDoorLocked;

    //CrewDoor
    public boolean isCrewDoorClosed;
    public boolean isCrewDoorLocked;

    //EmergencyExitDoor
    public boolean isEmergencyExitDoorClosed;
    public boolean isEmergencyExitDoorLocked;
    public boolean isEmergencyExitDoorEscapeSlideActivated;

    //GearDoor
    public boolean isGearDoorClosed;
    public boolean isGearDoorLocked;

    //APUOilTank
    public int aPUOilTankLevel;

    //Battery
    public int batteryPercentage;

    //EngineOilTank
    public int leftWingEngineOilTankLevel;
    public int rightWingEngineOilTankLevel;

    //FuelTank
    public int leftWingFuelTankAmount;
    public int rightWingFuelTankAmount;

    //NitrogenBottle
    public int nitrogenBottleAmount;

    //OxygenBottle
    public int oxygenBottleAmount;

    //PotableWaterTank
    public int potableWaterTankAmount;
    public boolean isPotableWaterTankLocked;

    //WasteWaterTank
    public int wasteWaterTankCapacity;
    public boolean isWasteWaterTankLocked;

    //FireExtinguisher
    public int fireExtinguisherPercentage;

    //DeIcingSystem
    public int bodyDeIcingSystemAmount;
    public boolean isBodyDeIcingSystemActivated;
    public int leftWingDeIcingSystemAmount;
    public boolean isLeftDeIcingSystemActivated;
    public int rightWingDeIcingSystemAmount;
    public boolean isRightDeIcingSystemActivated;

    //FirstClassSeat
    public int firstClassSeatLevel;
    public boolean isFirstClassSeatSmokingSignOn;
    public boolean isFirstClassSeatSeatBeltSignOn;

    //BusinessClassSeat
    public int businessClassSeatLevel;
    public boolean isBusinessClassSeatSmokingSignOn;
    public boolean isBusinessClassSeatSeatBeltSignOn;

    //TouristClassSeat
    public int touristClassSeatLevel;
    public boolean isTouristClassSeatSmokingSignOn;
    public boolean isTouristClassSeatBeltSignOn;

    //CrewSeat

    //ExhaustGasTemperatureSensor
    public int  leftWingExhaustGasTemperatureSensorTemperature;
    public boolean isLeftExhaustGasTemperatureSensorAlarmMajor;
    public boolean isLeftExhaustGasTemperatureSensorAlarmCritical;
    public int rightWingExhaustGasTemperatureSensorTemperature;
    public boolean isRightExhaustGasTemperatureSensorAlarmMajor;
    public boolean isRightExhaustGasTemperatureSensorAlarmCritical;

    //FuelFlowSensor
    public int leftWingFuelFlowSensorFuelFlow;
    public int rightWingFuelFlowSensorFuelFlow;

    //FuelSensor
    public boolean isLeftWingAlarmReserve;
    public boolean isLeftWingAlarmMajor;
    public boolean isLeftWingAlarmCritical;
    public boolean isRightWingAlarmReserve;
    public boolean isRightWingAlarmMajor;
    public boolean isRightWingAlarmCritical;

    //IceDetectorProbe
    public boolean isBodyIceDetectorProbeActivated;
    public boolean isBodyIceDetected;
    public boolean isLeftWingIceDetectorProbeActivated;
    public boolean isLeftIceDetected;
    public boolean isRightWingIceDetectorProbeActivated;
    public boolean isRightIceDetected;

    //FireDetector
    public boolean isBodyFireDetectorAlarm;
    public boolean isLeftWingFireDetectorAlarm;
    public boolean isRightWingFireDetectorAlarm;

    //OxygenSensor
    public boolean isBodyOxygenSensorAlarm;

    //SchockSensor
    public boolean isBodyShockSensorCalibrated;
    public boolean isLeftWingShockSensorCalibrated;
    public boolean isRightWingShockSensorCalibrated;
    public boolean isBodyhockSensorShockDetected;
    public boolean isLeftWingSensorShockDetected;
    public boolean isRightWingSensorShockDetected;

    //StallingSensor
    public boolean isBodyStallingSensorAlarm;
    public boolean isLeftWingStallingSensorAlarm;
    public boolean isRightWingStallingSensorAlarm;

    //TemperatureSensor
    public int bodyTemperatureSensortemperature;
    public int leftWingTemperatureSensortemperature;
    public int rightWingTemperatureSensortemperature;
    public boolean isBodyTemperatureSensorAlarm;
    public boolean isLeftWingTemperatureSensorAlarm;
    public boolean isRightWingTemperatureSensorAlarm;

    //AirflowSensor
    public int bodyAirflowSensorAirPressure;
    public int leftWingAirflowSensorAirPressure;
    public int rightWingAirflowSensorAirPressure;
    public boolean isBodyAirflowSensorAlarm;
    public boolean isLeftWingAirflowSensorAlarm;
    public boolean isRightWingAirflowSensorAlarm;

    //PitotTube
    public int pitotTubeVelocity;
    public boolean isPitotTubeCleaned;

    //RadarAltimeter
    public int radarAltimeterAltitude;
    public boolean isRadarAltimeterOn;

    //TCAS
    public int zCASAltitude;
    public boolean isTCASOn;
    public boolean isTCASConnected;
    public boolean isTCASAlarm;

    //TurbulentAirFlowSensor
    public boolean isBodyTurbulentAirFlowSensorAlarm;
    public boolean isLeftWingTurbulentAirFlowSensorAlarm;
    public boolean isRightWingTurbulentAirFlowSensorAlarm;

    //camera
    public boolean isCameraOn;
    public double cameraFactor;

    //GPS
    public boolean isGPSOn;

    //Radar
    public boolean isRadarOn;
    public boolean isAirspaceFree;

    //SatCom
    public boolean isSatComConnected;

    //VHF
    public boolean isVHFOn;

    //AntiCollisionLight
    public boolean isAntiCollisionLightOn;

    //CargoCompartmentLight
    public boolean isCargoCompartmentLightOn;

    //LandingLight
    public boolean isBodyLandingLightOn;
    public boolean isLeftWingLandingLightOn;
    public boolean isRightWingLandingLightOn;

    //LeftNavigationLight
    public boolean isLeftWingLeftNavigationLightOn;
    public boolean isRightWingLeftNavigationLightOn;

    //LogoLight
    public boolean isLogoLightOn;

    //RightNavigationLight
    public boolean isLeftWingRightNavigationLightOn;
    public boolean isRightWingRightNavigationLightOn;

    //TailNavigationLight
    public boolean isTailNavigationLightOn;

    //TaxiLight
    public boolean isTaxiLightOn;

    //TCASLight
    public boolean isTCASLightOn;

    //CargoSystem
    public boolean isCargoSystemLocked;
    public boolean isCargoSystemSecured;
    public double cargoSystemTotalWeightContainer;
    public double cargoSystemTotalWeightAirCargoPallet;
    public double cargoSystemTotalWeigth;

    //StowageNumberFive
    public int stowageNumberFiveNumberOfItems;
    public ArrayList<Double> stowageNumberFiveBaggageList;
    //public ArrayList<SpecialGood> stowageNumberFiveSpecialGoodList;

    //AirConditioning
    public boolean isAirConditioningOn;
    public int airConditioningTemperature;

    //Kitchen
    public boolean isKitchenLocked;
    public boolean isKitchenFilled;
   // public ArrayList<Trolley> kitchenTrolleyList;

    //Lavatory
    public boolean isLavatoryLocked;
    public boolean isLavatoryCleaned;

    //WasteSystem
    public String[] wasteSystemWaste;
    public boolean isWasteSystemOn;
    public boolean isWasteSystemCleaned;

    //WaterSystem
    public boolean isWaterSystemOn;
    public boolean isWaterSystemFilled;
    public boolean isWaterSystemCleaned;

    //EscapeSlide
    public boolean isEscapeSlideActivated;

    //CostOptimizer
    public boolean isCostOptimizerOn;
   // public ArrayList<CheckPoint> costOptimizerCheckPointList;
    public int costOptimizerCostIndex;

    //RouteManagement
    public boolean isRouteManagementOn;
    //public ArrayList<CheckPoint> routeManagementCheckPointList;
    public double routeManagementCostIndex;

    //SeatManagement
   // public ArrayList<Seat> seatManagementSeats;
    public int seatManagementNumberOfPassengersFirstClassAssigned;
    public int seatManagementNumberOfPassengersBusinessClassAssigned;
    public int seatManagementNumberOfPassengersEconomyClassAssigned;
}