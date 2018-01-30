import org.junit.Assert;
import org.junit.Test;

public class ExhaustGasTemperatureSensorTest {

    @Test
    public void TestVersion() {
        Assert.assertNotNull( FuelFlowSensor.getInstance().version());
    }

    @Test
    public void TestMeasure() {
        FuelFlowSensor.getInstance().measure();
    }

}
