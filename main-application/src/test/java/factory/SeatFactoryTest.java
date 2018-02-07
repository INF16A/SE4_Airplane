package factory;

import factory.SeatFactory;
import org.junit.Assert;
import org.junit.Test;

public class SeatFactoryTest {
    @Test
    public void buildBusinessSeat() {
        Assert.assertNotNull(SeatFactory.buildBusinessSeat());
    }

    @Test
    public void buildCrewSeat() { Assert.assertNotNull(SeatFactory.buildCrewSeat()); }

    @Test
    public void buildFirstSeat(){
        Assert.assertNotNull(SeatFactory.buildFirstSeat());
    }

    @Test
    public void buildTouristSeat() { Assert.assertNotNull(SeatFactory.buildTouristSeat()); }
}
