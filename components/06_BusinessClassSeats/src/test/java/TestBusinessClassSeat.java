import org.junit.Assert;
import org.junit.Test;

public class TestBusinessClassSeat {
    @Test
    public void testVersion(){
        BusinessClassSeat seat = BusinessClassSeat.getInstance();
        BusinessClassSeat.Port port = seat.port;
        Assert.assertEquals("BusinessClassSeat - Recaro", port.version());
    }

    @Test
    public void testSmokingSign(){
        BusinessClassSeat seat = BusinessClassSeat.getInstance();
        BusinessClassSeat.Port port = seat.port;
        Assert.assertTrue(port.nonSmokingSignOn());
        Assert.assertFalse(port.nonSmokingSignOff());
    }

    @Test
    public void testSeatBeltSign(){
        BusinessClassSeat seat = BusinessClassSeat.getInstance();
        BusinessClassSeat.Port port = seat.port;
        Assert.assertTrue(port.seatBeltOn());
        Assert.assertFalse(port.seatBeltOff());
    }

    @Test
    public void testReadingLight(){
        BusinessClassSeat seat = BusinessClassSeat.getInstance();
        BusinessClassSeat.Port port = seat.port;
        Assert.assertTrue(port.readingLightOn());
        Assert.assertFalse(port.readingLightOff());
    }

    @Test
    public void testSeatPosition(){
        BusinessClassSeat seat = BusinessClassSeat.getInstance();
        BusinessClassSeat.Port port = seat.port;
        Assert.assertEquals(0, port.upRight());
        Assert.assertEquals(1, port.level1());
        Assert.assertEquals(2, port.level2());
    }
}
