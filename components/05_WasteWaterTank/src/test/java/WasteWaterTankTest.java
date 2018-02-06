import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WasteWaterTankTest {
    private WasteWaterTank.Port port;

    @Before
    public void init() {
        port = WasteWaterTank.getInstance().port;
    }

    @Test
    public void version() {
        Assert.assertEquals("WasteWaterTank - Version 1.0", port.version());
    }

    @Test
    public void lock() {
        Assert.assertTrue(port.lock());
    }

    @Test
    public void unlock() {
        Assert.assertFalse(port.unlock());
    }

    @Test
    public void add() {
        int cur = port.add(0);
        int after = port.add(100);
        Assert.assertTrue(after > cur);
    }

    @Test
    public void pumpOut() {
        Assert.assertEquals(0, port.pumpOut());
    }
}
