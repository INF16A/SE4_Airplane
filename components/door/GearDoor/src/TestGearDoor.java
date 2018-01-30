import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestGearDoor {

    GearDoor testGDoor;

    @Before
    public void init()
    {
        testGDoor = new GearDoor("1","Wagenheber");
    }

    @Test
    public void testClose()
    {
        assertTrue(testGDoor.close());
    }

    @Test
    public void testOpen()
    {
        assertFalse(testGDoor.open());
    }

    @Test
    public void testLock()
    {
        assertTrue(testGDoor.lock());
    }

    @Test
    public void testUnlock()
    {
        assertFalse(testGDoor.unlock());
    }

    @Test
    public void testSetGearDoorType()
    {
        assertEquals(GearDoorType.front, testGDoor.setGearDoorType("front"));
        assertEquals(GearDoorType.gear, testGDoor.setGearDoorType("gear"));
    }
}