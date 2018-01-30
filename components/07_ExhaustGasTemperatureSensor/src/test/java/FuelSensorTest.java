import org.junit.Assert;
import org.junit.Test;

public class FuelSensorTest {
    @Test
    public void TestVersion() {
        Assert.assertNotNull(new FuelSensor().version());
    }

    @Test
    public void TestMeasure() {
        new FuelSensor().measure();
    }
}
