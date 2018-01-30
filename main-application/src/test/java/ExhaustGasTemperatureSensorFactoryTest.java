import factory.ExhaustGasTemperatureSensorFactory;
import org.junit.Assert;
import org.junit.Test;

public class ExhaustGasTemperatureSensorFactoryTest {
    @Test
    public void Build() {
        Assert.assertNotNull(ExhaustGasTemperatureSensorFactory.build());
    }
}
