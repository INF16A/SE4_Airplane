import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GearTest {

    private Gear.Port port;

    @Before
    public void init() {
        port = Gear.getInstance().port;
    }

    @Test
    public void version() {
        Assert.assertEquals("Gear 1.0", port.version());
    }

    @Test
    public void setGearType() {
        Assert.assertEquals(GearType.front, port.setType("front"));
    }

    @Test
    public void down() {
        Assert.assertTrue(port.down());
    }

    @Test
    public void up() {
        Assert.assertFalse(port.up());
    }

    @Test
    public void setBrake() {
        Assert.assertEquals(100, port.setBrake());
    }

    @Test
    public void setBrakeWithNumber() {
        Assert.assertEquals(10, port.setBreak(10));
    }

    @Test
    public void releaseBrake() {
        Assert.assertEquals(0, port.releaseBrake());
    }

}
