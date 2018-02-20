import org.junit.Test;
import static org.junit.Assert.*;

public class TestBulkCargoDoor {

    private BulkCargoDoor testBCDoor = new BulkCargoDoor();

    @Test
    public void testClose()
    {
        assertTrue(testBCDoor.port.close());
    }

    @Test
    public void testOpen()
    {
        assertFalse(testBCDoor.port.open());
    }

    @Test
    public void testLock()
    {
        assertTrue(testBCDoor.port.lock());
    }

    @Test
    public void testUnlock()
    {
        assertFalse(testBCDoor.port.unlock());
    }
}
