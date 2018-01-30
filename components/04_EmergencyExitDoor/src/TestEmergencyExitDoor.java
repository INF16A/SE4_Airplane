import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestEmergencyExitDoor {

    EmergencyExitDoor testEEDoor;

    @Before
    public void init()
    {
        testEEDoor = new EmergencyExitDoor("1", "cool", "Wagenheber");
    }

    @Test
    public void testClose()
    {
        assertTrue(testEEDoor.close());
    }

    @Test
    public void testOpen()
    {
        assertFalse(testEEDoor.open());
    }

    @Test
    public void testLock()
    {
        assertTrue(testEEDoor.lock());
    }

    @Test
    public void testUnlock()
    {
        assertFalse(testEEDoor.unlock());
    }

    @Test
    public void testActivateEscapeSlide()
    {
        assertTrue(testEEDoor.activateEscapeSlide());
    }
}