import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
import dummies.*;
import dummies.Passenger;

import java.util.ArrayList;

/**
 * Created by npor1112 on 30.01.2018.
 */
public class SeatManagement {
    private static SeatManagement instance = new SeatManagement();

    private String manufacturer;
    private String id;
    private ArrayList<IFirstClassSeat> firstClassSeats;
    private ArrayList<IBusinessClassSeat> businessClassSeats;
    private ArrayList<ITouristClassSeat> touristClassSeats;

    private String type;
    private int numberOfPassengersFirstClassAssigned;
    private int numberOfPassengersBusinessClassAssigned;
    private int numberOfPassengersEconomyClassAssigned;

    private SeatManagement() {
        this.port = new Port();
    }

    private int assignAll(final ArrayList<dummies.Passenger> passengers) {

        int assigned = firstClassSeats.stream()
                .map(seat -> assignPassengerToSeat(passengers, (ISeat)seat, TicketClass.First))
                .mapToInt(Integer::intValue)
                .sum();

        assigned += businessClassSeats.stream()
                .map(seat -> assignPassengerToSeat(passengers, (ISeat)seat, TicketClass.Business))
                .mapToInt(Integer::intValue)
                .sum();

        assigned += touristClassSeats
                .stream()
                .map(seat -> assignPassengerToSeat(passengers, (ISeat)seat, TicketClass.Economy))
                .mapToInt(Integer::intValue)
                .sum();

        return assigned;
    }

    private int assignPassengerToSeat(ArrayList<Passenger> passengers, ISeat seat, TicketClass seatClass) {
        for (Passenger passenger: passengers) {
            if (seat.getId().equals(passenger.boardingPass.seat)&& seatClass == passenger.boardingPass.ticketClass) {
                seat.assign(passenger);
                return 1;
            }
        }
        return 0;
    }

    private class Port implements ISeatManagement {
        @Override
        public String version() {
            return "Seat Managment (╯°□°)╯︵ ┻━┻ 1.0.0";
        }

        @Override
        public int assign(ArrayList<Passenger> passengers) {
            return assignAll(passengers);
        }
    }

    public ISeatManagement port;

    public static SeatManagement getInstance() {
        return instance;
    }

    // TODO: remove after body with seats is added
    public void setSeats(ArrayList<IFirstClassSeat> firstClass,
                    ArrayList<IBusinessClassSeat> businessClass,
                    ArrayList<ITouristClassSeat> touristClass) {
        this.firstClassSeats = firstClass;
        this.businessClassSeats = businessClass;
        this.touristClassSeats = touristClass;
    }
}
