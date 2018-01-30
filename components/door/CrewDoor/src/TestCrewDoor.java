import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCrewDoor {

    CrewDoor testCDoor;

    @Before
    public void init()
    {
        testCDoor = new CrewDoor("1", "cool", "Wagenheber");
    }

    @Test
    public void testClose()
    {
        assertTrue(testCDoor.close());
    }

    @Test
    public void testOpen()
    {
        assertFalse(testCDoor.open());
    }

    @Test
    public void testLock()
    {
        assertTrue(testCDoor.lock());
    }

    @Test
    public void testUnlock()
    {
        assertFalse(testCDoor.unlock());
    }
}