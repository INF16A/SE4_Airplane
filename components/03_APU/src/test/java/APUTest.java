import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class APUTest {

    private APU.Port port;

    @Before
    public void init(){
        port = APU.getInstance().port;
    }

    @Test
    public void version(){
        Assert.assertEquals("APU 1.0", port.version());
    }

    @Test
    public void start() {
        Assert.assertTrue(port.start());
    }

    @Test
    public void increaseRPM() {
        Assert.assertEquals(0, port.increaseRPM(10));
    }

    @Test
    public void decreaseRPM() {
        Assert.assertTrue(port.decreaseRPM(10) != 0);
    }

    @Test
    public void shutDown() {
        Assert.assertFalse(port.shutdown());
    }

}
