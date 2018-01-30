import factory.FuelSensorFactory;
import org.junit.Assert;
import org.junit.Test;

public class FuelSensorFactoryTest {
    @Test
    public void Build() {
        Assert.assertNotNull(FuelSensorFactory.build());
    }
}
