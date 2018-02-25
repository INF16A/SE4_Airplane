import org.junit.Test;
import static org.junit.Assert.*;

public class TestCrewDoor {

    private CrewDoor testCDoor = new CrewDoor();

    @Test
    public void testClose()
    {
        assertTrue(testCDoor.port.close());
    }

    @Test
    public void testOpen()
    {
        assertFalse(testCDoor.port.open());
    }

    @Test
    public void testLock()
    {
        assertTrue(testCDoor.port.lock());
    }

    @Test
    public void testUnlock()
    {
        assertFalse(testCDoor.port.unlock());
    }
}