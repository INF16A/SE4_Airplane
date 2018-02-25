import org.junit.Assert;
import org.junit.Test;

public class AirflowSensorTest {

    AirflowSensor.Port port = AirflowSensor.getInstance().port;

    @Test
    public void measure() {
        Assert.assertEquals(3, port.measure("wow"));
    }

    @Test
    public void alarm() {
        Assert.assertFalse(port.alarm(3));
    }

}
