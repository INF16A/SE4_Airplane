import org.junit.Assert;
import org.junit.Test;

public class ExhaustGasTemperatureSensorTest {

    @Test
    public void TestVersion() {
        Assert.assertNotNull(new FuelFlowSensor().version());
    }

    @Test
    public void TestMeasure() {
        new FuelFlowSensor().measure();
    }

}
