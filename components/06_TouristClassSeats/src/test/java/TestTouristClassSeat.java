import org.junit.Assert;
import org.junit.Test;

public class TestTouristClassSeat {
    @Test
    public void testVersion(){
        TouristClassSeat seat = TouristClassSeat.getInstance();
        TouristClassSeat.Port port = seat.port;
        Assert.assertEquals("TouristClassSeat - Recaro", port.version());
    }

    @Test
    public void testSmokingSign(){
        TouristClassSeat seat = TouristClassSeat.getInstance();
        TouristClassSeat.Port port = seat.port;
        Assert.assertTrue(port.nonSmokingSignOn());
        Assert.assertFalse(port.nonSmokingSignOff());
    }

    @Test
    public void testSeatBeltSign(){
        TouristClassSeat seat = TouristClassSeat.getInstance();
        TouristClassSeat.Port port = seat.port;
        Assert.assertTrue(port.seatBeltOn());
        Assert.assertFalse(port.seatBeltOff());
    }

    @Test
    public void testReadingLight(){
        TouristClassSeat seat = TouristClassSeat.getInstance();
        TouristClassSeat.Port port = seat.port;
        Assert.assertTrue(port.readingLightOn());
        Assert.assertFalse(port.readingLightOff());
    }

    @Test
    public void testSeatPosition(){
        TouristClassSeat seat = TouristClassSeat.getInstance();
        TouristClassSeat.Port port = seat.port;
        Assert.assertEquals(0, port.upRight());
        Assert.assertEquals(1, port.level1());
    }
}
