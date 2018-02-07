import org.junit.Assert;
import org.junit.Test;

public class TurbulentAirFlowSensorTest {

    TurbulentAirFlowSensor.Port port = TurbulentAirFlowSensor.getInstance().port;

    @Test
    public void measure() {
        Assert.assertEquals("test".hashCode(), port.measure("test"));
    }

    @Test
    public void alarm() {
        Assert.assertFalse(port.alarm());
    }
}
