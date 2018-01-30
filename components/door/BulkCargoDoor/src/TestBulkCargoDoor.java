import org.junit.Test;
import static org.junit.Assert.*;

public class TestBulkCargoDoor {

    BulkCargoDoor testBCDoor;

    @Test
    public void testClose()
    {
        boolean result = BulkCargoDoor.Port.close();
        assertTrue();
    }

    @Test
    public void testOpen()
    {
        assertFalse(testBCDoor.open());
    }

    @Test
    public void testLock()
    {
        assertTrue(testBCDoor.lock());
    }

    @Test
    public void testUnlock()
    {
        assertFalse(testBCDoor.unlock());
    }
}
