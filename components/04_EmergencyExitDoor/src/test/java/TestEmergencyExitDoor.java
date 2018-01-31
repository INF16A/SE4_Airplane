import org.junit.Test;
import static org.junit.Assert.*;

public class TestEmergencyExitDoor {
    
    private EmergencyExitDoor testEED = new EmergencyExitDoor();

    @Test
    public void testClose()
    {
        assertTrue(testEED.port.close());
    }

    @Test
    public void testOpen()
    {
        assertFalse(testEED.port.open());
    }

    @Test
    public void testLock()
    {
        assertTrue(testEED.port.lock());
    }

    @Test
    public void testUnlock()
    {
        assertFalse(testEED.port.unlock());
    }

    @Test
    public void testActivateEscapeSlide()
    {
        assertTrue(testEED.port.activateEscapeSlide());
    }
}
