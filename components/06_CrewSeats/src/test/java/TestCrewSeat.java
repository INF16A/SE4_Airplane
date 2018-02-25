import org.junit.Assert;
import org.junit.Test;

public class TestCrewSeat {
    @Test
    public void testVersion(){
        CrewSeat seat = CrewSeat.getInstance();
        CrewSeat.Port port = seat.port;
        Assert.assertEquals("CrewSeat - Recaro", port.version());
    }

    @Test
    public void testReadingLight(){
        CrewSeat seat = CrewSeat.getInstance();
        CrewSeat.Port port = seat.port;
        Assert.assertTrue(port.readingLightOn());
        Assert.assertFalse(port.readingLightOff());
    }
}
