import dummies.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by npor1112 on 30.01.2018.
 */
public class TestSeatManagement {

    @Test
    public void testAssign() {
        SeatManagement seatInst = SeatManagement.getInstance();

        ArrayList<IFirstClassSeat> firstClassSeats = new ArrayList<>();
        firstClassSeats.add(new FirstSeat("S1"));
        firstClassSeats.add(new FirstSeat("S2"));
        firstClassSeats.add(new FirstSeat("S3"));

        ArrayList<IBusinessClassSeat> businessClassSeats = new ArrayList<>();
        businessClassSeats.add(new BusinessSeat("S4"));

        ArrayList<ITouristClassSeat> touristClassSeats = new ArrayList<>();
        touristClassSeats.add(new TouristSeat("S5"));
        touristClassSeats.add(new TouristSeat("S6"));

        // Set seats for test values
        seatInst.setSeats(firstClassSeats, businessClassSeats, touristClassSeats);

        ArrayList<Passenger> passengers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            Passenger p = new Passenger();
            p.boardingPass = new BoardingPass();
            p.boardingPass.seat = "S" + i;
            p.boardingPass.ticketClass = TicketClass.Business.First;
            passengers.add(p);
        }
        passengers.get(3).boardingPass.ticketClass = TicketClass.Business;
        passengers.get(4).boardingPass.ticketClass = TicketClass.Economy;
        passengers.get(5).boardingPass.ticketClass = TicketClass.PremiumEconomy;

        // 6 Passenger with TicketClass: F, F, F, B, E, PE, can not handle PE
        Assert.assertEquals(5, seatInst.port.assign(passengers));
    }

    private class FirstSeat implements IFirstClassSeat {
        Passenger passenger;
        String id;

        public FirstSeat(String id) {
            this.id = id;
        }

        @Override
        public String getId() {
            return this.id;
        }

        @Override
        public void assign(Passenger passenger) {
            this.passenger = passenger;
        }
    }

    private class BusinessSeat implements IBusinessClassSeat {
        Passenger passenger;
        String id;

        public BusinessSeat(String id) {
            this.id = id;
        }

        @Override
        public String getId() {
            return this.id;
        }

        @Override
        public void assign(Passenger passenger) {
            this.passenger = passenger;
        }
    }

    private class TouristSeat implements ITouristClassSeat {
        Passenger passenger;
        String id;

        public TouristSeat(String id) {
            this.id = id;
        }

        @Override
        public String getId() {
            return this.id;
        }

        @Override
        public void assign(Passenger passenger) {
            this.passenger = passenger;
        }
    }
}
