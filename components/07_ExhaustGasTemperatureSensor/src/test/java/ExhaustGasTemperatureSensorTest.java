import org.junit.Assert;
import org.junit.Test;

public class ExhaustGasTemperatureSensorTest {

    @Test
    public void TestVersion() {
        Assert.assertNotNull( ExhaustGasTemperatureSensor.getInstance().version());
    }

    @Test
    public void TestMeasure() {
        ExhaustGasTemperatureSensor.getInstance().measure();
    }

}
