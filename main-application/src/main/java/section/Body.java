package section;

import java.lang.reflect.Method;
import java.util.ArrayList;

import base.PrimaryFlightDisplay;
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
    private ArrayList<Object> firstClassSeatPorts;
    private ArrayList<Object> businessClassSeatPorts;
    private ArrayList<Object> touristClassSeatPorts;
    private ArrayList<Object> crewSeatPorts;
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
        firstClassSeatPorts = new ArrayList<>();
        for(int firstSeatIndex = 0; firstSeatIndex < 16; firstSeatIndex++)
			FirstClassSeatPorts.add(SeatFactory.buildFirstSeat());
        businessClassSeatPorts = new ArrayList<>();
        for(int businessSeatIndex = 0; businessSeatIndex < 72; businessSeatIndex++)
			BusinessClassSeatPorts.add(SeatFactory.buildBusinessSeat());
        touristClassSeatPorts = new ArrayList<>();
        for(int touristSeatIndex = 0; touristSeatIndex < 480; touristSeatIndex++)
			TouristClassSeatPorts.add(SeatFactory.buildTouristSeat());
        crewSeatPorts = new ArrayList<>();
        for (int crewSeatIndex = 0; crewSeatIndex < 14; crewSeatIndex++)
			CrewSeatPorts.add(SeatFactory.buildCrewSeat());


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

            // please add here
            //Seats
			for (int crewSeatIndex = 0; crewSeatIndex < 14; crewSeatIndex++){
				Method crewSeatVersionMethod = CrewSeatPorts.get(crewSeatIndex).getClass().getDeclaredMethod("version");
				String crewSeatVersion = (String)crewSeatVersionMethod.invoke(CrewSeatPorts.get(crewSeatIndex));
				LogEngine.instance.write("crewSeatPort: " + crewSeatPort.get(crewSeatIndex).hashCode() + " - " + crewSeatVersion);
			}
			for (int touristSeatIndex = 0; touristSeatIndex < 480; touristSeatIndex++){
				Method touristSeatVersionMethod = TouristSeatPorts.get(touristSeatIndex).getClass().getDeclaredMethod("version");
				String touristSeatVersion = (String)touristSeatVersionMethod.invoke(TouristSeatPorts.get(touristSeatIndex));
				LogEngine.instance.write("touristSeatPort: " + TouristSeatPort.get(touristSeatIndex).hashCode() + " - " + touristSeatVersion);
			}
			for (int businessSeatIndex = 0; businessSeatIndex < 72; businessSeatIndex++){
				Method businessSeatVersionMethod = BusinessSeatPorts.get(businessSeatIndex).getClass().getDeclaredMethod("version");
				String businessSeatVersion = (String)businessSeatVersionMethod.invoke(BusinessSeatPorts.get(businessSeatIndex));
				LogEngine.instance.write("businessSeatPort: " + businessSeatPort.get(businessSeatIndex).hashCode() + " - " + businessSeatVersion);
			}
			for (int firstSeatIndex = 0; firstSeatIndex < 16; firstSeatIndex++){
				Method firstSeatVersionMethod = FirstSeatPorts.get(firstSeatIndex).getClass().getDeclaredMethod("version");
				String firstSeatVersion = (String)firstSeatVersionMethod.invoke(FirstSeatPorts.get(firstSeatIndex));
				LogEngine.instance.write("firstSeatPort: " + FirstSeatPort.get(firstSeatIndex).hashCode() + " - " + firstSeatVersion);
			}
            //End of Seat

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

     public ArrayList<Object> getFirstClassSeatPorts()
    {
        return firstClassSeatPorts;
    }

    public ArrayList<Object> getBusinessClassSeatPorts()
    {
        return businessClassSeatPorts;
    }

    public ArrayList<Object> getTouristClassSeatPorts()
    {
        return touristClassSeatPorts;
    }

    public ArrayList<Object> getCrewSeatPorts()
    {
        return crewSeatPorts;
    }

	@Subscribe
    public void receive(SeatBeltSignOff seatBeltSignOff) {
        LogEngine.instance.write("+ Body.receive(" + seatBeltSignOff + ")");

        try {
			//CrewSeats
            for (int SeatBeltIndex = 0;SeatBeltIndex < 14;SeatBeltIndex++) {
                Method SeatBeltSignOffMethod = CrewSeatPorts.get(SeatBeltIndex).getClass().getDeclaredMethod("seatBeltOff");
                LogEngine.instance.write("seatBeltSignOffMethod = " + SeatBeltSignOffMethod);

                boolean isSeatBeltSignOff = (boolean)SeatBeltSignOffMethod.invoke(CrewSeatPorts.get(SeatBeltIndex));
                LogEngine.instance.write(seatBeltSignOff.getSeatBeltSign() + " : isSeatBeltSignOff = " + isSeatBeltSignOff);

                PrimaryFlightDisplay.instance.isSeatBeltSignOff = isSeatBeltSignOff;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),seatBeltSignOff.getSeatBeltSign() + " : SeatBeltSign (isOff) = " + isSeatBeltSignOff);

                LogEngine.instance.write("+");
            }
			
			//TouristClassSeats
			for (int SeatBeltIndex = 0;SeatBeltIndex < 480;SeatBeltIndex++) {
                Method SeatBeltSignOffMethod = TouristSeatPorts.get(SeatBeltIndex).getClass().getDeclaredMethod("seatBeltOff");
                LogEngine.instance.write("seatBeltSignOffMethod = " + SeatBeltSignOffMethod);

                boolean isSeatBeltSignOff = (boolean)SeatBeltSignOffMethod.invoke(TouristSeatPorts.get(SeatBeltIndex));
                LogEngine.instance.write(seatBeltSignOff.getSeatBeltSign() + " : isSeatBeltSignOff = " + isSeatBeltSignOff);

                PrimaryFlightDisplay.instance.isSeatBeltSignOff = isSeatBeltSignOff;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),seatBeltSignOff.getSeatBeltSign() + " : SeatBeltSign (isOff) = " + isSeatBeltSignOff);

                LogEngine.instance.write("+");
            }
			
			//BusinessClassSeats
			for (int SeatBeltIndex = 0;SeatBeltIndex < 72;SeatBeltIndex++) {
                Method SeatBeltSignOffMethod = BusinessSeatPorts.get(SeatBeltIndex).getClass().getDeclaredMethod("seatBeltOff");
                LogEngine.instance.write("seatBeltSignOffMethod = " + SeatBeltSignOffMethod);

                boolean isSeatBeltSignOff = (boolean)SeatBeltSignOffMethod.invoke(BusinessSeatPorts.get(SeatBeltIndex));
                LogEngine.instance.write(seatBeltSignOff.getSeatBeltSign() + " : isSeatBeltSignOff = " + isSeatBeltSignOff);

                PrimaryFlightDisplay.instance.isSeatBeltSignOff = isSeatBeltSignOff;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),seatBeltSignOff.getSeatBeltSign() + " : SeatBeltSign (isOff) = " + isSeatBeltSignOff);

                LogEngine.instance.write("+");
            }
			
			//FirstClassSeats
			for (int SeatBeltIndex = 0;SeatBeltIndex < 16;SeatBeltIndex++) {
                Method SeatBeltSignOffMethod = FirstSeatPorts.get(SeatBeltIndex).getClass().getDeclaredMethod("seatBeltOff");
                LogEngine.instance.write("seatBeltSignOffMethod = " + SeatBeltSignOffMethod);

                boolean isSeatBeltSignOff = (boolean)SeatBeltSignOffMethod.invoke(FirstSeatPorts.get(SeatBeltIndex));
                LogEngine.instance.write(seatBeltSignOff.getSeatBeltSign() + " : isSeatBeltSignOff = " + isSeatBeltSignOff);

                PrimaryFlightDisplay.instance.isSeatBeltSignOff = isSeatBeltSignOff;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),seatBeltSignOff.getSeatBeltSign() + " : SeatBeltSign (isOff) = " + isSeatBeltSignOff);

                LogEngine.instance.write("+");
            }
			
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
	
	@Subscribe
    public void receive(SeatBeltSignOn seatBeltSignOn) {
        LogEngine.instance.write("+ Body.receive(" + seatBeltSignOn + ")");

        try {
			//CrewSeats
            for (int SeatBeltIndex = 0;SeatBeltIndex < 14;SeatBeltIndex++) {
                Method SeatBeltSignOnMethod = CrewSeatPorts.get(SeatBeltIndex).getClass().getDeclaredMethod("seatBeltOn");
                LogEngine.instance.write("seatBeltSignOnMethod = " + SeatBeltSignOnMethod);

                boolean isSeatBeltSignOn = (boolean)SeatBeltSignOnMethod.invoke(CrewSeatPorts.get(SeatBeltIndex));
                LogEngine.instance.write(seatBeltSignOn.getSeatBeltSign() + " : isSeatBeltSignOn = " + isSeatBeltSignOn);

                PrimaryFlightDisplay.instance.isSeatBeltSignOn = isSeatBeltSignOn;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),seatBeltSignOn.getSeatBeltSign() + " : SeatBeltSign (isOn) = " + isSeatBeltSignOn);

                LogEngine.instance.write("+");
            }
			
			//TouristClassSeats
			for (int SeatBeltIndex = 0;SeatBeltIndex < 480;SeatBeltIndex++) {
                Method SeatBeltSignOnMethod = TouristSeatPorts.get(SeatBeltIndex).getClass().getDeclaredMethod("seatBeltOn");
                LogEngine.instance.write("seatBeltSignOnMethod = " + SeatBeltSignOnMethod);

                boolean isSeatBeltSignOn = (boolean)SeatBeltSignOnMethod.invoke(TouristSeatPorts.get(SeatBeltIndex));
                LogEngine.instance.write(seatBeltSignOn.getSeatBeltSign() + " : isSeatBeltSignOn = " + isSeatBeltSignOn);

                PrimaryFlightDisplay.instance.isSeatBeltSignOn = isSeatBeltSignO;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),seatBeltSignOn.getSeatBeltSign() + " : SeatBeltSign (isOn) = " + isSeatBeltSignOn);

                LogEngine.instance.write("+");
            }
			
			//BusinessClassSeats
			for (int SeatBeltIndex = 0;SeatBeltIndex < 72;SeatBeltIndex++) {
                Method SeatBeltSignOnMethod = BusinessSeatPorts.get(SeatBeltIndex).getClass().getDeclaredMethod("seatBeltOn");
                LogEngine.instance.write("seatBeltSignOnMethod = " + SeatBeltSignOnMethod);

                boolean isSeatBeltSignOn = (boolean)SeatBeltSignOnMethod.invoke(BusinessSeatPorts.get(SeatBeltIndex));
                LogEngine.instance.write(seatBeltSignOn.getSeatBeltSign() + " : isSeatBeltSignOn = " + isSeatBeltSignOn);

                PrimaryFlightDisplay.instance.isSeatBeltSignOn = isSeatBeltSignOn;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),seatBeltSignOn.getSeatBeltSign() + " : SeatBeltSign (isOn) = " + isSeatBeltSignOn);

                LogEngine.instance.write("+");
            }
			
			//FirstClassSeats
			for (int SeatBeltIndex = 0;SeatBeltIndex < 16;SeatBeltIndex++) {
                Method SeatBeltSignOnMethod = FirstSeatPorts.get(SeatBeltIndex).getClass().getDeclaredMethod("seatBeltOn");
                LogEngine.instance.write("seatBeltSignOnMethod = " + SeatBeltSignOnMethod);

                boolean isSeatBeltSignOn = (boolean)SeatBeltSignOnMethod.invoke(FirstSeatPorts.get(SeatBeltIndex));
                LogEngine.instance.write(seatBeltSignOn.getSeatBeltSign() + " : isSeatBeltSignOn = " + isSeatBeltSignOn);

                PrimaryFlightDisplay.instance.isSeatBeltSignOn = isSeatBeltSignOn;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),seatBeltSignOn.getSeatBeltSign() + " : SeatBeltSign (isOn) = " + isSeatBeltSignOn);

                LogEngine.instance.write("+");
            }
			
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }	
	
	@Subscribe
    public void receive(SmokingSignOff smokingSignOff) {
        LogEngine.instance.write("+ Body.receive(" + smokingSignOff + ")");

        try {
			//CrewSeats
            for (int SmokingSignIndex = 0;SmokingSignIndex < 14;SmokingSignIndex++) {
                Method SmokingSignOffMethod = CrewSeatPorts.get(SmokingSignIndex).getClass().getDeclaredMethod("smokingSignOff");
                LogEngine.instance.write("SmokingSignOffMethod = " + SeatBeltSignOffMethod);

                boolean isSmokingSignOff = (boolean)SmokingSignOffMethod.invoke(CrewSeatPorts.get(SmokingSignIndex));
                LogEngine.instance.write(smokingSignOff.getSmokingSign() + " : isSmokingSignOff = " + isSmokingSignOff);

                PrimaryFlightDisplay.instance.isSmokingSignOff = isSmokingSignOff;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),smokingSignOff.getSmokingSign() + " : SmokingSign (isOff) = " + isSmokingSignOff);

                LogEngine.instance.write("+");
            }
			
			//TouristClassSeats
			for (int SmokingSignIndex = 0;SmokingSignIndex < 480;SmokingSignIndex++) {
                Method SmokingSignOffMethod = TouristSeatPorts.get(SmokingSignIndex).getClass().getDeclaredMethod("smokingSignOff");
                LogEngine.instance.write("smokingSignOffMethod = " + SmokingSignOffMethod);

                boolean isSmokingSignOff = (boolean)SmokingSignOffMethod.invoke(TouristSeatPorts.get(SmokingSignIndex));
                LogEngine.instance.write(smokingSignOff.getSmokingSign() + " : isSmokingSignOff = " + isSmokingSignOff);

                PrimaryFlightDisplay.instance.isSmokingSignOff = isSmokingSignOff;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),smokingSignOff.getSmokingSign() + " : SmokingSign (isOff) = " + isSmokingSignOff);

                LogEngine.instance.write("+");
            }
			
			//BusinessClassSeats
			for (int SmokingSignIndex = 0;SmokingSignIndex < 72;SmokingSignIndex++) {
                Method SmokingSignOffMethod = BusinessSeatPorts.get(SmokingSignIndex).getClass().getDeclaredMethod("smokingSignOff");
                LogEngine.instance.write("smokingSignOffMethod = " + SmokingSignOffMethod);

                boolean isSmokingSignOff = (boolean)SmokingSignOffMethod.invoke(BusinessSeatPorts.get(SmokingSignIndex));
                LogEngine.instance.write(smokingSignOff.getSmokingSign() + " : isSmokingSignOff = " + isSmokingSignOff);

                PrimaryFlightDisplay.instance.isSmokingSignOff = isSmokingSignOff;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),smokingSignOff.getSmokingSign() + " : SmokingSign (isOff) = " + isSmokingSignOff);

                LogEngine.instance.write("+");
            }
			
			//FirstClassSeats
			for (int SmokingSignIndex = 0;SmokingSignIndex < 16;SmokingSignIndex++) {
                Method SmokingSignOffMethod = FirstSeatPorts.get(SmokingSignIndex).getClass().getDeclaredMethod("seatBeltOff");
                LogEngine.instance.write("smokingOffMethod = " + SmokingSignOffMethod);

                boolean isSmokingSignOff = (boolean)SmokingSignOffMethod.invoke(FirstSeatPorts.get(SmokingSignIndex));
                LogEngine.instance.write(smokingSignOff.getSmokingSign() + " : isSmokingSignOff = " + isSmokingSignOff);

                PrimaryFlightDisplay.instance.isSmokingSignOff = isSmokingSignOff;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),smokingSignOff.getSmokingSign() + " : SmokingSign (isOff) = " + isSmokingSignOff);

                LogEngine.instance.write("+");
            }
			
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
	
	@Subscribe
    public void receive(SmokingSignOn smokingBeltSignOn) {
        LogEngine.instance.write("+ Body.receive(" + smokingSignOn + ")");

        try {
			//CrewSeats
            for (int SmokingSignIndex = 0;SmokingSignIndex < 14;SmokingSignIndex++) {
                Method SmokingSignOnMethod = CrewSeatPorts.get(SmokingSignIndex).getClass().getDeclaredMethod("smokingOn");
                LogEngine.instance.write("smokingSignOnMethod = " + SmokingSignOnMethod);

                boolean isSmokingSignOn = (boolean)SmokingSignOnMethod.invoke(CrewSeatPorts.get(SmokingSignIndex));
                LogEngine.instance.write(smokingSignOn.getSmokingSign() + " : isSmokingSignOn = " + isSmokingSignOn);

                PrimaryFlightDisplay.instance.isSmokingSignOn = isSmokingSignOn;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),smokingSignOn.getSmokingSign() + " : SmokingSign (isOn) = " + isSmokingSignOn);

                LogEngine.instance.write("+");
            }
			
			//TouristClassSeats
			for (int SmokingSignIndex = 0;SmokingSignIndex < 480;SmokingSignIndex++) {
                Method SmokingSignOnMethod = TouristSeatPorts.get(SmokingSignIndex).getClass().getDeclaredMethod("seatBeltOn");
                LogEngine.instance.write("smokingSignOnMethod = " + SmokingSignOnMethod);

                boolean isSmokingSignOn = (boolean)SmokingSignOnMethod.invoke(TouristSeatPorts.get(SmokingSignIndex));
                LogEngine.instance.write(smokingSignOn.getSeatBeltSign() + " : isSmokingSignOn = " + isSmokingSignOn);

                PrimaryFlightDisplay.instance.isSmokingSignOn = isSmokingSignO;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),smokingSignOn.getSmokingSign() + " : SmokingSign (isOn) = " + isSmokingSignOn);

                LogEngine.instance.write("+");
            }
			
			//BusinessClassSeats
			for (int SmokingSignIndex = 0;SmokingSignIndex < 72;SmokingSignIndex++) {
                Method SmokingSignOnMethod = BusinessSeatPorts.get(SmokingSignIndex).getClass().getDeclaredMethod("seatBeltOn");
                LogEngine.instance.write("smokingSignOnMethod = " + SmokingSignOnMethod);

                boolean isSmokingSignOn = (boolean)SmokingSignOnMethod.invoke(BusinessSeatPorts.get(SmokingSignIndex));
                LogEngine.instance.write(smokingSignOn.getSmokingSign() + " : isSmokingSignOn = " + isSmokingSignOn);

                PrimaryFlightDisplay.instance.isSmokingSignOn = isSmokingSignOn;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),smokingSignOn.getSmokingSign() + " : SmokingSign (isOn) = " + isSmokingSignOn);

                LogEngine.instance.write("+");
            }
			
			//FirstClassSeats
			for (int SmokingSignIndex = 0;SmokingSignIndex < 16;SmokingSignIndex++) {
                Method SmokingSignOnMethod = FirstSeatPorts.get(SmokingSignIndex).getClass().getDeclaredMethod("seatBeltOn");
                LogEngine.instance.write("smokingSignOnMethod = " + SmokingSignOnMethod);

                boolean isSmokingSignOn = (boolean)SmokingSignOnMethod.invoke(FirstSeatPorts.get(SmokingSignIndex));
                LogEngine.instance.write(smokingSignOn.getSmokingSign() + " : isSmokingSignOn = " + isSmokingSignOn);

                PrimaryFlightDisplay.instance.isSmokingSignOn = isSmokingSignOn;
                FlightRecorder.instance.insert(this.getClass().getSimpleName(),smokingSignOn.getSmokingSign() + " : SmokingSign (isOn) = " + isSmokingSignOn);

                LogEngine.instance.write("+");
            }
			
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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

}
