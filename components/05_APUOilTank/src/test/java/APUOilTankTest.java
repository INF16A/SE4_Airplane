
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class APUOilTankTest {
    private APUOilTank.Port port;

    @Before
    public void init(){
        port = APUOilTank.getInstance().port;
    }

    @Test
    public void version(){
        Assert.assertEquals("v1.0", port.version());
    }

    @Test
    public void increase() {
        int cur = port.increaseLevel(0);
        int after = port.increaseLevel(200);
        Assert.assertTrue(after>=0 && after <=100);
    }

    @Test
    public void decrease() {
        int cur = port.decreaseLevel(0);
        int after = port.decreaseLevel(12);
        System.out.println(after);
        Assert.assertTrue(after>=0 && after <=100);
    }
}