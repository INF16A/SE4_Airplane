import factory.FuelFlowSensorFactory;
import org.junit.Assert;
import org.junit.Test;

public class FuelFlowSensorFactoryTest {
    @Test
    public void Build() {
        Assert.assertNotNull(FuelFlowSensorFactory.build());
    }
}
