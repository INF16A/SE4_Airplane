import org.junit.Test;
import static org.junit.Assert.*;

public class TestGearDoor {

    private GearDoor testGDoor = new GearDoor();

    @Test
    public void testClose()
    {
        assertTrue(testGDoor.port.close());
    }

    @Test
    public void testOpen()
    {
        assertFalse(testGDoor.port.open());
    }

    @Test
    public void testLock()
    {
        assertTrue(testGDoor.port.lock());
    }

    @Test
    public void testUnlock()
    {
        assertFalse(testGDoor.port.unlock());
    }

    @Test
    public void testSetGearDoorType()
    {
        assertEquals(GearDoorType.front, testGDoor.port.setGearDoorType("front"));
        assertEquals(GearDoorType.gear, testGDoor.port.setGearDoorType("gear"));
    }
}