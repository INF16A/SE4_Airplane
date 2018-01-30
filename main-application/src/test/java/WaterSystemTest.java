import factory.WaterSystemFactory;
import org.junit.Assert;
import org.junit.Test;

public class WaterSystemTest {

    @Test
    public void TestWaterSystemLoad() {
        Object o = WaterSystemFactory.build();
        Assert.assertNotNull(o);
    }
}
