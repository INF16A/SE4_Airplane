
import main.java.EngineOilTank;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class EngineOilTankTest {
    private EngineOilTank.Port port;

    @Before
    public void init() {
        port = EngineOilTank.getInstance().port;
    }

    @Test
    public void version(){
        Assert.assertEquals("v1.0", port.version());
    }

    @Test
    public void increase() {
        int cur = port.increaseLevel(0);
        int after = port.increaseLevel(10);
        Assert.assertTrue(after == cur+10);
    }

    @Test
    public void decrease() {
        int cur = port.decreaseLevel(0);
        int after = port.decreaseLevel(10);
        Assert.assertTrue(after == cur-10);
    }


}
