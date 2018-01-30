package section;

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

import java.lang.reflect.Method;
import java.util.ArrayList;

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
        cameras = new ArrayList<>();
        for (int cameraIndex = 0; cameraIndex < 2; cameraIndex++)
            cameras.add(CameraFactory.build());
        // Factory magic 2
        gPSs = new ArrayList<>();
        for (int gpsIndex = 0; gpsIndex < 2; gpsIndex++)
            gPSs.add(GPSFactory.build());
        // Factory magic 2
        radars = new ArrayList<>();
        for (int radarIndex = 0; radarIndex < 2; radarIndex++)
            radars.add(RadarFactory.build());
        // Factory magic 2
        satComs = new ArrayList<>();
        for (int satComIndex = 0; satComIndex < 2; satComIndex++)
            satComs.add(SatComFactory.build());
        // Factory magic 2
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

    @Subscribe
    public void recieve(AirflowSensorAlarm airflowSensorAlarm) {
        LogEngine.instance.write("+ Body.receive(" + airflowSensorAlarm + ")");
        try {
            for (int i = 0; i < airflowSensors.size(); i++) {
                Method alarmMethod = airflowSensors.get(i).getClass().getDeclaredMethod("alarm", int.class);
                LogEngine.instance.write("airflowSensorAlarmMethod = " + alarmMethod);

                boolean alarmResult = (boolean) alarmMethod.invoke(airflowSensors.get(i), airflowSensorAlarm.getThreshhold());
                LogEngine.instance.write(airflowSensorAlarm.getPhase() + " : isAlarm" + alarmResult);
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

//                PrimaryFlightDisplay.instance.isWeatherRadarOn = isWeatherRadarOn;
//                FlightRecorder.instance.insert(this.getClass().getSimpleName(),weatherRadarOn.getPhase() + " : WeatherRadar (isOn) = " + isWeatherRadarOn);

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

//                PrimaryFlightDisplay.instance.isWeatherRadarOn = isWeatherRadarOn;
//                FlightRecorder.instance.insert(this.getClass().getSimpleName(),weatherRadarOn.getPhase() + " : WeatherRadar (isOn) = " + isWeatherRadarOn);

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

//                PrimaryFlightDisplay.instance.isWeatherRadarOn = isWeatherRadarOn;
//                FlightRecorder.instance.insert(this.getClass().getSimpleName(),weatherRadarOn.getPhase() + " : WeatherRadar (isOn) = " + isWeatherRadarOn);

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

//                PrimaryFlightDisplay.instance.isWeatherRadarOn = isWeatherRadarOn;
//                FlightRecorder.instance.insert(this.getClass().getSimpleName(),weatherRadarOn.getPhase() + " : WeatherRadar (isOn) = " + isWeatherRadarOn);

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

//                PrimaryFlightDisplay.instance.isWeatherRadarOn = isWeatherRadarOn;
//                FlightRecorder.instance.insert(this.getClass().getSimpleName(),weatherRadarOn.getPhase() + " : WeatherRadar (isOn) = " + isWeatherRadarOn);

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

//                PrimaryFlightDisplay.instance.isWeatherRadarOn = isWeatherRadarOn;
//                FlightRecorder.instance.insert(this.getClass().getSimpleName(),weatherRadarOn.getPhase() + " : WeatherRadar (isOn) = " + isWeatherRadarOn);

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

//                PrimaryFlightDisplay.instance.isWeatherRadarOn = isWeatherRadarOn;
//                FlightRecorder.instance.insert(this.getClass().getSimpleName(),weatherRadarOn.getPhase() + " : WeatherRadar (isOn) = " + isWeatherRadarOn);

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

//                PrimaryFlightDisplay.instance.isWeatherRadarOn = isWeatherRadarOn;
//                FlightRecorder.instance.insert(this.getClass().getSimpleName(),weatherRadarOn.getPhase() + " : WeatherRadar (isOn) = " + isWeatherRadarOn);

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

//                PrimaryFlightDisplay.instance.isWeatherRadarOn = isWeatherRadarOn;
//                FlightRecorder.instance.insert(this.getClass().getSimpleName(),weatherRadarOn.getPhase() + " : WeatherRadar (isOn) = " + isWeatherRadarOn);

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

//                PrimaryFlightDisplay.instance.isWeatherRadarOn = isWeatherRadarOn;
//                FlightRecorder.instance.insert(this.getClass().getSimpleName(),weatherRadarOn.getPhase() + " : WeatherRadar (isOn) = " + isWeatherRadarOn);

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
                Method turbulentAirFlowSensorMeasureMethod = turbulentAirFlowSensors.get(momSensor).getClass().getDeclaredMethod("measure", int.class);
                LogEngine.instance.write("turbulentAirFlowSensorMeasureMethod = " + turbulentAirFlowSensorMeasureMethod);

                int measuredValue = (int) turbulentAirFlowSensorMeasureMethod.invoke(turbulentAirFlowSensors.get(momSensor), turbulentAirFlowSensorMeasure.getAirFlow());
                LogEngine.instance.write(turbulentAirFlowSensorMeasure.getPhase() + " : turbulentAirFlowSensorMeasure = " + measuredValue);

//                PrimaryFlightDisplay.instance.isWeatherRadarOn = isWeatherRadarOn;
//                FlightRecorder.instance.insert(this.getClass().getSimpleName(),weatherRadarOn.getPhase() + " : WeatherRadar (isOn) = " + isWeatherRadarOn);

                LogEngine.instance.write("+");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // please add here
}