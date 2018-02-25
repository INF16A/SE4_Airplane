import org.junit.Assert;
import org.junit.Test;

public class TestFirstClassSeat {
    @Test
    public void testVersion(){
        FirstClassSeat seat = FirstClassSeat.getInstance();
        FirstClassSeat.Port port = seat.port;
        Assert.assertEquals("FirstClassSeat - Recaro", port.version());
    }

    @Test
    public void testSmokingSign(){
        FirstClassSeat seat = FirstClassSeat.getInstance();
        FirstClassSeat.Port port = seat.port;
        Assert.assertTrue(port.nonSmokingSignOn());
        Assert.assertFalse(port.nonSmokingSignOff());
    }

    @Test
    public void testSeatBeltSign(){
        FirstClassSeat seat = FirstClassSeat.getInstance();
        FirstClassSeat.Port port = seat.port;
        Assert.assertTrue(port.seatBeltOn());
        Assert.assertFalse(port.seatBeltOff());
    }

    @Test
    public void testReadingLight(){
        FirstClassSeat seat = FirstClassSeat.getInstance();
        FirstClassSeat.Port port = seat.port;
        Assert.assertTrue(port.readingLightOn());
        Assert.assertFalse(port.readingLightOff());
    }

    @Test
    public void testSeatPosition(){
        FirstClassSeat seat = FirstClassSeat.getInstance();
        FirstClassSeat.Port port = seat.port;
        Assert.assertEquals(0, port.upRight());
        Assert.assertEquals(1, port.level1());
    }
}
