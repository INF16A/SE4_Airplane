import org.junit.Assert;
import org.junit.Test;

public class FuelSensorTest {
    @Test
    public void TestVersion() {
        Assert.assertNotNull(FuelSensor.getInstance().port.version());
    }

    @Test
    public void TestMeasure() {
        FuelSensor.getInstance().port.measure();
    }
}
